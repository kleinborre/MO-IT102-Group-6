package ms2_outputs;

class AVLTree {
    AVLNode root; // Public variable for the root node

    // Function to get the height of the node
    private int height(AVLNode N) {
        return (N == null) ? 0 : N.height;
    }

    // Function to right rotate subtree rooted with y
    private AVLNode rightRotate(AVLNode y) {
        AVLNode x = y.left;
        AVLNode T2 = x.right;

        // Perform rotation
        x.right = y;
        y.left = T2;

        // Update heights
        y.height = Math.max(height(y.left), height(y.right)) + 1;
        x.height = Math.max(height(x.left), height(x.right)) + 1;

        // Return new root
        return x;
    }

    // Function to left rotate subtree rooted with x
    private AVLNode leftRotate(AVLNode x) {
        AVLNode y = x.right;
        AVLNode T2 = y.left;

        // Perform rotation
        y.left = x;
        x.right = T2;

        // Update heights
        x.height = Math.max(height(x.left), height(x.right)) + 1;
        y.height = Math.max(height(y.left), height(y.right)) + 1;

        // Return new root
        return y;
    }

    // Function to get balance factor of node N
    private int getBalance(AVLNode N) {
        return (N == null) ? 0 : height(N.left) - height(N.right);
    }

    // Function to insert a stock
    public AVLNode insert(AVLNode node, String stockData) {
        // Normal BST insertion
        if (node == null) {
            return new AVLNode(stockData);
        }

        if (stockData.compareTo(node.stockData) < 0) {
            node.left = insert(node.left, stockData);
        } else if (stockData.compareTo(node.stockData) > 0) {
            node.right = insert(node.right, stockData);
        } else {
            // Duplicate stock data not allowed
            return node;
        }

        // Update height of this ancestor node
        node.height = 1 + Math.max(height(node.left), height(node.right));

        // Get the balance factor
        int balance = getBalance(node);

        // If the node becomes unbalanced, then there are 4 cases

        // Left Left Case
        if (balance > 1 && stockData.compareTo(node.left.stockData) < 0) {
            return rightRotate(node);
        }

        // Right Right Case
        if (balance < -1 && stockData.compareTo(node.right.stockData) > 0) {
            return leftRotate(node);
        }

        // Left Right Case
        if (balance > 1 && stockData.compareTo(node.left.stockData) > 0) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }

        // Right Left Case
        if (balance < -1 && stockData.compareTo(node.right.stockData) < 0) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }

        // Return the (unchanged) node pointer
        return node;
    }

    // Function to delete a node
    public AVLNode delete(AVLNode root, String stockData) {
        // STEP 1: PERFORM STANDARD BST DELETE
        if (root == null) {
            return root;
        }

        if (stockData.compareTo(root.stockData) < 0) {
            root.left = delete(root.left, stockData);
        } else if (stockData.compareTo(root.stockData) > 0) {
            root.right = delete(root.right, stockData);
        } else {
            // node with only one child or no child
            if ((root.left == null) || (root.right == null)) {
                AVLNode temp = null;
                if (temp == root.left) {
                    temp = root.right;
                } else {
                    temp = root.left;
                }

                // No child case
                if (temp == null) {
                    return null;
                } else { // One child case
                    return temp;
                }
            } else {
                // node with two children: Get the inorder successor (smallest in the right subtree)
                AVLNode temp = minValueNode(root.right);
                root.stockData = temp.stockData; // Copy the inorder successor's content to this node
                root.right = delete(root.right, temp.stockData); // Delete the inorder successor
            }
        }

        // If the tree had only one node, then return
        if (root == null) {
            return root;
        }

        // STEP 2: UPDATE THE HEIGHT OF THE CURRENT NODE
        root.height = Math.max(height(root.left), height(root.right)) + 1;

        // STEP 3: GET THE BALANCE FACTOR OF THIS NODE (to check whether this node became unbalanced)
        int balance = getBalance(root);

        // If this node becomes unbalanced, then there are 4 cases

        // Left Left Case
        if (balance > 1 && getBalance(root.left) >= 0) {
            return rightRotate(root);
        }

        // Left Right Case
        if (balance > 1 && getBalance(root.left) < 0) {
            root.left = leftRotate(root.left);
            return rightRotate(root);
        }

        // Right Right Case
        if (balance < -1 && getBalance(root.right) <= 0) {
            return leftRotate(root);
        }

        // Right Left Case
        if (balance < -1 && getBalance(root.right) > 0) {
            root.right = rightRotate(root.right);
            return leftRotate(root);
        }

        return root;
    }

    // Function to get the node with the smallest value
    private AVLNode minValueNode(AVLNode node) {
        AVLNode current = node;
        while (current.left != null) {
            current = current.left;
        }
        return current;
    }
}