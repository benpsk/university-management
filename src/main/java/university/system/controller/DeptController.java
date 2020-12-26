package university.system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import university.system.dto.DeptDto;
import university.system.services.DepartServices;

@Controller
public class DeptController {

	@Autowired
	private DepartServices service;

	@RequestMapping(value = "index.htm")
	public String home(Model m) {
		return "home";
	}

	@RequestMapping(value = "deptForm")
	public String deptForm(Model m) {
		m.addAttribute("dept", new DeptDto());
		return "dept/deptForm";
	}
	
	@RequestMapping(value="list")
	public String list(Model m) {
		m.addAttribute("dept", service.getDept());
		return "dept/list";
	}

	@RequestMapping(value = "manageDept")
	public String manageDept(Model m) {
		m.addAttribute("dept", service.getDept());
		return "dept/manageDept";
	}

	@RequestMapping(value = "upDeptForm/{id}")
	public String upDeptForm(@PathVariable int id, Model m) {
		m.addAttribute("dept", service.deptByID(id));
		return "dept/upDeptForm";
	}

	@RequestMapping(value = "addDept")
	public String depForm(@ModelAttribute("dept") DeptDto dept) {
		service.addDept(dept);
		return "redirect:/manageDept";
	}

	@RequestMapping(value = "upDept")
	public String upDept(@ModelAttribute("dept") DeptDto dept) {
		service.upDept(dept);
		return "redirect:/manageDept";
	}

	@RequestMapping(value = "delDept/{id}")
	public String delDept(@PathVariable int id) {
		service.delDept(id);
		return "redirect:/manageDept";
	}
}
