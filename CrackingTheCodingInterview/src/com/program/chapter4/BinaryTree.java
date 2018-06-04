package com.program.chapter4;

public class BinaryTree {
	
	static Node root = null;

	public static void main(String[] args) {
		root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		
	}

	
	// Tree Node
	private static class Node{
		int data;
		Node left,right;
		
		public Node(int data) {
			this.data = data;
		}
	}
}
