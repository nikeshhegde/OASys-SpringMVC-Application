package com.project.erp.controller.gstian.examcell;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.project.erp.model.StudentDetails;
import com.project.erp.support.gstian.examcell.CustomUserDetails;

@Transactional
@Controller
public class LoginController {

	@Autowired
	private SessionFactory sessionFactory;
	
	@PreAuthorize("hasAnyRole('APPLICANT','ADMIN','STUDENT','ALUMNI','EXAMCELLCOORD')")
	@Transactional
	@RequestMapping("/gstian")
	public String home(Model model,Authentication auth)
	{
		CustomUserDetails user=(CustomUserDetails)auth.getPrincipal();
		String Name;
		String page;
		
		if(user.getUsername().equalsIgnoreCase("EXAMCELLCOORD"))
			{Name=user.getUsername();
			page="/gstian/examcell/admin/AdminHome";}
		
		else{
		Session session = sessionFactory.openSession();
		StudentDetails studentDetails=(StudentDetails)session.get(StudentDetails.class,user.getUsername());
		session.close();
		Name=studentDetails.getStudentName();
		page="/gstian/examcell/student/StudentHome";
		}
		model.addAttribute("Name",Name);
		
	
		
		return page;
	}
	
	@RequestMapping("/login")
	public String login()
	{
		return "login";
	}
	
	@RequestMapping("/logout")
	public String logout()
	{
		
		return "login";
	}
	
	
	@RequestMapping("/loginfailed")
	public String loginfailed(Model model)
	{
		model.addAttribute("error", true);
		return "login";
	}
	
}
