package com.example.graphqlspringbootdemo.resolver;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.example.graphqlspringbootdemo.domain.Author;
import com.example.graphqlspringbootdemo.domain.Book;
import com.example.graphqlspringbootdemo.repository.AuthorRepository;
import graphql.schema.DataFetchingEnvironment;
import org.springframework.stereotype.Component;

@Component
public class BookResolver implements GraphQLResolver<Book> {

    private AuthorRepository authorRepository;

    public BookResolver(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public Author getAuthor(Book book, DataFetchingEnvironment dataFetchingEnvironment) {
        return authorRepository.findById(book.getAuthor().getId()).get();
    }
}
