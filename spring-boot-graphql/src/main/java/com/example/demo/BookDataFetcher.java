package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;


@Component
public class BookDataFetcher implements DataFetcher<Book>{
	
	@Autowired
	private BookRepository bookRepo;

	@Override
	public Book get(DataFetchingEnvironment environment) {
		String isn=environment.getArgument("id");
		return bookRepo.getOne(isn);
	}

}
