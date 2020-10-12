package org.hooah.algorithms;

import java.util.ArrayList;

// A Java program to introduce Binary Tree
class BinaryTree {
	
	// Root of Binary Tree
	Node root1, root2;
	
	
	// Returns true if there is a path from root
	// to the given node. It also populates
	// 'arr' with the given path
	//If root = NULL, return false.
	//push the root’s data into arr[].
	//if root’s data = x, return true.
	//if node x is present in root’s left or right subtree, return true.
	//Else remove root’s data value from arr[] and return false.
	public static boolean hasPath(Node root, ArrayList<Integer> arr, int x) {
		if(root==null){
			return false;
		}
		arr.add(root.data);
		if(root.data==x){
			return true;
		}else if(hasPath(root.left,arr,x)||hasPath(root.right,arr,x)){
			return true;
		}else{
			arr.remove(arr.size()-1);
			return false;
		}
		
	}
	
	void printKDistant(Node node, int k) {
		if(node == null) { return; }
		if(k == 0) {
			System.out.print(node.data + " ");
		} else {
			printKDistant(node.left, k - 1);
			printKDistant(node.right, k - 1);
		}
	}
	
	/* A utility function to check whether trees with roots as root1 and
	  root2 are identical or not */
	boolean areIdentical(Node root1, Node root2) {
		
		/* base cases */
		if(root1 == null && root2 == null) { return true; }
		
		if(root1 == null || root2 == null) { return false; }
   
        /* Check if the data of both roots is same and data of left and right
           subtrees are also same */
		return (root1.data == root2.data && areIdentical(root1.left, root2.left) && areIdentical(root1.right, root2.right));
	}
	
	/* This function returns true if S is a subtree of T, otherwise false */
	boolean isSubtree(Node T, Node S) {
		/* base cases */
		if(S == null) { return true; }
		
		if(T == null) { return false; }
		
		/* Check the tree with root as current node */
		if(areIdentical(T, S)) { return true; }
   
        /* If the tree with root as current node doesn't match then
           try left and right subtrees one by one */
		return isSubtree(T.left, S) || isSubtree(T.right, S);
	}
	
	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree();
		
		// TREE 1
        /* Construct the following tree
              26
             /   \
            10     3
           /    \     \
          4      6      3
           \
            30  */
		
		tree.root1 = new Node(26);
		tree.root1.right = new Node(3);
		tree.root1.right.right = new Node(3);
		tree.root1.left = new Node(10);
		tree.root1.left.left = new Node(4);
		tree.root1.left.left.right = new Node(30);
		tree.root1.left.right = new Node(6);
		tree.printPaths(tree.root1);
		
		System.out.println("Nodes at k distance from root: ");
		tree.printKDistant(tree.root1, 2);
		System.out.println();
		
		// TREE 2
        /* Construct the following tree
           10
         /    \
         4      6
          \
          30  */
		
		tree.root2 = new Node(10);
		tree.root2.right = new Node(6);
		tree.root2.left = new Node(4);
		tree.root2.left.right = new Node(30);
		System.out.println("Nodes at k distance from root: ");
		tree.printKDistant(tree.root2, 2);
		System.out.println();
		
		if(tree.isSubtree(tree.root1, tree.root2)) {
			System.out.println("Tree 2 is subtree of Tree 1 ");
		} else {
			System.out.println("Tree 2 is not a subtree of Tree 1");
		}
		
		
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right.left = new Node(6);
		root.right.right = new Node(7);
		int x = 5;
		tree.printPaths(root);
		
		printPath(root, x);
		
	}
	
	private static void printPath(Node root, int x) {
		// ArrayList to store the path
		ArrayList<Integer> arr = new ArrayList<>();
		
		// if required node 'x' is present
		// then print the path
		if(hasPath(root, arr, x)) {
			for(int i = 0; i < arr.size() - 1; i++) {
				System.out.print(arr.get(i) + "->");
			}
			System.out.print(arr.get(arr.size() - 1));
		}
		
		// 'x' is not present in the binary tree
		else {
			System.out.print("No Path");
		}
	}
	
	void printPaths(Node node)
	{
		int[] path = new int[1000];
		printPathsRecur(node, path, 0);
	}
	
	/* Recursive helper function -- given a node, and an array containing
	   the path from the root node up to but not including this node,
	   print out all the root-leaf paths. */
	void printPathsRecur(Node node, int[] path, int pathLen)
	{
		if (node == null)
			return;
		
		/* append this node to the path array */
		path[pathLen] = node.data;
		pathLen++;
		
		/* it's a leaf, so print the path that led to here */
		if (node.left == null && node.right == null)
			printArray(path, pathLen);
		else
		{
			/* otherwise try both subtrees */
			printPathsRecur(node.left, path, pathLen);
			printPathsRecur(node.right, path, pathLen);
		}
	}
	
	/* Utility that prints out an array on a line */
	void printArray(int[] ints, int len)
	{
		int i;
		for (i = 0; i < len; i++)
			System.out.print(ints[i] + " ");
		System.out.println();
	}
	
}