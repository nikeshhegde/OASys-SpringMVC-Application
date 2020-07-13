package com.project.erp.dao.gstian.examcell;

//this interface is related to studentDetails model class the purpose of this dao is to fetch data to regular exam form

import com.project.erp.model.StudentDetails;

public interface RegularExamFormDao {
	
	public StudentDetails fetchStudentDetails(String rollNumber);

}




	