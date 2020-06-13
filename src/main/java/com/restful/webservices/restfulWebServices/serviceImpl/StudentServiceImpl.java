/**
 * 
 */
package com.restful.webservices.restfulWebServices.serviceImpl;

import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

import org.reactivestreams.Publisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restful.webservices.restfulWebServices.Dao.StudentDoa;
import com.restful.webservices.restfulWebServices.Model.Student;
import com.restful.webservices.restfulWebServices.service.StudentService;

import io.leangen.graphql.annotations.GraphQLArgument;
import io.leangen.graphql.annotations.GraphQLInputField;
import io.leangen.graphql.annotations.GraphQLMutation;
import io.leangen.graphql.annotations.GraphQLQuery;
import io.leangen.graphql.annotations.GraphQLSubscription;
import io.leangen.graphql.spqr.spring.annotations.GraphQLApi;
import reactor.core.publisher.Flux;
import reactor.core.publisher.FluxSink;

/**
 * @author rajivranjan
 *
 */
@Service
@GraphQLApi
public class StudentServiceImpl implements StudentService {
	
   @Autowired
   private StudentDoa studentdao;
   private ConcurrentHashMap<Integer, FluxSink<Student>> subscribers = new ConcurrentHashMap<>();

	
   @GraphQLQuery
	@Override
	public Iterable<Student> getAllStudet() {
		return studentdao.findAll();
	}
	
   @GraphQLQuery
	@Override
	public Student getStudent(@GraphQLArgument(name = "id") Integer id) {
		Optional<Student> stud= studentdao.findById(id);
		return stud.orElse(null);
	}

	@Override
	public void saveStudent(Student student) {
      studentdao.save(student);		
	}

	@GraphQLMutation
	@Override
	public Student updateStudent(@GraphQLInputField(name="student") Student student) {
     saveStudent(student);
     // for subscription
     if(subscribers.get(student.getId())!=null) {
    	 subscribers.get(student.getId()).next(student);
     }
     return student;

	}

	@Override
	public Integer deleteObj(Student stud) {
		 studentdao.delete(stud);
		 return stud.getId();
	}
	
	@GraphQLSubscription
	public Publisher<Student> OnUpdateStudent(@GraphQLArgument(name="studentId") Integer studentId) {
        return Flux.create(subscriber-> subscribers.put(studentId,subscriber.onDispose(()->subscribers.remove(studentId,subscriber))), FluxSink.OverflowStrategy.LATEST);
	}

}
