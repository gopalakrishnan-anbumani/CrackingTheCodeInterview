package com.program.chapter2;

import java.util.HashMap;
import java.util.HashSet;

public class RemoveDuplication {

	static Node1 head;
	
	public static void main(String[] args) {
		
		addNode(1);addNode(3);addNode(2);addNode(2);addNode(2);
		printList();
		//withBufferMethod();
		withoutBuffer();
		printList();

	}
	
	/**
	 * Without any buffer we have to iterate 2 times
	 */
	public static void withoutBuffer(){
		Node1 n = head;
		while(n!=null){
			Node1 point = n;
			while(point.next!=null){
				if(n.data==point.next.data){
					point.next = point.next.next;
				}else{
					point = point.next;
				}
			}
			n=n.next;
		}
	}
	
	/**
	 * Method to remove duplication in the linked list. This method use the hashtable
	 */
	public static void withBufferMethod(){
		HashSet<Integer> set = new HashSet<Integer>();
		Node1 n = head;
		if(n!=null){
			set.add(n.data);
		}else{
			return;
		}
		while(n.next!=null){
			int data = n.next.data;
			if(set.contains(data)){
				n.next = n.next.next;
			}else{
				set.add(data);
				n=n.next;
			}
			
		}
	}
	// Add a new Node
	public static void addNode(int data){
		Node1 n = head;
		if(n==null){
			head = new Node1(data);
			return;
		}
		while(n.next!=null){
			n=n.next;
		}
		n.next = new Node1(data);
	}
	
	//Print Single List
	public static void printList(){
		Node1 n = head;
		while(n!=null){
			System.out.print(n.data+" ");
			n=n.next;
		}
		System.out.println("");
	}

}
class Node1{
	int data;
	Node1 next=null;
	public Node1(int data){
		this.data = data;
	}
}
