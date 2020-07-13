package com.project.erp.controller.gstian.examcell;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping(value = "/gstian")

public class WelcomeController {

	
@RequestMapping(value="/exam-cell",method = RequestMethod.GET)
	
	public String welcomeexamcell(Model model, HttpSession session) {
		return "gstian/examcell/index";
		
	}

@RequestMapping(value="/placement-cell",method = RequestMethod.GET)

public String welcomeplacementcell(Model model, HttpSession session) {
	return "gstian/placementcell/index";
	
}

@RequestMapping(value="/exam-cell-admin",method = RequestMethod.GET)

public String welcomealumni(Model model, HttpSession session) {
	return "gstian/examcell/admin/index";
	
}

@RequestMapping(value="/alumni",method = RequestMethod.GET)

public String welcomeadmin(Model model, HttpSession session) {
	return "gstian/Alumni/index";
	
}

}
