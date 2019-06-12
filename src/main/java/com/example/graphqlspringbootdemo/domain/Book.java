package com.example.graphqlspringbootdemo.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@NoArgsConstructor
@Data
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Book {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private String title;

    private String genre;

    private String publisher;

    private int pageCount;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "book")
    private List<Author> authors;

    public Book(final String title, final String genre, final String publisher, int pageCount) {
        this.title = title;
        this.genre = genre;
        this.publisher = publisher;
        this.pageCount = pageCount;
    }

}
