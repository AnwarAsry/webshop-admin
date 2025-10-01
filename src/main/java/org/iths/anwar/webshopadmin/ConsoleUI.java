package org.iths.anwar.webshopadmin;

import org.iths.anwar.webshopadmin.models.UI;

import java.util.Scanner;

public class ConsoleUI implements UI {
    Scanner sc = new Scanner(System.in);

    @Override
    public String prompt(String message) {
        System.out.println(message);
        String input = sc.nextLine();
        // Checks if input is empty so it won't crash
        if (input == null) return "";
        return input;
    }

    @Override
    public void info(String message) {
        System.out.println(message);
    }

    @Override
    public String menu() {
        System.out.println("\n--- Webshop Administration ---");
        System.out.println("1. Add product");
        System.out.println("2. List all products");
        System.out.println("3. Show product details");
        System.out.println("4. Exit");
        System.out.print("Choose an option: ");
        return sc.nextLine();
    }
}