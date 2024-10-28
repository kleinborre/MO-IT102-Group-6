package ms2_outputs;

class AVLTree {
    private AVLNode root;

    public int getHeight(AVLNode node) {
        return node == null ? 0 : node.height;
    }

    public int getBalance(AVLNode node) {
        return node == null ? 0 : getHeight(node.left) - getHeight(node.right);
    }

    private AVLNode rotateRight(AVLNode y) {
        AVLNode x = y.left;
        AVLNode T2 = x.right;
        x.right = y;
        y.left = T2;
        y.height = Math.max(getHeight(y.left), getHeight(y.right)) + 1;
        x.height = Math.max(getHeight(x.left), getHeight(x.right)) + 1;
        return x;
    }

    private AVLNode rotateLeft(AVLNode x) {
        AVLNode y = x.right;
        AVLNode T2 = y.left;
        y.left = x;
        x.right = T2;
        x.height = Math.max(getHeight(x.left), getHeight(x.right)) + 1;
        y.height = Math.max(getHeight(y.left), getHeight(y.right)) + 1;
        return y;
    }

    public void insert(String stockData) {
        root = insertNode(root, stockData);
    }

    private AVLNode insertNode(AVLNode node, String stockData) {
        if (node == null) {
            return new AVLNode(stockData);
        }
        
        if (stockData.compareTo(node.stockData) < 0) {
            node.left = insertNode(node.left, stockData);
        } else if (stockData.compareTo(node.stockData) > 0) {
            node.right = insertNode(node.right, stockData);
        } else {
            return node; // duplicate keys not allowed
        }

        node.height = 1 + Math.max(getHeight(node.left), getHeight(node.right));

        int balance = getBalance(node);

        if (balance > 1 && stockData.compareTo(node.left.stockData) < 0) {
            return rotateRight(node);
        }
        if (balance < -1 && stockData.compareTo(node.right.stockData) > 0) {
            return rotateLeft(node);
        }
        if (balance > 1 && stockData.compareTo(node.left.stockData) > 0) {
            node.left = rotateLeft(node.left);
            return rotateRight(node);
        }
        if (balance < -1 && stockData.compareTo(node.right.stockData) < 0) {
            node.right = rotateRight(node.right);
            return rotateLeft(node);
        }
        return node;
    }

    public void delete(String stockData) {
        root = deleteNode(root, stockData);
    }

    private AVLNode deleteNode(AVLNode node, String stockData) {
        if (node == null) return node;

        if (stockData.compareTo(node.stockData) < 0) {
            node.left = deleteNode(node.left, stockData);
        } else if (stockData.compareTo(node.stockData) > 0) {
            node.right = deleteNode(node.right, stockData);
        } else {
            if ((node.left == null) || (node.right == null)) {
                AVLNode temp = node.left != null ? node.left : node.right;
                node = temp;
            } else {
                AVLNode temp = minValueNode(node.right);
                node.stockData = temp.stockData;
                node.right = deleteNode(node.right, temp.stockData);
            }
        }

        if (node == null) return node;

        node.height = Math.max(getHeight(node.left), getHeight(node.right)) + 1;
        int balance = getBalance(node);

        if (balance > 1 && getBalance(node.left) >= 0) return rotateRight(node);
        if (balance > 1 && getBalance(node.left) < 0) {
            node.left = rotateLeft(node.left);
            return rotateRight(node);
        }
        if (balance < -1 && getBalance(node.right) <= 0) return rotateLeft(node);
        if (balance < -1 && getBalance(node.right) > 0) {
            node.right = rotateRight(node.right);
            return rotateLeft(node);
        }
        return node;
    }

    private AVLNode minValueNode(AVLNode node) {
        AVLNode current = node;
        while (current.left != null) current = current.left;
        return current;
    }
}