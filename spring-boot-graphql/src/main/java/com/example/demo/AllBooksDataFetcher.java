package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;

@Component
public class AllBooksDataFetcher implements DataFetcher<List<Book>>{
	
	@Autowired
	private BookRepository bookRepo;

	@Override
	public List<Book> get(DataFetchingEnvironment environment) {
		
		return bookRepo.findAll();
	}
	
}
