/**
 * 
 */
package com.restful.webservices.restfulWebServices.configuration;

import java.util.Properties;

import org.springframework.context.annotation.Configuration;

/**
 * @author rajivranjan
 *
 */
@Configuration
public class CommonConfig {

	public final static String MODEL_PACKAGE = "com.restful.webservices.restfulWebServices.Model";
	
	    public final static Properties JPA_PROPERTIES = new Properties() {{
	        put("hibernate.dialect","org.hibernate.dialect.MySQL5Dialect");
	        put("hibernate.hbm2ddl.auto", "none");
	        put("show-sql", "true");
	    }};
	    
}
