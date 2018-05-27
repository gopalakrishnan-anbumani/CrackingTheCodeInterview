package com.program.chapter2;

public class LoopDetection {
	static Node head;

	public static void main(String[] args) {
		head = new Node(1);
		Node node2 = new Node(2);
		head.next = node2;
		Node node3 = new Node(3);
		node2.next = node3;
		Node node4 = new Node(4);
		node3.next = node4;
		Node node5 = new Node(5);
		node4.next = node5;
		Node node6 = new Node(6);
		node5.next = node6;
		Node node7 = new Node(7);
		node6.next = node7;
		Node node8 = new Node(8);
		node7.next = node8;
		Node node9 = new Node(9);
		node8.next = node9;
		node9.next = head;
		detectLoop();
	}

	public static void detectLoop() {

		if (head == null || head.next == null)
			return;
		// Note : First both should point to the Head
		Node slow = head;
		Node fast = head;
		// Continue: Then It should move by 1 step and 2 step.
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast) {
				System.out.println("This is the loop");
				System.out.println("Meething Point :");
				System.out.println("             " + slow.data + " reference "
						+ slow);
				System.out.println("             " + fast.data + " reference "
						+ fast);
				break;
			}

		}
		if (fast == null || fast.next == null) {
			System.out.println("There is No loop");
		}
		slow = head;
		while (slow != fast) {
			slow = slow.next;
			fast = fast.next;
		}

		System.out.println("Loop start Point is :");
		System.out.println(slow.data + " reference is " + slow);

	}

	public static void printList(Node nn) {
		Node n = nn;
		while (n != null) {
			System.out.print(n.data + " ");
			n = n.next;
		}
		System.out.println();
	}

}
