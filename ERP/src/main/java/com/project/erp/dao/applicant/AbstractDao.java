/**
 * 
 */
package com.project.erp.dao.applicant;

import java.util.List;

import org.springframework.stereotype.Component;

/**
 * @author ERP Developer
 *
 */
@Component
public interface AbstractDao<T> {

	public void addRecord(T typeObject);

	public void removeRecord(T className,Integer id);

	public List<T> listRecord(String className);
	
	public List<T> listSelected(String className,String username,String password);
	
	public List<T> listSelectedByUserName(String className, String username);

	//public List<T> listRecord(String className, String userId);Monika 
	public List<T> listRecord(String className, Integer userId);
	
	public void updateRecord(T typeObject);
	
	public Integer rowCount(String table);
	
	public List<T> listForeignRecord(String className,Integer userId);
	
}
