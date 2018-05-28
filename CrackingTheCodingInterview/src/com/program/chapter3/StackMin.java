package com.program.chapter3;

public class StackMin {
	
	MyStack top;
	int min;

	public static void main(String[] args) {
		
		StackMin stack = new StackMin();
		stack.push(10);
		stack.push(12);
		stack.push(35);
		stack.push(47);
		stack.push(5);
		stack.push(6);
		stack.push(7);
		
		
		System.out.println(stack.min());
		
		
	}
	
	private static class MyStack{
		MyStack next;
		int data;
		public MyStack(int data){
			this.data = data;
		}
	}
	
	public void push(int value){
		if(top==null) min = value;
		
		MyStack newNode = new MyStack(value);
		newNode.next = top;
		top = newNode;
		
		if(min>value){
			min=value;
		}
	}
	
	
	public int pop(){
		int data = top.data;
		if(top!=null){
			top = top.next;
		}
		return data;
	}
	
	public int peek(){
		return top.data;
	}
	public boolean isEmpty(){
		return (top==null);
	}
	public int min(){
		return min;
	}

}
