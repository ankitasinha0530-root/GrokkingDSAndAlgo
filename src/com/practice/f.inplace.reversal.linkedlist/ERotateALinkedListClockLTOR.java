package com.practice.f.inplace.reversal.linkedlist;

public class ERotateALinkedListClockLTOR {

	public static void main(String[] args) {
		// Refer Video = https://www.youtube.com/watch?v=9VPm6nEbVPA
		// clockwise is from left to right
		
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next= new ListNode(4);
		head.next.next.next.next = new ListNode(5);
		head.next.next.next.next.next = new ListNode(6);
		head.next.next.next.next.next.next = new ListNode(7);
		head.next.next.next.next.next.next.next = new ListNode(8);
		
		ListNode printMain = head;
		System.out.print("Main Lis = ");
		while(printMain != null) {
			System.out.print(printMain.value + " ");
			printMain = printMain.next;
			}
		
		ListNode reversed = ERotateALinkedListClockLTOR.rotateList(head, 18);
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
		
		ListNode reversedV2 = ERotateALinkedListClockLTOR.rotateList(head1, 2);
		System.out.println();
		System.out.print("Reversed Nodes v2 are = ");
		while(reversedV2 != null) {
			System.out.print(reversedV2.value + " ");
			reversedV2 = reversedV2.next;
			}		
	}

	private static ListNode rotateList(ListNode head, int k) {

		if(head == null && k <= 1) {
			return head;
		}
		
		int len = 1;
		ListNode curr = head;
		
		while(curr.next != null) {
			curr = curr.next;
			++len;
		}
		
		curr.next = head;
		
		k = k % len;  // extract the remainder, this is the number of elements that will be rotated
		k = len - k; // kth element position will be the last node, we need this for clockwise rotation
		
		if(k == 0) return head;
		while(k > 0) {
			curr = curr.next; // move to kth element
			k--;
		}
		
		head = curr.next; // kth next element will be the head
		curr.next = null; // add null to kth elemnt's next
		
		return head;
	}
	
	public int getSizeOfList(ListNode node) {
		
		if(node == null)
		return 0;
		
		return getSizeOfList(node.next) + 1;
	}

	public static ListNode rotateListAnti(ListNode head, int i) {
		// TODO Auto-generated method stub
		return null;
	}
}
