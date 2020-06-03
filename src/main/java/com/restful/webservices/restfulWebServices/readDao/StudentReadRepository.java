/**
 * 
 */
package com.restful.webservices.restfulWebServices.readDao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.restful.webservices.restfulWebServices.Model.Student;

/**
 * @author rajivranjan
 *
 */
@Transactional
public interface StudentReadRepository extends JpaRepository<Student,Integer>{
	
  public Optional<Student> findById(Integer id);

}
