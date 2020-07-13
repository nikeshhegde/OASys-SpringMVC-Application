package com.project.erp.controller.applicant;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.project.erp.common.util.logging.InjectableLogger;
import com.project.erp.forms.applicant.NewAdmissionForm1;
import com.project.erp.model.AcademicDetailsDse;
import com.project.erp.model.AdmissionUser1;
import com.project.erp.model.AdmissionUserBranchSelection;
import com.project.erp.model.AdmissionUserFeAcademics;
import com.project.erp.model.PaymentLog;
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

public class addAdmissionController {
	
	   
       
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
	
	@RequestMapping(value = "/addAdmission" , method = RequestMethod.POST)

	public ModelAndView handleButtonAction(
			@ModelAttribute("AdmissionUser1") NewAdmissionForm1 newAdmissionForm) {
		
		//logger.debug("NewAdmissionController");
		
			
		setRegistrationDetails (newAdmissionForm);
		
		
		ModelAndView model = new ModelAndView();
		model.setViewName("applicant/Admission/admissionStep2");
		//model.addObject("abc", newAdmissionForm.getAdmissionUserFname());
		return model;
	
	}
	
	private  void setRegistrationDetails(NewAdmissionForm1 newAdmissionForm) {
		
		AdmissionUser1 admUser = new AdmissionUser1();
		
		AdmissionUserFeAcademics admUserFeAcademics=new AdmissionUserFeAcademics();
		
		AcademicDetailsDse acadDetailsDse=new AcademicDetailsDse();
		
		PaymentLog pl=new PaymentLog();
		
		Collection <PaymentLog> paymentLog=new ArrayList<PaymentLog>();
		
		
		AdmissionUserBranchSelection admUserBranchSelection=new AdmissionUserBranchSelection();
		
		
		Users users=new Users();
		
		users.setUsername(newAdmissionForm.getAdmissionEmail());
		
		users.setAuthority("APPLICANT");
		
		users.setPassword(newAdmissionForm.getAdmissionUserPassword());
		
		//System.out.println(newAdmissionForm.getUser_fname());
		
		admUser.setAdmissionUserFname(newAdmissionForm.getAdmissionUserFname());
		
		admUser.setAdmissionUserSurName(newAdmissionForm.getAdmissionUserSurName());
		
		admUser.setAdmissionUserEmail(newAdmissionForm.getAdmissionEmail());
		
		admUser.setAdmissionUserFatherName(newAdmissionForm.getAdmissionUserFatherName());
		
		admUser.setAdmissionUserMotherName(newAdmissionForm.getAdmissionUserMotherName());
		
		admUser.setAdmissionUserPassword(newAdmissionForm.getAdmissionUserPassword());
		
		admUser.setApplicantId(0);
		
		admUser.setAdmissionUserGender(newAdmissionForm.getAdmissionUserGender());
		
		admUser.setAdmissionUserType(newAdmissionForm.getAdmissionUserType());
		
		admUser.setAdmissionUserCurrentSemester(0);
		
		admUser.setAdmissionUserStatus("Registered");
		
		admUser.setAdmissionUserRole("APPLICANT");
		
		admUser.setUsers(users);
		
		//paymentLog.add(pl);
		
		//admUser.setPaymentLog(paymentLog);
		
		if(newAdmissionForm.getAdmissionUserType().equals("Diploma"))
		{
			admUser.setAdmissionUserBranch(newAdmissionForm.getAdmissionUserBranch());
			admUser.setAdmissionUserCurrentSemester(2);
			admUser.setAcademicDetailsDse(acadDetailsDse);
			abstractService.addRecord(acadDetailsDse);

		}
		else
		{
			admUser.setAdmUserBranchSelection(admUserBranchSelection);
			admUser.setAdmissionUserFeAcademics(admUserFeAcademics);
			abstractService.addRecord(admUserBranchSelection);
			abstractService.addRecord(admUserFeAcademics);	
		}
		//abstractService.addRecord(pl);
		abstractService.addRecord(users);
		abstractService.addRecord(admUser);
	
		
				
		
		
	}	
	
	
	@RequestMapping(value = "/autostore" , method = RequestMethod.GET)
		
