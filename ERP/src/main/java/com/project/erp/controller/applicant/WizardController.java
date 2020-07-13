package com.project.erp.controller.applicant;


import java.io.IOException;
import java.io.OutputStream;
import java.io.StringBufferInputStream;
import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.FactoryConfigurationError;
import javax.xml.parsers.ParserConfigurationException;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.xhtmlrenderer.pdf.ITextRenderer;
import org.xml.sax.SAXException;

import com.lowagie.text.DocumentException;
import com.project.erp.common.util.logging.InjectableLogger;
import com.project.erp.forms.applicant.AcademicDetailsDseForm;
import com.project.erp.forms.applicant.AdmissionUserBranchSelectionForm;
import com.project.erp.forms.applicant.AdmissionUserFeAcademicsForm;
import com.project.erp.forms.applicant.NewAdmissionForm1;
import com.project.erp.forms.applicant.NewAdmissionPGForm;
import com.project.erp.model.AcademicDetailsDse;
import com.project.erp.model.AdmissionUser1;
import com.project.erp.model.AdmissionUserBranchSelection;
import com.project.erp.model.AdmissionUserFeAcademics;
import com.project.erp.model.Users;
import com.project.erp.pdfgen.PictureRenderer;
import com.project.erp.service.applicant.AbstractService;
//import com.gsl.web.domin.model.AdmissionUserDseAcademics;

/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping(value = "/")

public class WizardController {
	
	@InjectableLogger
	public Logger logger;

	@Autowired
	private AbstractService abstractService;
	
	
@PreAuthorize("hasRole('STUDENT')")	
@RequestMapping(value = "/test-orm" ,method = RequestMethod.GET)
	
	public ModelAndView testorm(Model model, HttpSession session) {
		
		ModelAndView mv=new ModelAndView();
		
		List dummy=abstractService.listRecord("DummyTable");
		
		logger.debug("Size of dummy is"+dummy.size());
		
		mv.setViewName("applicant/Admission/error");
		return mv;
}
	
	
	@RequestMapping(value = "/fe1" ,method = RequestMethod.GET)
	
	public ModelAndView fe1(Model model, HttpSession session) {
		
		ModelAndView mv=new ModelAndView();
		mv.setViewName("applicant/Admission/fe1");
		model.addAttribute("userID", session.getAttribute("userID"));
		model.addAttribute("userModel", session.getAttribute("userModel"));
		
		return  mv;
		
	}

	@RequestMapping(value = "/userentry", method = RequestMethod.GET)
	public ModelAndView userentry(Model model, HttpSession session)
	{
		ModelAndView mv=new ModelAndView();
		List <AdmissionUser1> adm= abstractService.listRecord("AdmissionUser1");
		Users user=new Users();
		int i=0;
		for(i=0;i<adm.size();i++)
		{
			user.setUsername("test"+i+"@gmail.com");
			user.setPassword("Qwerty@123");
			user.setAuthority("APPLICANT");
			adm.get(i).setUsers(user);
			abstractService.addRecord(user);
			abstractService.updateRecord(adm.get(i));
		}
			mv.setViewName("Error");
			return mv;
	}
	
	@RequestMapping(value = "/fe2" ,method = RequestMethod.GET)
	
	public ModelAndView fe2(@ModelAttribute("AdmissionUser1") NewAdmissionForm1 newAdmissionForm,Model model, HttpSession session) {
		
		//UPDATE LOGIC
		
			//String userID=(String)session.getAttribute("userID");
			Integer userID=(Integer)session.getAttribute("userID");//Monika
			List userData= abstractService.listRecord("AdmissionUser1",userID);
		// TODO Check admUser1
		
			AdmissionUser1 userSession=(AdmissionUser1)session.getAttribute("userModel");
			
			//String password=userSession.getAdmissionUserPassword();
		
			logger.debug("new admission object "+newAdmissionForm.toString());
		AdmissionUser1 admUser = setRegistrationDetails1(userSession,newAdmissionForm,userID);
		//AdmissionUser1 admUser1=(AdmissionUser1)userData.get(0);
		//abstractService.addRecord((AdmissionUser1)userData.get(0));Monika
		abstractService.updateRecord(admUser);
		session.setAttribute("userModel",admUser);
		
		
		//UPDATE LOGIC ENDS HERE
		
		String type=admUser.getAdmissionUserType();
		
		String viewname;
		List acad;
		if(type.equals("Diploma"))
		{
			viewname="applicant/Admission/dse2";
			acad=abstractService.listForeignRecord("AcademicDetailsDse", userID);
			
			if(acad.size()>0)
			{
			AcademicDetailsDse  admUserAcad=(AcademicDetailsDse)acad.get(0);
			model.addAttribute("userModelAcademics", admUserAcad);
			}
		}
		else
		{
			viewname="applicant/Admission/fe2";
			acad=abstractService.listForeignRecord("AdmissionUserFeAcademics", userID);
			
			if(acad.size()>0)
			{
			AdmissionUserFeAcademics  admUserAcad=(AdmissionUserFeAcademics)acad.get(0);
			model.addAttribute("userModelAcademics", admUserAcad);
			}
		}
		// TODO Insert alternative way
		//abstractService.addRecord(admUser);
		ModelAndView mv=new ModelAndView();
		mv.setViewName(viewname);
		model.addAttribute("id", admUser.getId());
		
		
		
		
		//model.addAttribute("userDataRecord",tempuser.getAdmissionUserFname());
		return  mv;
		
	}	
	
	
	
	@RequestMapping(value = "/fe3" ,method = RequestMethod.GET)
	
	public ModelAndView fe3(@ModelAttribute("AdmissionUserFeAcademicsForm") AdmissionUserFeAcademicsForm newAdmissionForm,Model model, HttpSession session) {
		
		//AdmissionUserFeAcademics admUser=setRegistrationDetails2(newAdmissionForm);
		
		Integer userID=(Integer)session.getAttribute("userID");
		AdmissionUser1 sessionmodel=(AdmissionUser1)session.getAttribute("userModel");
		//List acad=abstractService.listForeignRecord("AdmissionUserFeAcademics", userID);
		AdmissionUserFeAcademics admUserbefore=(AdmissionUserFeAcademics)sessionmodel.getAdmissionUserFeAcademics();
		AdmissionUserFeAcademics admUser=setRegistrationDetails2(newAdmissionForm,admUserbefore);
		logger.debug(admUser.getAdmissionUserFeAcademicsAllIndiaJeeRank()+" is the all India JEE Rank");
		sessionmodel.setAdmissionUserFeAcademics(admUser);
		
		abstractService.updateRecord(admUser);
		abstractService.updateRecord(sessionmodel);
		session.setAttribute("userModel", sessionmodel);
		ModelAndView mv=new ModelAndView();
		mv.setViewName("applicant/Admission/fe3");
		
		List acads=abstractService.listForeignRecord("AdmissionUserBranchSelection", userID);
		if(acads.size()>0)
		{
		AdmissionUserBranchSelection admUserBranch=(AdmissionUserBranchSelection)acads.get(0);
		model.addAttribute("userModelBranchSelection", admUserBranch);
		}

		
		
		
		return  mv;
		
	}	
		
	
	
	
	@RequestMapping(value = "/dse3" ,method = RequestMethod.GET)
	
