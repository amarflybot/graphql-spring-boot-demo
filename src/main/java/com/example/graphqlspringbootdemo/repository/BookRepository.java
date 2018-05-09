package com.example.graphqlspringbootdemo.repository;

import com.example.graphqlspringbootdemo.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface BookRepository extends CrudRepository<Book, Long> {
}
