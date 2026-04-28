package com.practice.f.inplace.reversal.linkedlist;

class ListNode{
	int value;
	ListNode next;
	
	public ListNode(int value) {
		this.value = value;
	}
}

public class AReverseLinkedList {
	
	private static ListNode reverse(ListNode head) {
		ListNode current = head; // current node that will be processing
		ListNode prev = null; // previous node that we have processed
		ListNode next = null; // will be used to temporarily store the next node
		
		while(current != null) {
			next = current.next; // temporarily store the next node which is cuurent.next
			current.next = prev; // reverse the current node by putting previous in current.next
			prev = current; // before we move to the next node, point previous to the current node
			current = next; // move on to the next node to process, which is the next we saved earlier
		}
		return prev;
	}

	public static void main(String[] args) {
		ListNode head = new ListNode(2);
		head.next = new ListNode(4);
		head.next.next = new ListNode(6);
		head.next.next.next= new ListNode(8);
		head.next.next.next.next = new ListNode(10);
		
		ListNode printMain = head;
		while(printMain != null) {
			System.out.print(printMain.value + " ");
			printMain = printMain.next;
			}
		
		ListNode reversed = AReverseLinkedList.reverse(head);
		System.out.println();
		System.out.print("Reversed Nodes are = ");
		while(reversed != null) {
			System.out.print(reversed.value + " ");
			reversed = reversed.next;
			}
	}

}
