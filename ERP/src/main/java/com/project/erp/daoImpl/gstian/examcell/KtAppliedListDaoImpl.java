

package com.project.erp.daoImpl.gstian.examcell;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.erp.dao.gstian.examcell.KtAppliedListDao;
import com.project.erp.model.KtAppliedList;

@Repository
public class KtAppliedListDaoImpl implements KtAppliedListDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	public void storeKtStudentDetails(KtAppliedList studentKtRecord) {
		getSession().save(studentKtRecord);
	}
	
	
	private Session getSession(){
		      Session sess = sessionFactory.openSession();
        
        return sess;
	}

}
