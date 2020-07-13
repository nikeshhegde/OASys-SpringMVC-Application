package com.project.erp.serviceImpl.gstian.examcell;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.erp.dao.gstian.examcell.KtAppliedListDao;
import com.project.erp.model.KtAppliedList;
import com.project.erp.model.KtStudents;
import com.project.erp.service.gstian.examcell.KtAppliedListService;

@Service
public class KtAppliedListServiceImpl implements KtAppliedListService {

	@Autowired
	private KtAppliedListDao ktAppliedListDao;

	@Transactional
	public void storeKtStudentDetails(KtAppliedList studentKtRecord) {
		ktAppliedListDao.storeKtStudentDetails(studentKtRecord);
	}

	public ArrayList<KtAppliedList> getSubjectNamesforType(String rollNumber,
			int type, Session session) {
		// List<KtAppliedList> studentList;

		Query query = session
				.createQuery("select subjectCode from KtAppliedList where rollNumber=? and "+typeQuery(type)+"=?"); // query
																						// for
																						// subject
																						// codes
		query.setString(0, rollNumber);
		query.setBoolean(1, true);
		
		ArrayList<String> ktSubjects = (ArrayList<String>) query.list();

		
		
		
			
		Criteria criteria = session.createCriteria(KtStudents.class);

		criteria.add(Restrictions.eq("rollNumber", rollNumber)).add(Restrictions.eq(typeQuery(type), true));
		
		if(!ktSubjects.isEmpty())
		criteria.add(Restrictions.not(Restrictions.in("subjectCode", ktSubjects)));
				

		
		ArrayList<KtAppliedList> studentList = (ArrayList<KtAppliedList>) criteria.list();

		return studentList;
	}

	/*
	 * private String typeGenerate(int type) // generates value for input field
	 * { int i = 0; String type_string = ""; for (i = 0; i < 3; i++) { if (i ==
	 * type) type_string = type_string + "1"; else type_string = type_string +
	 * "0"; } return type_string; }
	 */

	private String typeQuery(int type) {
		String type_query = "";
		if (type == 0)
			type_query = "theoryKt";
		if (type == 1)
			type_query = "practicalKt";
		if (type == 2)
			type_query = "oralKt";
		if (type == 3)
			type_query = "internalKt";

		return type_query;
	}

	private int typeGenerate(String type) {

		return Integer.parseInt(type);
	}

	public void saveUpdateStudentListForType(List<KtStudents> subjects,
			String type, Session session) {
		Query query;

		// int type_int = typeGenerate(type);

		// iterates through the list of subjects
		for (KtStudents subject : subjects) {
			query = session
					.createQuery("from KtAppliedList where rollNumber=? and subjectCode=?");
			query.setString(0, subject.getRollNumber());
			query.setString(1, subject.getSubjectCode());

			// get the list of subjects in applied section to check if
			// application already present for said subject
			List<KtAppliedList> applied = query.list();

			// if no application present for subject
			if (applied.isEmpty()) {
				// create new application based on existing details..
				KtAppliedList newApplication = new KtAppliedList()
						.copy(subject);

				// ..and kt type obtained from method param
				if(type.equalsIgnoreCase("0"))
					newApplication.setTheoryKt(true);
				
				if(type.equalsIgnoreCase("1"))
					newApplication.setPracticalKt(true);
				if(type.equalsIgnoreCase("2"))
					newApplication.setOralKt(true);
				if(type.equalsIgnoreCase("3"))
					newApplication.setInternalKt(true);
				

				session.beginTransaction();
				session.save(newApplication);
				session.getTransaction().commit();
			}

			else {
				// get existing application record
				KtAppliedList existingApplication = applied.get(0);
				session.beginTransaction();
				KtAppliedList applicationRecord = (KtAppliedList) session.get(
						KtAppliedList.class, existingApplication.getId());
				
				if(type.equalsIgnoreCase("0")) //update type to applied
					existingApplication.setTheoryKt(true);
				
				if(type.equalsIgnoreCase("1"))
					existingApplication.setPracticalKt(true);
				if(type.equalsIgnoreCase("2"))
					existingApplication.setOralKt(true);
				if(type.equalsIgnoreCase("3"))
					existingApplication.setInternalKt(true);
				
				
				session.save(applicationRecord);
				session.getTransaction().commit();
			}

		}
	}

}
