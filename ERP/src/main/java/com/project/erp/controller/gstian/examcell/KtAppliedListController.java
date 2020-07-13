package com.project.erp.controller.gstian.examcell;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.StringBufferInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.FactoryConfigurationError;
import javax.xml.parsers.ParserConfigurationException;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import org.xhtmlrenderer.pdf.ITextRenderer;
import org.xml.sax.SAXException;

import com.lowagie.text.DocumentException;
import com.project.erp.model.KtAppliedList;
import com.project.erp.model.KtStudents;
import com.project.erp.model.StudentDetails;
import com.project.erp.service.gstian.examcell.KtAppliedListService;
import com.project.erp.serviceImpl.gstian.examcell.AcknowledgementGeneration;
import com.project.erp.support.gstian.examcell.CustomUserDetails;
import com.project.erp.support.gstian.examcell.KtApplicationResponseStorer;
import com.project.erp.support.gstian.examcell.PictureRenderer;

@Controller
@PreAuthorize("hasRole('STUDENT')")
@RequestMapping("/ktform")
@SessionAttributes({ "theoryList", "practicalList", "oralList", "internalList",
		"typeOfKt", "list" })
public class KtAppliedListController {

	
	@Autowired
	private KtAppliedListService ktAppliedListService;

	@Autowired
	private SessionFactory sessionFactory;
	
	@RequestMapping("/exam")
	public String redirectToExamPage()
	{
		return "gstian/examcell/ktform/exam";
	}

	@RequestMapping("/")
	@Transactional
	public String formlinksdisplayer(Authentication auth, Model model) {
		CustomUserDetails user = (CustomUserDetails) auth.getPrincipal();
		Session session = sessionFactory.openSession();
		String rollNum = user.getUsername();

		// Gets the list of theory KTs left to fill
		ArrayList<KtAppliedList> theoryList = (ArrayList<KtAppliedList>) ktAppliedListService
				.getSubjectNamesforType(rollNum,
						ktAppliedListService.TYPE_THEORY, session);

		// Gets the list of practical kts left to fill
		ArrayList<KtAppliedList> practicalList = (ArrayList<KtAppliedList>) ktAppliedListService
				.getSubjectNamesforType(rollNum,
						ktAppliedListService.TYPE_PRACTICAL, session);

		// Gets the list of oral kts left to fill
		ArrayList<KtAppliedList> oralList = (ArrayList<KtAppliedList>) ktAppliedListService
				.getSubjectNamesforType(rollNum,
						ktAppliedListService.TYPE_ORAL, session);

		// Gets the list of internal kts left to fill
		ArrayList<KtAppliedList> internalList = (ArrayList<KtAppliedList>) ktAppliedListService
				.getSubjectNamesforType(rollNum,
						ktAppliedListService.TYPE_INTERNAL, session);

		// saves the theory list to session
		model.addAttribute("theoryList", theoryList);

		// saves the practical list to session
		model.addAttribute("practicalList", practicalList);

		// saves the oral list to session
		model.addAttribute("oralList", oralList);

		// saves the internal list to session
		model.addAttribute("internalList", internalList);

		if (theoryList.isEmpty())
			model.addAttribute("theoryListEmpty", 1); // disables theory form
														// link

		if (practicalList.isEmpty())
			model.addAttribute("practicalListEmpty", 1); // disables pror form
															// link

		if (oralList.isEmpty())
			model.addAttribute("oralListEmpty", 1); // disables pror form link

		if (internalList.isEmpty())
			model.addAttribute("internalListEmpty", 1); // disables internal
														// form link

		if (theoryList.isEmpty() && practicalList.isEmpty()
				&& internalList.isEmpty() && oralList.isEmpty())
			model.addAttribute("NoKtsLeft", 1); // All links disabled, redirect
												// to home

		return "gstian/examcell/ktform/formlinks"; // redirects to form links holder page
	}

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/form/{type}", method = RequestMethod.GET)
	public ModelAndView formcreator(@PathVariable String type, Model model) {
		HashMap<String, Object> listMap = (HashMap<String, Object>) model
				.asMap();
		String listToBeSent = "";
		model.addAttribute("typeOfKt", type);

		if (type.equalsIgnoreCase("0")) // 0 is the type code for theory
			listToBeSent = "theoryList";

		if (type.equalsIgnoreCase("1")) // 1 is type code for practical
			listToBeSent = "practicalList";

		if (type.equalsIgnoreCase("2")) // 2 is type code for oral
			listToBeSent = "oralList";

		if (type.equalsIgnoreCase("3")) // 3 is type code for internal
			listToBeSent = "internalList";

		ArrayList<KtStudents> listOfSubjects = (ArrayList<KtStudents>) listMap
				.get(listToBeSent);

		ModelAndView direction;
		String redirect = "gstian/examcell/ktform/ktApplicationForm";
		try {
			listOfSubjects.isEmpty();
			model.addAttribute("list", listOfSubjects);
			direction=new ModelAndView(redirect, "listofkts",
					new KtApplicationResponseStorer()); // add list to model and send

		} catch (NullPointerException e) {
			redirect = "redirect:/";
			direction=new ModelAndView(redirect);
		}

		model.addAttribute("enable", "1");

		return direction;	
				}

