package org.iths.anwar.webshopadmin;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Product> products = new ArrayList<>();

        Product p1 = new Book(
                34629,
                "Ready player one",
                "Novel by Ernest Cline, about a dystopian future where people escape reality by living in a vast virtual world called the OASIS.",
                11.99
        );
        Product p2 = new Electronic(
                12938,
                "Apple Macbook Pro 14",
                "A powerful, compact laptop designed for professionals, featuring the M4 chip for enhanced performance and Apple Intelligence features.",
                2099
        );
        Product p3 = new Clothing(
                69302,
                "Round Ultra Mini Bag",
                "Compact size handily holds your smartphone and wallet.",
                13.99
        );

        products.add(p1);
        products.add(p2);
        products.add(p3);

        while (true) {
            System.out.println("\n--- Webshop Administration ---");
            System.out.println("1. Add product");
            System.out.println("2. List all products");
            System.out.println("3. Show product details");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");

            int choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1 -> {
                    System.out.println("Choose category (1=Book, 2=Electronic, 3=Clothing)");
                    int category = Integer.parseInt(sc.nextLine());

                    System.out.print("Article number: ");
                    int articleNumber = Integer.parseInt(sc.nextLine());

                    System.out.print("Product name: ");
                    String productName = sc.nextLine();

                    System.out.println("Product description: ");
                    String productDescription = sc.nextLine();

                    System.out.print("Price: ");
                    double price = Double.parseDouble(sc.nextLine());

                    Product p = null;
                    if (category == 1) {
                        p = new Book(articleNumber, productName, productDescription, price);
                    } else if (category == 2) {
                        p = new Electronic(articleNumber, productName, productDescription, price);
                    } else if (category == 3) {
                        p = new Clothing(articleNumber, productName, productDescription, price);
                    } else {
                        System.out.println("Invalid category");
                    }

                    if (p != null) {
                        products.add(p);
                        System.out.println("Product added: " + p.getTitle());
                    }
                }
                case 2 -> products.forEach(p -> System.out.println(
                        p.getArticleNumber() + ": " + p.getTitle() + " (" + p.category() + ") " + p.getPrice()));
                case 3 -> {
                    System.out.print("Enter article number: ");
                    int articleNumber = Integer.parseInt(sc.nextLine());

                    boolean found = false;
                    for (Product p : products) {
                        if (p.getArticleNumber() == articleNumber) {
                            System.out.println("\n--- Product details ---");
                            System.out.println("Article number: " + p.getArticleNumber());
                            System.out.println("Title: " + p.getTitle());
                            System.out.println("Description: " + p.getDescription());
                            System.out.println("Price: " + p.getPrice() + " $");
                            System.out.println("Category: " + p.category());
                            found = true;
                        }
                    }

                    if (!found) {
                        System.out.println("No product found with article number " + articleNumber);
                    }
                }
                case 4 -> {
                    System.out.println("Exiting...");
                    return;
                }
                default -> System.out.println("Invalid choice, try again");
            }
        }
    }
}
