package com.program.chapter4;

public class FirstCommonParent {

	private static Node root;
	public static void main(String[] args) {
		root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		
		root.right.left = new Node(6);
		root.right.right = new Node(7);
		System.out.println(findTheFirstCommonParent(root,4,7));
	}
	
	private static int findTheFirstCommonParent(Node node,int a,int b){
		int res = -1;
		if(node == null){
			return -1;
		}
		if(node.data==a || node.data==b){
			return node.data;
		}
		
		if((a+b)==(findTheFirstCommonParent(node.left, a, b)+findTheFirstCommonParent(node.right, a, b))){
			System.out.println("res"+node.data);
			res = node.data;
			return res;
		}
		return res;
	}

	
	//==============================
	//Node Class
	//==============================
	@SuppressWarnings("unused")
	private static class Node{
		int data;
		Node left,right;
		
		public Node(int data) {
			this.data = data;
		}
	}
	
	
}
