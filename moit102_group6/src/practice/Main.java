package practice;

public class Main{
	
	public static void main(String[] args) {
		
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.right.left = new TreeNode(4);
		root.right.right = new TreeNode(5);
		
		BinaryTree tree = new BinaryTree();
		int nodeCount = tree.countNodes(root);
		
		System.out.println("Number of nodes inside the tree: " + nodeCount);
		
	}
	
}