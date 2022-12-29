package com.piseth.java.school.schoolManagement.exception;

import org.springframework.http.HttpStatus;
import lombok.Data;

@Data
public class BadRequestException extends ApiException{
	private static final long serialVersionUID = 1L;
	private String filed;
	   public BadRequestException(String filed) {
		   super(HttpStatus.BAD_REQUEST,String.format("%s is blank!",filed));
	   }
}
