package com.project.erp.controller;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.project.erp.common.constant.ViewConstant;
import com.project.erp.common.util.logging.InjectableLogger;
import com.project.erp.forms.applicant.GateWayForm;
import com.project.erp.forms.applicant.changePasswordForm;
import com.project.erp.model.AdmissionUser1;
import com.project.erp.model.Users;
import com.project.erp.service.applicant.AbstractService;

/**
 * Handles requests for the application home page.
 */



@Controller
@RequestMapping(value = "/")

public class HomeController extends LandingControllerBackup{



	@RequestMapping(method = RequestMethod.GET)

	public ModelAndView index(Model model, HttpSession session) {

  
		ModelAndView mv=new ModelAndView();
		mv.setViewName("index");
		return  mv;

	}
	
	@RequestMapping(value="/admin/controlpanel",method = RequestMethod.GET)

	public ModelAndView showAdmin(Model model, HttpSession session) {


		ModelAndView mv=new ModelAndView();
		mv.setViewName("admincp");
		return  mv;

	}
	
	
	@PreAuthorize("hasAnyRole("+ViewConstant.ALLOW_ALL_ROLES+")")
	@RequestMapping(value="/changePassword", method = RequestMethod.GET)

	public ModelAndView changePassword(Model model, HttpSession session) {


		ModelAndView mv=new ModelAndView();
		mv.setViewName("changePassword");
		return  mv;

	}

	
		@InjectableLogger
		public Logger logger;

		@Autowired
		private AbstractService abstractService;
		
		/**
		 * This method will call when user click on submit button
		 * 
		 * @param String
		 *            name
		 * @return {@link ModelAndView} model
		 */
		@PreAuthorize("hasAnyRole("+ViewConstant.ALLOW_ALL_ROLES+")")
		@RequestMapping(value = "/changePasswordAction" , method = RequestMethod.POST)
		public ModelAndView handleButtonAction(Model model,
				@ModelAttribute("AdmissionUser1") changePasswordForm changePassword,Authentication auth, HttpSession session) {
			
			
			/*
			List authorityRoles = new ArrayList(auth.getAuthorities());
			authorityRoles.get(0);
			*/
             ModelAndView mv = new ModelAndView();
			try{
			List userData= abstractService.listSelected("Users",auth.getName(),changePassword.getOldPassword());			
			List admissionUserData = abstractService.listSelected("AdmissionUser1", auth.getName(), changePassword.getOldPassword());
			AdmissionUser1 admUser1=(AdmissionUser1)admissionUserData.get(0);
			Users user1 = (Users)userData.get(0);
	        if(changePassword.getNewPassword().equalsIgnoreCase(changePassword.getNewPasswordConfirm())){		
			admUser1.setAdmissionUserPassword(changePassword.getNewPassword());
			user1.setPassword(changePassword.getNewPassword());
	        }
	        else{
	        }
			abstractService.updateRecord(admUser1);
			abstractService.updateRecord(user1);
			
			}
			catch(Exception e){
			}
			
			
			
			
		/*	logger.info("User's name is "+auth.getName());
			logger.info("Old Password is "+changePassword.getOldPassword());
			logger.info("New Password is "+changePassword.getNewPassword());
			logger.info("New Password Confirm is "+changePassword.getNewPasswordConfirm());
		*/	
			
     /*			if(changePassword.getNewUser().equalsIgnoreCase("admissionSeeker") ) {
				model.setViewName(ViewConstant.NEW_STUDENT_PAGE); 
				model.addObject("userID", session.getAttribute("userID"));
			}
			else if (gateWayForm.getNewUser().equalsIgnoreCase("staff")){
				model.setViewName(ViewConstant.STAFF_PAGE); 
			}
			else if (gateWayForm.getNewUser().equalsIgnoreCase("existingStudent")){
				model.setViewName(ViewConstant.EXISTING_STUDENT_PAGE); 
			}
			
		
		*/	
			mv = loadDashboard(model,auth,session);
			return mv;
		}
			
		
	
}
