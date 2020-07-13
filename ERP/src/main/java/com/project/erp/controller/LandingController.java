package com.project.erp.controller;


import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.servletapi.SecurityContextHolderAwareRequestWrapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.project.erp.common.constant.ViewConstant;
import com.project.erp.common.util.logging.InjectableLogger;
import com.project.erp.model.AdmissionUser1;
import com.project.erp.model.DashboardMenu;
import com.project.erp.model.Users;
import com.project.erp.service.applicant.AbstractService;
import com.project.erp.support.gstian.examcell.CustomUserDetails;
/**
 * Handles requests for the application home page.
 */

@Controller

public class LandingController {

	@InjectableLogger
	public Logger logger;

	@Autowired
	private AbstractService abstractService;
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@PreAuthorize("hasAnyRole('APPLICANT','EXAMCELLCOORD','ALUMNI','ADMIN','STUDENT')")
    @RequestMapping(value = "/Dash-board1" , method = RequestMethod.GET)
	public ModelAndView loadDashboard(Model model,Authentication auth,HttpSession session)
	{
		ModelAndView mv=new ModelAndView();
		
		CustomUserDetails user=(CustomUserDetails)auth.getPrincipal();
		//logger.debug("The role is "+authoriti.get(0));
		List authoriti = new ArrayList(auth.getAuthorities());
		String role = authoriti.get(0).toString();
		
		
		logger.debug(user.getUsername()+" is the user name");
		
		Session sessions=sessionFactory.openSession();
		Criteria cr=sessions.createCriteria(DashboardMenu.class);
		cr.add(Restrictions.eq("dashboardMenuRoleId", role));
		List menu=cr.list();
		sessions.close();
		logger.debug(menu.size()+" is the size");
		
		

		
		
		if(role.equalsIgnoreCase("APPLICANT")){
		//	mv.setViewName("applicant/Admission/welcome");
			logger.debug("I am a applicant");
			
			List userData= abstractService.listSelectedByUserName("Users",auth.getName());			
			List admissionUserData = abstractService.listSelectedByUserName("AdmissionUser1", auth.getName());
			AdmissionUser1 admUser1=(AdmissionUser1)admissionUserData.get(0);
			Users user1 = (Users)userData.get(0);
			//String id_valid_user = element_valid_user.getAdmissionUserUserId(); Monika
			Integer id_valid_user = admUser1.getId();
			Calendar now = Calendar.getInstance();   // Gets the current date and time
			int year = now.get(Calendar.YEAR); 
			//int app_id=id_valid_user*10000+year;
			session.setAttribute("userID",id_valid_user);
			session.setAttribute("userModel",admUser1);//Monika
			logger.debug("below set we have a get "+(Integer)session.getAttribute("userID"));
			logger.debug("the session of element_valid_user current address"+admUser1.getAdmissionUserCurrentAddress() );
			//attr.addAttribute("ApplicationID", app_id);
			
			List valid_user_details = abstractService.listRecord("AdmissionUser1", id_valid_user);
			//AdmissionUser element_valid_user_details = (AdmissionUser) valid_user_details.get(0);
			mv.addObject("loggedinuserdetails", valid_user_details);
			
			mv.setViewName("Dashboard/dashboardhome");
		}
		else if(role.equalsIgnoreCase("EXAMCELLCOORD")){
			mv.setViewName("gstian/examcell/admin/AdminHome");
		}
		else if(role.equalsIgnoreCase("ADMIN")){
			mv.setViewName("applicant/Admission/DashboardAdmin");
		}
		else if(role.equalsIgnoreCase("STUDENT")){
			mv.setViewName("gstian/examcell/student/StudentHome");
		}
		else if(role.equalsIgnoreCase("ALUMNI")){
	
			
			mv.setViewName("gstian/Alumni/DashBoardAlumni");
		}
		else{
			mv.setViewName("Dashboard/dashboardiframe");
		}
		
			
			model.addAttribute("menu", menu);
		return mv;
	}
	
}
