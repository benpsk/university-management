package university.system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import university.system.dto.GradeDto;
import university.system.services.GradeServices;

@Controller
public class GradeController {

	@Autowired
	private GradeServices services;

	@RequestMapping(value = "gradeForm")
	public String gradeForm(Model m) {
		m.addAttribute("grade", new GradeDto());
		return "grade/gradeForm";
	}

	@RequestMapping(value = "manageGrade")
	public String manageGrade(Model m) {
		m.addAttribute("grade", services.getGrade());
		return "grade/manageGrade";
	}

	@RequestMapping(value = "upGradeForm/{id}")
	public String upGradeForm(@PathVariable int id, Model m) {
		m.addAttribute("grade", services.getGradeByID(id));
		return "grade/upGradeForm";
	}

	@RequestMapping(value = "addGrade")
	public String addGrade(@ModelAttribute("grade") GradeDto grade) {
		services.addGrad(grade);
		return "redirect:/manageGrade";
	}

	@RequestMapping(value = "upGrade")
	public String upGrade(@ModelAttribute("grade") GradeDto grade) {
		services.upGrade(grade);
		return "redirect:/manageGrade";
	}

	@RequestMapping(value = "delGrade/{id}")
	public String delGrade(@PathVariable int id) {
		services.delGrade(id);
		return "redirect:/manageGrade";
	}

}
