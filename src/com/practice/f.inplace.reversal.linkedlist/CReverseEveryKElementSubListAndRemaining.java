package com.practice.f.inplace.reversal.linkedlist;

public class CReverseEveryKElementSubListAndRemaining {
	
	// refer - video = https://www.youtube.com/watch?v=IsD4Fo1K85Q
	//Refer video = https://www.youtube.com/watch?v=nYHOtT1Tdns

	public static void main(String[] args) {
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
		
		ListNode reversed = CReverseEveryKElementSubListAndRemaining.reverseSubList(head, 3);
		System.out.println();
		System.out.print("Reversed Nodes are = ");
		while(reversed != null) {
			System.out.print(reversed.value + " ");
			reversed = reversed.next;
			}
		
		System.out.println();
		System.out.println("For Version2");
		
		ListNode head1 = new ListNode(1);
		head1.next = new ListNode(2);
		head1.next.next = new ListNode(3);
		head1.next.next.next= new ListNode(4);
		head1.next.next.next.next = new ListNode(5);
		head1.next.next.next.next.next = new ListNode(6);
		head1.next.next.next.next.next.next = new ListNode(7);
		head1.next.next.next.next.next.next.next = new ListNode(8);
		

		ListNode reversed1 = CReverseEveryKElementSubListAndRemaining.reverseSubListV2(head1, 3);
		System.out.println();
		System.out.print("Reversed Nodes are = ");
		while(reversed1 != null) {
			System.out.print(reversed1.value + " ");
			reversed1 = reversed1.next;
			}

	}

	private static ListNode reverseSubListV2(ListNode head, int k) {

		if(head == null) {
			return  null;
		}
		
		ListNode current = head;
		ListNode previous = null;
		ListNode next = null;
		int count = k;

		while(current != null && count > 0) {
			System.out.print(current.value + " ");
			next = current.next;
			current.next = previous;
			previous = current;
			current = next;
			count--;
		}
		
		head.next = reverseSubListV2(current, k);

		return previous;
	}

	private static ListNode reverseSubList(ListNode head, int k) {

		if(head == null && head.next == null && k <= 1) {
			return  head;
		}
		
		ListNode current = head;
		ListNode previous = null;
		
		while(true) {
			ListNode futureLastElementOfFirstList = previous;
			ListNode futureLastElementOfSublist = current;
			ListNode next = null;
			
			
			for(int i = 0; current != null && i < k ; i++) {
				
				next = current.next;
				current.next = previous;
				previous = current;
				current = next;
				
			}
			
			if(futureLastElementOfFirstList != null) {
				futureLastElementOfFirstList.next = previous;
			}else {
				head = previous;
			}
			
			futureLastElementOfSublist.next = current;
			
			if(current == null) {
				break;
			}
			
			previous = futureLastElementOfSublist;
		
		}
		return head;
	}

}
