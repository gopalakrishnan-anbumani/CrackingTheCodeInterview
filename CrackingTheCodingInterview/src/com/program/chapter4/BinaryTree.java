package com.program.chapter4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

/**
 *  Minimal Tree from Sorted Array
 * 
 * @author KRISH
 *
 */
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
		//DFS(root);
		int[] arr = {1,2,3,4,5,6,7,8,9,10};
		//sampleRecur(arr, 0, arr.length-1);
		//root = createBSTTree(arr, 0, arr.length-1);
		//levelOrderSearch(root);
		ArrayList<Integer> a = new ArrayList<Integer>();
		ArrayList<Integer> b = new ArrayList<Integer>();
		a.add(2);
		a.add(1);
		b.add(1);
		b.add(2);
		System.out.println(maxPoints(a, b));
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
	
	/**
	 * Method to create BST Tree from Array (Increasing Order)
	 * 
	 * @param arr
	 * @param start
	 * @param end
	 * @return Node
	 */
	public static Node createBSTTree(int[] arr, int start, int end){
		if(end < start){
			return null;
		}
		int mid = (start+end)/2;
		Node n = new Node(arr[mid]);
		n.left = createBSTTree(arr, start, mid-1);
		n.right = createBSTTree(arr, mid+1, end);
		return n;
	}
	/**
	 * Level Order Search / BFS
	 * @param n
	 */
	public static void levelOrderSearch(Node n){
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(n);
		
		while(!queue.isEmpty()){
			Node node = queue.remove();
			System.out.println("  "+node.data);
			if(node.left!=null){
				queue.add(node.left);
			}
			if(node.right!=null){
				queue.add(node.right);
			}
		}
	}
	
	/**
	 * Method to test sample recursion
	 * split the array by left side and write side.  
	 */
	public static void sampleRecur(int[] arr,int start, int end){
		if(end < start){
			
			return;
		}
		int mid = (start + end) / 2;
		
		//System.out.println("Left -> "+start+" to " + (mid-1));
		sampleRecur(arr,start,mid-1);
		//System.out.println("right -> from" + (mid+1)+" to "+end);
		sampleRecur(arr,mid+1,end);
		System.out.println("Mid ->" + mid);
	}
	public static int maxPoints(ArrayList<Integer> a, ArrayList<Integer> b) {
	    int maxPoints = 0;
        HashMap<Double, Integer> map = new HashMap<Double, Integer>();
        if(a.size() != b.size() || a.size() == 0 || a == null || b.size() == 0 || b == null)
            return maxPoints;
        if(a.size() == 1 && b.size() == 1)
            return 1;
        int N = a.size();
	    for(int i=0;i<N;i++){
	        int duplicate = 1;
            int vertical = 0;
            int xi = a.get(i);
            int yi = b.get(i);
            
	        for(int j=i+1;j<N;j++){
	            
	            int xj = a.get(j);
                int yj = b.get(j);
                if(xi == xj){
                    if(yi == yj){
                        duplicate++;
                    }else{
                        vertical++;
                    }
                }else{
                    double slope = 0.0;
                    if(yj - yi == 0)
                        slope = 0.0;
                    else if(xj - xi == 0)
                        slope = Double.MAX_VALUE;
                    else
                        slope = (double)(yj - yi) / (double)(xj - xi);
                    
                    //System.out.println("Slope : " + slope);
                    if(map.containsKey(slope))
                        map.put(slope, map.get(slope) + 1);
                    else 
                        map.put(slope, 1);
                }
            
	        }
	        for(int sl : map.values())
                if(maxPoints < sl + duplicate)
                maxPoints = sl + duplicate;
            
            maxPoints = Math.max(vertical + duplicate, maxPoints);
            map.clear();
	    }
	    return maxPoints;
}
}
