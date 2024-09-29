package db;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Db {
    private String[][] data;

    public Db(String filePath) {
        readCsv(filePath);
    }

    private void readCsv(String filePath) {
        String line;
        String splitBy = ",";
        int rowCount = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            // Skip the first row (header)
            br.readLine();

            // Count rows
            while ((line = br.readLine()) != null) {
                rowCount++;
            }

            // Initialize the data array
            data = new String[rowCount][5]; // 5 columns based on the categories

            // Create a new BufferedReader to read the file again
            try (BufferedReader br2 = new BufferedReader(new FileReader(filePath))) {
                br2.readLine(); // Skip the header again

                int currentRow = 0;
                while ((line = br2.readLine()) != null) {
                    String[] row = line.split(splitBy);
                    
                    // Ensure the row has at least 5 columns
                    if (row.length >= 5) {
                        data[currentRow][0] = row[0]; // Date Entered
                        data[currentRow][1] = row[1]; // Stock Label
                        data[currentRow][2] = row[2]; // Brand
                        data[currentRow][3] = row[3]; // Engine Number
                        data[currentRow][4] = row[4]; // Status
                        currentRow++;
                    } else {
                        // Handle the case where the row does not have enough columns
                        System.err.println("Warning: Skipping row " + (currentRow + 1) + " due to insufficient columns.");
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String[][] getData() {
        return data;
    }
}
