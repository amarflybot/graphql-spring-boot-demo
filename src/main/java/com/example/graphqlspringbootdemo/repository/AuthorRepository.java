package com.example.graphqlspringbootdemo.repository;

import com.example.graphqlspringbootdemo.domain.Author;
import com.example.graphqlspringbootdemo.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource
public interface AuthorRepository extends JpaRepository<Author, Long> {

    List<Author> findAuthorsByBook(Book book);
}
