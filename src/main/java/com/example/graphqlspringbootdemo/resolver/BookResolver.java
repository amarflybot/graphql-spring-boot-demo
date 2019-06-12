package com.example.graphqlspringbootdemo.resolver;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.example.graphqlspringbootdemo.domain.Author;
import com.example.graphqlspringbootdemo.domain.Book;
import com.example.graphqlspringbootdemo.repository.AuthorRepository;
import graphql.schema.DataFetchingEnvironment;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookResolver implements GraphQLResolver<Book> {

    private final AuthorRepository authorRepository;

    public BookResolver(final AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public List<Author> getAuthors(Book book, DataFetchingEnvironment dataFetchingEnvironment) {
        List<Author> authorsByBook = this.authorRepository.findAuthorsByBook(book);
        return authorsByBook;
    }
}
