/**
 * 
 */
package com.restful.webservices.restfulWebServices.pojo;

import java.util.Date;

import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import lombok.Data;




/**
 * @author rajivranjan
 *
 */
@Data
public class User {

	private Integer id;
	
	@Size(min=2,message="Name field should be atleast 2 char")
	private String name;

	@Past
	private Date birthDate;
	
	public User(){
		
	}
	
	public User(int id, String name, Date date) {
     this.id=id;
     this.name=name;
     this.birthDate=date;
	}
	
}
