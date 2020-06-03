/**
 * 
 */
package com.restful.webservices.restfulWebServices.writeDao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.restful.webservices.restfulWebServices.Model.Student;

/**
 * @author rajivranjan
 *
 */
public interface StudentWriteRepository extends JpaRepository<Student,Integer>{

}
