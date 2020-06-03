/**
 * 
 */
package com.restful.webservices.restfulWebServices.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.restful.webservices.restfulWebServices.exception.UserNotFoundException;
import com.restful.webservices.restfulWebServices.pojo.User;
import com.restful.webservices.restfulWebServices.serviceImpl.UserDaoService;

import lombok.extern.log4j.Log4j2;

/**
 * @author rajivranjan
 *
 */
@RestController
@Log4j2
public class UserResource {
	
	@Autowired
	private UserDaoService userDaoService;
	
	//@RequestMapping(method=RequestMethod.GET,path="/hello")
	@GetMapping(path="/users")
	public List<User> getAllUser(){
		log.info(" inside get user method ");
		log.error(" inside get all user method");
		log.debug("This is a debug message");
		log.warn("This is a warn message");
		//log.fatal("This is a fatal message");

		return userDaoService.findAll();
	}
	
	// this method is commented because we have decrease version of spring because of hateous and swagger incompatiblity.
	/*@GetMapping(path="/users/{id}")
	public Entitymodel<User> findById(@PathVariable Integer id) {
		User us= userDaoService.findOne(id);
		if(us==null)
			throw new UserNotFoundException("id- "+id);
		//Hypermedia as the engine of Application state
		//HATEOUS concept here
		EntityModel<User> model=new EntityModel<>(us);
		WebMvcLinkBuilder linkTo=WebMvcLinkBuilder.linkTo(ControllerLinkBuilder.methodOn(this.getClass()).getAllUser());
		model.add(linkTo.withRel("all-users"));
		return model;
	}*/
	
	@GetMapping(path="/users/{id}")
	public User findById(@PathVariable Integer id) {
		User us= userDaoService.findOne(id);
		if(us==null)
			throw new UserNotFoundException("user not found id- "+id);
		//Hypermedia as the engine of Application state
		//HATEOUS concept here
		//Resource<User> resource = new Resource<User>(us);
		//ControllerLinkBuilder linkTo = ControllerLinkBuilder.linkTo(ControllerLinkBuilder.methodOn(this.getClass()).getAllUser());
		//resource.add(linkTo.withRel("all-users"));
		return us;
	}
	
	@PostMapping(path="/users")
	public ResponseEntity<Object> addUser(/*@Valid*/ @RequestBody User user) {
		 User saveduser=userDaoService.save(user);
		 URI location=ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(saveduser.getId()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	@DeleteMapping(path="/user/{id}")
	public void deleteUser(@PathVariable Integer id) {
		User user=userDaoService.deleteBYId(id);
		if(user==null) {
			throw new UserNotFoundException("id- "+id);
		}
	}
}
