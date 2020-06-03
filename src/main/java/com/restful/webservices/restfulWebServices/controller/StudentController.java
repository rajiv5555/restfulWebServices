/**
 * 
 */
package com.restful.webservices.restfulWebServices.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.restful.webservices.restfulWebServices.Model.Student;
import com.restful.webservices.restfulWebServices.exception.UserNotFoundException;
import com.restful.webservices.restfulWebServices.service.StudentService;

import lombok.extern.log4j.Log4j2;

/**
 * @author rajivranjan
 *
 */
@RestController
@Log4j2
public class StudentController {

	@Autowired
	private StudentService studentService;
	
	@GetMapping(path="/students")
	public Iterable<Student> getAllStudent(){
		return studentService.getAllStudet();
	}
	
	@GetMapping(path="/student/{id}")
	public Student getStudentById(@PathVariable("id") Integer id){
		Student student= studentService.getStudent(id);
		if(student==null)
			throw new UserNotFoundException("user not found id- "+id);
		return student;
	}
	
	@PostMapping(path="/student")
	public void saveStudent(@RequestBody Student student) {
		log.info(" student obj "+student);
		studentService.saveStudent(student);
	}
	
	@PutMapping(path="/student")
	public Student updateStudent(@RequestBody Student student) {
		log.info("updating object "+student);
		studentService.updateStudent(student);
		return student;
	}
	
	@DeleteMapping
	public Integer deleteStudent(@RequestBody Student stud) {
		log.info(" delete obj : "+stud);
		Integer id=studentService.deleteObj(stud);
		return id;
	}
	
	
}
