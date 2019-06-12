package com.example.graphqlspringbootdemo.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.example.graphqlspringbootdemo.domain.Author;
import com.example.graphqlspringbootdemo.domain.Book;
import com.example.graphqlspringbootdemo.repository.AuthorRepository;
import com.example.graphqlspringbootdemo.repository.BookRepository;
import graphql.schema.DataFetchingEnvironment;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;


@Service
public class Query implements GraphQLQueryResolver {

    private BookRepository bookRepository;
    private AuthorRepository authorRepository;

    public Query(final AuthorRepository authorRepository, final BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    public Iterable<Book> findAllBooks() {
        return bookRepository.findAll();
    }

    public Iterable<Book> findBookById(final Long id) {
        return Arrays.asList(bookRepository.findById(id).get());
    }

    public Iterable<Author> findAllAuthors() {
        return authorRepository.findAll();
    }

    public Iterable<Author> findAuthorById(final Long id) {
        return Arrays.asList(authorRepository.findById(id).get());

    }

    public long countBooks(final DataFetchingEnvironment dataFetchingEnvironment) {
        return bookRepository.count();
    }

    public long countAuthors(final DataFetchingEnvironment dataFetchingEnvironment) {
        return authorRepository.count();
    }
}
