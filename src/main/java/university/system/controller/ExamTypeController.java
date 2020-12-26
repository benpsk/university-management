package university.system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import university.system.dto.ExamTypeDto;
import university.system.services.ExamServices;
import university.system.services.ExamTypeServices;

@Controller
@RequestMapping(value = "etype")
public class ExamTypeController {

	@Autowired
	private ExamTypeServices services;
	@Autowired
	private ExamServices examServices;

	@RequestMapping(value = "etypeForm")
	public String etypeForm(Model m) {
		m.addAttribute("etype", new ExamTypeDto());
		m.addAttribute("exam", examServices.getExam());
		return "examtype/etypeForm";
	}

	@RequestMapping(value = "addEtype")
	public String addEtype(@ModelAttribute("etype") ExamTypeDto etype) {
		services.save(etype);
		return "redirect:/etype/examList";
	}

	@RequestMapping(value = "examList")
	public String list(Model m) {
		m.addAttribute("etype", services.findAll());
		return "examtype/examList";
	}

	@RequestMapping(value = "manage")
	public String manage(Model m) {
		m.addAttribute("etype", services.findAll());
		return "examtype/manage";
	}

	@RequestMapping(value = "update/{id}")
	public String update(@PathVariable int id, Model m) {
		m.addAttribute("etype", services.findById(id));
		m.addAttribute("exam", examServices.getExam());
		return "examtype/update";
	}

	@RequestMapping(value = "update", method = RequestMethod.POST)
	public String up(@ModelAttribute("etype") ExamTypeDto etype) {
		services.update(etype);
		return "redirect:/etype/manage";
	}

	@RequestMapping(value = "delete/{id}")
	public String delete(@PathVariable int id) {
		services.delete(id);
		return "redirect:/etype/manage";
	}

}
