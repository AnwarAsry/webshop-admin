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
        if (cat == null || cat.isEmpty()) {
            ui.info("Action cancelled");
            return;
        }

        try {
            int articleNumber = Integer.parseInt(ui.prompt("Article number:"));
            String productName = ui.prompt("Product name:");
            String productDescription = ui.prompt("Product description:");
            double price = Double.parseDouble(ui.prompt("Price:"));

            Product p = switch (cat) {
                case "1" -> p = new Book(articleNumber, productName, productDescription, price);
                case "2" -> p = new Electronic(articleNumber, productName, productDescription, price);
                case "3" -> p = new Clothing(articleNumber, productName, productDescription, price);
                default -> null;
            };

            if (p == null) {
                ui.info("Invalid category, try again");
                return;
            }

            // Call the update file method return boolean
            boolean success = fileMan.addProductAndSave(p);
            ui.info((success ? "Product added: " : "Failed to add product: ") + p.getTitle());

        } catch (NumberFormatException e) {
            System.out.println("Could not convert the values");
            return;
        }
    }

    public void listProducts() {
        List<Product> products = fileMan.getProducts();
        StringBuilder message = new StringBuilder("\n------ All Products ------\n");

        if (products.isEmpty()) {
            message.append("No products exist");
            return;
        }

        for (Product p : products) {
            message.append(p.getArticleNumber()).append(": ").append(p.getTitle()).append("\n");
        }

        ui.info(message.toString());
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

        if (product == null) {
            ui.info("No product found with article number " + articleNum);
            return;
        }

        String message = """
                Article number: %d
                Title: %s
                Description: %s
                Price: %.2f
                Category: %s
                """.formatted(
                product.getArticleNumber(),
                product.getTitle(),
                product.getDescription(),
                product.getPrice(),
                product.category()
        );

        ui.info("\n------ Product details ------\n" + message);
    }
}
