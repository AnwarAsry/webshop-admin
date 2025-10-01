package org.iths.anwar.webshopadmin.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Book extends Product {
    public Book() {
    }

    public Book(int articleNumber, String title, String description, double price) {
        super(articleNumber, title, description, price, "Book");
    }

    @Override
    public String category() {
        return "Book";
    }
}
