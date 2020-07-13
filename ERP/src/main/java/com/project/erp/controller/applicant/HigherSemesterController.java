package com.project.erp.controller.applicant;


import java.io.IOException;
import java.io.OutputStream;
import java.io.StringBufferInputStream;
import java.text.SimpleDateFormat;
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
import com.project.erp.forms.applicant.TransactionIdForm;
import com.project.erp.model.AdmissionUser1;
import com.project.erp.model.PaymentLog;
import com.project.erp.pdfgen.PictureRenderer;
import com.project.erp.service.applicant.AbstractService;
//import com.gsl.web.form.HigherSemester;

/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping(value = "/")

public class HigherSemesterController{
	
	@InjectableLogger
	public Logger logger;

	@Autowired
	private AbstractService abstractService;

	@RequestMapping(value = "/highersemester" ,method = RequestMethod.GET)
	public ModelAndView highersemester(Model model, HttpSession session) 
{
		
		ModelAndView mv=new ModelAndView();
		Integer userID=(Integer)session.getAttribute("userID");
		List userData= abstractService.listRecord("AdmissionUser1",userID);
		model.addAttribute("userID", session.getAttribute("userID"));
		model.addAttribute("userModel", session.getAttribute("userModel"));
		
		//Object newHigherSemester;
		//AdmissionUser1 admUser = setRegistrationDetails1(userSession,newHigherSemester,userID);
		
		
		//AdmissionUser1 admUser1=(AdmissionUser1)userData.get(0);
		mv.setViewName("applicant/Admission/higher_semester_step1");
		//model.addAttribute("admissionUserFatherName",userData.get(0));
		
		return mv;
		
	}
	
	@RequestMapping(value = "/higher-semester-step-2" ,method = RequestMethod.GET)
	public ModelAndView highersemesterstep2(@ModelAttribute("TransactionIdForm") TransactionIdForm newAdmissionForm,Model model, HttpSession session) 
	{
		AdmissionUser1 admUser=(AdmissionUser1)session.getAttribute("userModel");
		
		admUser.setAdmissionUserStatus("AnnualFeePending");
		ModelAndView mv=new ModelAndView();
		PaymentLog pl=new PaymentLog();
		Integer userId=(Integer)session.getAttribute("userID");
		pl.setAdmissionUserId(userId);
		pl.setPaymentLogTransactionId(newAdmissionForm.getAdmissionUserTransactionId());
		pl.setPaymentLogAmount("90560");
		pl.setPaymentLogBankId(1);
		pl.setPaymentLogSemester(""+admUser.getAdmissionUserCurrentSemester());
		pl.setPaymentLogStatus("AnnualFeePending");
		abstractService.addRecord(pl);
		abstractService.updateRecord(admUser);
		session.setAttribute("userModel", admUser);
		mv.setViewName("applicant/Admission/pending");
	
		return mv;
	}
	
	
	@SuppressWarnings("deprecation")
	@RequestMapping("/fee-receipt")
	public void blah(HttpServletResponse response,Model model,HttpSession session) throws ParserConfigurationException, FactoryConfigurationError, SAXException, IOException, DocumentException {

	StringBuffer b = new StringBuffer();
	
	Integer userId=525;//(Integer)session.getAttribute("userID");
	
	List admUsers=abstractService.listRecord("AdmissionUser1",userId);
	
	AdmissionUser1 admUser=(AdmissionUser1)admUsers.get(0);
	b=getString(admUser,userId);
	
	DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
	org.w3c.dom.Document doc = builder.parse(new StringBufferInputStream(b.toString()));
	ITextRenderer renderer = new ITextRenderer();
	renderer.getSharedContext().setReplacedElementFactory(new PictureRenderer(renderer.getSharedContext().getReplacedElementFactory()));
	renderer.setDocument(doc, "file:///D:/ERP/MyFirstSpringMVCProject/src/main/webapp/");
	OutputStream os = response.getOutputStream();
	renderer.layout();
	renderer.createPDF(os);
	os.close();
	}
	
	public StringBuffer getString(AdmissionUser1 admUser, Integer userId)
	{
		StringBuffer b=new StringBuffer();
		String clas[]=new String[4];
		
		int year=Calendar.getInstance().get(Calendar.YEAR);
		
	      Calendar calendar = Calendar.getInstance();
	      SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
	     

		
		
		
		String appId=""+year+userId;
		List pls=abstractService.listForeignRecord("PaymentLog", userId);
		
		PaymentLog pl=(PaymentLog)pls.get(0);
		
		logger.debug(pl.getPaymentLogTransactionId());
		
		clas[0]="F.E.";
		clas[1]="S.E";
		clas[2]="T.E";
		clas[3]="B.E";
		b.append("<html><body><table><tr><td><div class=\"image\"><img src="+" 'resources/applicant/login/image/logo2.png' "+" width="+" '300' "+ "height="+" '150' "+"/></div> </td>");
		b.append("<td>Sri Chandrasekarendra Saraswathy Vidyapuram,<br/>Plot 1-C D &amp; E, Sector V,Nerul, Navi Mumbai-400706<br/>Tel:2771 6969/6928 <br/><small>www.siesgst.net</small> </td>");
		b.append("</tr></table><hr />");
		b.append("<b>Receipt No. "+appId+"</b><br/>");
		b.append("<p>Date : "+format.format(calendar.getTime())+"</p><br/>");
		b.append("Received from: <u>"+admUser.getAdmissionUserFname()+"</u><br/><br />");
		b.append("<table><tr><td>Class: <u>"+clas[admUser.getAdmissionUserCurrentSemester()/2+1]+"</u></td>");
		b.append("<td>Branch: <u>"+admUser.getAdmissionUserBranch()+"</u></td></tr></table><br/><br/>");
		//b.append("Amount: "+pl.getPaymentLogAmount()+"<br /><br/>");
		b.append("TransactionId: "+pl.getPaymentLogTransactionId()+"<br/><br/>");
		b.append("<table width="+" '600' "+ "border="+" '2' "+">");
		b.append("<tr><td>1.</td><td>Development Fee</td><td>5924</td></tr>");
		b.append("<tr><td>2.</td><td>Tution Fee</td><td>84636</td></tr>");
		b.append("<tr><td>3.</td><td><b>Total Rs.</b></td><td>90560</td></tr>");
		b.append("</table>");
		b.append("</body></html>");
		return b;
	}
	

}	