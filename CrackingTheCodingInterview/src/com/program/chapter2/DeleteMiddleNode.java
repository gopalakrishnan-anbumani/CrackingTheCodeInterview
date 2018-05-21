package com.program.chapter2;

public class DeleteMiddleNode {

	static Node head;
	
	public static void main(String[] args) {
		SingleLinkedList list = new SingleLinkedList();
		list.addNode(1);
		list.addNode(2);
		list.addNode(3);
		//list.addNode(4);
		//list.addNode(5);
		//list.addNode(6);
		//list.addNode(7);
		head = list.head;
		list.printList();
		DeleteMiddleNodeMethod1();
		list.printList();
	}
	public static void DeleteMiddleNodeMethod1(){
		Node fast = head.next.next;
		Node slow = head;
		while(fast.next!=null && fast.next.next!=null){
			slow = slow.next;
			fast = fast.next.next;
		}
		slow.next = slow.next.next;
	}

}
