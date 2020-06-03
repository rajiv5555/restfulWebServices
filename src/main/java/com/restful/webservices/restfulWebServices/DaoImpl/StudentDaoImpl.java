/**
 * 
 */
package com.restful.webservices.restfulWebServices.DaoImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.restful.webservices.restfulWebServices.Dao.StudentDoa;
import com.restful.webservices.restfulWebServices.Model.Student;
import com.restful.webservices.restfulWebServices.readRepository.StudentReadRepository;
import com.restful.webservices.restfulWebServices.writeRepository.StudentWriteRepository;

/**
 * @author rajivranjan
 *
 */
@Repository
public class StudentDaoImpl implements StudentDoa {
	
	@Autowired
	private  StudentReadRepository studentReadRepository;
	
	@Autowired
    private  StudentWriteRepository studentWriteRepository;

	@Override
	public <S extends Student> S save(S entity) {
		return studentWriteRepository.save(entity);
	}

	@Override
	public <S extends Student> Iterable<S> saveAll(Iterable<S> entities) {
		return studentWriteRepository.saveAll(entities);
	}

	@Override
	public Optional<Student> findById(Integer id) {
		return studentReadRepository.findById(id);
	}

	@Override
	public boolean existsById(Integer id) {
		return studentReadRepository.existsById(id);
	}

	@Override
	public Iterable<Student> findAll() {
		return studentReadRepository.findAll();
	}

	@Override
	public Iterable<Student> findAllById(Iterable<Integer> ids) {
		return studentReadRepository.findAllById(ids);
	}

	@Override
	public long count() {
		return studentReadRepository.count();
	}

	@Override
	public void deleteById(Integer id) {
		studentWriteRepository.deleteById(id);		
	}

	@Override
	public void delete(Student entity) {
		studentWriteRepository.delete(entity);		
	}

	@Override
	public void deleteAll(Iterable<? extends Student> entities) {
		studentWriteRepository.deleteAll(entities);		
	}

	@Override
	public void deleteAll() {
		studentWriteRepository.deleteAll();		
	}

	

}
