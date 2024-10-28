package ms2_outputs;

class AVLNode {
    String stockData; // Data for the stock
    AVLNode left;     // Left child
    AVLNode right;    // Right child
    int height;       // Height of the node

    public AVLNode(String stockData) {
        this.stockData = stockData;
        this.height = 1; // New node is initially added at height 1
    }
}
