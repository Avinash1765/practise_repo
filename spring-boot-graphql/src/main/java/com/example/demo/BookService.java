package com.example.demo;

import java.io.File;
import java.io.IOException;
import java.util.stream.Stream;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import graphql.GraphQL;
import graphql.schema.GraphQLSchema;
import graphql.schema.idl.RuntimeWiring;
import graphql.schema.idl.SchemaGenerator;
import graphql.schema.idl.SchemaParser;
import graphql.schema.idl.TypeDefinitionRegistry;

@Service
public class BookService {
	
	@Autowired
	private BookRepository bookRepository;

	@Value("${classpath:books.graphql}")
	Resource resource;
	
	private GraphQL graphql;
	
	@Autowired
	private AllBooksDataFetcher allBooksDataFetcher;
	
	@Autowired
	private BookDataFetcher bookDataFetcher;
	
	@PostConstruct
	private void loadSchema() throws IOException {
		loaddataIntoHLSQL();
		
		File schemaFile= new ClassPathResource("books.graphql").getFile();
		
		TypeDefinitionRegistry registry=new SchemaParser().parse(schemaFile);
		
		RuntimeWiring runtimeWiring = buildRuntimeWiring();
		
		GraphQLSchema graphQLSchema=new SchemaGenerator().makeExecutableSchema(registry, runtimeWiring);
		
		graphql=GraphQL.newGraphQL(graphQLSchema).build();
		
	}

	private void loaddataIntoHLSQL() {

		Stream.of(
				new Book("123", "Book of clouds", "Kindle edition" , new String[] {
						"author1"
				},"NOv 2017")
				).forEach(obj -> {bookRepository.save(obj);});

		
	}

	private RuntimeWiring buildRuntimeWiring() {
		return RuntimeWiring.newRuntimeWiring()
				.type("Query", typeWiring -> typeWiring
						.dataFetcher("allBooks", allBooksDataFetcher)
						.dataFetcher("book", bookDataFetcher))
				.build();
	}
	
	public GraphQL getGraphQL() {
		return graphql;
	}
}
