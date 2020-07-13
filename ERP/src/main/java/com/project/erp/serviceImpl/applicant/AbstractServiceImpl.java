package com.project.erp.serviceImpl.applicant;

import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.project.erp.common.util.logging.InjectableLogger;
import com.project.erp.dao.applicant.AbstractDao;
import com.project.erp.service.applicant.AbstractService;

/**
 * @author ERP Developer
 * @param <T>
 *
 */
public class AbstractServiceImpl<T> implements AbstractService<T> {

	@Override
	public List<T> listSelectedByUserName(String className, String username) {
		// TODO Auto-generated method stub
		return abstractDao.listSelectedByUserName(className,username);
	}

	@Autowired
	private AbstractDao abstractDao;

	@InjectableLogger
	public Logger logger;

	@Override
	@Transactional
	public void addRecord(T typeObject) {
		logger.info("Inside the add record method of the abstract service impl");
		abstractDao.addRecord(typeObject);

	}

	@Override
	@Transactional
	public void removeRecord(T typeObject, Integer id) {
		logger.info("Inside the remove record method of the abstract service impl");
		abstractDao.removeRecord(typeObject,id);

	}

	@Override
	@Transactional
	public List<T> listRecord(String className) {
		logger.info("Inside the list record method of the abstract service impl");
		return abstractDao.listRecord(className);
		// return null;
	}
	
	@Override
	@Transactional
	public List<T> listSelected(String className,String username,String password){
	
		return abstractDao.listSelected(className,username,password);
	}
	
	@Override
	@Transactional
	//public List<T> listRecord(String className, String userId){Monika
	public List<T> listRecord(String className, Integer userId){
		return abstractDao.listRecord(className,userId);
		
	}
	
	
	
	
	@Override
	@Transactional
	public void updateRecord(T typeObject) {
		logger.info("Inside the add record method of the abstract service impl");
		abstractDao.updateRecord(typeObject);

	}
	
	
	@Override
	@Transactional
	public Integer rowCount(String table)
	{
		return abstractDao.rowCount(table);
	}

	@Override
	@Transactional
	public List<T> listForeignRecord(String className, Integer userId)
	{
		return abstractDao.listForeignRecord(className, userId);
	}
	
}