		public @ResponseBody ModelAndView autostore(@RequestParam Map<String,String> postData)
		{
		
		String[] temp=postData.values().toArray(new String[30]);
		int id=Integer.parseInt(temp[0]);
		id=id/10000;
		/*
		for(int i=0;i<temp.length;i++)
			temp[i]="Temporary";
		*/
		//logger.info("Id of the user is"+id);
		AdmissionUser1 admUser=getdetails(temp);
		
		//admUser.setAdmissionUserId(12);
		/*
		admUser.setAdmissionAppliedUnder(temp[i++]);
		
		admUser.setAdmissionUserSurName(temp[i++]);
		
		admUser.setAdmissionUserFname(temp[i++]);
				
		admUser.setAdmissionUserFatherName(temp[i++]);
		
		admUser.setAdmissionUserMotherName(temp[i++]);
		
		admUser.setAdmissionPermanentAddress(temp[i++]);
		
		admUser.setAdmissionCurrentAddress(temp[i++]);
		
		admUser.setAdmissionLandlineNumber(temp[i++]);
		
		admUser.setAdmissionMobileNumber(temp[i++]);
		
		admUser.setAdmissionEmail(temp[i++]);
		
		admUser.setAdmissionDateOfBirth(java.sql.Date.valueOf("2015-01-01"));
		
		admUser.setAdmissionPlaceOfBirth(temp[i++]);
		
		admUser.setAdmissionUserGender(temp[i++]);
		
		admUser.setAdmissionDomicile(temp[i++]);
		
		admUser.setAdmissionState(temp[i++]);
		
		admUser.setAdmissionNationality(temp[i++]);
		
		admUser.setAdmissionReligion(temp[i++]);
		
		admUser.setAdmissionCaste(temp[i++]);
		
		admUser.setAdmissionPhyHandicapped(temp[i++]);
		
		admUser.setAdmissionEcoBackward(temp[i++]);
		
		admUser.setAdmissionBloodGroup(temp[i++]);
		
		admUser.setAdmissionRh(temp[i++]);
		
		admUser.setAdmissionUserUserId(temp[i++]);
		*/
		abstractService.addRecord(admUser);
		ModelAndView model = new ModelAndView();
		model.setViewName("applicant/Admission/autostore");
		return model;
		}
	
	
	private AdmissionUser1 getdetails(String[] temp) {
		AdmissionUser1 admUser = new AdmissionUser1();
		
		AdmissionUserBranchSelection admUserBranchSelection=new AdmissionUserBranchSelection();
		int i=1;
		
		//dmUser.setAdmissionUserId(id);
		
		admUser.setAdmissionUserAppliedUnder(temp[i++]);
		
		admUser.setAdmissionUserSurName(temp[i++]);
		
		admUser.setAdmissionUserFname(temp[i++]);
				
		admUser.setAdmissionUserFatherName(temp[i++]);
		
		admUser.setAdmissionUserMotherName(temp[i++]);
		
		
		admUser.setAdmissionUserPermanentAddress(temp[i++]);
		
		admUser.setAdmissionUserCurrentAddress(temp[i++]);
		
		
		admUser.setAdmissionUserLandlineNumber(temp[i++]);
		
		admUser.setAdmissionUserMobileNumber(temp[i++]);
		
		admUser.setAdmissionUserEmail(temp[i++]);
		
		
		admUser.setAdmissionUserDateOfBirth(java.sql.Date.valueOf(temp[i++]));
		
		
		admUser.setAdmissionUserPlaceOfBirth(temp[i++]);
		
		admUser.setAdmissionUserGender(temp[i++]);
		
		admUser.setAdmissionUserDomicile(temp[i++]);
		
		admUser.setAdmissionUserState(temp[i++]);
		
		admUser.setAdmissionUserNationality(temp[i++]);
		
		admUser.setAdmissionUserReligion(temp[i++]);
		
		admUser.setAdmissionUserCaste(temp[i++]);
		
		admUser.setAdmissionUserPhyHandicapped(temp[i++]);
		
		admUser.setAdmissionUserEcoBackward(temp[i++]);
		
		admUser.setAdmissionUserBloodGroup(temp[i++]);
		
		admUser.setAdmissionUserRh(temp[i++]);
	
		
		
		//admUserBranchSelection.setAdmissionUserBranchSelectionBTPriority(5);
		
		//admUser.setAdmissionUserBranchSelection(admUserBranchSelection);

		return admUser;

	}
	
}




