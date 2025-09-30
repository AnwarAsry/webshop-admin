package org.iths.anwar.webshopadmin.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Book extends Product {
    public Book() {
    }

    public Book(int articleNumber, String title, String description, double price, String category) {
        super(articleNumber, title, description, price, category);
    }

    @Override
    public String category() {
        return "Book";
    }
}