	public ModelAndView dse3(@ModelAttribute("AcademicDetailsDse") AcademicDetailsDseForm newAdmissionForm,Model model, HttpSession session) {
		
		
				
		//Integer rowCount=abstractService.rowCount("AcademicDetailsDse");
		
		//logger.debug("Number of rows are "+rowCount);
		Integer userID=(Integer)session.getAttribute("userID");
		AdmissionUser1 sessionmodel=(AdmissionUser1)session.getAttribute("userModel");
		//List acad=abstractService.listForeignRecord("AcademicDetailsDse", userID);
		AcademicDetailsDse admUserbefore=(AcademicDetailsDse)sessionmodel.getAcademicDetailsDse();
		AcademicDetailsDse admUser=setRegistrationDetailsdse2(newAdmissionForm,admUserbefore);
		abstractService.updateRecord(admUser);
		abstractService.updateRecord(sessionmodel);
		//admUser.setAdmissionUserId(userID);
		/*
		logger.debug(admUser.getAcademicDetailsDseDiplomaCategoryRank());
		logger.debug(admUser.getAcademicDetailsDseDiplomaMarksFirstYearObtained());
		logger.debug(admUser.getAcademicDetailsDseDiplomaMarksSecondYearObtained());
		logger.debug(admUser.getAcademicDetailsDseDiplomaMarksThirdYearObtained());
		logger.debug(admUser.getacademicDetailsDseDiplomaMarksTotalFirstYear());
		logger.debug(admUser.getacademicDetailsDseDiplomaMarksTotalSecondYear());
		logger.debug(admUser.getacademicDetailsDseDiplomaMarksTotalThirdYear());
		logger.debug(admUser.getAcademicDetailsDseDiplomaStateRank());
		logger.debug(admUser.getAcademicDetailsDseDiplomaUniversityRank());
		logger.debug(admUser.getAcademicDetailsDseDiplomaYearOfPassing());
		logger.debug(admUser.getAcademicDetailsDseSscMarksGrandObtained());
		logger.debug(admUser.getAcademicDetailsDseSscMarksMathsObtained());
		logger.debug(admUser.getAcademicDetailsDseSscMarksTotalGrand());
		logger.debug(admUser.getAcademicDetailsDseSscMarksTotalMaths());
		logger.debug(admUser.getAcademicDetailsDseSscPercentageObtained());
		logger.debug(admUser.getAcademicDetailsDseSscYearOfPassing());
		logger.debug("UserID: "+admUser.getAdmissionUserId());
		*/
		session.setAttribute("userModel", sessionmodel);
		model.addAttribute("userModel", session.getAttribute("userModel"));
		//abstractService.addRecord(admUser);
		ModelAndView mv=new ModelAndView();
		mv.setViewName("applicant/Admission/dse3");
		

		return  mv;
		
	}	
	
	
@RequestMapping(value = "/dse4" ,method = RequestMethod.GET)
	
	public ModelAndView dse4(@ModelAttribute("NewAdmissionPGForm") NewAdmissionPGForm newAdmissionForm,Model model, HttpSession session) {
		
		
		logger.debug("banta "+newAdmissionForm.getAdmissionUserPGFatherAnnualIncome());
		AdmissionUser1 userSession=(AdmissionUser1)session.getAttribute("userModel"); 
      		
		AdmissionUser1 admUser=setRegistrationDetails4(userSession,newAdmissionForm);
		
		//model.addAttribute("userModel", session.getAttribute("userModel"));
		
		logger.debug("Pg form data is "+newAdmissionForm.getAdmissionUserPGFatherOccupation());
		ModelAndView mv=new ModelAndView();
		model.addAttribute("userModel", session.getAttribute("userModel"));
		logger.info("This is "+session.getAttribute("userModel"));
		abstractService.updateRecord(admUser);
		session.setAttribute("userModel", admUser);
		//REMEMBER//
		
		mv.setViewName("applicant/Admission/dse4");

		
		//REMEMBER//
		
		return  mv;
		
	}	
	
	
	@RequestMapping(value = "/fe4" ,method = RequestMethod.GET)
	
	public ModelAndView fe4(@ModelAttribute("AdmissionUserBranchSelectionForm") AdmissionUserBranchSelectionForm newAdmissionForm,Model model, HttpSession session) {
		
		//AdmissionUserBranchSelection admUser=setRegistrationDetails3(newAdmissionForm);
		Integer userID=(Integer)session.getAttribute("userID");
		AdmissionUser1 sessionmodel=(AdmissionUser1)session.getAttribute("userModel");
		List acad=abstractService.listForeignRecord("AdmissionUserBranchSelection", userID);
		AdmissionUserBranchSelection admUserbefore=(AdmissionUserBranchSelection)sessionmodel.getAdmUserBranchSelection();
		AdmissionUserBranchSelection admUser=setRegistrationDetails3(newAdmissionForm,admUserbefore);
		abstractService.updateRecord(admUser);
		abstractService.updateRecord(sessionmodel);
		//admUser.setAdmissionUserId(userID);
		//abstractService.addRecord(admUser);
		
		session.setAttribute("userModel", sessionmodel);
		model.addAttribute("userModel", session.getAttribute("usermodel"));
		ModelAndView mv=new ModelAndView();
		mv.setViewName("applicant/Admission/fe4");
		
		return  mv;
		
	}
	
	@RequestMapping(value = "/fe5" ,method = RequestMethod.GET)
	
	public ModelAndView fe5(@ModelAttribute("NewAdmissionPGForm") NewAdmissionPGForm newAdmissionForm,Model model, HttpSession session) {
		
		
		
		AdmissionUser1 userSession=(AdmissionUser1)session.getAttribute("userModel"); 
		
		AdmissionUser1 admUser=setRegistrationDetails4(userSession,newAdmissionForm);
		
		//model.addAttribute("userModel", session.getAttribute("userModel"));
		
		logger.debug("Pg form data is "+newAdmissionForm.getAdmissionUserPGFatherOccupation());
		ModelAndView mv=new ModelAndView();
		model.addAttribute("userModel", session.getAttribute("userModel"));
		logger.info("This is "+session.getAttribute("userModel"));
		abstractService.updateRecord(admUser);
		session.setAttribute("userModel", admUser);
		//REMEMBER//
		
		mv.setViewName("applicant/Admission/fe5");

		
		//REMEMBER//
		
		return  mv;
		
	}	
	
	@RequestMapping(value = "/fe6" ,method = RequestMethod.GET)
	
