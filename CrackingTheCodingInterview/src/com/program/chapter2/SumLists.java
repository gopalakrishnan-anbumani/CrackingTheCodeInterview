package com.program.chapter2;

public class SumLists {

	static Node head1;
	static Node head2;
	
	public static void main(String[] args) {
		SingleLinkedList list = new SingleLinkedList();
		list.addNode(7);
		list.addNode(1);
		list.addNode(6);
		//list.addNode(4);
		//list.addNode(5);
		head1 = list.head;
		SingleLinkedList list1 = new SingleLinkedList();
		list1.addNode(5);
		list1.addNode(9);
		list1.addNode(2);
		//list1.addNode(4);
		//list1.addNode(5);
		head2 = list1.head;
		sumTwoListMethod1();
		
	}
	//This Method will print sum of the two list ex: 1->2->3  and 6->7->5  = 7->9->8
	public static void sumTwoListMethod1(){
		int carry = 0;
		
		int digitOne;
		int digitTwo;
		int total;
		Node oneLists = head1;
		Node twoLists = head2;
		Node result=null;
		Node head3 = null;
		while(oneLists!=null || twoLists!=null){
			digitOne = (oneLists!=null) ? oneLists.data : 0;
			digitTwo = (twoLists!=null) ? twoLists.data : 0;
			
			total = digitOne+digitTwo+carry;
			
			int singleTotal = total % 10;
			if(result==null){
				result = new Node(singleTotal);
				head3 = result;
			}else{
				result.next = new Node(singleTotal);
				result = result.next;
			}
			carry = total / 10;
			oneLists = (oneLists!=null) ? oneLists.next : null;
			twoLists = (twoLists!=null) ? twoLists.next : null;
		}
		if(carry!=0){

			result.next = new Node(carry);
			result = result.next;
		}
		
		while(head3!=null){
			System.out.print(head3.data+" ");
			head3 = head3.next;
		}
		
	} 
	
	// This Method will print sum of the two list ex: 1->2->3 (321) and 6->7->5 (576) = 897 (Out in forward order Integer)  
	public static void sumTwoListMethod2(){
		
		int carry = 0;
		int place = 1;
		int digitOne;
		int digitTwo;
		int total;
		int sum = 0;
		Node oneLists = head1;
		Node twoLists = head2;
		while(oneLists!=null || twoLists!=null){
			digitOne = (oneLists!=null) ? oneLists.data : 0;
			digitTwo = (twoLists!=null) ? twoLists.data : 0;
			System.out.println(digitOne+" "+digitTwo);
			total = digitOne+digitTwo;
			
			int singleTotal = total % 10;
			
			sum = sum + ((singleTotal+carry)*place);
			carry = total / 10;
			place*=10;
			
			oneLists = (oneLists!=null) ? oneLists.next : null;
			twoLists = (twoLists!=null) ? twoLists.next : null;
		}
		if(carry!=0){
			sum = sum + (carry*place);
		}
		System.out.println(sum);
		
	}

}
