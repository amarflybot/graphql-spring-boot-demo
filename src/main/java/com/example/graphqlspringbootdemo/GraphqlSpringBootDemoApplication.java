package com.example.graphqlspringbootdemo;

import com.example.graphqlspringbootdemo.domain.Author;
import com.example.graphqlspringbootdemo.domain.Book;
import com.example.graphqlspringbootdemo.repository.AuthorRepository;
import com.example.graphqlspringbootdemo.repository.BookRepository;
import com.github.javafaker.Faker;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class GraphqlSpringBootDemoApplication {

	public static void main(final String[] args) {
		SpringApplication.run(GraphqlSpringBootDemoApplication.class, args);
	}

/*	@Bean*/
	public ApplicationRunner demo(final AuthorRepository authorRepository, final BookRepository bookRepository) {
		return (args) -> {

			for (int i = 0; i < 1000; i++) {

				Faker faker = new Faker();

				com.github.javafaker.Book book1 = faker.book();

				final Book book = bookRepository.save(new Book(book1.title(), book1.genre(),
						book1.publisher(), faker.number().numberBetween(100, 1000)));
				final Author author = new Author(faker.name().firstName(), faker.name().lastName(), book);
				final Author author1 = new Author(faker.name().firstName(), faker.name().lastName(), book);
				final Author author2 = new Author(faker.name().firstName(), faker.name().lastName(), book);
				authorRepository.save(author);
				authorRepository.save(author1);
				authorRepository.save(author2);
			}
		};
	}
}
