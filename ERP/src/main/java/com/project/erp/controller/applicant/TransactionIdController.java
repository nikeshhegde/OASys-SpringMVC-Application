package com.project.erp.controller.applicant;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.StringBufferInputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.FactoryConfigurationError;
import javax.xml.parsers.ParserConfigurationException;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.xhtmlrenderer.pdf.ITextRenderer;
import org.xml.sax.SAXException;

import com.lowagie.text.DocumentException;
import com.project.erp.common.constant.ViewConstant;
import com.project.erp.common.util.logging.InjectableLogger;
import com.project.erp.forms.applicant.ConfigureBankDetails;
import com.project.erp.forms.applicant.NewAdmissionForm;
import com.project.erp.forms.applicant.TransactionIdForm;
import com.project.erp.model.AdmissionUser1;
import com.project.erp.model.BankDetails;
import com.project.erp.model.DDDetails;
import com.project.erp.model.FeeDistribution;
import com.project.erp.model.PaymentLog;
import com.project.erp.model.Users;
import com.project.erp.pdfgen.PictureRenderer;
import com.project.erp.service.applicant.AbstractService;


@Controller
@RequestMapping(value = "/")


public class TransactionIdController {

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

	@PreAuthorize("hasAnyRole("+ViewConstant.ALLOW_USER_ROLES+")")
	@RequestMapping(value = "/trans_id" ,method = RequestMethod.GET)
	public ModelAndView trans_id1(@ModelAttribute("PaymentLog") TransactionIdForm transForm,Model model, HttpSession session) {
		
		ModelAndView mv=new ModelAndView();
		
		
		mv.setViewName("applicant/Admission/trans_id");
		//PaymentLog pl= setTransDetails(transForm,(Integer)session.getAttribute("userID"));
		
		BankDetails bankDetail=new BankDetails();
		
		AdmissionUser1 admUser= (AdmissionUser1)session.getAttribute("userModel");
		
		
		List bankDetails=abstractService.listRecord("BankDetails");
		
		String role=admUser.getAdmissionUserRole();
		String status=admUser.getAdmissionUserStatus();
		String semester=""+admUser.getAdmissionUserCurrentSemester();
		
		int i=0;
		while(i<bankDetails.size())
		{
			
			if(((BankDetails)bankDetails.get(i)).getStatus().equals(status) && ((BankDetails)bankDetails.get(i)).getRole().equals(role)  && ((BankDetails)bankDetails.get(i)).getSemester().equals(semester))
			{
				bankDetail=((BankDetails)bankDetails.get(i));
				break;
			}
			i++;
		}
		/*		
		bankDetail.getAccountHolder()
		bankDetail.getAccountNumber()
		bankDetail.getAccountType()
		bankDetail.getAmountPaid()
		bankDetail.getBankBranch() 
		bankDetail.getBankCity()
		bankDetail.getBankCity()
		bankDetail.getBankDetailsId()
		bankDetail.getBankName()
		bankDetail.getIFSCNumber()
		bankDetail.get
*/
		
		Collection<FeeDistribution> feedistribution=bankDetail.getFeeDistribution();
		
		List <FeeDistribution> feeDistribution=new ArrayList<FeeDistribution>(feedistribution);
		i=0;
		Integer price=0;
		FeeDistribution fee;
		while(i<feedistribution.size())
		{
			fee=(FeeDistribution)feeDistribution.get(i);
			
			price=price+fee.getFeeAmount();
			i++;
		}
		logger.debug(" The amount generated is : "+price);
		model.addAttribute("Amount", price);
		model.addAttribute("bankDetail", bankDetail);
		
		
		return  mv;
	}
	
	
	private PaymentLog setTransDetails(TransactionIdForm transForm, Integer userID)
	{
		PaymentLog pl1=new PaymentLog();
		
		//pl1.setId(10);
		logger.info("I am setTransDetails "+transForm.getAdmissionUserTransactionId());
		pl1.setPaymentLogTransactionId(transForm.getAdmissionUserTransactionId());
		return pl1;
	}


