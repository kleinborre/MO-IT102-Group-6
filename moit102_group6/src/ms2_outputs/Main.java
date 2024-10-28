package ms2_outputs;

public class Main {
    public static void main(String[] args) {
        InventoryManager manager = new InventoryManager();
        
        // Adding stocks
        manager.addAndSortStocks("Honda 142QVTSIUR On-hand");
        manager.addAndSortStocks("Honda PZCT1S00XE Sold");
        manager.addAndSortStocks("Honda 4VBTV8YNM7 Sold");
        manager.addAndSortStocks("Honda 95AN3AWVF4 On-hand");
        manager.addAndSortStocks("Kawasaki 483QHIM661 On-hand");

        // Sort and print stocks
        System.out.println("Before Deletion:");
        manager.sortStocks();
        
        // Example of deleting a stock
        System.out.println();
        manager.deleteStock("Honda PZCT1S00XE Sold");
        System.out.println("After Deletion:");
        manager.sortStocks();
    }
}