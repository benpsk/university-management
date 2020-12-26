package university.system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import university.system.dto.StudentDto;
import university.system.services.GradeServices;
import university.system.services.StudentServices;

@Controller
public class StudentController {

	@Autowired
	private StudentServices services;
	@Autowired
	private GradeServices gradeService;

	@RequestMapping(value = "stdForm")
	public String stdForm(Model m) {
		m.addAttribute("grade", gradeService.getGrade());
		m.addAttribute("std", new StudentDto());
		return "student/stdForm";
	}

	@RequestMapping(value = "manageStd")
	public String manageStd(Model m) {
		m.addAttribute("std", services.getStd());
		return "student/manageStd";
	}

	@RequestMapping(value = "upStdForm/{id}")
	public String upStdForm(@PathVariable int id, Model m) {
		m.addAttribute("std", services.getStdByID(id));
		m.addAttribute("grade", gradeService.getGrade());
		return "student/upStdForm";
	}

	@RequestMapping(value = "addStd")
	public String addStd(@ModelAttribute("std") StudentDto std) {
		services.addStd(std);
		return "redirect:/stdList";
	}

	@RequestMapping(value = "upStd")
	public String upStd(@ModelAttribute("std") StudentDto std) {
		services.upStd(std);
		return "redirect:/manageStd";
	}

	@RequestMapping(value = "delStd/{id}")
	public String delStd(@PathVariable int id) {
		services.delStd(id);
		return "redirect:/manageStd";
	}

	@RequestMapping(value = "stdList")
	public String stdLit(@RequestParam(value = "gradeid", required = false) Integer gradeid, Model m) {
		m.addAttribute("grade", gradeService.getGrade());
		if (gradeid != null && gradeid != 0) {
			m.addAttribute("std", services.getByGradeId(gradeid));
		} else {
			m.addAttribute("std", services.getStd());
		}
		return "student/stdList";
	}

}