	@Transactional
	@RequestMapping(value = "/trans_id2" ,method = RequestMethod.GET)
	public ModelAndView trans_id2(@ModelAttribute("TransactionIdForm") TransactionIdForm newAdmissionForm,Model model, HttpSession session) 
	{
		AdmissionUser1 admUser=(AdmissionUser1)session.getAttribute("userModel");
		
		Integer userId=admUser.getId();
		
		
		logger.debug("Payment method is "+newAdmissionForm.getPaymentLogType());
		
		//admUser=(AdmissionUser1)(abstractService.listRecord("AdmissionUser1",userId)).get(0);
		
		
		//admUser.setAdmissionUserStatus("Application Fee Pending");
		ModelAndView mv=new ModelAndView();
		Collection<PaymentLog> cpl=new ArrayList<PaymentLog>();
		PaymentLog pl=new PaymentLog();
		pl=setPaymentLogFromTransactionId(newAdmissionForm, userId, admUser);
		//Integer userId=(Integer)session.getAttribute("userID");
		admUser.getPaymentLog().add(pl);
		abstractService.addRecord(pl);
		abstractService.updateRecord(admUser);
		cpl=admUser.getPaymentLog();
		//logger.debug(cpl.size()+" is the size of the returned list");
		//String newStatus=admUser.getAdmissionUserStatus().replace("Pending", "Paid");
		//admUser.setAdmissionUserStatus(newStatus);
		if(admUser.getAdmissionUserStatus().equals("Registered"))
		{
		admUser.setAdmissionUserStatus("Application Fee Pending");
		}
		else if(admUser.getAdmissionUserStatus().equals("Shortlisted"))
		{
		admUser.setAdmissionUserStatus("Annual Fee Pending");
		}
		
		
		
		
		session.setAttribute("userModel", admUser);
		mv.setViewName("applicant/Admission/pending");
	
		return mv;
	}
	
	
	@SuppressWarnings("null")
	public PaymentLog setPaymentLogFromTransactionId(TransactionIdForm t1, Integer userId,AdmissionUser1 admUser){
		
		BankDetails bankDetail=new BankDetails();
		List bankDetails=abstractService.listRecord("BankDetails");
		
		String role=admUser.getAdmissionUserRole();
		String status=admUser.getAdmissionUserStatus();
		String semester=""+admUser.getAdmissionUserCurrentSemester();
		
		int i=0;
		while(i<bankDetails.size())
		{
			
			if(((BankDetails)bankDetails.get(i)).getStatus().equals(status) && ((BankDetails)bankDetails.get(i)).getRole().equals(role)  && ((BankDetails)bankDetails.get(i)).getSemester().equals(semester))
			{
				bankDetail=((BankDetails)bankDetails.get(i));
				break;
			}
			i++;
		}
		
		
		
		
		
		PaymentLog pl = new PaymentLog();
		pl.setAdmissionUserId(userId);
		pl.setPaymentLogBankId(bankDetail.getBankDetailsId());
		pl.setPaymentLogSemester(""+admUser.getAdmissionUserCurrentSemester());
		
		//Get from Bank Details Table
		if(admUser.getAdmissionUserStatus().equals("Registered"))
		{
		pl.setPaymentLogStatus("Application Fee Pending");
		}
		else if(admUser.getAdmissionUserStatus().equals("Shortlisted"))
		{
		pl.setPaymentLogStatus("Annual Fee Pending");
		}
		
		
		
		Calendar calendar=Calendar.getInstance();
		
		//logger.debug(calendar.getTime()+" is the time bro!");
		Date timestamp=calendar.getTime();
		
		pl.setPaymentLogTime(timestamp);
		if(t1.getPaymentLogType().equalsIgnoreCase("NEFT"))
			{
			pl.setPaymentLogTransactionId(t1.getAdmissionUserTransactionId());
			}
		else if(t1.getPaymentLogType().equals("DD"))
			{
			DDDetails ddDetail=new DDDetails();
			ddDetail.setApplicantBank(t1.getApplicantBank());
			ddDetail.setApplicantBranch(t1.getApplicantBranch());
			ddDetail.setDdAmount(t1.getDdAmount());
			ddDetail.setDdMicrCode(t1.getDdMicrCode());
			ddDetail.setDdNumber(t1.getDdNumber());
			ddDetail.setDdPayable(t1.getDdPayable());
			ddDetail.setDrawnDate(t1.getDrawnDate());
			ddDetail.setDrawnName(t1.getDrawnName());
			pl.setDddetails(ddDetail);
			abstractService.addRecord(ddDetail);
			}
		
		
		//Get from Bank Details Table
		//pl.setPaymentLogAmount(bankDetail.getAmountPaid());
		
		//Get from Bank Details Table
		
			
		return pl;
	}
	
	
	@PreAuthorize("hasRole('ADMIN')")
	@RequestMapping(value = "/configureBank" ,method = RequestMethod.GET)
	public ModelAndView conf(Model model, HttpSession session) 
	{
		ModelAndView mv = new ModelAndView();
		String roles_user = ViewConstant.ALLOW_USER_ROLES;
		String roles_status = ViewConstant.ALL_STATUS;
		
		String user123[] = convertStrings(roles_user);
		String status123[]  = convertStrings(roles_status);
			
		model.addAttribute("UserRoles", user123);
		model.addAttribute("UserStatus", status123);	
		mv.setViewName("applicant/Admission/configureP");
	
		return mv;
	}
	
	
	public String[] convertStrings(String abc){
		String[] abc123 = abc.split(",");
		
		for(int s=0;s<abc123.length;s++){
		abc123[s]=abc123[s].substring(1, abc123[s].length()-1);	
		}
		
		return abc123;
	}
	
	
	@PreAuthorize("hasRole('ADMIN')")
	@RequestMapping(value = "/payment-info" ,method = RequestMethod.GET)
	public ModelAndView viewPaymentInfo(@RequestParam("id") Integer userId,Model model, HttpSession session) 
	{
	ModelAndView mv=new ModelAndView();
	
	AdmissionUser1 admUser=(AdmissionUser1)(abstractService.listRecord("AdmissionUser1",userId)).get(0);
	List record=abstractService.listRecord("AdmissionUser1", userId);
	
	//AdmissionUser1 student=(AdmissionUser1) record.get(0);
	
	//logger.debug(admUser.getPaymentLog().size()+" is the size of paymentLog");
	
	List paymentLog=new ArrayList(admUser.getPaymentLog());
 
	/*
	List <PaymentLog>paymentLog=new ArrayList<PaymentLog>();
	
	paymentLog.addAll(((AdmissionUser1)(abstractService.listRecord("AdmissionUser1",userId)).get(0)).getPaymentLog());

	logger.debug(((PaymentLog)paymentLog.get(0)).getPaymentLogTransactionId()+ " is the info");*/
	model.addAttribute("paymentLog",paymentLog);
	
	model.addAttribute("infos",admUser);
	
	mv.setViewName("applicant/Admission/viewInfo");
	return mv;
	}
	
