package com.project.erp.controller.applicant;

import java.io.IOException;
import java.io.OutputStream;
import java.io.StringBufferInputStream;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
//import com.project.erp.forms.applicant.ReportForm;











import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.FactoryConfigurationError;
import javax.xml.parsers.ParserConfigurationException;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
//import org.aspectj.apache.bcel.classfile.Method;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
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
import com.project.erp.common.util.logging.InjectableLogger;
import com.project.erp.forms.applicant.QueryForm;
import com.project.erp.model.AdmissionUser1;
import com.project.erp.model.Parameters;
import com.project.erp.model.ParametersDatabaseMapping;
import com.project.erp.pdfgen.PictureRenderer;
import com.project.erp.service.applicant.AbstractService;

/**
 * Handles requests for the application home page.
 */
@Controller
//@RequestMapping(value = "/")

public class ReportController {
	
	@InjectableLogger
	public Logger logger;
	
	@Autowired
	private AbstractService abstractService;
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@RequestMapping(value="/report-menu",method = RequestMethod.GET)
	public ModelAndView reportMenu(Model model, HttpSession session) {
		
		
		ModelAndView mv= new ModelAndView();
		
		
		List reportCategories=abstractService.listRecord("ParametersDatabaseMapping");
		
		
		model.addAttribute("reportCategories", reportCategories);
		
		mv.setViewName("applicant/Admission/reportmenu");
		return mv;
		
	}
	
	
	@RequestMapping(value="/report",method = RequestMethod.POST)
	public ModelAndView report(@RequestParam Map<String,String> formData,Model model, HttpSession session) throws ClassNotFoundException {
	
		
		ModelAndView mv= new ModelAndView();
		String value[]=formData.values().toArray(new String[formData.size()]);
		String reportCategory=value[formData.size()-1];
	
		List values=getQueryResult(Parameters.class,"parameterType",reportCategory);
		
		
		model.addAttribute("reportCategory", reportCategory);
		model.addAttribute("reportValues", values);
		List admUsers;
		String inputName[]=new String[formData.size()];
		if(formData.size()>1)
		{
			Set<String> keys=formData.keySet();
			int i=0;
			for(String key:keys)
			{
				inputName[i++]=key;
			}
			logger.debug("Form data is "+formData.toString());
			
			Session criteriaSession1=sessionFactory.openSession();
			Criteria cr1=criteriaSession1.createCriteria(ParametersDatabaseMapping.class);
			cr1.add(Restrictions.eq("parameterType",inputName[0]));
			List dbMap=cr1.list();
			criteriaSession1.close();
			
			logger.debug("Size of dbMap is: "+dbMap.size());
			
			Session criteriaSession2=sessionFactory.openSession();
			Criteria cr2=criteriaSession2.createCriteria(AdmissionUser1.class);
			cr2.add(Restrictions.eq(((ParametersDatabaseMapping)dbMap.get(0)).getColumnName(),value[0]));
			admUsers=cr2.list();
			criteriaSession2.close();
			//admUsers=getQueryResult(c, ((ParametersDatabaseMapping)dbMap.get(0)).getColumnName(), inputName[1]);
		}
		else
		{
		admUsers=abstractService.listRecord("AdmissionUser1");
		}
		model.addAttribute("students", admUsers);
		
		logger.debug("size is: "+formData.size());
		mv.setViewName("applicant/Admission/report");
		
		return mv;
	}
	
	
	
	
	
