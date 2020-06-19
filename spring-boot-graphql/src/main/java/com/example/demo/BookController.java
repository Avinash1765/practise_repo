package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import graphql.ExecutionResult;

@RestController
@RequestMapping("/rest/books")
public class BookController {
	
	@Autowired
	private BookService service;

	@PostMapping
	public ResponseEntity<Object> getBooks(@RequestBody String query) {
		ExecutionResult result=service.getGraphQL().execute(query);
		return new ResponseEntity<Object>(result,HttpStatus.OK);
	}
}