	//@PreAuthorize("hasRole('ADMIN')")
	@RequestMapping(value = "/fee-distribution" ,method = RequestMethod.GET)
	public ModelAndView feedsitribution(Model model, HttpSession session) 
	{
		ModelAndView mv=new ModelAndView();
		
		FeeDistribution feedistribution;
		
		List bankDetails=abstractService.listRecord("BankDetails");
		
		BankDetails bankDetail;
		
		String typeName[]={"DEVELOPMENT FEE","TUTION FEE"};
		Integer typeAmount[]={5132,73598};
		int i=0;
		int j=0;
		while(i<bankDetails.size())
		{
			feedistribution=new FeeDistribution();
			feedistribution.setFeeAmount(typeAmount[j%typeAmount.length]);
			feedistribution.setFeeType(typeName[j%typeName.length]);
			
			bankDetail=(BankDetails)bankDetails.get(i);
			bankDetail.getFeeDistribution().add(feedistribution);
			
			abstractService.addRecord(feedistribution);
			abstractService.updateRecord(bankDetail);
			
			if(j%2==1)
			{
			i++;
			}
			j++;
		}
		
		return mv;
		
	}
	
	
	
	
	@PreAuthorize("hasRole('ADMIN')")
	@RequestMapping(value = "/trans_id3a" ,method = RequestMethod.POST)
	public ModelAndView trans_id3(@ModelAttribute("ConfigureBankDetails") ConfigureBankDetails configurator,Model model, HttpSession session) 
	{
		BankDetails b1 = new BankDetails();
		
		b1 = setBankDetailsfromForm(configurator);
		abstractService.addRecord(b1);
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("applicant/Admission/pending");
	
		return mv;
	}
	
