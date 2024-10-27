package practice;

public class BinaryTree {
	
	// Function to count the number of nodes in the binary tree
    public int countNodes(TreeNode root) {
        // If the root is null, there are no nodes in the tree
        if (root == null) {
            return 0;
        }

        // Otherwise, count the nodes in the left and right subtrees
        int leftCount = countNodes(root.left);
        int rightCount = countNodes(root.right);

        // Add 1 for the root node and return the total count
        return 1 + leftCount + rightCount;
    }
	
}