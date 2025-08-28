package org.example.entity;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.math.BigDecimal;

@Entity
@Table(name = "book")
@DiscriminatorValue(value = "B")
public class Book extends Product {

    private String author;

    public Book() {
    }

    public Book(String author, String name, BigDecimal price) {
        super(name, price);
        this.author = author;
    }
}
