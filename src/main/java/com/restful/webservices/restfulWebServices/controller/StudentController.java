/**
 * 
 */
package com.restful.webservices.restfulWebServices.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.restful.webservices.restfulWebServices.Model.Student;
import com.restful.webservices.restfulWebServices.service.StudentService;

/**
 * @author rajivranjan
 *
 */
@RestController
public class StudentController {

	@Autowired
	private StudentService studentService;
	
	@GetMapping(path="/students")
	public List<Student> getAllStudent(){
		return studentService.getAllStudet();
	}
	
	@GetMapping(path="/student/{id}")
	public Student getStudentById(@PathVariable("id") Integer id){
		return studentService.getStudent(id);
	}
}
