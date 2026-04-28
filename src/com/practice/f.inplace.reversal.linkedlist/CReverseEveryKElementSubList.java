package com.practice.f.inplace.reversal.linkedlist;

public class CReverseEveryKElementSubList {
	
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
		
		ListNode reversed = CReverseEveryKElementSubList.reverseSubListKEle(head, 3);

		System.out.println();
		System.out.print("Reversed Nodes are = ");
		while(reversed != null) {
			System.out.print(reversed.value + " ");
			reversed = reversed.next;
			}

	}

	private static ListNode reverseSubListKEle(ListNode head, int k) {
		
		if(head == null) {
			return  null;
		}
		
		ListNode current = head;
		ListNode previous = null;
		ListNode next = null;
		int count = k;
		while(current != null && count > 0) {
			next = current.next;
			current.next = previous;
			previous = current;
			current = next;
			count--;
		}
		
		if(current == null && count > 0) {
			current = previous;
			previous = null;
			next = null;
			while(current != null) {
				next = current.next;
				current.next = previous;
				previous = current;
				current = next;
			}
		}
		
		if(count > 0) {
			return previous;
		}else {
			head.next = reverseSubListKEle(current, k);
		}
		return previous;
	}

	

}
