package org.iths.anwar.webshopadmin.controller;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.iths.anwar.webshopadmin.models.Product;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

public class FileManagement {
    private final File dataFile = new File("data/products.json");
    private final ObjectMapper mapper = new ObjectMapper();

    // Get all Products
    public List<Product> getProducts() {
        return getData();
    }

    // Find product by article number
    public Product getProductByArticleNum(int articleNumber) {
        List<Product> products = getData();
        return products.stream().filter(product -> product.getArticleNumber() == articleNumber).findFirst().orElse(null);
    }

    // Add product and save file
    public boolean addProductAndSave(Product product) {
        try {
            List<Product> products = getData();
            // Prevent duplicates
            boolean exists = products.stream()
                    .anyMatch(p -> p.getArticleNumber() == product.getArticleNumber());
            if (exists) {
                return false;
            }

            products.add(product);
            mapper.writeValue(dataFile, products);
            return true;
        } catch (IOException e) {
            System.err.println("Error while updating file: " + e.getMessage());
            return false;
        }
    }

    // Read all products from file
    public List<Product> getData() {
        try {
            // If file exist, read values and then return the data
            if (checkFileExist()) {
                return mapper.readValue(dataFile, new TypeReference<List<Product>>() {
                });
            }
            // Creates file if not exist
            createFile();
        } catch (IOException e) {
            System.out.println("Could not read file: " + e.getMessage());
        }
        return new ArrayList<>();
    }

    public boolean checkFileExist() {
        return dataFile.exists() && dataFile.toPath().getParent() != null;
    }

    // Create empty file with empty list
    public void createFile() {
        try {
            // If there is no file or directory
            System.out.println("Trying to create data file");
            Files.createDirectories(dataFile.toPath().getParent());
            // this is because when file is empty and the program tries to
            // readValues on 53 it will fail and call the catch
            mapper.writeValue(dataFile, new ArrayList<Product>());
        } catch (IOException e) {
            System.out.println("Could not create file: " + e.getMessage());
        }
    }
}
