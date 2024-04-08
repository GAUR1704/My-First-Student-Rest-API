package com.prowings.exception;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.prowings.model.MyCustomError;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(SQLException.class)
	public ResponseEntity<String> handleSQLException(HttpServletRequest request, Exception ex){
		System.out.println("inside SQLEx handler method");
		return new ResponseEntity<String>("database_error", HttpStatus.INTERNAL_SERVER_ERROR);
	}
	

	@ExceptionHandler(InvalidStudentException.class)
	public ResponseEntity<MyCustomError> handleInvalidStudentException(HttpServletRequest request, Exception ex) {

		System.out.println("Inside handleInvalidStudentException handler method");

		MyCustomError error = new MyCustomError();

		error.setMassage(ex.getMessage());
		error.setRootCause("abc");
		error.setStatus(400);
		return new ResponseEntity<MyCustomError>(error, HttpStatus.BAD_REQUEST);

	}

	@ExceptionHandler(StudentNotFoundException.class)
	public ResponseEntity<MyCustomError> handleStudentNotFoundException(HttpServletRequest request, Exception ex) {

		System.out.println("inside StudentNotFoundException handler method");
		MyCustomError error = new MyCustomError();

		error.setMassage(ex.getMessage());
		error.setRootCause("abc");
		error.setStatus(404);
		;

		return new ResponseEntity<MyCustomError>(error, HttpStatus.NOT_FOUND);

	}

}
