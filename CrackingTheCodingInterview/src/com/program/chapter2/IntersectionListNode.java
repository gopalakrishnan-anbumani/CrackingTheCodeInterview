package com.program.chapter2;

public class IntersectionListNode {
	
	static Node head;
	static Node head1;
	public static void main(String[] args) {
		
		//Head 1 3 5     
		//             > 6 7 8
		//Head 2 4
		head = new Node(1);
		Node list1node1 = new Node(3);
		head.next = list1node1;
		Node list1node2 = new Node(5);
		list1node1.next = list1node2;
		
		head1 = new Node(2);
		Node list2node1 = new Node(4);
		head1.next = list2node1;
		Node list2node2 = new Node(5);
		list2node1.next = list2node2;
	
		//Node common1 = new Node(6);
		Node common2 = new Node(7);
		//common1.next = common2;
		Node common3 = new Node(8);
		common2.next = common3;

		list1node2.next = common2;
		list2node2.next = common2;
		
		
		usingNormal(head,head1);

	}
	
	public static void usingNormal(Node list1, Node list2){
		Node l1 = list1;
		int length1=1;
		while(l1.next!=null){
			length1++;
			l1=l1.next;
		}
		Node l2 = list2;
		int length2=1;
		while(l2.next!=null){
			length2++;
			l2=l2.next;
		}
		if(l1!=l2){
			System.out.println("This Nodes are not intersecting");
			return;
		}
		Node min = list1;
		Node max = list2;
		if(length1>length2){
			max = list1;
			min = list2;
			
		}
		int diff = Math.abs(length1-length2);
		while(diff!=0){
			max = max.next;
			diff--;
		}
		//The Below Comments Line Taken From Book
//		while(diff!=0 && max !=null){
//			max = max.next;
//			diff--;
//		}
		while(min!=null){
			if(max==min){
				System.out.println("InterSection Found ");
				System.out.println("Reference : "+min +" = "+max);
				System.out.println("Value : "+min.data+" = "+max.data);
				break;
			}
			max = max.next;
			min = min.next;
		}
		//The Below Comments Line Taken From Book
//		while(min!=max){
//			max = max.next;
//			min = min.next;
//		}
//		System.out.println("Reference : "+min +" = "+max);
		
	}
	
	public static void printList(Node nn){
		Node n = nn;
		while(n!=null){
			System.out.print(n.data+" ");
			n=n.next;
		}
		System.out.println();
	}

}
