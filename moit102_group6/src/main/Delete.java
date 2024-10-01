package main;

import java.util.Scanner;

public class Delete {

	// Node class to represent each stock item in the linked list
    private static class Node {
        String[] stockData; // Array to hold stock data
        Node next; // Pointer to the next node

        Node(String[] stockData) {
            this.stockData = stockData;
            this.next = null;
        }
    }

    // Head of the linked list
    private Node head;

    // Constructor
    public Delete() {
        this.head = null;
    }

    // Method to add new stock to the linked list
    public void addStock(String[] stockData) {
        Node newNode = new Node(stockData);
        if (head == null) {
            head = newNode; // If the list is empty, set head to new node
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next; // Traverse to the end of the list
            }
            current.next = newNode; // Add new node at the end
        }
    }

    // Method to delete a stock by engine number
    public void deleteStock(String engineNumber) {
        if (head == null) {
            System.out.println("Inventory is empty.");
            return;
        }

        // Handle case for the head node
        if (head.stockData[3].equals(engineNumber)) {
            head = head.next; // Move head to the next node
            System.out.println("Stock with engine number " + engineNumber + " deleted.");
            return;
        }

        Node current = head;
        Node previous = null;

        // Traverse the linked list to find the stock to delete
        while (current != null && !current.stockData[3].equals(engineNumber)) {
            previous = current;
            current = current.next;
        }

        // If the stock was found, delete it
        if (current != null) {
            previous.next = current.next; // Bypass the current node
            System.out.println("Stock with engine number " + engineNumber + " deleted.");
        } else {
            System.out.println("Stock with engine number " + engineNumber + " not found.");
        }
    }

    // Method to display all stocks in the inventory
    public void displayInventory() {
        Node current = head;
        System.out.printf("%-15s %-10s %-10s %-15s %-10s%n", "Date Entered", "Type", "Brand", "Engine Number", "Status");
        System.out.println("---------------------------------------------------------------");
        while (current != null) {
            System.out.printf("%-15s %-10s %-10s %-15s %-10s%n",
                current.stockData[0],
                current.stockData[1],
                current.stockData[2],
                current.stockData[3],
                current.stockData[4]);
            current = current.next; // Move to the next node
        }
    }

    public static void main(String[] args) {
        Delete inventoryManager = new Delete();

        // Initial inventory data represented as a 2D array
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

        // Adding initial inventory to the linked list
        for (String[] stock : initialInventory) {
            inventoryManager.addStock(stock);
        }

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
