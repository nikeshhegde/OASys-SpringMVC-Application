package com.project.erp.controller.gstian.examcell;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@PreAuthorize("hasRole('STUDENT')")
@RequestMapping("/student")
public class StudentController {

	@RequestMapping("/StudentHome")
	public String StudentHome()
	{
		return "/gstian/examcell/student/StudentHome";
	}
	
	@RequestMapping("/help")
	public String studentHelp()
	{
		return "/gstian/examcell/student/help";
	}
}
