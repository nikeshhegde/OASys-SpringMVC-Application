package com.project.erp.controller.applicant;


import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpSession;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.project.erp.common.util.logging.InjectableLogger;
import com.project.erp.forms.applicant.AdminForm;
import com.project.erp.forms.applicant.LoginForm;
import com.project.erp.model.Admin;
import com.project.erp.model.AdmissionUser1;
import com.project.erp.model.AdmissionUserFeAcademics;
import com.project.erp.model.MasterTableERP;
import com.project.erp.model.MeritListFe;
import com.project.erp.others.RollNumber;
import com.project.erp.service.applicant.AbstractService;

/**
 * Handles requests for the application home page.
 */
@Controller
//@RequestMapping(value = "/")

public class AdminControllerApplicant {
	
	@InjectableLogger
	public Logger logger;
	
	@Autowired
	private AbstractService abstractService;
	
	@Autowired
	private SessionFactory sessionFactory;
	@RequestMapping(value = "/adminChangeUserStatus" ,method = RequestMethod.GET)
	public ModelAndView fe7(Model model, HttpSession session) {
		
		
		List admUsers=abstractService.listRecord("AdmissionUser1");
		ModelAndView mv=new ModelAndView();
		mv.setViewName("applicant/Admission/admin_change_userstatus");
		mv.addObject("Users", admUsers);
		return  mv;
		
	}
	
	
	@RequestMapping(value="/admin-login",method = RequestMethod.GET)
	public String welcome(Model model, HttpSession session) {
		session.setAttribute("userID",-1);
		return "applicant/Admission/adminlogin";
		
	}

	
	
	 
	@RequestMapping(value = "/admin-login-action" ,method = RequestMethod.POST)
	public ModelAndView adminloginaction(@ModelAttribute("loginForm") LoginForm loginForm,Model model, HttpSession session) 
	{
		ModelAndView mv=new ModelAndView();
		
		List valid_users=abstractService.listSelected("Admin", loginForm.getLogInUserName(),loginForm.getLogInUserPwd());
		String viewname;
		if(valid_users.size()!=0)
		{
			Admin adm=(Admin)valid_users.get(0);
			logger.debug("Logged in as :"+adm.getAdminFname());
			session.setAttribute("adminModel", adm);
			model.addAttribute("adminModel",session.getAttribute("adminModel"));
			viewname="applicant/Admission/DashboardAdmin";
		}
		else
		{
			logger.debug("Login failed");
			viewname="applicant/Admission/error";
		}
		mv.setViewName(viewname);
		return mv;
	}

	@RequestMapping(value = "/admission-admin" ,method = RequestMethod.GET)
	public String admissionadmin(Model model, HttpSession session) 
	{
		
		model.addAttribute("adminModel",session.getAttribute("adminModel"));
		return "applicant/Admission/admission-admin";
	}
	
	
	@RequestMapping(value = "/sub-admission-admin-applicant" ,method = RequestMethod.GET)
	public String subadmissionadminapplicant(Model model, HttpSession session) 
	{
		
		model.addAttribute("adminModel",session.getAttribute("adminModel"));
		return "applicant/Admission/sub-admission-admin-applicant";
	}
	
	@RequestMapping(value = "/sub-admission-admin-merit" ,method = RequestMethod.GET)
	public String subadmissionadminmerit(Model model, HttpSession session) 
	{
		
		model.addAttribute("adminModel",session.getAttribute("adminModel"));
		return "applicant/Admission/sub-admission-admin-merit";
	}
	
