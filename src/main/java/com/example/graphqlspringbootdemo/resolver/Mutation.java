package com.example.graphqlspringbootdemo.resolver;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.example.graphqlspringbootdemo.domain.Author;
import com.example.graphqlspringbootdemo.domain.Book;
import com.example.graphqlspringbootdemo.exception.BookNotFoundException;
import com.example.graphqlspringbootdemo.repository.AuthorRepository;
import com.example.graphqlspringbootdemo.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Optional;

@Service
public class Mutation implements GraphQLMutationResolver {

    private BookRepository bookRepository;
    private AuthorRepository authorRepository;

    public Mutation(final AuthorRepository authorRepository, final BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    public Author newAuthor(final String firstName, final String lastName) {
        final Author author = new Author();
        author.setFirstName(firstName);
        author.setLastName(lastName);

        authorRepository.save(author);

        return author;
    }

    public Book newBook(final String title, final String isbn, final Integer pageCount, final Long authorId) {
        final Book book = new Book();
        Optional<Author> byId = authorRepository.findById(authorId);
        book.setAuthors(Arrays.asList(byId.get()));
        book.setTitle(title);
        book.setGenre(isbn);
        book.setPageCount(pageCount != null ? pageCount : 0);

        bookRepository.save(book);

        return book;
    }

    public boolean deleteBook(final Long id) {
        bookRepository.deleteById(id);
        return true;
    }

    public Book updateBookPageCount(final Integer pageCount, final Long id) {
        final Book book = bookRepository.findById(id).get();
        if(book == null) {
            throw new BookNotFoundException("The book to be updated was not found", id);
        }
        book.setPageCount(pageCount);

        bookRepository.save(book);

        return book;
    }
}
