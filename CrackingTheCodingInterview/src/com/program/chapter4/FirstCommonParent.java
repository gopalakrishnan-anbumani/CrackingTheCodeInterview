package com.program.chapter4;

import java.util.LinkedList;
import java.util.Queue;

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
		
		root.left.left.left = new Node(8);
		root.left.left.right = new Node(9);
		
		root.left.right.left = new Node(10);
		root.left.right.right = new Node(11);
		
		

		//System.out.println(isContain(root, 71));
		//System.out.println(findTheFirstCommonParent(root,4,6));
		solve();
	}
	
	private static void solve(){
		int a = 8;
		int b = 11;
		Node node = root;
		Queue<Node> q = new LinkedList<FirstCommonParent.Node>();
		q.add(node);
		while(!q.isEmpty()){
			Node node1 = q.remove();
			boolean left1 = isContain(node1.left, a);
			boolean left2 = isContain(node1.left, b);
			if(left1 && left2){
				q.add(node1.left);
			}else if(left1){
				boolean right2 = isContain(node1.right, b);
				if(right2){
					System.out.println("Found "+node1.data);
				}else{
					System.out.println("Not Found");
				}
				break;
			}else if(left2){
				boolean right1 = isContain(node1.right, a);
				if(right1){
					System.out.println("Found "+node1.data);
				}else{
					System.out.println("Not Found");
				}
				break;
			}else{
				q.add(node1.right);
			}
		}
	}
	
	private static int findTheFirstCommonParent(Node node,int a,int b){
		//int res = -1;
		if(node == null){
			return -1;
		}
		if(node.data==a || node.data==b){
			return node.data;
		}
		
		int aa = findTheFirstCommonParent(node.left,a,b);
		int bb = 0;
		if(aa == a+b){
			return aa;
		}else if(aa==a || aa==b){
			bb = findTheFirstCommonParent(node.right,a,b);
		}else{
			return -1;
		}
		
		
//		if(a+b == aa+bb){
//			System.out.println(node.data);
//			return node.data;
//		}
		
		if(aa + bb ==a+b){
			System.out.println("node"+node.data);
			return aa+bb;
		}else{
			return -1;
		}
		
		//return res;
	}
	
	public static boolean isContain(Node node, int data){
		if(node!=null){
			if(node.data==data){
				return true;
			}else{
				return isContain(node.left,data) || isContain(node.right,data);
			}
		}
		return false;
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
