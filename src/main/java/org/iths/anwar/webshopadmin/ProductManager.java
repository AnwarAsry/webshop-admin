package org.iths.anwar.webshopadmin;

import org.iths.anwar.webshopadmin.models.Book;
import org.iths.anwar.webshopadmin.models.Clothing;
import org.iths.anwar.webshopadmin.models.Electronic;
import org.iths.anwar.webshopadmin.models.Product;

import java.util.List;

public class ProductManager {
    private final UI ui;
    FileManagement fileMan = new FileManagement();

    public ProductManager(UI ui) {
        this.ui = ui;
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

        int articleNumber;
        String productName;
        String productDescription;
        double price;
        try {
            articleNumber = Integer.parseInt(ui.prompt("Article number:"));
            productName = ui.prompt("Product name:");
            productDescription = ui.prompt("Product description:");
            price = Double.parseDouble(ui.prompt("Price:"));
        } catch (NumberFormatException e) {
            System.out.println("Could not convert the values");
            return;
        }

        Product p = null;
        switch (cat) {
            case "1" -> p = new Book(articleNumber, productName, productDescription, price, "Book");
            case "2" -> p = new Electronic(articleNumber, productName, productDescription, price, "Electronic");
            case "3" -> p = new Clothing(articleNumber, productName, productDescription, price, "Clothing");
            default -> ui.info("Invalid category");
        }

        if (p != null) {
            // Call the update file method return boolean
            boolean success = fileMan.updateFile(p);
            if (success) {
                ui.info("Product added: " + p.getTitle());
            } else {
                ui.info("Failed to add product: " + p.getTitle());
            }
        }
    }

    public void listProducts() {
        List<Product> products = fileMan.getProducts();
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
        int articleNum;
        try {
            articleNum = Integer.parseInt(ui.prompt("Enter product article number:"));
        } catch (NumberFormatException e) {
            ui.info("Invalid number entered");
            return;
        }

        Product product = fileMan.getProductByArticleNum(articleNum);

        if (product != null) {
            String message = "Article number: " + product.getArticleNumber() + "\n"
                    + "Title: " + product.getTitle() + "\n"
                    + "Description: " + product.getDescription() + "\n"
                    + "Price: " + product.getPrice() + "\n"
                    + "Category: " + product.category();

            ui.info("\n------ Product details ------\n" + message);
            return;
        }

        ui.info("No product found with article number " + articleNum);
    }
}
