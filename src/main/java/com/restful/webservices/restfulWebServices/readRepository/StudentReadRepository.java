/**
 * 
 */
package com.restful.webservices.restfulWebServices.readRepository;

import org.springframework.data.repository.CrudRepository;

import com.restful.webservices.restfulWebServices.Model.Student;

/**
 * @author rajivranjan
 *
 */
public interface StudentReadRepository extends CrudRepository<Student,Integer>{

}
