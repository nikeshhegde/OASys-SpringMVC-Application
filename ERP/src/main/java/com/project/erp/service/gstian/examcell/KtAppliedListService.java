package com.project.erp.service.gstian.examcell;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import com.project.erp.model.KtAppliedList;
import com.project.erp.model.KtStudents;

public interface KtAppliedListService {
	
	public static final int TYPE_THEORY=0;
	public static final int TYPE_PRACTICAL=1;
	public static final int TYPE_ORAL=2;
	public static final int TYPE_INTERNAL=3;
	
	
	public void storeKtStudentDetails(KtAppliedList studentKtRecord);
	
	public ArrayList<KtAppliedList> getSubjectNamesforType(String rollNumber,int type,Session session); //fetches subjects which the student has not applied for yet; after scanning for a particular type(theory/pror/internal)
	
	public void saveUpdateStudentListForType(List<KtStudents> subjects,String type,Session session);
		

}
