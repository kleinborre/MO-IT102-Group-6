package ms2_outputs;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        InventoryManager manager = new InventoryManager();
        
        Scanner scan = new Scanner(System.in);
        
        // Current stocks
        manager.addAndSortStocks("Honda,142QVTSIUR,On-hand");
        manager.addAndSortStocks("Honda,PZCT1S00XE,Sold");
        manager.addAndSortStocks("Honda,4VBTV8YNM7,Sold");
        manager.addAndSortStocks("Honda,95AN3AWVF4,On-hand");
        manager.addAndSortStocks("Kawasaki,483QHIM661,On-hand");
        
        // Sort and display stocks
        manager.sortStocks();
        
        // Search Stocks by Details
        System.out.print("\nSearch by stock details: ");
        String result = scan.nextLine(); // This can be the full string
        
        // Show search result
        System.out.println("\nRESULT:");
        manager.searchInventory(result);
        
        // Example of deleting a stock
        manager.deleteStock("Kawasaki,483QHIM661,On-hand");
        manager.sortStocks(); // To check the updated list
    }
}
