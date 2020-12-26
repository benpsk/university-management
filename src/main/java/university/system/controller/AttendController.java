package university.system.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import university.system.dto.AttListDto;
import university.system.dto.StudentDto;
import university.system.services.AttendServices;
import university.system.services.GradeServices;
import university.system.services.StudentServices;

@Controller
@RequestMapping(value = "att")
public class AttendController {

	@Autowired
	private GradeServices gServices;
	@Autowired
	private StudentServices sServices;
	@Autowired
	private AttendServices attServices;

	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		dateFormat.setLenient(false);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
	}

	@RequestMapping(value = "show")
	public String attList(@RequestParam(value = "gid", required = false) Integer gid, Model m) {
		m.addAttribute("grade", gServices.getGrade());
		List<StudentDto> stdList = new ArrayList<StudentDto>();

		if (gid != null) {
			stdList = sServices.getByGradeId(gid);
		}
		m.addAttribute("attList", stdList);
		m.addAttribute("attList", new AttListDto());
		return "attend/show";
	}

	@RequestMapping(value = "save", method = RequestMethod.POST)
	public String save(@ModelAttribute(value = "attList") AttListDto attList) {
		attServices.save(attList);
		return "redirect:/att/list";
	}

	@RequestMapping(value = "list")
	public String list(@RequestParam(value = "dd", required = false) Date dd, Model m) {

		List<AttListDto> attList = new ArrayList<AttListDto>();
		if (dd != null) {
			attList = attServices.findByDate(dd);
			m.addAttribute("attList", attList);
		} else {
			m.addAttribute("attList", attServices.findAll());
		}

		return "attend/list";
	}
}
