package org.iths.anwar.webshopadmin.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Electronic extends Product {
    public Electronic() {
    }

    public Electronic(int articleNumber, String title, String description, double price) {
        super(articleNumber, title, description, price);
    }

    @Override
    public String category() {
        return "Electronic";
    }
}