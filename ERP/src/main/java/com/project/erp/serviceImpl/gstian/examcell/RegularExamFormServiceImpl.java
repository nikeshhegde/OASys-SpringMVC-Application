package com.project.erp.serviceImpl.gstian.examcell;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.erp.dao.gstian.examcell.RegularExamFormDao;
import com.project.erp.model.StudentDetails;
import com.project.erp.service.gstian.examcell.RegularExamFormService;

@Service
public class RegularExamFormServiceImpl implements RegularExamFormService {

	@Autowired
	private RegularExamFormDao regularExamFormDao;
	
	@Transactional
	public StudentDetails fetchStudentDetails(String rollNumber) {
		return regularExamFormDao.fetchStudentDetails(rollNumber);
	}
	

}
