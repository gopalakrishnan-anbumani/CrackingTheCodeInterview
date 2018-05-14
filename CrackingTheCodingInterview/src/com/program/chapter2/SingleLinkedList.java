package com.program.chapter2;

public class SingleLinkedList {
	
	static Node head;
	static int count =0;
	

	public static void main(String[] args) {
		
		addNode(1); addNode(2);	addNode(3);	addNode(4); addNode(5);
		System.out.println(count);
		printList();
	}
	// Add Node
	// Remove Node
	// How many Nodes
	// is the Sequence Empty
	// Get Data from specified Node
	public static void addNode(int data){
		Node n = head;
		if(n==null){
			head = new Node(data);
			count++;
			return;
		}
		while(n.next!=null){
			n=n.next;
		}
		n.next = new Node(data);
		count++;
	}
	public static void printList(){
		Node n = head;
		while(n!=null){
			System.out.print(n.data+" ");
			n=n.next;
		}
	}
}
