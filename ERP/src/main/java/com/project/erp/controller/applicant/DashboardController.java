package com.project.erp.controller.applicant;


import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.project.erp.common.util.logging.InjectableLogger;
import com.project.erp.service.applicant.AbstractService;

/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping(value = "/")

public class DashboardController {
	
	@InjectableLogger
	public Logger logger;

	@Autowired
	private AbstractService abstractService;
	@RequestMapping(value = "/dashboard" ,method = RequestMethod.GET)
	
	public ModelAndView dashboard(Model model, HttpSession session) {
		
		ModelAndView mv=new ModelAndView();
		mv.setViewName("Dashboard/dashboardhome");
		
		model.addAttribute("userModel",session.getAttribute("userModel"));
		
		return  mv;
		
	}
	
	/* ---------------------Admin--------------------*/
	@RequestMapping(value = "/dashboardhomeadmin" ,method = RequestMethod.GET)
	public ModelAndView dashboardadmin(Model model, HttpSession session) {
		
		ModelAndView mv=new ModelAndView();
		mv.setViewName("Dashboard/dashboardhomeadmin");
		
		model.addAttribute("userModel",session.getAttribute("userModel"));
		
		return  mv;
		
	}

	
	
	
	
	
	
	@RequestMapping(value = "/status" ,method = RequestMethod.GET)
	public ModelAndView status(Model model, HttpSession session) {
		
		ModelAndView mv=new ModelAndView();
		mv.setViewName("applicant/Admission/status");
		
		return  mv;
		
	}
}