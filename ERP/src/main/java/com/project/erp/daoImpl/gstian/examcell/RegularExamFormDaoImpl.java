package com.project.erp.daoImpl.gstian.examcell;

//This class is related to StudentDetails Model Class and used for fetching student record based on RollNumber
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.erp.dao.gstian.examcell.RegularExamFormDao;
import com.project.erp.model.StudentDetails;

@Repository
public class RegularExamFormDaoImpl implements RegularExamFormDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	//Fetches the student details that would get displayed to the Regular Form
	public StudentDetails fetchStudentDetails(String rollNumber) {
		return (StudentDetails)getSession().get(StudentDetails.class, rollNumber);
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	
	
	public Session getSession(){
		Session sess = getSessionFactory().getCurrentSession();
        if (sess == null) {
               sess = getSessionFactory().openSession();
        }
        return sess;
	}
}
