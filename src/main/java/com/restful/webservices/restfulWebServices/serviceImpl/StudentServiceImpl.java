/**
 * 
 */
package com.restful.webservices.restfulWebServices.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.restful.webservices.restfulWebServices.Model.Student;
import com.restful.webservices.restfulWebServices.dao.StudentRepository;
import com.restful.webservices.restfulWebServices.service.StudentService;

/**
 * @author rajivranjan
 *
 */
@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentRepository studentRepository;
	
	@Override
	public List<Student> getAllStudet() {
		return studentRepository.findAll();
	}
	
	@Override
	public Student getStudent(Integer id) {
		Optional<Student> stud= studentRepository.findById(id);
		return stud.orElse(null);
	}

}
