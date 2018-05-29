package com.program.chapter3;

public class OneArrayThreeStack {
	
	int[] array;
	int top1;
	int top2;
	int top3;

	public static void main(String[] args) {
		OneArrayThreeStack stack = new OneArrayThreeStack();
		
		for (int i = 0; i < 11; i++) {
			stack.pushOne(i);
		}
		
		for (int i = 0; i < 5; i++) {
			stack.pushTwo(i);
		}
		for (int i = 0; i < 7; i++) {
			stack.popTwo();
		}
		for (int i = 0; i < 7; i++) {
			stack.pushThree(i);
		}
		
		for (int i = 0; i < 30; i++) {
			System.out.print(stack.array[i]);
		}
	}
	
	public OneArrayThreeStack() {
		array = new int[30];
		top1 = -1;
		top2 = array.length/3-1;
		top3 = array.length/3+array.length/3-1;
	}
	
	public void pushOne(int data){
		int start = 0;
		int end = array.length/3-1;
		
		if(top1>=end){
			System.out.println("Array is Full");
			return;
		}
		top1++;
		array[top1]=data;
		System.out.println(data +" pushed -> arr1");
	}
	public void pushTwo(int data){
		int start = array.length/3;
		int end = (array.length/3+array.length/3)-1;
		
		if(top2>=end){
			System.out.println("Array is Full");
			return;
		}
		top2++;
		array[top2]=data;
		System.out.println(data +" pushed -> arr2");
	}
	public void pushThree(int data){
		int start = (array.length/3+array.length/3);
		int end = array.length-1;
		if(top3>=end){
			System.out.println("Array is Full");
			return;
		}
		top3++;
		array[top3]=data;
		System.out.println(data +" pushed -> arr3");
	}
	public boolean isEmptyOne(){
		return top1==-1;
	}
	public boolean isEmptyTwo(){
		return top2==(array.length/3-1);
	}
	public boolean isEmptyThree(){
		return top2==(array.length/3+array.length/3)-1;
	}
	public int popOne(){
		if(isEmptyOne()){
			System.out.println("Arrayone  is empty");
			return -1;
		}
		int data = array[top1];
		array[top1] = 0;
		top1--;
		System.out.println(data +" poped -> arr1");
		return data;
	}
	public int popTwo(){
		if(isEmptyTwo()){
			System.out.println("Array two is empty");
			return -1;
		}
		int data = array[top2];
		array[top2] = 0;
		top2--;
		System.out.println(data +" poped -> arr2");
		return data;
	}
	public int popThree(){
		if(isEmptyThree()){
			System.out.println("Array three is empty");
			return -1;
		}
		int data = array[top3];
		array[top3] = 0;
		top3--;
		System.out.println(data +" poped -> arr3");
		return data;
	}
	
}
