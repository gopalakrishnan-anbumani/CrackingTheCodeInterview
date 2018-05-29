package com.program.chapter3;

public class StackbyArray {

	int[] array;
	int top;

	public static void main(String[] args) {
		StackbyArray stackbyArray = new StackbyArray();
		try {
			stackbyArray.push(1);
			stackbyArray.push(2);
			stackbyArray.push(3);
			
			
			stackbyArray.pop();
			stackbyArray.pop();
			stackbyArray.pop();
			System.err.println(stackbyArray.isEmpty());
			stackbyArray.pop();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	public StackbyArray() {
		array = new int[10];
		top = -1;
	}

	private void push(int value) throws Exception {
		if (top == 10) {
			throw new Exception("Array is full");
		}
		top++;
		array[top] = value;
		System.out.println(value +" is pushed to Stack");
		
	}

	private int pop() throws Exception {
		if(isEmpty()){
			throw new Exception("Array is Empty");
		}
		int data = array[top];
		top = top-1;
		System.out.println(data +" is poped from Stack");
		return data;
		
	}

	private boolean isEmpty() {
		return (top == -1);
	}

}
