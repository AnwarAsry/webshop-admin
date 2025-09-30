package org.iths.anwar.webshopadmin;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.iths.anwar.webshopadmin.models.Product;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private static final File dataFile = new File("data/products.json");

    public static void main(String[] args) {
        ObjectMapper mapper = new ObjectMapper();
        List<Product> products = new ArrayList<>();

        // load products
        if (dataFile.exists()) {
            try {
                products = mapper.readValue(dataFile, new TypeReference<List<Product>>() {
                });
                System.out.println("Loaded " + products.size() + " products.");
            } catch (IOException e) {
                System.out.println("Could not load products: " + e.getMessage());
            }
        }

        UI ui = new ConsoleUI();
        //UI ui = new JOptionPaneUI();
        ProductManager manager = new ProductManager(ui, products);

        manager.run();
    }
}
