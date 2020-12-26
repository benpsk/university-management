package university.system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import university.system.dto.AnswersDto;
import university.system.dto.QuestionDto;
import university.system.services.AnswersServices;
import university.system.services.QuestionServices;

@Controller
@RequestMapping(value="ans")
public class AnswersController {

	@Autowired
	AnswersServices services;
	@Autowired
	QuestionServices qServices;
	
	@RequestMapping(value="save")
	public String home(Model m) {
		m.addAttribute("ans", new AnswersDto());
		m.addAttribute("ques", qServices.lastQ());
		QuestionDto dto = qServices.lastQ();
		System.out.println(dto.getQname());
		return "answers/save";
	}
	
	@RequestMapping(value="save", method = RequestMethod.POST)
	public String save(@ModelAttribute("ans") AnswersDto ans) {
		services.save(ans);
		System.out.println(ans.getQuestionid());
		return "redirect:/q/list";
	}
	
//	@RequestMapping(value="update")
//	public String update(Model m) {
////		services.update(ans);
////		m.addAttribute("ques", qServices.findById(dto.getId()));
//		m.addAttribute("ans", new AnswersDto());
//		System.out.println("hello answer");
//		return "answers/update";
//	}
	

}