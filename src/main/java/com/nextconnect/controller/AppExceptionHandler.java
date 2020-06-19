package com.nextconnect.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class AppExceptionHandler {

	@ExceptionHandler({Exception.class})
	public ResponseEntity<Object> logAllExceptions(Exception e) {
			System.out.println(e.getMessage());
			return new ResponseEntity<>("Unexpected error occured", HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
