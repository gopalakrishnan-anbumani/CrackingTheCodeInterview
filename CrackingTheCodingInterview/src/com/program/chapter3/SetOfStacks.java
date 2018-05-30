package com.program.chapter3;

import java.util.List;

public class SetOfStacks {
	
	int threshold;
	List<StackClass> setOfStacks;
	
	public SetOfStacks(int capacity){
		threshold = capacity;
		setOfStacks.add(new StackClass(threshold));
	}
	
	
	private static class StackClass{
		
		int top;
		int[] array;
		int capacity;
		
		public StackClass(int capacity){
			this.capacity = capacity;
			this.array = new int[capacity];
			this.top = -1;
		}
		public void push(int data) throws Exception{
			if(isFull()){
				throw new Exception("Stack is Full");
			}
			top++;
			array[top] = data;
		}
		public int pop() throws Exception{
			if(isEmpty()){
				throw new Exception("Stack is Empty");
			}
			int data = array[top];
			array[top] = 0;
			top--;
			return data;
		}
		public boolean isEmpty(){
			if(top==-1){
				return true;
			}
			return false;
		}
		public boolean isFull(){
			if(top>=capacity){
				return true;
			}
			return false;
		}
	}
	
	

}
