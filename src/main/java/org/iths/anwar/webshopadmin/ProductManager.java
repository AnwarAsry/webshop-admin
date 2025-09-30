package org.iths.anwar.webshopadmin;

import org.iths.anwar.webshopadmin.models.Book;
import org.iths.anwar.webshopadmin.models.Clothing;
import org.iths.anwar.webshopadmin.models.Electronic;
import org.iths.anwar.webshopadmin.models.Product;

import java.util.List;

public class ProductManager {
    List<Product> products;
    private final UI ui;
    FileManagement fileMan = new FileManagement();

    public ProductManager(UI ui) {
        this.ui = ui;
    }

    public void run() {
        products = fileMan.getData();

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
        String message = "";

        for (Product p : products) {
            message += p.getArticleNumber() + ": " + p.getTitle() + "\n";
        }

        if (products.isEmpty()) {
            message = "No products exist";
        }

        ui.info("\n------ All Products ------\n" + message);
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
                String message = "Article number: " + p.getArticleNumber() + "\n"
                        + "Title: " + p.getTitle() + "\n"
                        + "Description: " + p.getDescription() + "\n"
                        + "Price: " + p.getPrice() + "\n"
                        + "Category: " + p.category();
                ui.info("\n------ Product details ------\n" + message);
                return;
            }
        }

        ui.info("No product found with article number " + articleNum);
    }
}
