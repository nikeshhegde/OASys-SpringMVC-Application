package com.project.erp.dao.gstian.examcell;

import com.project.erp.model.KtAppliedList;

//this dao ensures that student kt details are taken from form and stored into database
public interface KtAppliedListDao {

	public void storeKtStudentDetails(KtAppliedList studentKtRecord);
}
