package org.iths.anwar.webshopadmin;

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
    ObjectMapper mapper = new ObjectMapper();

    // Fetches the data (Products)
    public List<Product> getData() {
        List<Product> products = new ArrayList<>();
        try {
            // If file exist, read values and then return the data
            if (checkFileExist()) {
                products = mapper.readValue(dataFile, new TypeReference<List<Product>>() {
                });
                System.out.printf("Loaded %s products.", products.size());
                return products;
            }
            // Creates file if not exist
            createFile();
        } catch (IOException e) {
            System.out.println("Could not read file: " + e.getMessage());
        }
        return products;
    }

    // Updates file with new data
    public void updateFile() {

    }

    public boolean checkFileExist() {
        return dataFile.exists() && dataFile.toPath().getParent() != null;
    }

    public void createFile() {
        try {
            // If there is no file or directory
            System.out.println("Trying to create data file");
            Files.createDirectories(dataFile.toPath().getParent());
            // this is because when file is empty and the program tries to
            // readValues on 21 it will fail and call the catch
            List<Product> emptyList = new ArrayList<>();
            mapper.writeValue(dataFile, emptyList);
        } catch (IOException e) {
            System.out.println("Could not create file: " + e.getMessage());
        }
    }
}
