/**
 * 
 */
package com.project.erp.common.util.logging;

import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * @author ERP Developer
 *
 */
@Service
public class LoggerProducer {
	
	@Produces  
    public Logger createLog(InjectionPoint injectionPoint) {  
		
		
		 String name = injectionPoint.getMember().getDeclaringClass().getName();
		 
		 return LoggerFactory.getLogger(name);
		 
		//return LoggerFactory.getLogger(injectionPoint.getMember().getDeclaringClass().getName());
		
        //return Logger.getLogger(injectionPoint.getMember().getDeclaringClass().getName());  
    }  

}





