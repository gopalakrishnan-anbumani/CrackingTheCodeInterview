package com.program.chapter2;

import java.util.Stack;

public class Palindrome {
	static Node head;
	public static void main(String[] args) {
		SingleLinkedList list = new SingleLinkedList();
		list.addNode(1);
		list.addNode(2);
		list.addNode(3);
		list.addNode(4);
		list.addNode(5);
		list.addNode(6);
		list.addNode(7);
		head = list.head;
		list.printList();
		usingStack();
	}
	
	public static void usingStack(){
		Stack<Integer> stack = new Stack<Integer>();  
		Node first = head;
		Node second = head;
		while(first.next!=null && first.next.next!=null){
			
			System.out.println(first.data+" fast ");
			System.out.println(second.data+" slow ");
			
			second = second.next;
			first = first.next.next;
			
		}
		System.out.println(first.data+" fast1 ");
		System.out.println(second.data+" slow1 ");
	}
	
	
	
}
