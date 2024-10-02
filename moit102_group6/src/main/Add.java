package main;

import java.util.LinkedList;
import java.util.Scanner;

public class Add {

    // LinkedList to hold stock data (each entry is an array of strings)
    private LinkedList<String[]> inventoryList;

    // Constructor
    public Add() {
        this.inventoryList = new LinkedList<>();
        // Initialize inventory data directly in the constructor
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

    // Method to add new stock to the linked list
    public void addStock(String[] stockData) {
        inventoryList.add(stockData); // Use LinkedList's add() method
    }

    // Method to display all stocks in the inventory
    public void displayInventory() {
        System.out.printf("%-15s %-10s %-10s %-15s %-10s%n", "Date Entered", "Type", "Brand", "Engine Number", "Status");
        System.out.println("---------------------------------------------------------------");
        for (String[] stock : inventoryList) {
            System.out.printf("%-15s %-10s %-10s %-15s %-10s%n", stock[0], stock[1], stock[2], stock[3], stock[4]);
        }
    }

    public static void main(String[] args) {
        Add inventoryManager = new Add();

        // Display initial inventory
        System.out.println("Initial Inventory:");
        inventoryManager.displayInventory();

        // Adding new stock
        Scanner scan = new Scanner(System.in);
        System.out.println("\nAdd New Stock:");
        System.out.print("Enter Date (MM/DD/YYYY): ");
        String date = scan.nextLine();
        System.out.print("Enter Type: ");
        String type = scan.nextLine();
        System.out.print("Enter Brand: ");
        String brand = scan.nextLine();
        System.out.print("Enter Engine Number: ");
        String engineNumber = scan.nextLine();
        System.out.print("Enter Status: ");
        String status = scan.nextLine();

        // Creating a new stock entry
        String[] newStock = {date, type, brand, engineNumber, status};
        inventoryManager.addStock(newStock);

        // Display updated inventory
        System.out.println("\nUpdated Inventory:");
        inventoryManager.displayInventory();

        scan.close();
    }
}