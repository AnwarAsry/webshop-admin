package org.iths.anwar.webshopadmin;

public class Electronic extends Product {
    public Electronic(int articleNumber, String title, String description, double price) {
        setArticleNumber(articleNumber);
        setTitle(title);
        setDescription(description);
        setPrice(price);
    }

    @Override
    public String category() {
        return "Electronic";
    }
}