package com.project.erp.controller.gstian.examcell;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@PreAuthorize("hasRole('EXAMCELLCOORD')")
@RequestMapping("/admin")
public class AdminController {

	@RequestMapping("/AdminHome")
	public String AdminHome()
	{
		return "gstian/examcell/admin/AdminHome";
	}
	
	@RequestMapping("/help")
	public String AdminHelp()
	{
		return "gstian/examcell/admin/help";
	}
}
