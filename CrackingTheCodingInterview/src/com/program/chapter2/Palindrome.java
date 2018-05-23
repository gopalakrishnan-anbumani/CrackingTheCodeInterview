package com.program.chapter2;

import java.util.Stack;

public class Palindrome {
	static Node head;
	public static void main(String[] args) {
		SingleLinkedList list = new SingleLinkedList();
		list.addNode(1);
		list.addNode(1000000000);
		list.addNode(-1000000000);
		list.addNode(-1000000000);
		list.addNode(1000000000);
		list.addNode(1);
		//list.addNode(1);
		//list.addNode(7);
		head = list.head;
		list.printList();
		usingStack();
		System.out.println();
	}
	
	public static void usingStack(){
		Stack<Integer> stack = new Stack<Integer>();  
		Node first = head;
		Node second = head;
		while(first.next!=null && first.next.next!=null){
//			System.out.println(first.data+" fast ");
//			System.out.println(second.data+" slow ");		
			stack.push(second.data);
			second = second.next;
			first = first.next.next;
			
		}
		//System.out.println(first.data+" fast1 ");
		//System.out.println(second.data+" slow1 ");
		if(first.next!=null){
			stack.push(second.data);
		}
		
		while(second.next!=null){
			second = second.next;
			if(stack.pop()!=second.data){
				System.out.println("This is not Palindrome");
				return;
				
			}
		}
		System.out.println("Palindrome");
		stack.forEach(i -> System.out.println(i));
	}	
	boolean isListPalindrome(ListNode<Integer> l) {
		Stack<Integer> stack = new Stack<Integer>();  
		ListNode<Integer> first = l;
		ListNode<Integer> second = l;
		while(first.next!=null && first.next.next!=null){	
			stack.push(second.value);
			second = second.next;
			first = first.next.next;
			
		}
		if(first.next!=null){
			stack.push(second.value);
		}
		
		while(second.next!=null){
			second = second.next;
			
			if(stack.pop()!=second.value){
				return false;
			}
		}
		return true;
	}
	 class ListNode<T> {
  ListNode(T x) {
    value = x;
  }
  T value;
  ListNode<T> next;
}
}
