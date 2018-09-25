package org.hooah.algorithms;


/**
 Given a sorted (increasing order) array with unique integer elements, write an algorithm to create a binary search tree with minimal height
 */
public class MinimalBinaryTreeHeight {
	
	
	
	/* Driver program to test above functions */
	public static void main(String args[])
	{
		int[] arr = {1,2,3,4,5,6,7,8,9,10,11,12,15,19};
		
		Node node = createMinimalBST(arr);
		BinaryTree tree1 = new BinaryTree();
		tree1.root = node;
		System.out.println("The minimum depth of "+
				"binary tree is : " + tree1.minimumDepth());
		
	
	}
	
	static Node createMinimalBST(int arr[], int start, int end) {
		if (end < start) {
			return null;
		}
		int mid = (start + end) / 2;
		Node n = new Node(arr[mid]);
		n.left = createMinimalBST(arr, start, mid - 1);
		n.right = createMinimalBST(arr, mid + 1, end);
		return n;
	}
	
	static Node createMinimalBST(int array[]) {
		return createMinimalBST(array, 0, array.length - 1);
	}
	
	
/* Java implementation to find minimum depth
   of a given Binary tree */
	
	/* Class containing left and right child of current
	node and key value*/
	static class Node
	{
		int data;
		Node left, right;
		public Node(int item)
		{
			data = item;
			left = right = null;
		}
	}
	static class BinaryTree
	{
		//Root of the Binary Tree
		Node root;
		
		int minimumDepth()
		{
			return minimumDepth(root);
		}
		
		/* Function to calculate the minimum depth of the tree */
		int minimumDepth(Node root)
		{
			// Corner case. Should never be hit unless the code is
			// called on root = NULL
			if (root == null)
				return 0;
			
			// Base case : Leaf Node. This accounts for height = 1.
			if (root.left == null && root.right == null)
				return 1;
			
			// If left subtree is NULL, recur for right subtree
			if (root.left == null)
				return minimumDepth(root.right) + 1;
			
			// If right subtree is NULL, recur for left subtree
			if (root.right == null)
				return minimumDepth(root.left) + 1;
			
			return Math.min(minimumDepth(root.left),
					minimumDepth(root.right)) + 1;
		}
		
	}
	
}
