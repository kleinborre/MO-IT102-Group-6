package ms2_outputs;

import java.security.NoSuchAlgorithmException;

class InventoryManager {
    private AVLTree avlTree;
    private HashTable hashTable; // Initialize hashTable

    public InventoryManager() {
        avlTree = new AVLTree();
        hashTable = new HashTable(); // Ensure hashTable is initialized
    }

    // Add and sort stocks
    public void addAndSortStocks(String stockData) {
        avlTree.root = avlTree.insert(avlTree.root, stockData);
        
        // Insert the full stock data in hashTable
        try {
            hashTable.insert(stockData);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

    // Sort and print stocks
    public void sortStocks() {
        System.out.println("Sorted Stocks by Brand:");
        printSortedStocks(avlTree.root);
    }

    // Helper method to print sorted stocks
    private void printSortedStocks(AVLNode node) {
        if (node != null) {
            printSortedStocks(node.left);
            System.out.println(node.stockData);
            printSortedStocks(node.right);
        }
    }

    // Delete a stock
    public void deleteStock(String stockData) {
        avlTree.root = avlTree.delete(avlTree.root, stockData);
        
        // Remove the stock data from hashTable
        try {
            hashTable.delete(stockData);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

    // Search for inventory by stock details
    public void searchInventory(String stockDetails) {
        try {
            String stockData = hashTable.search(stockDetails.trim());
            
            if (stockData != null) {
                System.out.println("Stock found: " + stockData);
            } else {
                System.out.println("Stock not found for: " + stockDetails);
            }
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }
}


