package university.system.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import university.system.dto.AnswersDto;
import university.system.dto.QuestionDto;
import university.system.dto.ResultDto;
import university.system.services.AnswersServices;
import university.system.services.ExamTypeServices;
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

	@RequestMapping(value = "take")
	public String takeE(Model m) {
		m.addAttribute("etype", etypeServices.findAll());
		m.addAttribute("stu", stuServices.getStd());
		m.addAttribute("result", new ResultDto());
		return "result/take";
	}

	@RequestMapping(value = "take", method = RequestMethod.POST)
	public String q(@ModelAttribute("result") ResultDto dto, Model m) {
		System.out.println(dto.getStudentid());
		List<QuestionDto> question = qServices.findByEid(dto.getExamtypeid());
		question.forEach(q -> {
			q.setAns(aServices.findByQid(q.getId()));
		});
		m.addAttribute("ques", question);
		return "result/list";
	}

	
	
	@RequestMapping(value = "result", method = RequestMethod.POST)
	public String r(HttpServletRequest request, @ModelAttribute("result") ResultDto dto, Model m) {

		int RightAns = 0;
		int QNO = 0;
		Double score = 0.0;
		Double status = 0.0;
		String remark = null;
		for (String qid : dto.getqIds()) {
			QNO++;
			QuestionDto qq = qServices.findById(Integer.parseInt(qid));
			status += qq.getMark();

			Integer correctAid = findCorrectAid(Integer.parseInt(qid));
			if (correctAid == Integer.parseInt(request.getParameter("q_" + qid))) {
				QuestionDto q = qServices.findById(Integer.parseInt(qid));
				score += q.getMark();
				RightAns++;
			}
		}
		m.addAttribute("rAns", RightAns);
		m.addAttribute("qno", QNO);
		m.addAttribute("score", score);

		if (score >= status / 2) {
			remark = "Pass";
		} else {
			remark = "Fail";
		}
		dto.setMark(score);
		dto.setRemark(remark);
		dto.setQno(QNO);
		dto.setCorrectno(RightAns);

		rServices.save(dto);
		return "result/result";
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

	@RequestMapping(value = "history")
	public String history(Model m) {
		m.addAttribute("result", rServices.findAll());
		return "result/history";
	}
	
	@RequestMapping(value="pass")
	public String pass(Model m) {
		m.addAttribute("pass", rServices.findPass());
		return "result/pass";
	}
	
	@RequestMapping(value="fail")
	public String fail(Model m) {
		m.addAttribute("fail", rServices.findFail());
		return "result/fail";
	}
}
