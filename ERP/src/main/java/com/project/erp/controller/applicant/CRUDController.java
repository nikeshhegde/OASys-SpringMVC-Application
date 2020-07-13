package com.project.erp.controller.applicant;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.project.erp.common.util.logging.InjectableLogger;
import com.project.erp.service.applicant.AbstractService;

/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping(value = "/")

public class CRUDController {
	
	@InjectableLogger
	public Logger logger;

	@Autowired
	private AbstractService abstractService;
	
	
	
	@RequestMapping(value = "/crud" ,method = RequestMethod.GET)
	
	public ModelAndView crud(@RequestParam("table") String type,Model model, HttpSession session) throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		ModelAndView mv=new ModelAndView();
		int i=0;
		String tables[]=getTables();
		int typenumber=Integer.parseInt(type);
		Class c=Class.forName("com.gsl.web.domin.model."+tables[typenumber]);
		logger.debug(c.getName()+" is the class");
		ArrayList<Method> list = new ArrayList<Method>();
		Method[] methods=c.getDeclaredMethods();
		Type t;
	
		for(Method method:methods)
		{
			t=method.getGenericReturnType();
			logger.debug(" method is :"+t.toString());
			if(!t.toString().equals("void"))
			{	
				logger.debug("Method name is "+method.toString());
				list.add(method);
			}
		}
		List records=abstractService.listRecord(tables[typenumber]);
		
		i=0;
		int j=0;
		Object object=c.newInstance();
		String [][] result=new String[records.size()][list.size()];
		Object value;
		
		String methodName[]=new String[list.size()];
		String tempmethod="";
		while(i<records.size())
		{
			object=records.get(i);
			j=0;
			while(j<list.size())
			{
				value=list.get(j).invoke(object);
				if(i==0)
				{
				tempmethod=list.get(j).toString();
				//logger.debug("Starts with "+tempmethod.indexOf("get"));
				methodName[j]=tempmethod.substring(tempmethod.indexOf("get")+3,tempmethod.length()-2);
				}
				result[i][j]="null";
				if(value!=null)
				{
				if(list.get(j).getReturnType().toString().contains("String"))
					{
					result[i][j]=(String)value;
					}
				
				else if(list.get(j).getReturnType().toString().contains("Integer"))
					{
					result[i][j]=value.toString();	
					}
				else
					{
					
					}
				}
				if(result[i][j].equals(""))
				{
					result[i][j]="empty";
				}
				j++;
			}
			i++;
		}
		
		/*
		for(i=0;i<records.size();i++)
		{
			logger.debug("Record i: "+i);
			for(j=0;j<list.size();j++)
			{
				logger.debug("field j: "+ j+" value: "+result[i][j]);
			}
		}
		*/
		//logger.debug("Length is "+result.length);
		//logger.debug(" Length 2 is "+result[i].length);
		model.addAttribute("result", result);
		model.addAttribute("Attribute",methodName);
		mv.setViewName("crud");
		return  mv;
	}
	
	public String[] getTables()
	{
		int numberOfTables=6;
		String tables[]=new String[numberOfTables];
		int i=0;
		tables[i++]="AcademicDetailsDse";
		tables[i++]="Admin";
		tables[i++]="AdmissionUser1";
		tables[i++]="AdmissionUserBranchSelection";
		tables[i++]="AdmissionUserFeAcademics";
		tables[i++]="PaymentLog";
		return tables;
	}
	
	
	
@RequestMapping(value = "/schema" ,method = RequestMethod.GET)
	
	public ModelAndView testorm(Model model, HttpSession session) {
		
		String[] tables=getTables();
	
		String url[]=new String[tables.length];
		int i;
		for(i=0;i<url.length;i++)
		{
			url[i]="crud/?table="+i;
		}
		model.addAttribute("tables", tables);
		model.addAttribute("url", url);
		ModelAndView mv=new ModelAndView();
		mv.setViewName("schema");
		return mv;
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}