package org.iths.anwar.webshopadmin;

import java.util.ArrayList;
import java.util.List;

public class ProductManager {
    List<Product> products = new ArrayList<Product>();
    private final UI ui;

    public ProductManager(UI ui, List<Product> products) {
        this.ui = ui;
        this.products = products;
    }

    public void run() {
        while (true) {
            String choice = ui.menu();

            switch (choice) {
                case "1" -> addProduct();
                case "2" -> listProducts();
                case "3" -> showProductDetails();
                case "4" -> {
                    ui.info("Exiting program...");
                    return;
                }
                default -> ui.info("Invalid choice, try again");
            }
        }
    }

    public void addProduct() {
        String cat = ui.prompt("Choose category (1=Book, 2=Electronic, 3=Clothing)");
        // User pressed cancel/enter without input
        if (cat.isEmpty()) {
            ui.info("Action cancelled");
            return;
        }

        int articleNumber = Integer.parseInt(ui.prompt("Article number:"));
        String productName = ui.prompt("Product name:");
        String productDescription = ui.prompt("Product description:");
        double price = Double.parseDouble(ui.prompt("Price:"));

        Product p = null;
        switch (cat) {
            case "1" -> p = new Book(articleNumber, productName, productDescription, price);
            case "2" -> p = new Electronic(articleNumber, productName, productDescription, price);
            case "3" -> p = new Clothing(articleNumber, productName, productDescription, price);
            default -> ui.info("Invalid category");
        }

        if (p != null) {
            products.add(p);
            ui.info("Product added: " + p.getTitle());
        }
    }

    public void listProducts() {
        ui.info("\n------ All Products ------");
        for (Product p : products) {
            ui.info(p.getArticleNumber() + ": " + p.getTitle());
        }
    }

    public void showProductDetails() {
        String input = ui.prompt("Enter product article number:");
        if (input.isEmpty()) {
            ui.info("Action cancelled");
            return;
        }

        int articleNum;
        try {
            articleNum = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            ui.info("Invalid number entered");
            return;
        }

        for (Product p : products) {
            if (p.getArticleNumber() == articleNum) {
                ui.info("\n------ Product details ------");
                ui.info("Article number: " + p.getArticleNumber());
                ui.info("Title: " + p.getTitle());
                ui.info("Description: " + p.getDescription());
                ui.info("Price: " + p.getPrice() + " $");
                ui.info("Category: " + p.category());
                return;
            }
        }

        ui.info("No product found with article number " + articleNum);
    }
}
