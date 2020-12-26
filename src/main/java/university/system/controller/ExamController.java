package university.system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import university.system.dto.ExamDto;
import university.system.services.ExamServices;

@Controller
@RequestMapping(value="exam")
public class ExamController {

	@Autowired
	private ExamServices services;

	@RequestMapping(value = "examForm")
	public String examForm(Model m) {
		m.addAttribute("exam", new ExamDto());
		return "exam/examForm";
	}

	@RequestMapping(value = "addExam")
	public String addExam(@ModelAttribute("exam") ExamDto exam) {
		services.addExam(exam);
		return "redirect:/exam/manage";
	}

	@RequestMapping(value = "manage")
	public String manage(Model m) {
		m.addAttribute("exam", services.getExam());
		return "exam/manage";
	}
	
	@RequestMapping(value="update/{id}")
	public String update(@PathVariable int id, Model m) {
		m.addAttribute("exam", services.findById(id));
		return "exam/update";
	}
	
	@RequestMapping(value="update", method=RequestMethod.POST)
	public String up(@ModelAttribute("exam") ExamDto dto) {
		System.out.println(dto.getName());
		services.update(dto);
		return "redirect:/exam/manage";
		
	}
	@RequestMapping(value="delete/{id}")
	public String delete(@PathVariable int id) {
		services.delete(id);
		return "redirect:/exam/manage";
	}
}