	@SuppressWarnings("deprecation")
	@RequestMapping(value="/report-pdf",method=RequestMethod.POST)
	public void blah(@RequestParam Map<String,String> formData,HttpServletResponse response,Model model,HttpSession session,HttpServletRequest req) throws ParserConfigurationException, FactoryConfigurationError, SAXException, IOException, DocumentException, ClassNotFoundException {

	StringBuffer b = new StringBuffer();
	
	ModelAndView mv= new ModelAndView();
	String value[]=formData.values().toArray(new String[formData.size()]);
	String reportCategory=value[formData.size()-1];

	List values=getQueryResult(Parameters.class,"parameterType",reportCategory);
	
	
	model.addAttribute("reportCategory", reportCategory);
	model.addAttribute("reportValues", values);
	List admUsers;
	String inputName[]=new String[formData.size()];
	if(formData.size()>1)
	{
		Set<String> keys=formData.keySet();
		int i=0;
		for(String key:keys)
		{
			inputName[i++]=key;
		}
		logger.debug("Form data is "+formData.toString());
		
		Session criteriaSession1=sessionFactory.openSession();
		Criteria cr1=criteriaSession1.createCriteria(ParametersDatabaseMapping.class);
		cr1.add(Restrictions.eq("parameterType",inputName[0].replace('-', ' ')));
		List dbMap=cr1.list();
		criteriaSession1.close();
		
		logger.debug("Size of dbMap is: "+dbMap.size());
		
		Session criteriaSession2=sessionFactory.openSession();
		Criteria cr2=criteriaSession2.createCriteria(AdmissionUser1.class);
		logger.debug("dbMap :"+dbMap.size()+" value :"+value.length);
		cr2.add(Restrictions.eq(((ParametersDatabaseMapping)dbMap.get(0)).getColumnName(),value[0].replace('-', ' ')));
		admUsers=cr2.list();
		criteriaSession2.close();
		//admUsers=getQueryResult(c, ((ParametersDatabaseMapping)dbMap.get(0)).getColumnName(), inputName[1]);
	}
	else
	{
	admUsers=abstractService.listRecord("AdmissionUser1");
	}
	
	
	logger.debug(admUsers.size()+" is size in pdf");
	
	//List <AdmissionUser1> admUser=(List<AdmissionUser1>) req.getAttribute("students");
	
	
	
	
	/*
	 List <AdmissionUser1>admUser=reportForm.getStudents();
	 logger.debug("Something something!"+admUser.get(0));
	 logger.debug("admUser size is: some random text "+admUser.size());
	 AdmissionUser1 temp=(AdmissionUser1)admUser.get(0);
	 String tempString=temp.getAdmissionUserFname();
	 logger.debug(tempString+" is the firs ladka/ladki");
	*/
	
	//logger.debug("Size is:"+formData.size());
	
	
	b.append(getHeader());
	
	b.append("<h1>Report</h1>");
	
	b.append(reportBody(admUsers));
	
	b.append(getFooter());
	
	/*
	
	List admUsers=abstractService.listRecord(parameterDatabaseMappingRecord.getTableName());
	if(!reportCategory.equals("none"))
		{
		List parameterDatabaseMapping=getQueryResult(Parameters.class,"parameterType",reportCategory);
		ParametersDatabaseMapping parameterDatabaseMappingRecord=(ParametersDatabaseMapping)parameterDatabaseMapping.get(0);
		Class table=Class.forName(parameterDatabaseMappingRecord.getTableName());
		admUsers=get
		}
	*/
	DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
	org.w3c.dom.Document doc = builder.parse(new StringBufferInputStream(b.toString()));
	ITextRenderer renderer = new ITextRenderer();
	renderer.getSharedContext().setReplacedElementFactory(new PictureRenderer(renderer.getSharedContext().getReplacedElementFactory()));
	renderer.setDocument(doc, "/home");
	OutputStream os = response.getOutputStream();
	renderer.layout();
	renderer.createPDF(os);
	os.close();
	}
	
	
	public List getQueryResult(Class c,String columnName,String columnValue)
		{
		Session criteriaSession=sessionFactory.openSession();
		Criteria cr=criteriaSession.createCriteria(c);
		cr.add(Restrictions.eq(columnName,columnValue));
		List values=cr.list();
		criteriaSession.close();
		return values;
		}
	
