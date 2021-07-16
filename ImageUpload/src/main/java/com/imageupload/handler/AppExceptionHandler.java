package com.imageupload.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class AppExceptionHandler {
	
	@ExceptionHandler(Exception.class)
	   public ResponseEntity<Object> exception(Exception exception) {
		System.out.println("err msg is "+exception.getMessage());
	      return new ResponseEntity<>("Product not found", HttpStatus.NOT_FOUND);
	   } 
}
