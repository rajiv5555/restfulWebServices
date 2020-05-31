/**
 * 
 */
package com.restful.webservices.restfulWebServices.serviceImpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;

import com.restful.webservices.restfulWebServices.pojo.User;

/**
 * @author rajivranjan
 *
 */
@Component
public class UserDaoService {
	
	static List<User> users=new ArrayList<>();

	static {
		users.add(new User(1,"Jack",new Date()));
		users.add(new User(2,"Rao",new Date()));
		users.add(new User(3,"Mark",new Date()));
	}
	
	private Integer userIdcnt=3;
	
	public List<User> findAll(){
		return users;
	}
	
	public User save(User user) {
		if(null==user.getId()) {
			user.setId(++userIdcnt);
		}
		users.add(user);
		return user;
	}
	
	public User findOne(Integer id) {
		for(User u:users) {
			if(u.getId().equals(id)){
				return u;
			}
		}
		return null;
	}
	
	public User deleteBYId(Integer id) {
		Iterator<User> itr=users.iterator();
		while(itr.hasNext()) {
			User user=itr.next();
			if(user.getId()==id) {
				itr.remove();
				return user;
			}
		}
		return null;
	}
	
	
}
