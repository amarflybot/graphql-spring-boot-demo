package com.example.graphqlspringbootdemo.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.example.graphqlspringbootdemo.domain.Author;
import com.example.graphqlspringbootdemo.domain.Book;
import com.example.graphqlspringbootdemo.repository.AuthorRepository;
import com.example.graphqlspringbootdemo.repository.BookRepository;
import graphql.schema.DataFetchingEnvironment;
import org.springframework.stereotype.Component;


@Component
public class Query implements GraphQLQueryResolver {

    private BookRepository bookRepository;
    private AuthorRepository authorRepository;

    public Query(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    public Iterable<Book> findAllBooks(DataFetchingEnvironment dataFetchingEnvironment) {
        return bookRepository.findAll();
    }

    public Iterable<Author> findAllAuthors(DataFetchingEnvironment dataFetchingEnvironment) {
        return authorRepository.findAll();
    }

    public long countBooks(DataFetchingEnvironment dataFetchingEnvironment) {
        return bookRepository.count();
    }
    public long countAuthors(DataFetchingEnvironment dataFetchingEnvironment) {
        return authorRepository.count();
    }
}
