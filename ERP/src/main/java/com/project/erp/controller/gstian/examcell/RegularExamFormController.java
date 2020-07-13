package com.project.erp.controller.gstian.examcell;

import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.project.erp.model.RegularApplied;
import com.project.erp.model.StudentDetails;
import com.project.erp.service.gstian.examcell.RegularExamFormService;
import com.project.erp.support.gstian.examcell.CustomUserDetails;

@Controller
@PreAuthorize("hasRole('STUDENT')")
@RequestMapping("/regularform")
public class RegularExamFormController {

	@Autowired
	RegularExamFormService regularExamFormService;

	@Autowired
	private SessionFactory sessionFactory;

	@RequestMapping(value = "/apply")
	@Transactional
	public String fetchRegularFormStudentDetails(Authentication auth,
			Map<String, Object> formMap) {
		String url = "redirect:gstian/examcell/alreadyApplied";
		CustomUserDetails user = (CustomUserDetails) auth.getPrincipal();

		Session session = sessionFactory.openSession();
		RegularApplied student = (RegularApplied) session.get(
				RegularApplied.class, user.getUsername());

		if (student == null) {
			StudentDetails studentDetails = (StudentDetails) session.get(
					StudentDetails.class, user.getUsername());
			formMap.put("studentDetails", studentDetails);
			url = "/gstian/examcell/regularform/showandverify";
		}

		session.close();

		return url;
	}

	/*
	 * 
	 * //This would be called once the student in the regularform validates and
	 * says his credentials are correct.
	 */
	@RequestMapping(value = "/verified")
	@Transactional
	public String obtainVerifyStatusFromStudent(Authentication auth) {
		CustomUserDetails user = (CustomUserDetails) auth.getPrincipal();

		RegularApplied student = new RegularApplied();
		student.setRollNumber(user.getUsername());
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(student);
		session.getTransaction().commit();
		session.close();

		return "redirect:/gstian/examcell/regularform/alreadyApplied";
	}

	@RequestMapping("/alreadyApplied")
	public String applied(Model model) {
		String message = "You have already applied. Please check the receipts section of the page";
		model.addAttribute("regapp", message);
		return "gstian/examcell/student/StudentHome";
	}

}
