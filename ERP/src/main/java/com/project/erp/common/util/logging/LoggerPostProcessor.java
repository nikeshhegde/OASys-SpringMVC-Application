/**
 * best url to understand the seam style logging implementation 
 * http://www.tzavellas.com/techblog/2007/03/31/implementing-seam-style-logger-injection-with-spring/
 */
package com.project.erp.common.util.logging;

import java.lang.reflect.Field;

//import org.apache.commons.logging.Log;
//import org.apache.commons.logging.LogFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.util.ReflectionUtils;
import org.springframework.util.ReflectionUtils.FieldCallback;

/**
 * @author ERP Developer
 *
 */
public class LoggerPostProcessor implements BeanPostProcessor {
	
	@Override 
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		    return bean;
		  }
	 
	 
	 @Override
	 public Object postProcessBeforeInitialization(final Object bean, String beanName) throws BeansException {
		    ReflectionUtils.doWithFields(bean.getClass(), new FieldCallback() {
		      public void doWith(Field field) throws IllegalArgumentException, IllegalAccessException {
		    	// make the field accessible if defined private
	                ReflectionUtils.makeAccessible(field);
		    	  if (field.getAnnotation(InjectableLogger.class) != null) {
		        // Log log = LogFactory.getLog(bean.getClass());
		          Logger log= LoggerFactory.getLogger(bean.getClass());
		          field.set(bean, log);
		        }
		      }
		    });
		    return bean;
		  }

}
