package com.example.graphqlspringbootdemo.resolver;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.example.graphqlspringbootdemo.domain.Author;
import com.example.graphqlspringbootdemo.domain.Book;
import com.example.graphqlspringbootdemo.exception.BookNotFoundException;
import com.example.graphqlspringbootdemo.repository.AuthorRepository;
import com.example.graphqlspringbootdemo.repository.BookRepository;
import org.springframework.stereotype.Component;

@Component
public class Mutation implements GraphQLMutationResolver {

    private BookRepository bookRepository;
    private AuthorRepository authorRepository;

    public Mutation(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    public Author newAuthor(String firstName, String lastName) {
        Author author = new Author();
        author.setFirstName(firstName);
        author.setLastName(lastName);

        authorRepository.save(author);

        return author;
    }

    public Book newBook(String title, String isbn, Integer pageCount, Long authorId) {
        Book book = new Book();
        book.setAuthor(new Author(authorId));
        book.setTitle(title);
        book.setIsbn(isbn);
        book.setPageCount(pageCount != null ? pageCount : 0);

        bookRepository.save(book);

        return book;
    }

    public boolean deleteBook(Long id) {
        bookRepository.deleteById(id);
        return true;
    }

    public Book updateBookPageCount(Integer pageCount, Long id) {
        Book book = bookRepository.findById(id).get();
        if(book == null) {
            throw new BookNotFoundException("The book to be updated was not found", id);
        }
        book.setPageCount(pageCount);

        bookRepository.save(book);

        return book;
    }
}
