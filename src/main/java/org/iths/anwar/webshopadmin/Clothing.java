package org.iths.anwar.webshopadmin;

public class Clothing extends Product {
    public Clothing(int articleNumber, String title, String description, double price) {
        setArticleNumber(articleNumber);
        setTitle(title);
        setDescription(description);
        setPrice(price);
    }

    @Override
    public String category() {
        return "Clothing";
    }
}