	public ModelAndView fe6(Model model, HttpSession session) {
		
		AdmissionUser1 admUser=(AdmissionUser1)session.getAttribute("userModel");
		
		String fullName="";
		
		if(admUser.getAdmissionUserGender().equalsIgnoreCase("Male"))
		{
			fullName+="Mr. ";
		}
		else
		{
			fullName+="Ms. ";
					
		}
		
		fullName+=admUser.getAdmissionUserSurName()+" ";
		fullName+=admUser.getAdmissionUserFname()+" ";
		fullName+=admUser.getAdmissionUserFatherName();
		logger.debug("Full name is "+fullName);
		model.addAttribute("fullName", fullName);
		ModelAndView mv=new ModelAndView();
		mv.setViewName("applicant/Admission/fe6");
		
		return  mv;
		
	}
	
	@RequestMapping(value = "/fe7" ,method = RequestMethod.GET)
	
	public ModelAndView fe7(Model model, HttpSession session) {
		
		
		ModelAndView mv=new ModelAndView();
		AdmissionUser1 admUser=(AdmissionUser1)session.getAttribute("userModel");
		admUser.setAdmissionUserStatus("Applied");
		abstractService.updateRecord(admUser);
		session.setAttribute("userModel", admUser);
		mv.setViewName("applicant/Admission/fe7");
		
		return  mv;
		
	}	
	
	
	@SuppressWarnings("deprecation")
	@RequestMapping("/app")
	public void blah(HttpServletResponse response,Model model,HttpSession session) throws ParserConfigurationException, FactoryConfigurationError, SAXException, IOException, DocumentException {

	StringBuffer b = new StringBuffer();
	
	//Integer userId=3;
	Integer userId = (Integer)session.getAttribute("userID");
	//logger.info("User ID is "+userId1);
	List admUsers=abstractService.listRecord("AdmissionUser1",userId);
	//List admUsers1=abstractService.listRecord("AdmissionUser1",userId1);
	
	//logger.info("Issue of size"+admUsers1.size());
	AdmissionUser1 admUser=(AdmissionUser1)session.getAttribute("userModel");
	b=getString(admUser,admUser.getId());
	/*
	int userID=(Integer)session.getAttribute("userID");
	List admUsers=abstractService.listRecord("AdmissionUser1", (userID+1)); //Remember +1

	AdmissionUser1 admUser=(AdmissionUser1)admUsers.get(0);

	String applied_under=admUser.getAdmissionAppliedUnder();
	String blood_group=admUser.getAdmissionBloodGroup();
	String caste=admUser.getAdmissionCaste();
	String current_address=admUser.getAdmissionCurrentAddress();
	java.sql.Date date_of_birth=admUser.getAdmissionDateOfBirth();
	String domicile=admUser.getAdmissionDomicile();
	String eco_backward=admUser.getAdmissionEcoBackward();
	String email=admUser.getAdmissionEmail();
	String landline_number=admUser.getAdmissionLandLineNumber();
	String mobile_number=admUser.getAdmissionMobileNumber();
	String nationality=admUser.getAdmissionNationality();
	String permanent_address=admUser.getAdmissionPermanentAddress();
	String phy_handicapped=admUser.getAdmissionPhyHandicapped();
	String place_of_birth=admUser.getAdmissionPlaceOfBirth();
	String religion=admUser.getAdmissionReligion();
	String rh=admUser.getAdmissionRh();
	String state=admUser.getAdmissionState();
	String father_name=admUser.getAdmissionUserFatherName();
	String user_name=admUser.getAdmissionUserFname();
	String gender=admUser.getAdmissionUserGender();
	String mother_name=admUser.getAdmissionUserMotherName();
	String surname=admUser.getAdmissionUserSurName();
	
	
	// TODO Alternate parsing technique using JAXParser
	b.append("<html><body><h1 align="+" 'center'   "+">Application Form</h1>");
	b.append("<table width="+" '600' "+ "border="+" '2' "+">");
	b.append("<tr><td>Applied Under</td><td>"+applied_under+"</td></tr>");
	b.append("<tr><td>Surname</td><td>"+surname+"</td></tr>");
	b.append("<tr><td>Name</td><td>"+user_name+"</td></tr>");
	b.append("<tr><td>Father's Name</td><td>"+father_name+"</td></tr>");
	b.append("<tr><td>Mother's name</td><td>"+mother_name+"</td></tr>");
	b.append("<tr><td>Permanent Address</td><td>"+permanent_address+"</td></tr>");
	b.append("<tr><td>Current Address</td><td>"+current_address+"</td></tr>");
	b.append("<tr><td>Landline Number</td><td>"+landline_number+"</td></tr>");
	b.append("<tr><td>Mobile Number</td><td>"+mobile_number+"</td></tr>");
	b.append("<tr><td>Email</td><td>"+email+"</td></tr>");
	b.append("<tr><td>Date of birth</td><td>"+date_of_birth+"</td></tr>");
	b.append("<tr><td>Place of birth</td><td>"+place_of_birth+"</td></tr>");
	b.append("<tr><td>Caste</td><td>"+caste+"</td></tr>");
	b.append("<tr><td>Physically handicapped</td><td>"+phy_handicapped+"</td></tr>");
	b.append("<tr><td>Economically backward</td><td>"+eco_backward+"</td></tr>");
	b.append("<tr><td>Blood Group</td><td>"+blood_group+" "+rh+"</td></tr>");
	b.append("</table></body></html>");
	*/
	DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
	org.w3c.dom.Document doc = builder.parse(new StringBufferInputStream(b.toString()));
	ITextRenderer renderer = new ITextRenderer();
	renderer.getSharedContext().setReplacedElementFactory(new PictureRenderer(renderer.getSharedContext().getReplacedElementFactory()));
	renderer.setDocument(doc, null);
	OutputStream os = response.getOutputStream();
	renderer.layout();
	renderer.createPDF(os);
	os.close();
	}
	
	
	
	
	//private  AdmissionUser1 setRegistrationDetails1(NewAdmissionForm1 newAdmissionForm,String userID) {
	private  AdmissionUser1 setRegistrationDetails1(AdmissionUser1 userSession,NewAdmissionForm1 newAdmissionForm,Integer userID) {
	AdmissionUser1 admUser = userSession;
	
	//System.out.println(newAdmissionForm.getUser_fname());
	
	
	//admUser.setId(9);
	//admUser.setAdmissionUserUserId(userID);Monika
	//admUser.setId(userID);//Monika
	//admUser.setAdmissionUserPassword(password);
	System.out.println(" User ID :::::::: "+newAdmissionForm.getId());
	logger.debug(newAdmissionForm.getAdmissionUserFname() + " himesh");
	admUser.setAdmissionUserFname(newAdmissionForm.getAdmissionUserFname());
	
	admUser.setAdmissionUserSurName(newAdmissionForm.getAdmissionUserSurName());
	
	admUser.setAdmissionUserEmail(newAdmissionForm.getAdmissionEmail());
	
	admUser.setAdmissionUserFatherName(newAdmissionForm.getAdmissionUserFatherName());
	
	admUser.setAdmissionUserMotherName(newAdmissionForm.getAdmissionUserMotherName());
	
	//admUser.setAdmissionUserPassword(newAdmissionForm.getAdmissionUserPassword());
	
	//admUser.setAdmissionUserUserName(newAdmissionForm.getAdmissionUserUserName());
	
	admUser.setAdmissionUserGender(newAdmissionForm.getAdmissionUserGender());
	
	
	admUser.setAdmissionUserAppliedUnder(newAdmissionForm.getAdmissionUserAppliedUnder());
	
	admUser.setAdmissionUserPermanentAddress(newAdmissionForm.getAdmissionUserPermanentAddress());
	
	logger.debug("Permanent address is"+newAdmissionForm.getAdmissionUserPermanentAddress());
	
	admUser.setAdmissionUserCurrentAddress(newAdmissionForm.getAdmissionUserCurrentAddress());
	
	
	
	admUser.setAdmissionUserLandlineNumber(newAdmissionForm.getAdmissionUserLandLineNumber());
	
	admUser.setAdmissionUserMobileNumber(newAdmissionForm.getAdmissionUserMobileNumber());
	
	admUser.setAdmissionUserDateOfBirth(newAdmissionForm.getAdmissionUserDateOfBirth());
	
	
	admUser.setAdmissionUserPlaceOfBirth(newAdmissionForm.getAdmissionUserPlaceOfBirth());
	
	admUser.setAdmissionUserGender(newAdmissionForm.getAdmissionUserGender());
	
	admUser.setAdmissionUserDomicile(newAdmissionForm.getAdmissionUserDomicile());
	
	admUser.setAdmissionUserState(newAdmissionForm.getAdmissionUserState());
	
	admUser.setAdmissionUserNationality(newAdmissionForm.getAdmissionUserNationality());
	
	admUser.setAdmissionUserReligion(newAdmissionForm.getAdmissionUserReligion());
	
	admUser.setAdmissionUserMotherTongue(newAdmissionForm.getAdmissioUserMotherTongue());
	
	admUser.setAdmissionUserCaste(newAdmissionForm.getAdmissionUserCaste());
	
	admUser.setAdmissionUserPhyHandicapped(newAdmissionForm.getAdmissionUserPhyHandicapped());
	
	admUser.setAdmissionUserEcoBackward(newAdmissionForm.getAdmissionUserEcoBackward());
	
	admUser.setAdmissionUserBloodGroup(newAdmissionForm.getAdmissionUserBloodGroup());
	
	admUser.setAdmissionUserRh(newAdmissionForm.getAdmissionUserRh());

	
	//admUser.setAdmissionUserUserId(newAdmissionForm);
	
	
	
	return admUser;
	}
	
	
	private  AcademicDetailsDse setRegistrationDetailsdse2(AcademicDetailsDseForm newAdmissionForm, AcademicDetailsDse admUser){
		
		
		

		admUser.setAcademicDetailsDseDiplomaCategoryRank(newAdmissionForm.getAcademicDetailsDseDiplomaCategoryRank());
		admUser.setAcademicDetailsDseDiplomaMarksFirstYearObtained(newAdmissionForm.getAcademicDetailsDseDiplomaMarksFirstYearObtained());
		admUser.setAcademicDetailsDseDiplomaMarksSecondYearObtained(newAdmissionForm.getAcademicDetailsDseDiplomaMarksSecondYearObtained());
		admUser.setAcademicDetailsDseDiplomaMarksThirdYearObtained(newAdmissionForm.getAcademicDetailsDseDiplomaMarksThirdYearObtained());
		admUser.setAcademicDetailsDseDiplomaMarksTotalFirstYear(newAdmissionForm.getacademicDetailsDseDiplomaMarksTotalFirstYear());
		admUser.setAcademicDetailsDseDiplomaMarksTotalSecondYear(newAdmissionForm.getacademicDetailsDseDiplomaMarksTotalSecondYear());
		admUser.setAcademicDetailsDseDiplomaMarksTotalThirdYear(newAdmissionForm.getacademicDetailsDseDiplomaMarksTotalThirdYear());
		admUser.setAcademicDetailsDseDiplomaStateRank(newAdmissionForm.getAcademicDetailsDseDiplomaStateRank());
		admUser.setAcademicDetailsDseDiplomaUniversityRank(newAdmissionForm.getAcademicDetailsDseDiplomaUniversityRank());
		admUser.setAcademicDetailsDseDiplomaYearOfPassing(newAdmissionForm.getAcademicDetailsDseDiplomaYearOfPassing());
		admUser.setAcademicDetailsDseSscMarksGrandObtained(newAdmissionForm.getAcademicDetailsDseSscMarksGrandObtained());
		admUser.setAcademicDetailsDseSscMarksMathsObtained(newAdmissionForm.getAcademicDetailsDseSscMarksMathsObtained());
		admUser.setAcademicDetailsDseSscMarksTotalGrand(newAdmissionForm.getAcademicDetailsDseSscMarksTotalGrand());
		admUser.setAcademicDetailsDseSscMarksTotalMaths(newAdmissionForm.getAcademicDetailsDseSscMarksTotalMaths());
		admUser.setAcademicDetailsDseSscPercentageObtained(newAdmissionForm.getAcademicDetailsDseSscPercentageObtained());
		admUser.setAcademicDetailsDseSscYearOfPassing(newAdmissionForm.getAcademicDetailsDseSscYearOfPassing());
	
		return admUser;
	}
	
	
	
	
	private  AdmissionUserFeAcademics setRegistrationDetails2(AdmissionUserFeAcademicsForm newAdmissionForm, AdmissionUserFeAcademics admUser) {
	
		
		admUser.setAdmissionUserFeAcademicsAllIndiaJeeRank(newAdmissionForm.getAdmissionUserFeAcademicsAllIndiaJeeRank());
		
		admUser.setAdmissionUserFeAcademicsBoardPercentileObtained(newAdmissionForm.getAdmissionUserFeAcademicsBoardPercentileObtained());
		
		admUser.setAdmissionUserFeAcademicsJeeChemistryObtained(newAdmissionForm.getAdmissionUserFeAcademicsJeeChemistryObtained());
		
		admUser.setAdmissionUserFeAcademicsJeeChemistryTotal(newAdmissionForm.getAdmissionUserFeAcademicsJeeChemistryTotal());
		
		admUser.setAdmissionUserFeAcademicsJeeMathsObtained(newAdmissionForm.getAdmissionUserFeAcademicsJeeMathsObtained());

		admUser.setAdmissionUserFeAcademicsJeeMathsTotal(newAdmissionForm.getAdmissionUserFeAcademicsJeeMathsTotal());
		
		admUser.setAdmissionUserFeAcademicsJeePercentileObtained(newAdmissionForm.getAdmissionUserFeAcademicsJeePercentileObtained());
		
		admUser.setAdmissionUserFeAcademicsJeePhysicsObtained(newAdmissionForm.getAdmissionUserFeAcademicsJeePhysicsObtained());
		
		admUser.setAdmissionUserFeAcademicsJeePhysicsTotal(newAdmissionForm.getAdmissionUserFeAcademicsJeePhysicsTotal());
		
		admUser.setAdmissionUserFeAcademicsJeeTotal(newAdmissionForm.getAdmissionUserFeAcademicsJeeTotal());
		
		admUser.setAdmissionUserFeAcademicsJeeTotalObtained(newAdmissionForm.getAdmissionUserFeAcademicsJeeTotalObtained());
		
		admUser.setAdmissionUserFeAcademicsSscGrandMarksObtained(newAdmissionForm.getAdmissionUserFeAcademicsSscGrandMarksObtained());
		
		admUser.setAdmissionUserFeAcademicsSscGrandMarksTotal(newAdmissionForm.getAdmissionUserFeAcademicsSscGrandMarksTotal());
		
		admUser.setAdmissionUserFeAcademicsSscMathsMarksObtained(newAdmissionForm.getAdmissionUserFeAcademicsSscMathsMarksObtained());
		
		admUser.setAdmissionUserFeAcademicsSscMathsMarksTotal(newAdmissionForm.getAdmissionUserFeAcademicsSscMathsMarksTotal());
		
		admUser.setAdmissionUserFeAcademicsSscPercentageObtained(newAdmissionForm.getAdmissionUserFeAcademicsSscPercentageObtained());

		admUser.setAdmissionUserFeAcademicsSscYearOfPassing(newAdmissionForm.getAdmissionUserFeAcademicsSscYearOfPassing());
		
		logger.debug("SSC year of passing is"+newAdmissionForm.getAdmissionUserFeAcademicsSscYearOfPassing());
		
		admUser.setAdmissionUserFeAcademicsStateJeeRank(newAdmissionForm.getAdmissionUserFeAcademicsStateJeeRank());
		
		admUser.setAdmissionUserFeAcademicsXiiBoard(newAdmissionForm.getAdmissionUserFeAcademicsXiiBoard());
		
		admUser.setAdmissionUserFeAcademicsXiiChemistryMarksObtained(newAdmissionForm.getAdmissionUserFeAcademicsXiiChemistryMarksObtained());
		
		admUser.setAdmissionUserFeAcademicsXiiChemistryMarksTotal(newAdmissionForm.getAdmissionUserFeAcademicsXiiChemistryMarksTotal());
		
		admUser.setAdmissionUserFeAcademicsXiiEnglishMarksObtained(newAdmissionForm.getAdmissionUserFeAcademicsXiiEnglishMarksObtained());
		
		admUser.setAdmissionUserFeAcademicsXiiEnglishMarksTotal(newAdmissionForm.getAdmissionUserFeAcademicsXiiEnglishMarksTotal());
		
		admUser.setAdmissionUserFeAcademicsXiiMathsMarksObtained(newAdmissionForm.getAdmissionUserFeAcademicsXiiMathsMarksObtained());
		
		admUser.setAdmissionUserFeAcademicsXiiMathsMarksTotal(newAdmissionForm.getAdmissionUserFeAcademicsXiiMathsMarksTotal());
		
		admUser.setAdmissionUserFeAcademicsXiiPcmObtained(newAdmissionForm.getAdmissionUserFeAcademicsXiiPcmObtained());
		
		admUser.setAdmissionUserFeAcademicsXiiPcmTotal(newAdmissionForm.getAdmissionUserFeAcademicsXiiPcmTotal());
		
		admUser.setAdmissionUserFeAcademicsXiiPhysicsMarksObtained(newAdmissionForm.getAdmissionUserFeAcademicsXiiPhysicsMarksObtained());
		
		admUser.setAdmissionUserFeAcademicsXiiPhysicsMarksTotal(newAdmissionForm.getAdmissionUserFeAcademicsXiiPhysicsMarksTotal());
		
		admUser.setAdmissionUserFeAcademicsXiiPmvObtained(newAdmissionForm.getAdmissionUserFeAcademicsXiiPmvObtained());
		
		admUser.setAdmissionUserFeAcademicsXiiPmvTotal(newAdmissionForm.getAdmissionUserFeAcademicsXiiPmvTotal());
		
		admUser.setAdmissionUserFeAcademicsXiiVocationalMarksObtained(newAdmissionForm.getAdmissionUserFeAcademicsXiiVocationalMarksObtained());
		
		admUser.setAdmissionUserFeAcademicsXiiVocationalMarksTotal(newAdmissionForm.getAdmissionUserFeAcademicsXiiVocationalMarksTotal());
		
		admUser.setAdmissionUserFeAcademicsXiiYearOfPassing(newAdmissionForm.getAdmissionUserFeAcademicsXiiYearOfPassing());
		
		admUser.setAdmissionUserFeAcademicsMeritScore(newAdmissionForm.getAdmissionUserFeAcademicsMeritScore());
		
		
		return admUser;
	}
	
	
	private AdmissionUserBranchSelection setRegistrationDetails3(AdmissionUserBranchSelectionForm newAdmissionForm, AdmissionUserBranchSelection admUser)
	{
		//AdmissionUserBranchSelection admUser=new AdmissionUserBranchSelection();
		
		admUser.setAdmissionUserBranchSelectionBTPriority(newAdmissionForm.getAdmissionUserBranchSelectionBTPriority());
		
		admUser.setAdmissionUserBranchSelectionCEPriority(newAdmissionForm.getAdmissionUserBranchSelectionCEPriority());
		
		admUser.setAdmissionUserBranchSelectionEXTCPriority(newAdmissionForm.getAdmissionUserBranchSelectionEXTCPriority());
		
		admUser.setAdmissionUserBranchSelectionITPriority(newAdmissionForm.getAdmissionUserBranchSelectionITPriority());
		
		admUser.setAdmissionUserBranchSelectionMECHPriority(newAdmissionForm.getAdmissionUserBranchSelectionMECHPriority());
		
		admUser.setAdmissionUserBranchSelectionPPTPriority(newAdmissionForm.getAdmissionUserBranchSelectionPPTPriority());
		
		
		return admUser;
		
	}	
	
		
	private AdmissionUser1 setRegistrationDetails4(AdmissionUser1 userSession,NewAdmissionPGForm newAdmissionForm)
	{
		AdmissionUser1 admUser=userSession;
		
		logger.debug("null idhar aa rha hai"+newAdmissionForm.getAdmissionUserPGFatherAnnualIncome());
		
		admUser.setAdmissionUserFatherAnnualIncome(newAdmissionForm.getAdmissionUserPGFatherAnnualIncome());
		
		admUser.setAdmissionUserFatherEmail(newAdmissionForm.getAdmissionUserPGFatherEmail());
		
		admUser.setAdmissionUserFatherMobileNumber(newAdmissionForm.getAdmissionUserPGFatherMobileNumber());
		
		admUser.setAdmissionUserFatherOccupation(newAdmissionForm.getAdmissionUserPGFatherOccupation());
		
		admUser.setAdmissionUserFatherOfficeAddress(newAdmissionForm.getAdmissionUserPGFatherOfficeAddress());
		
		admUser.setAdmissionUserFatherTelephoneNumber(newAdmissionForm.getAdmissionUserPGFatherOfficeAddress());
		
		admUser.setAdmissionUserGuardianAnnualIncome(newAdmissionForm.getAdmissionUserPGGuardianAnnualIncome());
		
		admUser.setAdmissionUserGuardianEmail(newAdmissionForm.getAdmissionUserPGGuardianEmail());
		
		admUser.setAdmissionUserGuardianMobileNumber(newAdmissionForm.getAdmissionUserPGGuardianMobileNumber());
		
		admUser.setAdmissionUserGuardianName(newAdmissionForm.getAdmissionUserPGGuardianName());
		
		admUser.setAdmissionUserGuardianOccupation(newAdmissionForm.getAdmissionUserPGGuardianOccupation());
		
		admUser.setAdmissionUserGuardianOfficeAddress(newAdmissionForm.getAdmissionUserPGGuardianOfficeAddress());
		
		admUser.setAdmissionUserGuardianTelephoneNumber(newAdmissionForm.getAdmissionUserPGGuardianTelephoneNumber());
		
		admUser.setAdmissionUserMotherAnnualIncome(newAdmissionForm.getAdmissionUserPGMotherAnnualIncome());
		
		admUser.setAdmissionUserMotherEmail(newAdmissionForm.getAdmissionUserPGMotherEmail());
		
		admUser.setAdmissionUserMotherMobileNumber(newAdmissionForm.getAdmissionUserPGMotherMobileNumber());
		
		admUser.setAdmissionUserMotherOccupation(newAdmissionForm.getAdmissionUserPGMotherOccupation());
		
		admUser.setAdmissionUserMotherOfficeAddress(newAdmissionForm.getAdmissionUserPGMotherOfficeAddress());
		
		admUser.setAdmissionUserMotherTelephoneNumber(newAdmissionForm.getAdmissionUserPGMotherTelephoneNumber());
		
		
		return admUser;
		
	}	
	
	
	private StringBuffer getString(AdmissionUser1 admUser,Integer userId)
	{
		
		int year=Calendar.getInstance().get(Calendar.YEAR);
		
		String appId=""+year+userId;
	
		StringBuffer b=new StringBuffer();
		/* ----------STEP 1---------- */
		String applied_under=admUser.getAdmissionUserAppliedUnder();
		String blood_group=admUser.getAdmissionUserBloodGroup();
		String caste=admUser.getAdmissionUserCaste();
		String current_address=admUser.getAdmissionUserCurrentAddress();
		java.sql.Date date_of_birth=admUser.getAdmissionUserDateOfBirth();
		String domicile=admUser.getAdmissionUserDomicile();
		String eco_backward=admUser.getAdmissionUserEcoBackward();
		String email=admUser.getAdmissionUserEmail();
		String landline_number=admUser.getAdmissionUserLandlineNumber();
		String mobile_number=admUser.getAdmissionUserMobileNumber();
		String nationality=admUser.getAdmissionUserNationality();
		String permanent_address=admUser.getAdmissionUserPermanentAddress();
		String phy_handicapped=admUser.getAdmissionUserPhyHandicapped();
		String place_of_birth=admUser.getAdmissionUserPlaceOfBirth();
		String religion=admUser.getAdmissionUserReligion();
		String rh=admUser.getAdmissionUserRh();
		String state=admUser.getAdmissionUserState();
		String father_name=admUser.getAdmissionUserFatherName();
		String user_name=admUser.getAdmissionUserFname();
		String gender=admUser.getAdmissionUserGender();
		String mother_name=admUser.getAdmissionUserMotherName();
		String surname=admUser.getAdmissionUserSurName();
		
		
		
		/*----------STEP 2----------*/
		
		List admUserAcademics;
		
		
		

		/* ----------STEP 3---------- */
		
		
		
		
		b.append("<html><body><center><h4 align="+" 'center' "+"><img src="+" 'sies.png' "+" width="+" '300' "+ "height="+" '150' "+"/><br/>");
		b.append("Sri Chandrasekarendra Saraswathy Vidyapuram,<br/>Plot 1-C D &amp; E, Sector V,Nerul, Navi Mumbai-400706</h4>Tel:2771 6969/6928 <small>www.siesgst.net</small>");
		b.append("<h1 align="+" 'center'   "+">Application Form</h1></center>");
		b.append("Applicant ID: "+appId);
		b.append("<p><b>Personal details</b></p>");
		b.append("<table width="+" '600' "+ "border="+" '2' "+">");
		b.append("<tr><td>Applied Under</td><td>"+applied_under+"</td></tr>");
		b.append("<tr><td>Surname</td><td>"+surname+"</td></tr>");
		b.append("<tr><td>Name</td><td>"+user_name+"</td></tr>");
		b.append("<tr><td>Father's Name</td><td>"+father_name+"</td></tr>");
		b.append("<tr><td>Mother's name</td><td>"+mother_name+"</td></tr>");
		b.append("<tr><td>Permanent Address</td><td>"+permanent_address+"</td></tr>");
		b.append("<tr><td>Current Address</td><td>"+current_address+"</td></tr>");
		b.append("<tr><td>Landline Number</td><td>"+landline_number+"</td></tr>");
		b.append("<tr><td>Mobile Number</td><td>"+mobile_number+"</td></tr>");
		b.append("<tr><td>Email</td><td>"+email+"</td></tr>");
		b.append("<tr><td>Date of birth</td><td>"+date_of_birth+"</td></tr>");
		b.append("<tr><td>Place of birth</td><td>"+place_of_birth+"</td></tr>");
		b.append("<tr><td>Caste</td><td>"+caste+"</td></tr>");
		b.append("<tr><td>Physically handicapped</td><td>"+phy_handicapped+"</td></tr>");
		b.append("<tr><td>Economically backward</td><td>"+eco_backward+"</td></tr>");
		b.append("<tr><td>Blood Group</td><td>"+blood_group+" "+rh+"</td></tr></table>");
		
		
		
		
		if(admUser.getAdmissionUserType().equals("FirstYearEngineering"))
		{
		
		AdmissionUserFeAcademics admUserAcademic = admUser.getAdmissionUserFeAcademics();
		
		logger.debug("Here is the record"+admUserAcademic.getAdmissionUserFeAcademicsAllIndiaJeeRank());
		String AllIndiaJeeRank=admUserAcademic.getAdmissionUserFeAcademicsAllIndiaJeeRank().toString();
		String BoardPercentileObtained=admUserAcademic.getAdmissionUserFeAcademicsBoardPercentileObtained().toString();
		String JeeChemistryObtained=admUserAcademic.getAdmissionUserFeAcademicsJeeChemistryObtained().toString();
		String JeeChemistryTotal=admUserAcademic.getAdmissionUserFeAcademicsJeeChemistryTotal().toString();
		String JeeMathsObtained=admUserAcademic.getAdmissionUserFeAcademicsJeeMathsObtained().toString();
		String JeeMathsTotal=admUserAcademic.getAdmissionUserFeAcademicsJeeMathsTotal().toString();
		String JeePercentileObtained=admUserAcademic.getAdmissionUserFeAcademicsJeePercentileObtained().toString();
		String JeePhysicsObtained=admUserAcademic.getAdmissionUserFeAcademicsJeePhysicsObtained().toString();
		String JeePhysicsTotal=admUserAcademic.getAdmissionUserFeAcademicsJeePhysicsTotal().toString();
		String JeeTotal=admUserAcademic.getAdmissionUserFeAcademicsJeeTotal().toString();
		String JeeTotalObtained=admUserAcademic.getAdmissionUserFeAcademicsJeeTotalObtained().toString();
		String SscGrandMarksObtained=admUserAcademic.getAdmissionUserFeAcademicsSscGrandMarksObtained().toString();
		String SscGrandMarksTotal=admUserAcademic.getAdmissionUserFeAcademicsSscGrandMarksTotal().toString();
		String SscPercentageObtained=admUserAcademic.getAdmissionUserFeAcademicsSscPercentageObtained().toString();
		String SscMathsMarksObtained=admUserAcademic.getAdmissionUserFeAcademicsSscMathsMarksObtained().toString();
		String SscMathsMarksTotal=admUserAcademic.getAdmissionUserFeAcademicsSscMathsMarksTotal().toString();
		String SscYearOfPassing=admUserAcademic.getAdmissionUserFeAcademicsSscYearOfPassing().toString();
		String StateJeeRank=admUserAcademic.getAdmissionUserFeAcademicsStateJeeRank().toString();
		String XiiBoard=admUserAcademic.getAdmissionUserFeAcademicsXiiBoard().toString();
		String XiiChemistryMarksObtained=admUserAcademic.getAdmissionUserFeAcademicsXiiChemistryMarksObtained().toString();
		String XiiChemistryMarksTotal=admUserAcademic.getAdmissionUserFeAcademicsXiiChemistryMarksTotal().toString();
		String XiiEnglishMarksObtained=admUserAcademic.getAdmissionUserFeAcademicsXiiEnglishMarksObtained().toString();
		String XiiEnglishMarksTotal=admUserAcademic.getAdmissionUserFeAcademicsXiiEnglishMarksTotal().toString();
		String XiiMathsMarksObtained=admUserAcademic.getAdmissionUserFeAcademicsXiiMathsMarksObtained().toString();
		String XiiMathsMarksTotal=admUserAcademic.getAdmissionUserFeAcademicsXiiMathsMarksTotal().toString();
		String XiiPcmObtained=admUserAcademic.getAdmissionUserFeAcademicsXiiPcmObtained().toString();
		String XiiPcmTotal=admUserAcademic.getAdmissionUserFeAcademicsXiiPcmTotal().toString();
		String XiiPhysicsMarksObtained=admUserAcademic.getAdmissionUserFeAcademicsXiiPhysicsMarksObtained().toString();
		String XiiPhysicsMarksTotal=admUserAcademic.getAdmissionUserFeAcademicsXiiPhysicsMarksTotal().toString();
		String XiiPmvObtained=admUserAcademic.getAdmissionUserFeAcademicsXiiPmvObtained().toString();
		String XiiPmvTotal=admUserAcademic.getAdmissionUserFeAcademicsXiiPmvTotal().toString();
		String XiiVocationalMarksObtained=admUserAcademic.getAdmissionUserFeAcademicsXiiVocationalMarksObtained().toString();
		String XiiVocationalMarksTotal=admUserAcademic.getAdmissionUserFeAcademicsXiiVocationalMarksTotal().toString();
		String XiiYearOfPassing=admUserAcademic.getAdmissionUserFeAcademicsXiiYearOfPassing().toString();
		
		b.append("<p><b>Academic Details</b></p>");
		
		b.append("<p>SSC</p>");
		b.append("<table width="+" '600' "+ "border="+" '2' "+">");
		b.append("<tr><td>Particular</td><td>Marks Obtained</td><td>Marks Out of</td></tr>");
		b.append("<tr><td>SSC</td><td>"+SscMathsMarksObtained+"</td><td>"+SscMathsMarksTotal+"</td></tr>");
		b.append("<tr><td>Grand Total</td><td>"+SscGrandMarksObtained+"</td><td>"+SscGrandMarksTotal+"</td></tr></table>");
		b.append("<table width="+" '600' "+ "border="+" '2' "+">");
		b.append("<tr><td>Percentage obtained</td><td>"+SscPercentageObtained+"</td></tr>");
		b.append("<tr><td>Year of passing</td><td>"+SscYearOfPassing+"</td></tr></table>");
		
		b.append("<p>HSC</p>");
		
		b.append("<table width="+" '600' "+ "border="+" '2' "+">");
		b.append("<tr><td>Board</td><td>"+XiiBoard+"</td></tr></table>");
		
		b.append("<table width="+" '600' "+ "border="+" '2' "+">");
		b.append("<tr><td>Particular</td><td>Marks Obtained</td><td>Marks Out of</td></tr>");
		b.append("<tr><td>English</td><td>"+XiiEnglishMarksObtained+"</td><td>"+XiiEnglishMarksTotal+"</td></tr>");
		b.append("<tr><td>Physics(P)</td><td>"+XiiPhysicsMarksObtained+"</td><td>"+XiiPhysicsMarksTotal+"</td></tr>");
		b.append("<tr><td>Chemistry(C)</td><td>"+XiiChemistryMarksObtained+"</td><td>"+XiiChemistryMarksTotal+"</td></tr>");
		b.append("<tr><td>Maths(M)</td><td>"+XiiMathsMarksObtained+"</td><td>"+XiiMathsMarksTotal+"</td></tr>");
		b.append("<tr><td>Vocational(V)</td><td>"+XiiVocationalMarksObtained+"</td><td>"+XiiVocationalMarksTotal+"</td></tr>");
		b.append("<tr><td>(P+C+M)</td><td>"+XiiPcmObtained+"</td><td>"+XiiPcmTotal+"</td></tr>");
		b.append("<tr><td>(P+M+V)</td><td>"+XiiPmvObtained+"</td><td>"+XiiPmvTotal+"</td></tr></table>");
		
		b.append("<table width="+" '600' "+ "border="+" '2' "+">");
		b.append("<tr><td>Board Percentile obtained</td><td>"+BoardPercentileObtained+"</td></tr>");
		b.append("<tr><td>Year of passing</td><td>"+XiiYearOfPassing+"</td></tr></table>");

		
		
		
		
		
		b.append("<p>JEE(main)</p>");
		
		
		b.append("<table width="+" '600' "+ "border="+" '2' "+">");
		b.append("<tr><td>Particular</td><td>Marks Obtained</td><td>Marks Out of</td></tr>");
		b.append("<tr><td>Physics(P)</td><td>"+JeePhysicsObtained+"</td><td>"+JeePhysicsTotal+"</td></tr>");
		b.append("<tr><td>Chemistry(C)</td><td>"+JeeChemistryObtained+"</td><td>"+JeeChemistryTotal+"</td></tr>");
		b.append("<tr><td>Maths(M)</td><td>"+JeeMathsObtained+"</td><td>"+JeeMathsTotal+"</td></tr>");
		b.append("<tr><td>(P+C+M)</td><td>"+JeeTotalObtained+"</td><td>"+JeeTotal+"</td></tr></table>");
		
		b.append("<table width="+" '600' "+ "border="+" '2' "+">");
		b.append("<tr><td>Board Percentile obtained</td><td>"+JeePercentileObtained+"</td></tr>");
		b.append("<tr><td>All India JEE Rank</td><td>"+AllIndiaJeeRank+"</td></tr>");
		b.append("<tr><td>State JEE Rank</td><td>"+StateJeeRank+"</td></tr></table>");

List admUsersBranchSelection=abstractService.listForeignRecord("AdmissionUserBranchSelection", userId);
		
		AdmissionUserBranchSelection admUserBranchSelection=admUser.getAdmUserBranchSelection();
		
		Integer BTPriority=admUserBranchSelection.getAdmissionUserBranchSelectionBTPriority();
		
		Integer CEPriority=admUserBranchSelection.getAdmissionUserBranchSelectionCEPriority();
		 
		Integer EXTCPriority=admUserBranchSelection.getAdmissionUserBranchSelectionEXTCPriority();
		 
		Integer ITPriority=admUserBranchSelection.getAdmissionUserBranchSelectionITPriority();
		
		Integer MECHPriority=admUserBranchSelection.getAdmissionUserBranchSelectionMECHPriority();
		
		Integer PPTPriority=admUserBranchSelection.getAdmissionUserBranchSelectionPPTPriority();
		logger.info(""+BTPriority);
		String priority[]=new String[6];
		
		priority[BTPriority-1]="BioTechnology";
		
		priority[CEPriority-1]="Computer Engineering";
		
		priority[EXTCPriority-1]="Electronics and Telecommunication";
		
		priority[ITPriority-1]="Information Technology";
		
		priority[MECHPriority-1]="Mechanical Engineering";
		
		priority[PPTPriority-1]="Printing and Packaging Technology";
		
		
		int i=5;
		
		
		
		
		b.append("<p><b>Branch Priority</b></p>");
		b.append("<table width="+" '600' "+ "border="+" '2' "+">");
		b.append("<tr><td>Department</td><td>Priority</td></tr>");
		for(i=0;i<6;i++)
		{
		b.append("<tr><td>"+priority[i]+"</td><td>"+(i+1)+"</td></tr>");	
		}
		
		
		
		
		
		
		
		}
		else
		{
			admUserAcademics=abstractService.listForeignRecord("AcademicDetailsDse", userId);
			
			AcademicDetailsDse admUserAcademic=admUser.getAcademicDetailsDse();

			String CategoryRank=admUserAcademic.getAcademicDetailsDseDiplomaCategoryRank();
			String FirstYearObtained=admUserAcademic.getAcademicDetailsDseDiplomaMarksFirstYearObtained();
			String SecondYearObtained=admUserAcademic.getAcademicDetailsDseDiplomaMarksSecondYearObtained();
			String ThirdYearObtained=admUserAcademic.getAcademicDetailsDseDiplomaMarksThirdYearObtained();
			String TotalFirstYear=admUserAcademic.getAcademicDetailsDseDiplomaMarksTotalFirstYear();
			String TotalSecondYear=admUserAcademic.getAcademicDetailsDseDiplomaMarksTotalSecondYear();
			String TotalThirdYear=admUserAcademic.getAcademicDetailsDseDiplomaMarksTotalThirdYear();
			String StateRank=admUserAcademic.getAcademicDetailsDseDiplomaStateRank();
			String UniversityRank=admUserAcademic.getAcademicDetailsDseDiplomaUniversityRank();
			String MarksGrandObtained=admUserAcademic.getAcademicDetailsDseSscMarksGrandObtained();
			String MarksMathsObtained=admUserAcademic.getAcademicDetailsDseSscMarksMathsObtained();
			String MarksTotalGrand=admUserAcademic.getAcademicDetailsDseSscMarksTotalGrand();
			String MarksTotalMaths=admUserAcademic.getAcademicDetailsDseSscMarksTotalMaths();
			String SscPercentageObtained=admUserAcademic.getAcademicDetailsDseSscPercentageObtained();
			String SscYearOfPassing=admUserAcademic.getAcademicDetailsDseSscYearOfPassing();
			String DiplomaYearOfPassing=admUserAcademic.getAcademicDetailsDseDiplomaYearOfPassing();
			
			
			b.append("<p><b>Academic Details</b></p>");
			
			b.append("<p>SSC</p>");
			b.append("<table width="+" '600' "+ "border="+" '2' "+">");
			b.append("<tr><td>Particular</td><td>Marks Obtained</td><td>Marks Out of</td></tr>");
			b.append("<tr><td>Maths</td><td>"+MarksMathsObtained+"</td><td>"+MarksTotalMaths+"</td></tr>");
			b.append("<tr><td>Grand Total</td><td>"+MarksGrandObtained+"</td><td>"+MarksTotalGrand+"</td></tr></table>");
			
			b.append("<table width="+" '600' "+ "border="+" '2' "+">");
			b.append("<tr><td>Year of passing</td><td>"+SscYearOfPassing+"</td></tr></table>");
			
			
			b.append("<p>Diploma</p>");
			b.append("<table width="+" '600' "+ "border="+" '2' "+">");
			b.append("<tr><td>Particular</td><td>Marks Obtained</td><td>Marks Out of</td></tr>");
			b.append("<tr><td>First Year Diploma</td><td>"+FirstYearObtained+"</td><td>"+TotalFirstYear+"</td></tr>");
			b.append("<tr><td>First Year Diploma</td><td>"+SecondYearObtained+"</td><td>"+TotalSecondYear+"</td></tr>");
			b.append("<tr><td>First Year Diploma</td><td>"+ThirdYearObtained+"</td><td>"+TotalThirdYear+"</td></tr></table>");
			b.append("<table width="+" '600' "+ "border="+" '2' "+">");
			b.append("<tr><td>State Rank</td><td>"+StateRank+"</td></tr>");
			b.append("<tr><td>University Rank</td><td>"+UniversityRank+"</td></tr>");
			b.append("<tr><td>Category Rank</td><td>"+CategoryRank+"</td></tr>");

			
		}
		
		
	
		b.append("</table>");
		b.append("<footer><hr/><h4 align="+" 'center' "+">SIES Graduate School of Technology Applicant ID "+appId+"</h4><h5>*For future correspondance use your application Id</h5></footer></body></html>");

		
		
		
		
		
		
		return b;
	}
	
}