	@RequestMapping(value = "/applicants-admin" ,method = RequestMethod.GET)
	public String applicantsadmin(@RequestParam("type") String type,Model model, HttpSession session) 
	{
		
		List students=abstractService.listRecord("AdmissionUser1");
		List<AdmissionUser1> fe= new ArrayList<AdmissionUser1>();
		List<AdmissionUser1> dse= new ArrayList<AdmissionUser1>();		
		int i=0;
		AdmissionUser1 admUser;
		logger.debug(students.get(0)+" is the object");
		while(i<students.size())
		{
			logger.debug("In here");
			admUser=(AdmissionUser1)students.get(i++);
			//logger.debug("Student: "+admUser.getAdmissionUserFname());
			logger.debug("Index "+i+" is "+admUser.getAdmissionUserType());
			if(admUser.getAdmissionUserType().equals("Diploma") && admUser.getAdmissionUserCurrentSemester()==2)
			{
				logger.debug(" diploma it is");
				dse.add(admUser);	
			}
			else if(admUser.getAdmissionUserType().equals("FirstYearEngineering") && admUser.getAdmissionUserCurrentSemester()==0)
			{
				logger.debug("Fe add hoing");
				fe.add(admUser);
			}
			else
			{
				
			}
		}
		if(type.equals("fe"))
		{
			model.addAttribute("students", fe);
		}
		else if(type.equals("dse"))
		{
			model.addAttribute("students", dse);
		}
		else
		{
			
		}
		logger.debug(type+" is the parameter through url");
		//logger.debug(fe.get(0)+" is an fe");
		//logger.debug(dse.get(0)+" is a dse");
		//logger.debug(fe.get(0)+" is a dse");
		model.addAttribute("type", "applicantInfo");
		return "applicant/Admission/applicants-admin";
	}
	/*
	@RequestMapping(value = "/meritlistgenfe" ,method = RequestMethod.GET)
	public ModelAndView meritlistgenfe(Model model, HttpSession session)
	{
		ModelAndView mv=new ModelAndView();
		List admUserFeAcademics=abstractService.listRecord("AdmissionUserFeAcademics");
		
		//FUNCTION CALL to calculate merit list passing all the rows of fe academics as paramter
		List meritListUsers=abstractService.listRecord("MeritListFe");
		if(meritListUsers.isEmpty())
		{
		meritListCalculateFe(admUserFeAcademics);
		}
		mv.setViewName("applicant/Admission/meritlistfe");
		meritListUsers=abstractService.listRecord("MeritListFe");
		mv.addObject("Users", meritListUsers);
		return mv;
	}
	*/
	/*
	@RequestMapping(value = "/meritlistgendse" ,method = RequestMethod.GET)
	public ModelAndView meritlistgendse(Model model, HttpSession session)
	{
		ModelAndView mv=new ModelAndView();
		List <AdmissionUserDseAcademics> admUserDseAcademics=abstractService.listRecord("AdmissionUserDseAcademics");
		
		//FUNCTION CALL to calculate merit list passing all the rows of fe academics as paramter
		
		meritListCalculateDse(admUserDseAcademics);
		mv.setViewName("meritlistfe");
		List meritListUsers=abstractService.listRecord("meritlistfe");
		mv.addObject("Users", meritListUsers);
		return mv;
	}
*/	
	
	@RequestMapping(value = "/applicants-admin-action" , method = RequestMethod.POST)
	
	public ModelAndView applicantsadminaction(@RequestParam Map<String,String> formData,Model model,HttpSession session)
	{
		ModelAndView mv=new ModelAndView();
		
		
		Integer ids[]=new Integer[formData.size()];
		logger.debug("Size is:"+formData.size());
		Set<String> keys=formData.keySet();
		String values[]=formData.values().toArray(new String[formData.size()]);
		int i=0;
		
		for(String key:keys)
		{

			ids[i++]=new Integer(key);
			
		}
		logger.debug("MAP KEY-VALUE PAIRS ");
		for(i=0;i<ids.length;i++)
		{
			logger.debug(ids[i]+" : "+values[i]);
		}
		String type=saveChanges(ids,values);
		List students=abstractService.listRecord("AdmissionUser1");
		List<AdmissionUser1> fe= new ArrayList<AdmissionUser1>();
		List<AdmissionUser1> dse= new ArrayList<AdmissionUser1>();		
		i=0;
		AdmissionUser1 admUser;
		while(i<students.size())
		{
			logger.debug("In here");
			admUser=(AdmissionUser1)students.get(i++);
			//logger.debug("Student: "+admUser.getAdmissionUserFname());
			logger.debug("Index "+i+" is "+admUser.getAdmissionUserType());
			if(admUser.getAdmissionUserType().equals("Diploma") && admUser.getAdmissionUserCurrentSemester()==2)
			{
				logger.debug(" diploma it is");
				dse.add(admUser);	
				

			}
			else if(admUser.getAdmissionUserType().equals("FirstYearEngineering") && admUser.getAdmissionUserCurrentSemester()==0)
			{
				logger.debug("Fe add hoing");
				fe.add(admUser);
				
			}
			else
			{
				
			}
		}
		if(type.equals("Diploma"))
		{	
			//logger.info("admin side dse");
			
		model.addAttribute("students", dse);
		}
		
		else if(type.equals("FirstYearEngineering"))
		{
			model.addAttribute("students",fe);
		}

		
		mv.setViewName("applicant/Admission/applicants-admin");
		return mv;
	}
	
	
@RequestMapping(value = "/merit-list" , method = RequestMethod.GET)
	
