package com.project.erp.controller;


import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

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

public class LandingControllerBackup {

	@InjectableLogger
	public Logger logger;

	@Autowired
	private AbstractService abstractService;
	
	@Autowired
	private SessionFactory sessionFactory;
	
	
	@PreAuthorize("hasAnyRole("+ViewConstant.ALLOW_ALL_ROLES+")")
	@RequestMapping(value = "/Dash-board" , method = RequestMethod.GET)
	public ModelAndView loadDashboard(Model model,Authentication auth,HttpSession session)
	{
		ModelAndView mv=new ModelAndView();
		
		
		
		CustomUserDetails user=(CustomUserDetails)auth.getPrincipal();
		
		//List menu=abstractService.listRecord("DashboardMenu");
		
		
		
		List authoriti = new ArrayList(auth.getAuthorities());
		String role = authoriti.get(0).toString();
		AdmissionUser1 admUser1=new AdmissionUser1();
		if(role.equalsIgnoreCase("APPLICANT"))
		{
			List admissionUserData = abstractService.listSelectedByUserName("AdmissionUser1", auth.getName());
			admUser1=(AdmissionUser1)admissionUserData.get(0);
			session.setAttribute("userModel",admUser1);
		}
		logger.debug(" user model "+admUser1.getId());
		Session sessions=sessionFactory.openSession();
		Criteria cr=sessions.createCriteria(DashboardMenu.class);
		cr.add(Restrictions.eq("dashboardMenuRoleId", role));
		List menu=cr.list();
		sessions.close();
		logger.debug(menu.size()+" is the size");
		//session.setAttribute("userID",id_valid_user);
		
		model.addAttribute("menu", menu);
		mv.setViewName("Dashboard/Dashboard");
		return mv;
	}
	
	
	@PreAuthorize("hasAnyRole("+ViewConstant.ALLOW_ALL_ROLES+")")
	@RequestMapping(value = "/Dashboard-iframe" , method = RequestMethod.GET)
	public ModelAndView loadiframe(Model model,Authentication auth,HttpSession session)
	{
		ModelAndView mv=new ModelAndView();
		AdmissionUser1 userModel=(AdmissionUser1)session.getAttribute("userModel");
		AdmissionUser1 admUser1=userModel;
		Calendar now = Calendar.getInstance();   // Gets the current date and time
		int year = now.get(Calendar.YEAR); 
		//int app_id=id_valid_user*10000+year;
		
		
		
		List authoriti = new ArrayList(auth.getAuthorities());
		String role = authoriti.get(0).toString();
		
		if(role.equalsIgnoreCase("APPLICANT"))
			{
			if(admUser1.getAdmissionUserStatus().equals("Application Fee Paid") && admUser1.getApplicantId().equals(0))
			{
				logger.debug("I am here inside");
				year=Calendar.getInstance().get(Calendar.YEAR);	
				String appId=""+year+admUser1.getId();
				Integer applicantId=new Integer(appId);
				admUser1.setApplicantId(applicantId);
				abstractService.updateRecord(admUser1);
				session.setAttribute("userModel",admUser1);
			}
			}
		
		
		
		Session sessions=sessionFactory.openSession();
		Criteria cr=sessions.createCriteria(DashboardMenu.class);
		cr.add(Restrictions.eq("dashboardMenuRoleId", role));
		List menu=cr.list();
		sessions.close();
		userModel=(AdmissionUser1)session.getAttribute("userModel");
		model.addAttribute("userModel", userModel);
		model.addAttribute("menu", menu);
		mv.setViewName("Dashboard/dashboardiframe");
		return mv;
	}	
	
	@PreAuthorize("hasAnyRole("+ViewConstant.ALLOW_ALL_ROLES+")")
	@RequestMapping(value = "/proceed" , method = RequestMethod.GET)
	public ModelAndView dashboardProceed(Model model,Authentication auth,HttpSession session)
	{
		ModelAndView mv=new ModelAndView();
		
		
		
		CustomUserDetails user=(CustomUserDetails)auth.getPrincipal();
		
		//List menu=abstractService.listRecord("DashboardMenu");
		
		
		
		List authoriti = new ArrayList(auth.getAuthorities());
		String role = authoriti.get(0).toString();
		
		if(role.equalsIgnoreCase("APPLICANT")){
			//	mv.setViewName("applicant/Admission/welcome");
				logger.debug("I am a applicant");
				
				List userData= abstractService.listSelectedByUserName("Users",auth.getName());			
				List admissionUserData = abstractService.listSelectedByUserName("AdmissionUser1", auth.getName());
				AdmissionUser1 admUser1=(AdmissionUser1)admissionUserData.get(0);
				Users user1 = (Users)userData.get(0);
				//String id_valid_user = element_valid_user.getAdmissionUserUserId(); Monika
				Integer id_valid_user = admUser1.getId();
				
				
				
				
				
				session.setAttribute("userID",id_valid_user);
				session.setAttribute("userModel",admUser1);//Monika
				
				logger.debug("the session of element_valid_user current address"+admUser1.getAdmissionUserCurrentAddress() );
				
				
				List valid_user_details = abstractService.listRecord("AdmissionUser1", id_valid_user);
				
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
		return mv;
	}
	
	
}