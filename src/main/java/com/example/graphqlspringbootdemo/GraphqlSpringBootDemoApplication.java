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

			Author author1 = new Author("Amarendra", "Kumar");
			authorRepository.save(author1);

			bookRepository.save(new Book("Book Name1", "0071809233", 723, author1));

			Author author2 = new Author("Aditya", "Rane");
			authorRepository.save(author2);

			bookRepository.save(new Book("Book Name2", "0071809234", 713, author2));

			Author author3 = new Author("Arun", "Subhash");
			authorRepository.save(author3);

			bookRepository.save(new Book("Book Name3", "0071809211", 13, author3));

			Author author4 = new Author("Vaibhavi", "Gondil");
			authorRepository.save(author4);

			bookRepository.save(new Book("Book Name4", "0071809201", 1013, author4));
		};
	}
}
