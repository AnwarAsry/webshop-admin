package org.iths.anwar.webshopadmin.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.EXISTING_PROPERTY,
        property = "category",
        visible = true
)
@JsonSubTypes({
        @JsonSubTypes.Type(value = Book.class, name = "Book"),
        @JsonSubTypes.Type(value = Electronic.class, name = "Electronic"),
        @JsonSubTypes.Type(value = Clothing.class, name = "Clothing")
})
public abstract class Product {
    @JsonProperty("article_number")
    private int articleNumber;
    private String title;
    private String description;
    private double price;
    private String category;

    public Product() {
    }

    public Product(int articleNumber, String title, String description, double price, String category) {
        this.articleNumber = articleNumber;
        this.title = title;
        this.description = description;
        this.price = price;
        this.category = category;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    // Every subclass must have method
    public abstract String category();

    public int getArticleNumber() {
        return articleNumber;
    }

    public void setArticleNumber(int articleNumber) {
        this.articleNumber = articleNumber;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}