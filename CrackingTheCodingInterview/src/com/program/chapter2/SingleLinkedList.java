package com.program.chapter2;

public class SingleLinkedList {
	
	Node head;
	static int count =0;
	

	public static void main(String[] args) {
		SingleLinkedList list = new SingleLinkedList();
		list.addNode(1); 
		System.out.println(count);
		list.printList();
	}
	// Add Node
	// Remove Node
	// How many Nodes
	// is the Sequence Empty
	// Get Data from specified Node
	public void addNode(int data){
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
	public void printList(){
		Node n = head;
		while(n!=null){
			System.out.print(n.data+" ");
			n=n.next;
		}
		System.out.println();
	}
}
