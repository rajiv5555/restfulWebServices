/**
 * 
 */
package com.restful.webservices.restfulWebServices.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author rajivranjan
 *
 */
// 1. configuration
@Configuration
// 2. Enable Swagger
@EnableSwagger2
public class SwaggerConfig {
	
	//3. Bean Docket
	    // swagger 2
	    // all the path
		// all the api
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2);
	}

}
