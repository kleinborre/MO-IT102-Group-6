package practice;

public class BinaryTree {
	
	public static int countNodes(TreeNode root) {
		
		//If there is no value on the root, return null
		if(root == null) {
			return 0;
		}
		
		// Otherwise, count the nodes in the left and right subtrees
		int leftNode = countNodes(root.left);
		int rightNode = countNodes(root.right);
		
		// Add 1 for the root Node return the total count
		return 1 + leftNode + rightNode;
		
		
	}
	
}