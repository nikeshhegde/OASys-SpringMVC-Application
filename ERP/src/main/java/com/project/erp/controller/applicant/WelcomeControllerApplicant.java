package com.project.erp.controller.applicant;


import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.project.erp.common.constant.ViewConstant;
import com.project.erp.common.util.logging.InjectableLogger;
import com.project.erp.model.AdmissionUser1;

/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping(value = "/applicant")

public class WelcomeControllerApplicant {
	
	@InjectableLogger
	public Logger logger;

	
	@RequestMapping(method = RequestMethod.GET)
	
	public String welcome(Model model, HttpSession session) {
		session.setAttribute("userID",-1);
		return "applicant/Admission/welcome";
		
	}
@PreAuthorize("hasAnyRole("+ViewConstant.ALLOW_USER_ROLES+")")	
@RequestMapping(value="/admission",method = RequestMethod.GET)
	
	public String welcome123(Model model, HttpSession session,Authentication auth) {
		AdmissionUser1 userModel=(AdmissionUser1) session.getAttribute("userModel");
		Integer userId=(Integer)session.getAttribute("userID");
		logger.debug("Id is  "+userModel.getId());
		model.addAttribute("userModel",userModel);
		logger.debug("Status is  "+userModel.getAdmissionUserStatus());
		return "applicant/Admission/index";
		
	}
	
	
	
	@RequestMapping(value = "/pending" ,method = RequestMethod.GET)
	
	public ModelAndView pending(Model model, HttpSession session) {
		
		
		ModelAndView mv=new ModelAndView();
		mv.setViewName("applicant/Admission/pending");
		/*AdmissionUser1 userModel=(AdmissionUser1)session.getAttribute("userModel");
		String message="Your payment confirmation is pending. Please wait until the admin confirms your payment";
		if(userModel.getAdmissionUserStatus().equals("AppFeePending"))
		{
			model.addAttribute(message);
		}*/
		model.addAttribute("userModel", session.getAttribute("userModel"));
		return  mv;
		
	}	
}
