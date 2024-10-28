package ms2_outputs;

class InventoryManager {
    private AVLTree avlTree;
    private HashTable hashTable;

    public InventoryManager() {
        avlTree = new AVLTree();
        hashTable = new HashTable();
    }

    public void addAndSortStocks(String stockData) {
        // Add stock data to the AVL Tree
        avlTree.insert(stockData);
    }

    // Function to retrieve sorted stocks
    public void printSortedStocks(AVLNode node) {
        if (node != null) {
            printSortedStocks(node.left);
            System.out.println(node.stockData);
            printSortedStocks(node.right);
        }
    }
}