	public ModelAndView applicantsadminaction(@RequestParam("type") String type,Model model, HttpSession session)
	{
	ModelAndView mv=new ModelAndView(); 
	
	List shortlisted=null;
	AdmissionUserFeAcademics admUserFeAcademic;
	if(type.equals("fe"))
	{
		List admUserFeAcademics=abstractService.listRecord("AdmissionUserFeAcademics");
		//shortlisted=meritListCalculateFe(admUserFeAcademics);
		mv.setViewName("applicant/Admission/meritlist");
	}
	
	logger.debug("MERIT LIST");
	
	int i=0;
	while(i<shortlisted.size())
	{
		admUserFeAcademic=(AdmissionUserFeAcademics)shortlisted.get(i++);
		
		logger.debug(admUserFeAcademic.getAdmissionUserId()+"     "+admUserFeAcademic.getAdmissionUserFeAcademicsMeritScore());
	}
	model.addAttribute("shortListed",shortlisted);
	return mv;
	}
	
@RequestMapping(value = "/sub-admission-admin-add-admin" , method = RequestMethod.GET)

public ModelAndView subadmissionaddadmin(Model model,HttpSession session)
{
ModelAndView mv=new ModelAndView(); 
mv.setViewName("applicant/Admission/sub-admission-admin-add-admin");
return mv;
}

@RequestMapping(value = "/add-admin-action" , method = RequestMethod.POST)

public ModelAndView addadminaction(@ModelAttribute("Admin") AdminForm adminForm, HttpSession session)
{
ModelAndView mv=new ModelAndView(); 
Admin admin=setAdminDetails(adminForm);
abstractService.addRecord(admin);
mv.setViewName("applicant/Admission/sub-admission-admin-add-admin");
return mv;
}	


@RequestMapping(value = "/roll-number-menu" , method = RequestMethod.GET)

public ModelAndView rollNumberMenu(@ModelAttribute("Admin") AdminForm adminForm, HttpSession session)
{
	
	
ModelAndView mv=new ModelAndView(); 
mv.setViewName("applicant/Admission/sub-admission-admin-roll-number");
return mv;
}

@RequestMapping(value = "/roll-number" , method = RequestMethod.GET)

public ModelAndView rollNumber(@RequestParam Map<String,String> formData, HttpSession session)
{

	Set<String> keyset=formData.keySet();
	String values[]=formData.values().toArray(new String[formData.size()]);
	
	String keys[]=new String[formData.size()];
	int i=0;
	for(String k:keyset)
	{
		keys[i++]=k;
	}
	
	Integer currentSemester;
	Integer type;
	if(values[0].equals("FirstYearEngineering"))
	{
		currentSemester=0;
		type=1;
	}
	else
	{
		currentSemester=2;
		type=2;
	}
	Session s=sessionFactory.openSession();
	Criteria cr=s.createCriteria(AdmissionUser1.class);
	cr.add(Restrictions.eq("admissionUserStatus","Annual Fee Paid")).add(Restrictions.eq("admissionUserCurrentSemester",currentSemester));
	List admUsers=cr.list();
	s.close();
	AdmissionUser1 admUser,admUserNext,temp;
	int j=0;
	for(i=0;i<admUsers.size();i++){
		   for( j=0; j<(admUsers.size()-i-1); j++){	
				admUser=(AdmissionUser1)admUsers.get(j);
			  	admUserNext=(AdmissionUser1)admUsers.get(j+1);
		
			  if(admUser.getAdmissionUserFname().compareTo(admUserNext.getAdmissionUserFname())>0)
			  {
				  temp=admUser;
				  admUsers.set(j, admUserNext);
				  admUsers.set((j+1), admUser);
			  }
			}
		} 
	
	
	i=0;
	while(i<admUsers.size())
	{
		admUser=(AdmissionUser1)admUsers.get(i);
		logger.debug(admUser.getAdmissionUserFname()+" is student "+(i+1));
		i++;
	}
	
	List masters=abstractService.listRecord("MasterTableERP");
	//AdmisisonUser1 to MasterTable ERP
	
	
	
	logger.debug("Masters size is:"+masters.size());
	
	if(masters.size()==0)
	{
			logger.debug("Here here");
			i=0;
		while(i<admUsers.size())
		{
			admUser=(AdmissionUser1)admUsers.get(i);
			MasterTableERP masterTableERP=new MasterTableERP();
			masterTableERP.setMasterTableERPAppliedUnder(admUser.getAdmissionUserAppliedUnder());
			masterTableERP.setMasterTableERPBloodGroup(admUser.getAdmissionUserBloodGroup());
			masterTableERP.setMasterTableERPBranch(admUser.getAdmissionUserBranch());
			masterTableERP.setMasterTableERPCaste(admUser.getAdmissionUserCaste());
			masterTableERP.setMasterTableERPCurrentAddress(admUser.getAdmissionUserCurrentAddress());
			masterTableERP.setMasterTableERPCurrentSemester(admUser.getAdmissionUserCurrentSemester());
			masterTableERP.setMasterTableERPDateOfBirth(admUser.getAdmissionUserDateOfBirth());
			masterTableERP.setMasterTableERPDomicile(admUser.getAdmissionUserDomicile());
			masterTableERP.setMasterTableERPEcoBackward(admUser.getAdmissionUserEcoBackward());
			masterTableERP.setMasterTableERPEmail(admUser.getAdmissionUserEmail());
			masterTableERP.setMasterTableERPFatherAnnualIncome(admUser.getAdmissionUserFatherAnnualIncome());
			masterTableERP.setMasterTableERPFatherEmail(admUser.getAdmissionUserFatherEmail());
			masterTableERP.setMasterTableERPFatherMobileNumber(admUser.getAdmissionUserFatherMobileNumber());
			masterTableERP.setMasterTableERPFatherName(admUser.getAdmissionUserFatherName());
			masterTableERP.setMasterTableERPFatherOccupation(admUser.getAdmissionUserFatherOccupation());
			masterTableERP.setMasterTableERPFatherOfficeAddress(admUser.getAdmissionUserFatherOfficeAddress());
			masterTableERP.setMasterTableERPFatherTelephoneNumber(admUser.getAdmissionUserFatherTelephoneNumber());
			masterTableERP.setMasterTableERPFname(admUser.getAdmissionUserFname());
			masterTableERP.setMasterTableERPGender(admUser.getAdmissionUserGender());
			masterTableERP.setMasterTableERPGuardianAnnualIncome(admUser.getAdmissionUserGuardianAnnualIncome());
			masterTableERP.setMasterTableERPGuardianEmail(admUser.getAdmissionUserGuardianEmail());
			masterTableERP.setMasterTableERPGuardianMobileNumber(admUser.getAdmissionUserGuardianMobileNumber());
			masterTableERP.setMasterTableERPGuardianName(admUser.getAdmissionUserGuardianName());
			masterTableERP.setMasterTableERPGuardianOccupation(admUser.getAdmissionUserGuardianOccupation());
			masterTableERP.setMasterTableERPGuardianOfficeAddress(admUser.getAdmissionUserGuardianOfficeAddress());
			masterTableERP.setMasterTableERPGuardianTelephoneNumber(admUser.getAdmissionUserGuardianTelephoneNumber());
			masterTableERP.setMasterTableERPLandlineNumber(admUser.getAdmissionUserLandlineNumber());
			masterTableERP.setMasterTableERPMobileNumber(admUser.getAdmissionUserMobileNumber());
			masterTableERP.setMasterTableERPMotherAnnualIncome(admUser.getAdmissionUserMotherAnnualIncome());
			masterTableERP.setMasterTableERPMotherEmail(admUser.getAdmissionUserMotherEmail());
			masterTableERP.setMasterTableERPMotherMobileNumber(admUser.getAdmissionUserMotherMobileNumber());
			masterTableERP.setMasterTableERPMotherName(admUser.getAdmissionUserMotherName());
			masterTableERP.setMasterTableERPMotherOccupation(admUser.getAdmissionUserMotherOccupation());
			masterTableERP.setMasterTableERPMotherOfficeAddress(admUser.getAdmissionUserMotherOfficeAddress());
			masterTableERP.setMasterTableERPMotherTelephoneNumber(admUser.getAdmissionUserMotherTelephoneNumber());
			masterTableERP.setMasterTableERPMotherTongue(admUser.getAdmissionUserMotherTongue());
			masterTableERP.setMasterTableERPNationality(admUser.getAdmissionUserNationality());
			masterTableERP.setMasterTableERPNationality(admUser.getAdmissionUserNationality());
			masterTableERP.setMasterTableERPPassword(admUser.getAdmissionUserPassword());
			masterTableERP.setMasterTableERPPermanentAddress(admUser.getAdmissionUserPermanentAddress());
			masterTableERP.setMasterTableERPPhyHandicapped(admUser.getAdmissionUserPhyHandicapped());
			masterTableERP.setMasterTableERPPlaceOfBirth(admUser.getAdmissionUserPlaceOfBirth());
			masterTableERP.setMasterTableERPReligion(admUser.getAdmissionUserReligion());
			masterTableERP.setMasterTableERPRh(admUser.getAdmissionUserRh());
			masterTableERP.setMasterTableERPRole(admUser.getAdmissionUserRole());
			masterTableERP.setMasterTableERPState(admUser.getAdmissionUserState());
			masterTableERP.setMasterTableERPStatus("Roll Number Pending");
			masterTableERP.setMasterTableERPSurName(admUser.getAdmissionUserSurName());
			masterTableERP.setMasterTableERPType("Student");
			
			abstractService.addRecord(masterTableERP);
			
			
			
			i++;
		}
	}
	List rollNumberCandidates;
	int branchCode=1;
	Session s2=sessionFactory.openSession();
	Criteria cr2=s2.createCriteria(MasterTableERP.class);
	cr2.add(Restrictions.eq("masterTableERPBranch","CE"));
	rollNumberCandidates=cr2.list();
	s2.close();
	
	logger.debug(rollNumberCandidates.size()+" is the size");
	MasterTableERP m;
	Calendar c=Calendar.getInstance();
	int years=c.get(Calendar.YEAR);
	years=years%2000;
	Integer year=new Integer(years); 
	logger.debug("saal "+years+" "+year);
	i=0;
	m=(MasterTableERP)rollNumberCandidates.get(i);
	String roll="";
	RollNumber rollNumber=new RollNumber(type,year,"A",branchCode);
	logger.debug("--CE--");
	while(i<rollNumberCandidates.size())
	{
		m=(MasterTableERP)rollNumberCandidates.get(i);
		if(m.getMasterTableERPStatus().equals("Roll Number Pending"))
			{
			rollNumber.setBase(returnOffset(rollNumber));
			roll=buildRollNumber(rollNumber,rollNumber.getBase());
			m.setMasterTableERPRollNumber(roll);
			m.setMasterTableERPStatus("Student");
			abstractService.updateRecord(m);
			}
		i++;
	}
	branchCode++;
	
	Session s3=sessionFactory.openSession();
	Criteria cr3=s3.createCriteria(MasterTableERP.class);
	cr3.add(Restrictions.eq("masterTableERPBranch","EXTC"));
	rollNumberCandidates=cr3.list();
	s3.close();
	
	logger.debug(rollNumberCandidates.size()+" is the size");

	i=0;
	m=(MasterTableERP)rollNumberCandidates.get(i);
	roll="";
	rollNumber=new RollNumber(type,year,"A",branchCode);
	logger.debug("--EXTC--");
	while(i<rollNumberCandidates.size())
	{
		m=(MasterTableERP)rollNumberCandidates.get(i);
		if(m.getMasterTableERPStatus().equals("Roll Number Pending"))
			{
			rollNumber.setBase(returnOffset(rollNumber));
			roll=buildRollNumber(rollNumber,rollNumber.getBase());
			m.setMasterTableERPRollNumber(roll);
			m.setMasterTableERPStatus("Student");
			abstractService.updateRecord(m);
			}
		i++;
	}
	
	
	
	branchCode++;
	
	Session s4=sessionFactory.openSession();
	Criteria cr4=s4.createCriteria(MasterTableERP.class);
	cr4.add(Restrictions.eq("masterTableERPBranch","IT"));
	rollNumberCandidates=cr4.list();
	s4.close();
	
	logger.debug(rollNumberCandidates.size()+" is the size");

	i=0;
	m=(MasterTableERP)rollNumberCandidates.get(i);
	roll="";
	rollNumber=new RollNumber(type,year,"A",branchCode);
	logger.debug("--IT--");
	while(i<rollNumberCandidates.size())
	{
		m=(MasterTableERP)rollNumberCandidates.get(i);
		if(m.getMasterTableERPStatus().equals("Roll Number Pending"))
			{
			rollNumber.setBase(returnOffset(rollNumber));
			roll=buildRollNumber(rollNumber,rollNumber.getBase());
			m.setMasterTableERPRollNumber(roll);
			m.setMasterTableERPStatus("Student");
			abstractService.updateRecord(m);
			}
		i++;
	}
	
	
	
	branchCode++;
	
	Session s5=sessionFactory.openSession();
	Criteria cr5=s5.createCriteria(MasterTableERP.class);
	cr5.add(Restrictions.eq("masterTableERPBranch","PPT"));
	rollNumberCandidates=cr5.list();
	s5.close();
	
	logger.debug(rollNumberCandidates.size()+" is the size");

	i=0;
	m=(MasterTableERP)rollNumberCandidates.get(i);
	roll="";
	rollNumber=new RollNumber(type,year,"A",branchCode);
	logger.debug("--PPT--");
	while(i<rollNumberCandidates.size())
	{
		m=(MasterTableERP)rollNumberCandidates.get(i);
		if(m.getMasterTableERPStatus().equals("Roll Number Pending"))
			{
			rollNumber.setBase(returnOffset(rollNumber));
			roll=buildRollNumber(rollNumber,rollNumber.getBase());
			
			m.setMasterTableERPRollNumber(roll);
			m.setMasterTableERPStatus("Student");
			abstractService.updateRecord(m);
			}
		i++;
	}
	
	
	
	branchCode++;
	
	Session s6=sessionFactory.openSession();
	Criteria cr6=s6.createCriteria(MasterTableERP.class);
	cr6.add(Restrictions.eq("masterTableERPBranch","BT"));
	rollNumberCandidates=cr6.list();
	s6.close();
	
	logger.debug(rollNumberCandidates.size()+" is the size");

	i=0;
	m=(MasterTableERP)rollNumberCandidates.get(i);
	roll="";
	rollNumber=new RollNumber(type,year,"A",branchCode);
	logger.debug("--BT--");
	while(i<rollNumberCandidates.size())
	{
		m=(MasterTableERP)rollNumberCandidates.get(i);
		if(m.getMasterTableERPStatus().equals("Roll Number Pending"))
			{
			rollNumber.setBase(returnOffset(rollNumber));
			roll=buildRollNumber(rollNumber,rollNumber.getBase());
			
			m.setMasterTableERPRollNumber(roll);
			m.setMasterTableERPStatus("Student");
			abstractService.updateRecord(m);
			}
		i++;
	}
	
	
	branchCode++;
	Session s7=sessionFactory.openSession();
	Criteria cr7=s7.createCriteria(MasterTableERP.class);
	cr7.add(Restrictions.eq("masterTableERPBranch","MECH"));
	rollNumberCandidates=cr7.list();
	s7.close();
	
	logger.debug(rollNumberCandidates.size()+" is the size");

	i=0;
	m=(MasterTableERP)rollNumberCandidates.get(i);
	roll="";
	rollNumber=new RollNumber(type,year,"A",branchCode);
	logger.debug("--MECH--");
	while(i<rollNumberCandidates.size())
	{
		m=(MasterTableERP)rollNumberCandidates.get(i);
		if(m.getMasterTableERPStatus().equals("Roll Number Pending"))
			{
			rollNumber.setBase(returnOffset(rollNumber));
			roll=buildRollNumber(rollNumber,rollNumber.getBase());
			
			m.setMasterTableERPRollNumber(roll);
			m.setMasterTableERPStatus("Student");
			abstractService.updateRecord(m);
			}
		i++;
	}
	
	
	
	/*
	MeritListFe shortListedOne=(MeritListFe)meritListFe.get(0);
	AdmissionUser1 admUser=shortListedOne.getAdmissionUser1();
	Integer type;
	if(admUser.getAdmissionUserType().equals("FirstYearEngineering"))
		{
		type=1;
		}
	else
		{
		type=2;
		}
	Calendar c=Calendar.getInstance();
	int yearInt=c.YEAR;
	Integer year=new Integer(yearInt);
	
	String constant="A";
	

	String branch=shortListedOne.getBranchAssigned();
	
	Session s=sessionFactory.openSession();
	Criteria cr=s.createCriteria(AdmissionUser1.class);
	cr.add(Restrictions.eq("branchAssigned",branch
	s.close();
	
	*/
	
	
	ModelAndView mv=new ModelAndView(); 
	return mv;
}

	
	public String saveChanges(Integer[] ids,String[] values)
	{
		int i=0;
		List admUsers=abstractService.listRecord("AdmissionUser1");
		AdmissionUser1 temp=new AdmissionUser1();
		String status="";
		int j=0;
		String type="";
		logger.debug("Ids of j is"+ids[ids.length-1]);
		logger.debug("Size of ids "+ids.length);
		logger.debug("Size of values is"+values.length);
		for(i=0;i<ids.length;i++)
		{
			logger.debug("id: "+ids[i]+" values: "+values[i]);
		}
		for(i=0;i<admUsers.size();i++)
			{
				
				temp=(AdmissionUser1)admUsers.get(i);
				//logger.debug(temp.getId()+" and "+ids[j]);
				if(j<ids.length)
				{
				if(temp.getId().equals(ids[j]))
				{
				status=temp.getAdmissionUserStatus();
				
				if(status!=values[j] && values[j]!="")
					{
					logger.debug("Inside if");
					logger.debug("value : "+values[j]);
					logger.debug("id "+ids[j]);
					temp.setAdmissionUserStatus(values[j]);
					logger.debug("id to be reset: "+temp.getId());
					type=temp.getAdmissionUserType();
					logger.debug("Yeh hai"+type);
					abstractService.updateRecord(temp);
					}
				j++;
				}

				}
			}
		return type;
	}
	
	
private Admin setAdminDetails(AdminForm adminForm)
{
	Admin admin=new Admin();
	
	admin.setAdminEmail(adminForm.getAdminEmail());
	admin.setAdminFname(adminForm.getAdminFname());
	admin.setAdminMobileNumber(adminForm.getAdminMobileNumber());
	admin.setAdminPassword(adminForm.getAdminPassword());
	admin.setAdminType("Admin");
	return admin;
}




private RollNumber initializeRollNumber(Integer type,Integer year,String constant,Integer base)
	{
	
	RollNumber rollNumber=new RollNumber(type, year, constant, base);
	
	
	return rollNumber;
	}
private Integer returnOffset(RollNumber rollNumber)
{
	return (rollNumber.getBase()+1);
}
private String buildRollNumber(RollNumber rollNumber, Integer offset)	
	{
	
	String roll="";
	
	roll+=rollNumber.getType();
	roll+=rollNumber.getYear();
	roll+=rollNumber.getConstant();
	roll+=offset;
	return roll;
	}

}