package com.practice.f.inplace.reversal.linkedlist;

public class DReverseAltKElementSublist {

	public static void main(String[] args) {
		// Refer video = https://www.youtube.com/watch?v=83YOU4HTQ5I
		// Refer video = https://www.youtube.com/watch?v=83YOU4HTQ5I&t=6s
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next= new ListNode(4);
		head.next.next.next.next = new ListNode(5);
		head.next.next.next.next.next = new ListNode(6);
		head.next.next.next.next.next.next = new ListNode(7);
		head.next.next.next.next.next.next.next = new ListNode(8);
		
		ListNode printMain = head;
		while(printMain != null) {
			System.out.print(printMain.value + " ");
			printMain = printMain.next;
			}
		
		ListNode reversed = DReverseAltKElementSublist.reverseSubList(head, 2);
		System.out.println();
		System.out.print("Reversed Nodes are = ");
		while(reversed != null) {
			System.out.print(reversed.value + " ");
			reversed = reversed.next;
			}
		
		System.out.println();
		
		ListNode head1 = new ListNode(1);
		head1.next = new ListNode(2);
		head1.next.next = new ListNode(3);
		head1.next.next.next= new ListNode(4);
		head1.next.next.next.next = new ListNode(5);
		head1.next.next.next.next.next = new ListNode(6);
		head1.next.next.next.next.next.next = new ListNode(7);
		head1.next.next.next.next.next.next.next = new ListNode(8);
		
		ListNode reversedV2 = DReverseAltKElementSublist.reverseSubListV2(head1, 2);
		System.out.println();
		System.out.print("Reversed Nodes v2 are = ");
		while(reversedV2 != null) {
			System.out.print(reversedV2.value + " ");
			reversedV2 = reversedV2.next;
			}
		
		System.out.println();
		

	}

	private static ListNode reverseSubListV2(ListNode head, int k) {
		if(head == null || k <= 1 )
			return head;
		
		ListNode curr = head, prev = null, next = null;
		int i = 0;
		
		while(curr != null && i < k) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
			i++;
		}
		
		i = 0;
		
		if(next != null) {
			head.next = next;
			curr = next;
			while(curr != null && i < k-1) {
				curr = curr.next;
			}
			if(curr != null) {
				curr.next = reverseSubListV2(curr.next, 2); // using recurssion
			}
		}
		
		return prev;
	}

	private static ListNode reverseSubList(ListNode head, int k) {
		if(head == null || k <= 1 )
		return head;
		
		ListNode previous = null;
		ListNode current = head;
		
		while(true) {
			
			ListNode futureLastNodeOfFirstList = previous;
			ListNode futureLastNodeOfNextList = current;
			ListNode next = null;
			
			for(int i = 0; current != null && i < k; i++) {
				
				next = current.next;
				current.next = previous;
				previous = current;
				current = next;
			}
			
			if(futureLastNodeOfFirstList != null) {
				futureLastNodeOfFirstList.next = previous;
			}else {
				head = previous;
			}
			
			futureLastNodeOfNextList.next = current;
			
			for(int i = 0; current != null && i < k ; ++i) {
				previous = current;
				current = current.next;
			}
			
			if(current == null) {
				break;
			}
		}
		return head;
	}

}
