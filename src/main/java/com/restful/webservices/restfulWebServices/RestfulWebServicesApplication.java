package com.restful.webservices.restfulWebServices;

import java.util.Locale;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;

@SpringBootApplication
@EnableJpaRepositories
public class RestfulWebServicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestfulWebServicesApplication.class, args);
	}

	//Note: if we are using @RequestHeader(value="Accept-Language",required=false) Locale locale in controller
	// then we need to use SessionLocaleResolver
	//if we are using LocaleContextHolder.getLocale() in controller we need to use AcceptHeaderLocaleResolver
	@Bean
	public LocaleResolver localeResolver() {
		//SessionLocaleResolver locale=new SessionLocaleResolver();
		AcceptHeaderLocaleResolver locale=new AcceptHeaderLocaleResolver();
		locale.setDefaultLocale(Locale.US);
		return locale;
	}
	
	// 1st way shortcut configure in application.properties  spring.messages.basename=message
	/*@Bean
	public ResourceBundleMessageSource messageSource() {
		ResourceBundleMessageSource msgSource=new ResourceBundleMessageSource();
		msgSource.setBasename("message");
		return msgSource;
	}*/
}
