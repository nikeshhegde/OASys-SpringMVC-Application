package com.project.erp.controller.applicant;

import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.project.erp.common.util.logging.InjectableLogger;
import com.project.erp.controller.SendEmailAttachController;
import com.project.erp.forms.applicant.LoginForm;
import com.project.erp.forms.applicant.PasswordResetForm;
import com.project.erp.model.AdmissionUser1;
import com.project.erp.model.Users;
import com.project.erp.service.applicant.AbstractService;


/**
 * This is login controller and comes in action when user click on login button.
 * 
 * @author ERP Developer
 *
 */
@Controller
@RequestMapping(value = "/")
public class LoginControllerApplicant extends SendEmailAttachController{

	// private static final Logger logger =
	// LoggerFactory.getLogger(LoginController.class);
	@Autowired
    private JavaMailSender mailSender;
	
	@InjectableLogger
	public Logger logger;

	private static final String STUDENT_PAGE = "/student";
	private static final String USER_NAME = "vishal";
	private static final String USER_NAME_TEST = "sharma";
	private static final String USER_LOGIN_1 = "shiv";
	private static final String USER_LOGIN_2 = "vishnua";
	private static final String USER_LOGIN_3 = "brahma";
	private static final String PWD_1 = "123456";
	private static final String PWD_2 = "123456";
	private static final String PWD_3 = "123456";

	private static final String[] admin_change_userstatus = null;

	@Autowired
	private AbstractService abstractService;

	/**
	 * This method will call when user click on login
	 * 
	 * @param String
	 *            name
	 * @return {@link ModelAndView} model
	 */
	
	
	
	@SuppressWarnings("deprecation")
	@RequestMapping(value = "/admindashboard", method = RequestMethod.POST)
	public ModelAndView adminLoginButtonAction(
			@ModelAttribute("loginform") LoginForm loginForm,Model attr,HttpSession session) {
	
		
	List valid_user=abstractService.listSelected("AdmissionUser",loginForm.getLogInUserName(),loginForm.getLogInUserPwd());
		
		
		ModelAndView mv = new ModelAndView();
		/*
		if(valid_user.size()!=0)
		{
			AdmissionUser element_valid_user = (AdmissionUser) valid_user.get(0);
			int id_valid_user = element_valid_user.getAdmissionUserId();
			
			
			session.setAttribute("userID",id_valid_user);
		
			mv.setViewName("Admission/AdminDashboard");
		}
		*/
	return mv; 
	
	}
	
	
	
	
	
	

	@SuppressWarnings("deprecation")
	@RequestMapping(value = STUDENT_PAGE, method = RequestMethod.POST)
	public ModelAndView handleButtonAction(
			@ModelAttribute("loginForm") LoginForm loginForm,Model attr,HttpSession session) {
		
		ModelAndView model = new ModelAndView();

		List valid_user=abstractService.listSelected("AdmissionUser1",loginForm.getLogInUserName(),loginForm.getLogInUserPwd());
		
		
		
		
		if(valid_user.size()!=0)
		{
			AdmissionUser1 element_valid_user = (AdmissionUser1) valid_user.get(0);
			//String id_valid_user = element_valid_user.getAdmissionUserUserId(); Monika
			Integer id_valid_user = element_valid_user.getId();
			Calendar now = Calendar.getInstance();   // Gets the current date and time
			int year = now.get(Calendar.YEAR); 
			//int app_id=id_valid_user*10000+year;
			session.setAttribute("userID",id_valid_user);
			session.setAttribute("userModel",element_valid_user);//Monika
			
			logger.debug("the session of element_valid_user current address"+element_valid_user.getAdmissionUserCurrentAddress() );
			//attr.addAttribute("ApplicationID", app_id);
			
			List valid_user_details = abstractService.listRecord("AdmissionUser1", id_valid_user);
			//AdmissionUser element_valid_user_details = (AdmissionUser) valid_user_details.get(0);
			attr.addAttribute("loggedinuserdetails", valid_user_details);
			
			
			model.setViewName("Dashboard/dashboardhome");
			//model.addObject("ApplicationID", app_id);
			//model.addObject("ApplicationID",app_id);
		}
		else
		{
			model.setViewName("applicant/Admission/error");
		}
		return model;
	}
	
@RequestMapping(value = "/userlogin" ,method = RequestMethod.GET)
	
	public ModelAndView userlogin(Model model, HttpSession session) {
		
		ModelAndView mv=new ModelAndView();
		mv.setViewName("applicant/Admission/existingStudent");
		
		return  mv;
		
	}	

@RequestMapping(value = "/login/forgotPassword" ,method = RequestMethod.GET)

public ModelAndView userforgotpassword(Model model, HttpSession session) {
	
	ModelAndView mv=new ModelAndView();
	mv.setViewName("applicant/Admission/passwordReminderForm");
	
	return  mv;
	
}	

@RequestMapping(value = "/login/forgotPasswordAction" ,method = RequestMethod.POST)

public ModelAndView userforgotpasswordaction (@ModelAttribute("Users") PasswordResetForm passwordform,Model model, HttpSession session) {
	
	
	String emailId = passwordform.getEmail();
	logger.debug("The email ID is"+emailId);
	List userlist = abstractService.listSelectedByUserName("Users", emailId);
	
	if(userlist.size()>0){
		logger.debug("I am a registered user");
		Users user1 = (Users)userlist.get(0);
		String pass = user1.getPassword();
		SimpleMailMessage temp = new SimpleMailMessage();
    	temp.setTo(emailId);
    	temp.setSubject("SIES GST ERP- Password Retrieve Request");
    	temp.setText("Your Password is "+pass);
    	
    	mailSender.send(temp);
		
	}
	ModelAndView mv=new ModelAndView();
	mv.setViewName("applicant/Admission/passwordReminder");
	
	return  mv;
	
}	


/*
	private Login getLoginDetails(LoginForm loginForm) {
		Login loginDetail = new Login();

		loginDetail.setLoginName(loginForm.getLogInUserName());
		loginDetail.setLoginPassword(loginForm.getLogInUserPwd());

		return loginDetail;

	}

	private void addRecordFromDB(Login login) {
		abstractService.addRecord(login);

	}

	private void removeRecordFromDB(Login login, Integer id) {

		abstractService.removeRecord(login, id);
	}
*/
	private List getAllRecordFromDB(String className) {

		List detailList = abstractService.listRecord(className);

		return detailList;
	}
	
	

}
