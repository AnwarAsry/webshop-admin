package org.iths.anwar.webshopadmin;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileManagement {
    private final Path dataFile = new File("data/products.json").toPath();


    public File getDataFile() {
        if (Files.notExists(dataFile)) {
            try {
                Files.createFile(dataFile);
                return dataFile.toFile();
            } catch (IOException e) {
                System.out.println("Could not load products: " + e.getMessage());
            }
        }
        return dataFile.toFile();
    }

    public void updateFile() {
    }
}
