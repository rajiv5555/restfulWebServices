/**
 * 
 */
package com.restful.webservices.restfulWebServices.exception;

import java.util.Date;

import lombok.Getter;

/**
 * @author rajivranjan
 *
 */
@Getter
public class ExceptionResponse {
private Date timestamp;
private String message;
private String detail;

public ExceptionResponse(Date timestamp, String message, String detail) {
	super();
	this.timestamp = timestamp;
	this.message = message;
	this.detail = detail;
}

}