	@RequestMapping(value = "/form/formProcess", method = RequestMethod.POST)
	public String ktApplicationsUpdater(
			@ModelAttribute("listofkts") KtApplicationResponseStorer responseStorer,
			BindingResult result, Model model, Authentication auth) {
		CustomUserDetails user = (CustomUserDetails) auth.getPrincipal();

		HashMap<String, Object> sessionValues = (HashMap<String, Object>) model
				.asMap();

		String redirect; // USED TO CHECK FOR NO SELECTIONS

		try {
			Session session = sessionFactory.openSession();

			Criteria criteria = session.createCriteria(KtStudents.class);

			criteria.add(Restrictions.eq("rollNumber", user.getUsername()))
					.add(Restrictions.in("subjectCode",
							responseStorer.getResponse()));

			// gets the list of kts for the particular student and preferred
			// subjects
			ArrayList<KtStudents> ktSubjects = (ArrayList<KtStudents>) criteria
					.list();

			// save-updates list of subjects to DB
			ktAppliedListService.saveUpdateStudentListForType(ktSubjects,
					(String) sessionValues.get("typeOfKt"), session);

			model.addAttribute(
					"ktapp",
					"Your Application has been received. Please enter the forms section if you have any other kts left to apply");

			/*redirect = "student/StudentHome";*/
			redirect="gstian/examcell/student/help";
		} catch (NullPointerException e) {
			redirect = "gstian/examcell/student/help";
		}

		return redirect;
	}
	
	@PreAuthorize("hasRole('STUDENT')")
	@SuppressWarnings({ "deprecation", "unchecked" })
	@Transactional
	@RequestMapping("/acknowledgement")
	public void AcknowledgementDisplay(HttpServletResponse response,
			Authentication auth) throws ParserConfigurationException,
			FactoryConfigurationError, SAXException, IOException,
			DocumentException {

		Session session = sessionFactory.openSession();
		session.beginTransaction();

		CustomUserDetails user = (CustomUserDetails) auth.getPrincipal();

		StudentDetails student = (StudentDetails) session.get(
				StudentDetails.class, user.getUsername());

		Criteria criteria = session.createCriteria(KtAppliedList.class);
		criteria.add(Restrictions.eq("rollNumber", user.getUsername()));

		List<KtAppliedList> applications = criteria.list();

		session.getTransaction().commit();
		session.close();

		if (applications.isEmpty()) {
			PrintWriter htmlwriter = response.getWriter();
			htmlwriter.println("<html>");
			htmlwriter.println("<body>");
			htmlwriter
					.println("Please register for the exam to access the acknowledgement.");
			htmlwriter.println("</body>");
			htmlwriter.println("</html>");
		}

		else {

			AcknowledgementGeneration generator = new AcknowledgementGeneration(
					student, applications);

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

	}

}
