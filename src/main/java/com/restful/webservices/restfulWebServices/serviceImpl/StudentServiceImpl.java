/**
 * 
 */
package com.restful.webservices.restfulWebServices.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restful.webservices.restfulWebServices.Model.Student;
import com.restful.webservices.restfulWebServices.readDao.StudentReadRepository;
import com.restful.webservices.restfulWebServices.service.StudentService;
import com.restful.webservices.restfulWebServices.writeDao.StudentWriteRepository;

/**
 * @author rajivranjan
 *
 */
@Service
public class StudentServiceImpl implements StudentService {
	
	@Autowired
	private  StudentReadRepository studentReadRepository;
	
	@Autowired
    private  StudentWriteRepository studentWriteRepository;

  /*  public StudentServiceImpl(StudentReadRepository customerReadRepository, StudentWriteRepository customerWriteRepository) {
        this.studentReadRepository = customerReadRepository;
        this.studentWriteRepository = customerWriteRepository;
    }*/
	
	@Override
	public List<Student> getAllStudet() {
		return studentReadRepository.findAll();
	}
	
	@Override
	public Student getStudent(Integer id) {
		Optional<Student> stud= studentReadRepository.findById(id);
		return stud.orElse(null);
	}

}
