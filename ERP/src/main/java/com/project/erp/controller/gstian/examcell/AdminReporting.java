package com.project.erp.controller.gstian.examcell;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.StringBufferInputStream;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.FactoryConfigurationError;
import javax.xml.parsers.ParserConfigurationException;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.xhtmlrenderer.pdf.ITextRenderer;
import org.xml.sax.SAXException;

import com.lowagie.text.DocumentException;
import com.project.erp.model.StudentDetails;
import com.project.erp.serviceImpl.gstian.examcell.AdminAcknowledgement;
import com.project.erp.support.gstian.examcell.CustomUserDetails;
import com.project.erp.support.gstian.examcell.PictureRenderer;


@Controller
@PreAuthorize("hasRole('EXAMCELLCOORD')")
@RequestMapping("/adminreporting")
@SessionAttributes({ "semester", "branchCode"})
public class AdminReporting {

	@Autowired
	SessionFactory sessionFactory;
	
	@RequestMapping(value="/appliedstudents",method=RequestMethod.GET)
	public String openform() 
	{
		return "gstian/examcell/adminreporting/report";
	}
	
	@RequestMapping(value="/studentdata",method=RequestMethod.POST)
	public String applicationReview(@RequestParam(value="semester") String semester,@RequestParam(value="branch") String branchCode,Model model)
	{
		String page="";
		model.addAttribute("semester",semester);
		model.addAttribute("branchCode",branchCode);
		Session session=sessionFactory.openSession();
		Query query=session.createSQLQuery("select rollNumber from KtAppliedList where semester=? and branchCode=? ");
		
		query.setString(0, semester);
		query.setString(1,branchCode);

		List<String> rollNumbers=query.list();
		if(!rollNumbers.isEmpty()){
		Criteria criteria=session.createCriteria(StudentDetails.class);

		criteria.add(Restrictions.in("rollnumber", rollNumbers)).add(Restrictions.eq("branchCode", branchCode));

		List<StudentDetails> students=criteria.list();
		//System.out.println("checking 5");
		page="gstian/examcell/adminreporting/studentdata";
		
		if(students.isEmpty())
			model.addAttribute("message","No records found");
		
		model.addAttribute("students",students); //send list of student data
		}
		else{
			model.addAttribute("message","No records found");
			page="gstian/examcell/adminreporting/studentdata";
			
		}
		
		return page;
	}
	
	
	@SuppressWarnings({ "deprecation", "unchecked" })
	@Transactional
	@RequestMapping("/acknowledgement")
	public void ReportDisplay(HttpServletResponse response,
			Authentication auth,Model model) throws ParserConfigurationException,
			FactoryConfigurationError, SAXException, IOException,
			DocumentException {

		HashMap<String,Object> report=(HashMap<String, Object>) model.asMap();
		
		Session session = sessionFactory.openSession();
		
		

		CustomUserDetails user = (CustomUserDetails) auth.getPrincipal();

		
//		StudentDetails student = (StudentDetails) session.get(
//				StudentDetails.class, user.getUsername());

		Query query=session.createQuery("select distinct rollNumber from KtAppliedList where semester= :sem and branchCode= :branch");
		query.setParameter("sem", (String)report.get("semester"));
		query.setParameter("branch", (String)report.get("branchCode"));
		
		List<String> rollNumbers = query.list();

		System.out.println(rollNumbers.get(0));
		

		if (rollNumbers.isEmpty()) {
			PrintWriter htmlwriter = response.getWriter();
			htmlwriter.println("<html>");
			htmlwriter.println("<body>");
			htmlwriter
					.println("No results found.");
			htmlwriter.println("</body>");
			htmlwriter.println("</html>");
		}

		else {

			AdminAcknowledgement generator = new AdminAcknowledgement(rollNumbers,session,(String)report.get("branchCode"),(String)report.get("semester"));

			//System.out.println(generator.getAcknowledgement().toString());

			OutputStream os = response.getOutputStream();
			DocumentBuilder builder = DocumentBuilderFactory.newInstance()
					.newDocumentBuilder();
			org.w3c.dom.Document doc = builder
					.parse(new StringBufferInputStream(generator
							.getAcknowledgement().toString()));

			ITextRenderer renderer = new ITextRenderer();

			renderer.getSharedContext().setReplacedElementFactory(
					new PictureRenderer(renderer.getSharedContext()
							.getReplacedElementFactory()));

			renderer.setDocument(doc, null);
			renderer.layout();
			renderer.createPDF(os);
			os.close();

		}
		
		session.close();
	}

}
