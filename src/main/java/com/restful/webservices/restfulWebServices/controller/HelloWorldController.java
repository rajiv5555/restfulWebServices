/**
 * 
 */
package com.restful.webservices.restfulWebServices.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.restful.webservices.restfulWebServices.pojo.HelloWorldBean;

/**
 * @author rajivranjan
 *
 */
@RestController
public class HelloWorldController {

	@Autowired
	MessageSource msgSource;
	
	//@RequestMapping(method=RequestMethod.GET,path="/hello")
	@GetMapping(path="/hello")
	public String helloMethod() {
		return "Hello World";
	}
	
	@GetMapping(path="/hellobean")
	public HelloWorldBean helloBeanMethod() {
		return new HelloWorldBean("Hello World");
	}

	@GetMapping(path="/hellobean/path-variable/{name}")
	public HelloWorldBean helloBeanPathVariable(/*@PathVariable*/ String name) {
		return new HelloWorldBean(String.format("Hello World, %s",name));
	}
	
	/*@GetMapping(path="/helloI18N")
	public String helloi18N(@RequestHeader(value="Accept-Language",required=false) Locale locale) {
		return msgSource.getMessage("good.morning.message", null, locale);
	}*/

	@GetMapping(path="/helloI18N")
	public String helloi18N() {
		return msgSource.getMessage("good.morning.message", null, LocaleContextHolder.getLocale());
	}
	
}
