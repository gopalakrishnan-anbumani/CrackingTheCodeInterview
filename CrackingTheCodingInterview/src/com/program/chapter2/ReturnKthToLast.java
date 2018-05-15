package com.program.chapter2;

public class ReturnKthToLast {
	static Node head;
	@SuppressWarnings("static-access")
	public static void main(String[] args) {
		SingleLinkedList list = new SingleLinkedList();
		list.addNode(1);
		list.addNode(2);
		list.addNode(3);
		list.addNode(4);
		list.addNode(5);
		head = list.head;
		findKthNode(3);
		findKthNodeRecursive(head,3);
		findKthNode1(3);
		
	}
	public static void findKthNode(int k){
		int count = 0;
		Node n = head;
		Node slow = null;
		while(n!=null){
			count++;
			if(count==k){
				slow = head;
			}
			n=n.next;
			if(slow!=null && n!=null) slow=slow.next;
		}
		if(slow!=null){
			System.out.println("Kth Element "+slow.data);
		}else{
			System.out.println("Element in the List is lesser than K");
		}
	}
	/**
	 * Solution in Book
	 */
	public static void findKthNode1(int k){
		Node p1 = head;
		Node p2 = head;
		for(int i=0;i<k;i++){
			if(p1==null){
				System.out.println("Element in the List is lesser than K");
				return;
			}
			p1=p1.next;
		}
		while(p1!=null){
			p1 = p1.next;
			p2 = p2.next;
		}
		System.out.println("Element "+p2.data);
	}
	
	public static int findKthNodeRecursive(Node head,int k){
		if(head==null){
			return 0;
		}
		int index = findKthNodeRecursive(head.next, k)+1;
		if(index == k){
			System.out.println("Kth Elemrnt (Recursive) "+head.data);
			return head.data;
		}
		return index;
	}

}
