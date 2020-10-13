package org.hooah.problems;

import org.hooah.algorithms.BinaryTreeNode;

public class CountNodeBinaryTree {
	
	public int countNodes(BinaryTreeNode root) {
		if(root==null){
			return 0;
		}
		return 1+countNodes(root.right)+countNodes(root.left);
	}
}
