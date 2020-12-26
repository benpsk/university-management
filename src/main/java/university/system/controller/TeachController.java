package university.system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import university.system.dto.TeachDto;
import university.system.services.DepartServices;
import university.system.services.TeachServices;

@Controller
public class TeachController {

	@Autowired
	private TeachServices service;
	@Autowired
	private DepartServices depService;

	@RequestMapping(value = "teachForm")
	public String teachForm(Model m) {
		m.addAttribute("dept", depService.getDept());
		m.addAttribute("teach", new TeachDto());
		return "teach/teachForm";
	}

	@RequestMapping(value = "manageTeach")
	public String manageTeach(Model m) {
		m.addAttribute("teach", service.getTeach());
		return "teach/manageTeach";
	}

	@RequestMapping(value = "upTeachForm/{id}")
	public String upTeachForm(@PathVariable int id, Model m) {
		m.addAttribute("dept", depService.getDept());
		m.addAttribute("teach", service.teachByID(id));
		return "teach/upTeachForm";
	}

	@RequestMapping(value = "addTeach")
	public String addTeach(@ModelAttribute("teach") TeachDto teach) {
		service.addTeach(teach);
		return "redirect:/teachList";
	}

	@RequestMapping(value = "upTeach")
	public String upTeach(@ModelAttribute("teach") TeachDto teach) {
		service.upTeach(teach);
		return "redirect:/manageTeach";
	}

	@RequestMapping(value = "delTeach/{id}")
	public String delTeach(@PathVariable int id) {
		service.delTeach(id);
		return "redirect:/manageTeach";
	}

	@RequestMapping(value = "teachList")
	public String techList(@RequestParam(value = "deptid", required = false) Integer deptid, Model m) {
		m.addAttribute("dept", depService.getDept());
		if (deptid != null && deptid != 0) {
			m.addAttribute("teach", service.findByDeptId(deptid));
		} else {
			m.addAttribute("teach", service.getTeach());
		}
		return "teach/teachList";
	}
}
