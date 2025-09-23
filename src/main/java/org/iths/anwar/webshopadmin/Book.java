package org.iths.anwar.webshopadmin;

public class Book extends Product {
    public Book(int articleNumber, String title, String description, double price) {
        setArticleNumber(articleNumber);
        setTitle(title);
        setDescription(description);
        setPrice(price);
    }

    @Override
    public String category() {
        return "Book";
    }
}
