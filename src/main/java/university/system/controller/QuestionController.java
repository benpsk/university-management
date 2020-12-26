package university.system.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import university.system.dto.AnswersDto;
import university.system.dto.QuestionDto;
import university.system.services.AnswersServices;
import university.system.services.ExamTypeServices;
import university.system.services.QuestionServices;

@Controller
@RequestMapping(value = "q")
public class QuestionController {

	@Autowired
	QuestionServices services;
	@Autowired
	ExamTypeServices eServices;
	@Autowired
	AnswersServices aServices;

	@RequestMapping(value = "save")
	public String home(Model m) {
		m.addAttribute("ques", new QuestionDto());
		m.addAttribute("etype", eServices.findAll());
		return "question/save";
	}

	@RequestMapping(value = "save", method = RequestMethod.POST)
	public String save(@ModelAttribute("ques") QuestionDto ques) {
		services.save(ques);
		return "redirect:/ans/save";
	}

	@RequestMapping(value = "list")
	public String list(Model m) {
		List<QuestionDto> question = services.findAll();
		question.forEach(q -> {
			q.setAns(aServices.findByQid(q.getId()));
		});
		m.addAttribute("ques", question);
		return "question/list";
	}

	@RequestMapping(value = "manage")
	public String manage(Model m) {
		List<QuestionDto> question = services.findAll();
		question.forEach(q -> {
			q.setAns(aServices.findByQid(q.getId()));
		});
		m.addAttribute("ques", question);
		return "question/manage";
	}

	@RequestMapping(value = "update/{id}")
	public String update(@PathVariable int id, Model m) {
		QuestionDto q = services.findById(id);
		m.addAttribute("ques", q);
		m.addAttribute("etype", eServices.findAll());
		return "question/update";
	}

	@RequestMapping(value = "update", method = RequestMethod.POST)
	public String up(@ModelAttribute("ques") QuestionDto dto, Model m) {
		services.update(dto);
		System.out.println(dto.getId());
		m.addAttribute("ques", services.findById(dto.getId()));
		
		m.addAttribute("ans", new AnswersDto());
		aServices.deletebyQid(dto.getId());
		return "answers/update";
	}
	
	@RequestMapping(value="updateA", method=RequestMethod.POST)
	public String up(@ModelAttribute("ans") AnswersDto ans) {
		System.out.println(ans.getId());
		System.out.println(ans.getQuestionid());
		aServices.save(ans);
		System.out.println("hello answer");
		return "redirect:/q/manage";
	}

	@RequestMapping(value = "delete/{id}")
	public String delete(@PathVariable int id) {
		services.delete(id);
		return "redirect:/q/manage";
	}

}
