/**
 * 
 */
package com.restful.webservices.restfulWebServices.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restful.webservices.restfulWebServices.Dao.StudentDoa;
import com.restful.webservices.restfulWebServices.Model.Student;
import com.restful.webservices.restfulWebServices.readRepository.StudentReadRepository;
import com.restful.webservices.restfulWebServices.service.StudentService;
import com.restful.webservices.restfulWebServices.writeRepository.StudentWriteRepository;

/**
 * @author rajivranjan
 *
 */
@Service
public class StudentServiceImpl implements StudentService {
	
   @Autowired
   private StudentDoa studentdao;
  
	
	@Override
	public Iterable<Student> getAllStudet() {
		return studentdao.findAll();
	}
	
	@Override
	public Student getStudent(Integer id) {
		Optional<Student> stud= studentdao.findById(id);
		return stud.orElse(null);
	}

	@Override
	public void saveStudent(Student student) {
      studentdao.save(student);		
	}

	@Override
	public Student updateStudent(Student student) {
     saveStudent(student);
     return student;
	}

	@Override
	public Integer deleteObj(Student stud) {
		 studentdao.delete(stud);
		 return stud.getId();
	}

}
