package main;

import java.util.LinkedList;
import java.util.Scanner;

public class Delete {

    // LinkedList to store the inventory data
    private LinkedList<String[]> inventoryList;

    // Constructor
    public Delete() {
        this.inventoryList = new LinkedList<>();
        // Adding initial inventory directly to the linked list
        initializeInventory();
    }

    // Method to initialize the inventory with initial data
    private void initializeInventory() {
        String[][] initialInventory = {
            {"2/1/2023", "Old", "Honda", "142QVTSIUR", "On-hand"},
            {"2/1/2023", "Old", "Honda", "PZCT1S00XE", "Sold"},
            {"2/1/2023", "Old", "Honda", "4VBTV8YNM7", "Sold"},
            {"2/1/2023", "Old", "Honda", "95AN3AWVF4", "On-hand"},
            {"2/3/2023", "Old", "Kawasaki", "483QHIM661", "On-hand"},
            {"2/3/2023", "Old", "Kymco", "SPHA17SSEE", "On-hand"},
            {"2/3/2023", "Old", "Kymco", "0AV7SWGX93", "Sold"},
            {"2/4/2023", "Old", "Kymco", "QMUB6UYLKL", "Sold"},
            {"2/4/2023", "Old", "Honda", "V96GMTFFEI", "Sold"},
            {"2/5/2023", "Old", "Kawasaki", "4J8UA0FMVY", "Sold"},
            {"2/5/2023", "Old", "Kawasaki", "A8BDL926FA", "Sold"},
            {"2/5/2023", "Old", "Kawasaki", "X8G5ZZ7A69", "Sold"}
        };

        // Adding each initial stock to the LinkedList
        for (String[] stock : initialInventory) {
            inventoryList.add(stock);
        }
    }

    // Method to delete a stock by engine number
    public void deleteStock(String engineNumber) {
        boolean found = false;
        for (int i = 0; i < inventoryList.size(); i++) {
            String[] stockData = inventoryList.get(i);
            if (stockData[3].equals(engineNumber)) { // Check if engine number matches
                inventoryList.remove(i); // Remove the stock from LinkedList
                System.out.println("Stock with engine number " + engineNumber + " deleted.");
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Stock with engine number " + engineNumber + " not found.");
        }
    }

    // Method to display all stocks in the inventory
    public void displayInventory() {
        System.out.printf("%-15s %-10s %-10s %-15s %-10s%n", "Date Entered", "Type", "Brand", "Engine Number", "Status");
        System.out.println("---------------------------------------------------------------");
        for (String[] stockData : inventoryList) {
            System.out.printf("%-15s %-10s %-10s %-15s %-10s%n",
                stockData[0],
                stockData[1],
                stockData[2],
                stockData[3],
                stockData[4]);
        }
    }

    public static void main(String[] args) {
        Delete inventoryManager = new Delete();

        // Display initial inventory
        System.out.println("Initial Inventory:");
        inventoryManager.displayInventory();

        // Deleting a stock
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nEnter Engine Number to Delete: ");
        String engineNumberToDelete = scanner.nextLine();

        // Delete the stock by engine number
        inventoryManager.deleteStock(engineNumberToDelete);

        // Display updated inventory
        System.out.println("\nUpdated Inventory:");
        inventoryManager.displayInventory();

        scanner.close();
    }
}