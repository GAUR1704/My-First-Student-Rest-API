package com.prowings.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_GATEWAY, reason = "Student not found")
public class StudentNotFoundException extends RuntimeException{

	private static final long serialVersionUID = 5038283722895842431L;

	public StudentNotFoundException(int id) {
		
		super("StudentNotFoundException with id = "+id);
	}
	
	

}
