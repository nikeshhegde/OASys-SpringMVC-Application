package com.project.erp.daoImpl.applicant;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projections;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.erp.common.util.logging.InjectableLogger;
import com.project.erp.dao.applicant.AbstractDao;
/**
 * @author ERP Developer
 *
 */
@Repository
@Transactional
public class AbstractDaoImpl<T> implements AbstractDao<T> {

	

	@Override
	public List<T> listSelectedByUserName(String className, String username) {
		// TODO Auto-generated method stub
		String query="";
		if(className.equals("AdmissionUser1"))
		{
			query = "from "+className+" WHERE admissionUserEmail='"+username+"'";
		}
		else if(className.equals("Users"))
		{
			query = "from "+className+" WHERE username='"+username+"'";
		}
		return sessionFactory.getCurrentSession().createQuery(query)
				.list();
	}

	@Autowired
	private SessionFactory sessionFactory;

	@InjectableLogger
	public Logger logger;

	@Override
	public void addRecord(T typeObject) {

		//sessionFactory.getCurrentSession().clear();
		//Session session2=sessionFactory.openSession();
		//session2.beginTransaction();
		Transaction tx=null;
		//tx=sessionFactory.getCurrentSession().beginTransaction();
		try {
			logger.debug("Before saveorUpdate");
			//logger.debug("Sessionqwert "+sessionFactory.getCurrentSession());
			//sessionFactory.getCurrentSession().saveOrUpdate(typeObject);
			sessionFactory.getCurrentSession().save(typeObject);
			logger.debug("After saveorUpdate");
			//sessionFactory.getCurrentSession().getTransaction().commit();
		} catch (HibernateException hex) {
			logger.debug("After saveorUpdate2");
			logger.debug("Hibernate Exception {}", hex.getMessage());
		}
		

	}

	@Override
	public void removeRecord(T className,Integer id) {
		// TODO Auto-generated method stub
		
		logger.info("class name :: "+className.getClass().getSimpleName());
		
		
		Object login = (T) sessionFactory.getCurrentSession().load(className.getClass(), id);
        if (null != login) {
            sessionFactory.getCurrentSession().delete(login);
        }

	}

	@Override
	public List<T> listRecord(String className) {

		logger.info("Inside the addloginUser method for persisting new user"+className);
		String query = "from "+className;
		return sessionFactory.getCurrentSession().createQuery(query)
				.list();
	}

	
	
	
	@Override
	public List<T> listSelected(String className,String username,String password) {

		logger.info("Inside the addloginUser method for persisting new user"+className);
		String query="";
		if(className.equals("AdmissionUser1"))
		{
			query = "from "+className+" WHERE admissionUserEmail='"+username+"' AND admissionUserPassword='"+password+"'";
		}
		else if(className.equals("Admin"))
		{
			query = "from "+className+" WHERE adminFname='"+username+"' AND adminPassword='"+password+"'";

		}
		else if(className.equals("Alumni"))
		{
			query = "from "+className+" WHERE alumniFname='"+username+"' AND alumniPassword='"+password+"'";

		}
		else if(className.equals("Users")){
			query = "from "+className+" WHERE username='"+username+"' AND password='"+password+"'";
		}
		else
		{
			
		}
		return sessionFactory.getCurrentSession().createQuery(query)
				.list();
	}
	
	//public List<T> listRecord(String className, String userId) {Monika
	public List<T> listRecord(String className, Integer userId) {
		logger.info("Maintaining session across sessions"+className);
		//String query = "from "+className+" WHERE admission_user_username='" +userId+"' ";
		String query = "from "+className+" WHERE id='" +userId+"' ";
		return sessionFactory.getCurrentSession().createQuery(query).list();
	}
	
	
	@Override
	public void updateRecord(T typeObject) {

		//logger.info("Inside the addloginUser method for persisting new user");
		//sessionFactory.getCurrentSession().clear(); Monika
		//Session session2=sessionFactory.openSession();
		//session2.beginTransaction();
		//Transaction tx=null;
		try {
			//tx=sessionFactory.getCurrentSession().getTransaction();
			//session2.update(typeObject);
			//sessionFactory.getCurrentSession().getTransaction().commit();
			logger.debug("update hibernate");
			sessionFactory.getCurrentSession().update(typeObject);
		} catch (HibernateException hex) {
			logger.debug("Hibernate Exception {}", hex.getMessage());
		}
		
		finally
		{
			//session2.getTransaction().commit();
			//session2.close();
		}
	}
	
	@Override
	public Integer rowCount(String table){
	
		return (Integer) sessionFactory.getCurrentSession().createCriteria(table).setProjection(Projections.rowCount()).uniqueResult();

	}
	
	@Override
	public List<T> listForeignRecord(String className,Integer userId)
	{
		String query = "from "+className+" WHERE admissionUserId='" +userId+"' ";
		return sessionFactory.getCurrentSession().createQuery(query).list();	
	}
	


}
