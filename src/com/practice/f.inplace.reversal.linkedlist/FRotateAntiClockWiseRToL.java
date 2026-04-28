package com.practice.f.inplace.reversal.linkedlist;

public class FRotateAntiClockWiseRToL {

	public static void main(String[] args) {

		// Refer Video = https://www.youtube.com/watch?v=IMCCmLkO7o0
		// clockwise is from right to left
		
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next= new ListNode(4);
		head.next.next.next.next = new ListNode(5);
		head.next.next.next.next.next = new ListNode(6);
		head.next.next.next.next.next.next = new ListNode(7);
		head.next.next.next.next.next.next.next = new ListNode(8);
		
		ListNode printMain = head;
		System.out.print("Main List = ");
		while(printMain != null) {
			System.out.print(printMain.value + " ");
			printMain = printMain.next;
			}
		
		ListNode reversed = FRotateAntiClockWiseRToL.rotateListAnti(head, 18);
		System.out.println();
		System.out.print("Reversed Nodes are = ");
		while(reversed != null) {
			System.out.print(reversed.value + " ");
			reversed = reversed.next;
		}
		System.out.println();
		ListNode head1 = new ListNode(12);
		head1.next = new ListNode(99);
		head1.next.next = new ListNode(37);
		head1.next.next.next= new ListNode(8);
		head1.next.next.next.next = new ListNode(18);
//		head1.next.next.next.next.next = new ListNode(6);
//		head1.next.next.next.next.next.next = new ListNode(7);
//		head1.next.next.next.next.next.next.next = new ListNode(8);
		
		ListNode reversedV2 = FRotateAntiClockWiseRToL.rotateListAnti(head1, 2);
		System.out.println();
		System.out.print("Reversed Nodes v2 are = ");
		while(reversedV2 != null) {
			System.out.print(reversedV2.value + " ");
			reversedV2 = reversedV2.next;
			}

	}

	private static ListNode rotateListAnti(ListNode head, int k) {

		if(head == null && k <= 1) return head;
		
		ListNode curr = head;
		int len = 1;
		
		while(curr.next != null) {
			curr = curr.next;
			len++;
		}
		
		k = k%len;
//		k = len - k;   // for Anticlockwise rotation we don't need this step
		
		if(k == 0) return head;
		
		curr.next = head;
//		int i = 0;
//		while(i > k) {
		while(k > 0) {
			curr = curr.next;
			k--;
		}
		
		head = curr.next;
		curr.next = null;
		
		return head;
	}

}
