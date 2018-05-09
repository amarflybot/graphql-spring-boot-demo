package com.example.graphqlspringbootdemo.domain;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@NoArgsConstructor
@Data
public class Author {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private String firstName;

    private String lastName;

    public Author(Long id) {
        this.id = id;
    }

    public Author(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

}
