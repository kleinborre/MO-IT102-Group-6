package ms2_outputs;

class AVLNode {
    String stockData;
    AVLNode left, right;
    int height;

    public AVLNode(String stockData) {
        this.stockData = stockData;
        this.height = 1;
    }
}