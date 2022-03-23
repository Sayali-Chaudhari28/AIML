import java.util.LinkedList;
import java.util.Queue;

/*
 * DFS and BFS using Tree
 */

class TreeNode{
	int data;
	TreeNode left, right;
	
	public TreeNode(int item) {
		data = item;
		left = null;
		right = null;
	}
}

class BinaryTree{
	TreeNode rootNode;
	BinaryTree(){
		rootNode = null;
	}
	// BFS
	void BFS() {
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(rootNode);
		while (!queue.isEmpty()) {
			TreeNode temp = queue.poll();
			System.out.print(temp.data + " ");
			
			// enqueue left
			if(temp.left != null) {
				queue.add(temp.left);
			}
			
			// enqueue right
			if(temp.right != null) {
				queue.add(temp.right);
			}
		}
	}
	
	// DFS
	void postorderTraversal(TreeNode node) {
		if(node == null)
			return;
		postorderTraversal(node.left);
		postorderTraversal(node.right);
		System.out.print(node.data + " ");
	}
	
	void inorderTraversal(TreeNode node) {
		if(node == null)
			return;
		inorderTraversal(node.left);
		System.out.print(node.data + " ");
		inorderTraversal(node.right);
	}
	
	void preordertraversal(TreeNode node) {
		if(node == null)
			return;
		System.out.print(node.data + " ");
		preordertraversal(node.left);
		preordertraversal(node.right);
	}
	
	 void postorderTraversal() { postorderTraversal(rootNode); }
	 void inorderTraversal() { inorderTraversal(rootNode); }
	 void preordertraversal() { preordertraversal(rootNode); }
}
public class Assignment_0_tree {
	public static void main(String args[]) {
		// creating binary tree
		BinaryTree btree = new BinaryTree();
		btree.rootNode = new TreeNode(1);
		btree.rootNode.left = new TreeNode(2);
		btree.rootNode.right = new TreeNode(3);
		btree.rootNode.left.left = new TreeNode(4);
		btree.rootNode.left.right = new TreeNode(5);
		System.out.println("\n\nBreadth first Search traversal of binary tree is - ");
		btree.BFS();
		
		
		System.out.println("\n\nDepth First search - ");
		System.out.println("Preorder traversal of binary tree is ");
	        btree.preordertraversal();
	 
	        System.out.println("\nInorder traversal of binary tree is ");
	        btree.inorderTraversal();
	 
	        System.out.println("\nPostorder traversal of binary tree is ");
	        btree.postorderTraversal();
	}
}
