package com.program.chapter4;

public class BinaryTree {
	
	static Node root = null;

	public static void main(String[] args) {
		root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		
		root.right.left = new Node(6);
		root.right.right = new Node(7);
		DFS(root);
	}

	public static void DFS(Node node){
		
		int i=0;
		if(i==0){
			System.out.print(" ");
		}
		if(node.left!=null){
			DFS(node.left);
			System.out.println(node.left.data+" left ");
		}
		//if(node!=null){
			//DFS(node);
			//System.out.println(node.data+" cent ");
		//}
		
		if(node.right!=null){
			DFS(node.right);
			System.out.println(node.right.data+" ri8 ");
		}
		
		
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
