/**
 * 
 */
package com.restful.webservices.restfulWebServices.service;

import com.restful.webservices.restfulWebServices.Model.Student;

/**
 * @author rajivranjan
 *
 */
public interface StudentService {

	public Iterable<Student> getAllStudet();

	public Student getStudent(Integer id);

	public void saveStudent(Student student);

	public Student updateStudent(Student student);

	public Integer deleteObj(Student stud);
}
