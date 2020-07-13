package com.project.erp.controller.applicant;


import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.project.erp.common.util.logging.InjectableLogger;
import com.project.erp.forms.applicant.AlumniForm;
import com.project.erp.forms.applicant.LoginForm;
import com.project.erp.model.Alumni;
import com.project.erp.model.Users;
import com.project.erp.service.applicant.AbstractService;

/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping(value = "/")

public class AlumniController {
	
	@InjectableLogger
	public Logger logger;

	@Autowired
	private AbstractService abstractService;
	
	
	
@RequestMapping(value = "/new-alumni" ,method = RequestMethod.GET)
	
	public ModelAndView newAlumni(Model model, HttpSession session) {
		
		ModelAndView mv=new ModelAndView();
		mv.setViewName("gstian/Alumni/newAlumni");
		return mv;		
}

@RequestMapping(value = "/profile-alumni" ,method = RequestMethod.GET)

public ModelAndView profilealumni(Model model, HttpSession session) {
	
	ModelAndView mv=new ModelAndView();
	mv.setViewName("gstian/Alumni/DashBoardAlumni");
	model.addAttribute("alumniModel",session.getAttribute("alumniModel"));
	return mv;		
}




@RequestMapping(value = "/add-alumni" ,method = RequestMethod.POST)

public ModelAndView addAlumni(@ModelAttribute("Alumni") AlumniForm alumniForm,Model model, HttpSession session) {
	
	ModelAndView mv=new ModelAndView();
	mv.setViewName("login");
	
	
	logger.debug("Name is"+alumniForm.getAlumniFname());
	Alumni alm=setRegistrationDetails(alumniForm);
	abstractService.addRecord(alm);
	
	String message="Record has been added";
	model.addAttribute("message", message);
	return mv;		
}

@RequestMapping(value = "/alumni-login" ,method = RequestMethod.GET)

public ModelAndView alumniLogin(Model model, HttpSession session) {
	
	ModelAndView mv=new ModelAndView();
	mv.setViewName("gstian/Alumni/alumniLogin");
	return mv;		
}


@RequestMapping(value = "/alumni-login-action" ,method = RequestMethod.POST)
public ModelAndView adminloginaction(@ModelAttribute("loginForm") LoginForm loginForm,Model model, HttpSession session) 
{
	ModelAndView mv=new ModelAndView();
	logger.debug("Idhar aa gaya");
	List valid_users=abstractService.listSelected("Alumni", loginForm.getLogInUserName(),loginForm.getLogInUserPwd());
	String viewname;
	if(valid_users.size()!=0)
	{ 
		logger.debug("Dekho woh aa gaya");
		Alumni adm=(Alumni)valid_users.get(0);
		logger.debug("Logged in as :"+adm.getAlumniFname());
		session.setAttribute("alumniModel", adm);
		model.addAttribute("alumniModel",session.getAttribute("alumniModel"));
		viewname="gstian/Alumni/DashBoardAlumni";
	}
	else
	{
		logger.debug("Login failed");
		viewname="error";
	}
	mv.setViewName(viewname);
	return mv;
}


@RequestMapping(value = "/edit-profile-alumni" ,method = RequestMethod.GET)

public ModelAndView editprofilealumni(Model model, HttpSession session) {
	
	ModelAndView mv=new ModelAndView();
	mv.setViewName("gstian/Alumni/editProfileAlumni");
	return mv;		
}

@RequestMapping(value = "/edit-profile-action-alumni" ,method = RequestMethod.POST)

public ModelAndView editProfilealumniaction(@ModelAttribute("Alumni") AlumniForm alumniForm,Model model, HttpSession session) {
	
	ModelAndView mv=new ModelAndView();
	mv.setViewName("gstian/Alumni/newAlumni");
	
	
	logger.debug("Name is"+alumniForm.getAlumniFname());
	Alumni sessionrecord=(Alumni)session.getAttribute("alumniModel");
	List original=abstractService.listRecord("Alumni",sessionrecord.getId());
	Alumni alm=editRegistrationDetails(alumniForm,(Alumni)original.get(0));
	abstractService.updateRecord(alm);
	session.setAttribute("alumniModel", alm);
	String message="Record has been added";
	model.addAttribute("message", message);
	mv.setViewName("gstian/Alumni/DashBoardAlumni");
	model.addAttribute("alumniModel", session.getAttribute("alumniModel"));
	return mv;		
}



public Alumni setRegistrationDetails(AlumniForm alumniForm)
{
	Alumni alm=new Alumni();
	Users users=new Users();
	
	users.setUsername(alumniForm.getAlumniEmail());
	
	users.setAuthority("ALUMNI");
	
	users.setPassword(alumniForm.getAlumniPassword());
	
	alm.setAlumniContactNumber(alumniForm.getAlumniContactNumber());
	alm.setAlumniDepartment(alumniForm.getAlumniDepartment());
	alm.setAlumniEmail(alumniForm.getAlumniEmail());
	alm.setAlumniFatherName(alumniForm.getAlumniFatherName());
	alm.setAlumniFname(alumniForm.getAlumniFname());
	alm.setAlumniSurname(alumniForm.getAlumniSurname());
	alm.setAlumniYearOfPassing(alumniForm.getAlumniYearOfPassing());
	alm.setAlumniPassword(alumniForm.getAlumniPassword());
	alm.setUsers(users);
	
	abstractService.addRecord(users);
	return alm;
}

public Alumni editRegistrationDetails(AlumniForm alumniForm, Alumni original)
{
	Alumni alm=original;
	logger.debug("Ithey ithey");
	alm.setAlumniContactNumber(alumniForm.getAlumniContactNumber());
	alm.setAlumniDepartment(alumniForm.getAlumniDepartment());
	alm.setAlumniEmail(alumniForm.getAlumniEmail());
	alm.setAlumniFatherName(alumniForm.getAlumniFatherName());
	alm.setAlumniFname(alumniForm.getAlumniFname());
	alm.setAlumniSurname(alumniForm.getAlumniSurname());
	alm.setAlumniYearOfPassing(alumniForm.getAlumniYearOfPassing());
	//alm.setAlumniPassword(alumniForm.getAlumniPassword());
	logger.debug("Alumni department is: "+alumniForm.getAlumniDepartment());
	alm.setAlumniDepartment(alumniForm.getAlumniDepartment());
	alm.setAlumniAreaOfExpertise(alumniForm.getAlumniAreaOfExpertise());
	alm.setAlumniCurrentEmployment(alumniForm.getAlumniCurrentEmployment());
	alm.setAlumniCurrentWorkPlace(alumniForm.getAlumniCurrentWorkPlace());
	return alm;
}


}