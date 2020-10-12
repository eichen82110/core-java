package org.hooah.algorithms;

/* Class containing left and right child of current 
   node and key value*/
public class Node {
	
	int data;
	Node left, right, nextRight;
	
	public Node(int item){
		data = item;
		left = right = nextRight = null;
	}
}
