/**
 * 
 */
package com.project.erp.service.applicant;

import java.util.List;

import org.springframework.stereotype.Component;

/**
 * @author ERP Developer
 *
 */
@Component
public interface AbstractService<T> {

	public void addRecord(T typeObject);

	public void removeRecord(T typeObject,Integer id);

	public List<T> listRecord(String classname);
	
	public List<T> listSelectedByUserName(String className, String username);
	
	public List<T> listSelected(String className,String username,String password);
	
	public List<T> listRecord(String className, Integer userId);//Monika
	
	
	public void updateRecord(T typeObject);
	
	public Integer rowCount(String table);
	
	public List<T> listForeignRecord(String className,Integer userId);

}



