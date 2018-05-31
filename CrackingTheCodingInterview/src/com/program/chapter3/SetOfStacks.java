package com.program.chapter3;

import java.util.ArrayList;
import java.util.List;

import com.sun.xml.internal.bind.v2.TODO;



public class SetOfStacks {
	
	int threshold;
	List<StackClass> setOfStacks;
	
	public static void main(String[] args) {
		SetOfStacks stacks = new SetOfStacks(3);
		stacks.push(1);
		stacks.push(2);
		stacks.push(3);
		
		stacks.push(4);
		stacks.push(5);
		stacks.push(6);
		
	}
	
	public SetOfStacks(int capacity){
		threshold = capacity;
		setOfStacks = new ArrayList<SetOfStacks.StackClass>();
		setOfStacks.add(new StackClass(threshold));
	}
	
	public void push(int data){
		System.out.println(setOfStacks.size());
		StackClass stackClass = setOfStacks.get(setOfStacks.size()-1);
		if(stackClass.isFull()){
			setOfStacks.add(new StackClass(threshold));
			stackClass = setOfStacks.get(setOfStacks.size()-1);
		}
		stackClass.push(data);
	}
	//TODO when you removed last element from on stack. Make sure to delete that stack from list  
	public int pop(){
		StackClass stackClass = setOfStacks.get(setOfStacks.size()-1);
		int data = 0;
		try {
			data = stackClass.pop();
		} catch (Exception e) {
			System.out.println();
		}
		return data;
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
		public void push(int data){
			if(isFull()){
				System.out.println("It is Full");
				return;
			}
			System.out.println(data+" is inserted in array "+this);
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
			if(top==capacity-1){
				return true;
			}
			return false;
		}
	}
	
	

}
