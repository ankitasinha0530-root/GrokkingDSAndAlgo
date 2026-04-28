package com.practice.f.inplace.reversal.linkedlist;

public class BReverseASubList {

	public static void main(String[] args) {
		
		// Refer Video = https://www.youtube.com/watch?v=oDL8vuu2Q0E
		// Refer video = https://www.youtube.com/watch?v=JmC79B7-Eho

		// 1. Skip the first p-1 nodes, to reach the node at position p.
		// 2. Remember the node at position p-1 to be used later to connect with the reversed sub-list.
		// 3. Next, reverse the nodes from p to q using the same approach discussed in Reverse a LinkedList.
		// 4. Connect the p-1 and q+1 nodes to the reversed sub-list.
		
		ListNode head = new ListNode(2);
		head.next = new ListNode(6);
		head.next.next = new ListNode(4);
		head.next.next.next= new ListNode(3);
		head.next.next.next.next = new ListNode(9);
		head.next.next.next.next.next = new ListNode(8);
		head.next.next.next.next.next.next = new ListNode(5);
		
		ListNode printMain = head;
		while(printMain != null) {
			System.out.print(printMain.value + " ");
			printMain = printMain.next;
			}
		
		ListNode reversed = BReverseASubList.reverseSubList(head, 2, 5);
		System.out.println();
		System.out.print("Reversed Nodes are = ");
		while(reversed != null) {
			System.out.print(reversed.value + " ");
			reversed = reversed.next;
			}
	}

	public static ListNode reverseSubList(ListNode node, int p, int q) {

		if(node == null && node.next == null && p <= q && p < 1 && q < 1){
			return node;
		}
		
		ListNode current = node;
		ListNode previous = null;
		
		for (int i = 0; current != null && i < p-1; i++) {
			previous = current;
			current = current.next;
		}
		
		ListNode lastNodeOfFirstPart = previous;
		ListNode futureLAstNodeOfSecndPart = current;
		ListNode next = null;
		
		for(int i =0;  current != null && i < q-p+1; i++) {
			next = current.next;        
			current.next = previous;
			previous = current;
			current = next;
		}
		
		if(lastNodeOfFirstPart != null) {
			lastNodeOfFirstPart.next = previous;
		}else {
			node = previous;
		}
		
		futureLAstNodeOfSecndPart.next = current;

		return node;
	}
}
