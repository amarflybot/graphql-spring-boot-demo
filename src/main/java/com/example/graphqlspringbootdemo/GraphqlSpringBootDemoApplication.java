package com.example.graphqlspringbootdemo;

import com.example.graphqlspringbootdemo.domain.Author;
import com.example.graphqlspringbootdemo.domain.Book;
import com.example.graphqlspringbootdemo.repository.AuthorRepository;
import com.example.graphqlspringbootdemo.repository.BookRepository;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class GraphqlSpringBootDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(GraphqlSpringBootDemoApplication.class, args);
	}

	@Bean
	public ApplicationRunner demo(AuthorRepository authorRepository, BookRepository bookRepository) {
		return (args) -> {
			System.out.println("In Application Runner");
			Author author = new Author("Herbert", "Schildt");
			authorRepository.save(author);

			bookRepository.save(new Book("Java: A Beginner's Guide, Sixth Edition", "0071809252", 728, author));
		};
	}
}
