package university.system.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import university.system.dto.AnswersDto;
import university.system.dto.GradeDto;
import university.system.dto.QuestionDto;
import university.system.dto.ResultDto;
import university.system.services.AnswersServices;
import university.system.services.ExamTypeServices;
import university.system.services.GradeServices;
import university.system.services.QuestionServices;
import university.system.services.ResultServices;
import university.system.services.StudentServices;

@Service
@RequestMapping(value = "result")
public class ResultController {

	@Autowired
	private StudentServices stuServices;
	@Autowired
	private ExamTypeServices etypeServices;
	@Autowired
	private QuestionServices qServices;
	@Autowired
	private AnswersServices aServices;
	@Autowired
	private ResultServices rServices;
	@Autowired
	private GradeServices gServices;

	@RequestMapping(value = "take")
	public String takeE(Model m) {
		m.addAttribute("etype", etypeServices.findAll());
		m.addAttribute("stu", stuServices.getStd());
		m.addAttribute("result", new ResultDto());
		return "result/take";
	}

	@RequestMapping(value = "take", method = RequestMethod.POST)
	public String q(@ModelAttribute("result") ResultDto dto, Model m) {
		List<QuestionDto> question = qServices.findByEid(dto.getExamtypeid());
		question.forEach(q -> {
			q.setAns(aServices.findByQid(q.getId()));
		});
		m.addAttribute("ques", question);
		return "result/list";
	}

	@RequestMapping(value = "result", method = RequestMethod.POST)
	public String r(HttpServletRequest request, @ModelAttribute("result") ResultDto dto, Model m) {
		Double score = 0.0;
		for (String qid : dto.getqIds()) {
			Integer correctAid = findCorrectAid(Integer.parseInt(qid));
			if (correctAid == Integer.parseInt(request.getParameter("q_" + qid))) {
				QuestionDto q = qServices.findById(Integer.parseInt(qid));
				score = q.getMark();
			}
			dto.setQuestionid(Integer.parseInt(qid));
			dto.setAnswerid(Integer.parseInt(request.getParameter("q_" + qid)));
			dto.setMark(score);
			rServices.save(dto);
			score = 0.0;
		}
		Integer sid = dto.getStudentid();
		Integer eid = dto.getExamtypeid();
		return "redirect:/result/view/" + sid + "/" + eid;
	}

	private Integer findCorrectAid(int qid) {
		List<AnswersDto> answer = aServices.findByQid(qid);
		for (AnswersDto ans : answer) {
			if (ans.getStatus1() == true) {
				return ans.getId();
			}
		}
		return null;
	}

	@RequestMapping(value = "record")
	public String record(@ModelAttribute(value = "grade") GradeDto grade,
			@RequestParam(value = "eid", required = false) Integer eid, Model m) {
		m.addAttribute("etype", etypeServices.findAll());
		m.addAttribute("grade", gServices.getGrade());
		m.addAttribute("g", new GradeDto());

		List<ResultDto> resultList = new ArrayList<ResultDto>();
		Integer gid = grade.getId();

		if (eid != null && gid != 0) {
			resultList = rServices.findByEtypeId(eid, gid);
			m.addAttribute("result", resultList);

		} else {
			m.addAttribute("result", rServices.findAll());
		}
		return "result/record";
	}

	@RequestMapping(value = "view/{sid}/{eid}")
	public String view(@PathVariable int sid, @PathVariable int eid, Model m) {
		m.addAttribute("result", rServices.findByStdid(sid));
		List<ResultDto> result = rServices.findStd(sid);

		result.forEach(r -> {
			r.setAnswers(aServices.findByQid(r.getQuestionid()));
			r.setCorrectAns(aServices.correctAns(r.getQuestionid()));
		});
		m.addAttribute("ques", result);
		return "result/view";
	}
}
