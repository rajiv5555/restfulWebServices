/**
 * 
 */
package com.restful.webservices.restfulWebServices.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author rajivranjan
 *
 */
@Entity(name="student")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private Integer id;
	
	@NotNull(message="name field should not be empty!!!")
	@Column(name="name")
	private String name;
	
	@NotNull(message=" address field should not be empty!!!")
	@Column(name="address")
	private String address;
	
	@NotNull(message=" school name field should not be empty!!!")
	@Column(name="school_name")
	private String schoolName;

	
}
