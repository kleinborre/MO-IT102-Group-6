package ms2_outputs;

class InventoryManager {
    private AVLTree avlTree;

    public InventoryManager() {
        avlTree = new AVLTree();
    }

    // Add and sort stocks
    public void addAndSortStocks(String stockData) {
        avlTree.root = avlTree.insert(avlTree.root, stockData);
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
    }

    // Search for a stock (this can be implemented as needed)
    public String searchInventory(String brand) {
        // Implement search logic if necessary
        return null; // Placeholder for actual search logic
    }
}