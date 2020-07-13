/**
 * Implementing Seam style @Logger injection with Spring
 */
package com.project.erp.common.util.logging;


import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;


/**
 * @author ERP Developer
 *
 */
@Retention(RUNTIME)
@Target(FIELD)
@Documented
public @interface InjectableLogger {

}
