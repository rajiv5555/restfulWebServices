/**
 * 
 */
package com.restful.webservices.restfulWebServices.writeRepository;

import org.springframework.data.repository.CrudRepository;

import com.restful.webservices.restfulWebServices.Model.Student;

/**
 * @author rajivranjan
 *
 */
public interface StudentWriteRepository extends CrudRepository<Student,Integer>{

}
