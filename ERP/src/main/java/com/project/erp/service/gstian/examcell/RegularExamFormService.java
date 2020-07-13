package com.project.erp.service.gstian.examcell;


import com.project.erp.model.StudentDetails;

//This Service Interface is related to StudentDetails Model Class and used for fetching student record based on RollNumber
public interface RegularExamFormService {
	
	

	public StudentDetails fetchStudentDetails(String rollNumber);

}