	public BankDetails setBankDetailsfromForm(ConfigureBankDetails configurator){
		BankDetails b1 = new BankDetails();

		b1.setAccountHolder(configurator.getAccountHolder());
		b1.setAccountNumber(configurator.getAccountNumber());
		b1.setAccountType(configurator.getAccountType());
		//b1.setAmountPaid(configurator.getAmountPaid());
		b1.setBankBranch(configurator.getBankBranch());
		b1.setBankCity(configurator.getBankCity());
		b1.setBankName(configurator.getBankName());
		b1.setIFSCNumber(configurator.getIFSCNumber());
	//	b1.setRole(configurator.getRole());
	//	b1.setStatus(configurator.getStatus());
	//	b1.setSemester(configurator.getSemester());
	 //  b1.setAppliedUnder(configurator.getAppliedUnder());
		
	   return b1;
	}
	
	@SuppressWarnings("deprecation")
	@PreAuthorize("hasAnyRole("+ViewConstant.ALLOW_USER_ROLES+")")
	@RequestMapping("/fee-receipt-gen")
	public void blah(HttpServletResponse response,Model model,HttpSession session,Authentication auth) throws ParserConfigurationException, FactoryConfigurationError, SAXException, IOException, DocumentException {

	StringBuffer b = new StringBuffer();
		
	List userData= abstractService.listSelectedByUserName("Users",auth.getName());			
	List admissionUserData = abstractService.listSelectedByUserName("AdmissionUser1", auth.getName());
	AdmissionUser1 admUsers=(AdmissionUser1)admissionUserData.get(0);
	Users user1 = (Users)userData.get(0);
	
	Integer userId =admUsers.getId();
	
	AdmissionUser1 admUser=(AdmissionUser1)admissionUserData.get(0);
	b=getString(admUser,userId);
	
	DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
	org.w3c.dom.Document doc = builder.parse(new StringBufferInputStream(b.toString()));
	ITextRenderer renderer = new ITextRenderer();
	String outputFile  = "newReceipt"+userId+".pdf";
	OutputStream os1 = new FileOutputStream(outputFile);
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
		b.append("<html><body><table><tr><td><div class=\"image_sies\"></div></td>");
		b.append("<td>Sri Chandrasekarendra Saraswathy Vidyapuram,<br/>Plot 1-C D &amp; E, Sector V,Nerul, Navi Mumbai-400706<br/>Tel:2771 6969/6928 <br/><small>www.siesgst.net</small> </td>");
		b.append("</tr></table><hr />");
		b.append("<b>Receipt No. "+appId+"</b><br/>");
		b.append("<p>Date : "+format.format(calendar.getTime())+"</p><br/>");
		b.append("Received from: <u>"+admUser.getAdmissionUserFname()+"</u><br/><br />");
		b.append("<table><tr><td>Class: <u>"+clas[(admUser.getAdmissionUserCurrentSemester()-1)/2]+"</u></td>");
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
	
	
	
	
	
	


