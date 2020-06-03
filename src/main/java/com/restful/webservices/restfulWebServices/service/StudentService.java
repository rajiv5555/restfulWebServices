/**
 * 
 */
package com.restful.webservices.restfulWebServices.service;

import java.util.List;

import com.restful.webservices.restfulWebServices.Model.Student;

/**
 * @author rajivranjan
 *
 */
public interface StudentService {

	public List<Student> getAllStudet();

	public Student getStudent(Integer id);
}
