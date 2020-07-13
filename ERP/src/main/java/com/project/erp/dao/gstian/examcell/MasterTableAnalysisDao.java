package com.project.erp.dao.gstian.examcell;

import org.hibernate.Session;

public interface MasterTableAnalysisDao {

	void populateMasterTable(String[] record,Session session); //for populating master table
	void studentDetailsManage(String[] record,Session session); //for populating student-details
	void usersManage(String[] record,Session session);  //for populating login table
	void ktclassify(String[] record,Session session); //for classifying kt-eligible candidates
}
