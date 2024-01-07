package org.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class ClearCsvFile {
    public static void clearCsvFile(String filePath) {
        try {
            // Open the file in write mode and truncate its content
            Files.newBufferedWriter(Path.of(filePath), StandardOpenOption.WRITE, StandardOpenOption.TRUNCATE_EXISTING);
            System.out.println("CSV file cleared: " + filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