	public StringBuffer getHeader()
	{
		StringBuffer b=new StringBuffer();
		b.append("<html><head><style>@page{size:A3 landscape;} body{-webkit-transform: rotate(270deg); -moz-transform: rotate:(270deg); } </style></head><body><center><h4 align="+" 'center' "+"><img src="+" 'sies.png' "+" width="+" '300' "+ "height="+" '150' "+"/><br/>");
		b.append("Sri Chandrasekarendra Saraswathy Vidyapuram,<br/>Plot 1-C D &amp; E, Sector V,Nerul, Navi Mumbai-400706</h4>Tel:2771 6969/6928 <small>www.siesgst.net</small></center>");
		return b;
	}
	
	public StringBuffer getFooter()
	{
		StringBuffer b=new StringBuffer();
		b.append("<footer><hr/><h4 align="+" 'center' "+">SIES Graduate School of Technology</h4></footer></body></html>");
		return b;
	}
	
	public StringBuffer reportBody(List student)
	{
		StringBuffer b=new StringBuffer();
		b.append("<table><thead>");
		b.append("<tr><th>Id</th><th>Surname</th><th>Name</th><th>Father s Name</th><th>Mother s Name</th>");
		b.append("<th>Gender</th><th>Email ID</th><th>Applied Under</th><th>Permanent Address</th><th>Current Address</th><th>Mobile Number</th><th>LandLine Number</th>");
		b.append("<th>Place Of Birth</th><th>Domicile</th><th>State</th>");
		b.append("<th>Nationality</th><th>Religion</th><th>Caste</th><th>Physically Handicapped</th><th>Economically backward</th><th>Mother Tongue</th><th>Blood group</th></tr>");
		b.append("</thead><tbody>");
		
			int i=0;
			while(i<student.size())
			{
			b.append("<tr><td>"+(i+1)+"</td><td>"+((AdmissionUser1)student.get(i)).getAdmissionUserSurName()+"</td>");
			b.append("<td>"+((AdmissionUser1)student.get(i)).getAdmissionUserFname()+"</td><td>"+((AdmissionUser1)student.get(i)).getAdmissionUserFatherName()+"</td>");
			b.append("<td>"+((AdmissionUser1)student.get(i)).getAdmissionUserMotherName()+"</td><td>"+((AdmissionUser1)student.get(i)).getAdmissionUserGender()+"</td>");
			b.append("<td>"+((AdmissionUser1)student.get(i)).getAdmissionUserEmail()+"</td><td>"+((AdmissionUser1)student.get(i)).getAdmissionUserAppliedUnder()+"</td>");
			b.append("<td>"+((AdmissionUser1)student.get(i)).getAdmissionUserPermanentAddress()+"</td><td>"+((AdmissionUser1)student.get(i)).getAdmissionUserCurrentAddress()+"</td>");
			b.append("<td>"+((AdmissionUser1)student.get(i)).getAdmissionUserMobileNumber()+"</td><td>"+((AdmissionUser1)student.get(i)).getAdmissionUserLandlineNumber()+"</td>");
			b.append("<td>"+((AdmissionUser1)student.get(i)).getAdmissionUserPlaceOfBirth()+"</td>");
			b.append("<td>"+((AdmissionUser1)student.get(i)).getAdmissionUserDomicile()+"</td><td>"+((AdmissionUser1)student.get(i)).getAdmissionUserState()+"</td>");
			b.append("<td>"+((AdmissionUser1)student.get(i)).getAdmissionUserNationality()+"</td><td>"+((AdmissionUser1)student.get(i)).getAdmissionUserReligion()+"</td>");
			b.append("<td>"+((AdmissionUser1)student.get(i)).getAdmissionUserCaste()+"</td><td>"+((AdmissionUser1)student.get(i)).getAdmissionUserPhyHandicapped()+"</td>");
			b.append("<td>"+((AdmissionUser1)student.get(i)).getAdmissionUserEcoBackward()+"</td><td>"+((AdmissionUser1)student.get(i)).getAdmissionUserMotherTongue()+"</td>");
			b.append("<td>"+((AdmissionUser1)student.get(i)).getAdmissionUserBloodGroup()+" "+((AdmissionUser1)student.get(i)).getAdmissionUserRh()+"</td>");
			b.append("</tr>");
			
		
				i++;
			}
			b.append("</tbody></table>");
		
			return b;
	}
	

	}