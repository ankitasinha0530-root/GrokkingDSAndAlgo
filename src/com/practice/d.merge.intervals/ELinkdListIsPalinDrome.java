package com.practice.c.slow.fast.pointers.d.merge.intervals;

;

public class ELinkdListIsPalinDrome {

	static class ListNode{
		int value = 0;
		ListNode next;
		
		ListNode(int value){
			this.value = value;
		}
	}
	
	//A palindrome number is a number that is same after reverse
	// A for a Simple array we can two pointers method 
	// one from strat and one from end iterate and compare the elemnets
	// This is singly Linked List we cannot move backward as the node store address of only next element.
	// we can only move/Iterate backward in doublylinked where each node stores address of both previous and next element.
	
	// refer video - https://www.youtube.com/watch?v=WyI5dXMHW5c
	// refer video - 
	public static void main(String[] args) {
		ListNode head = new ListNode(2);
		head.next = new ListNode(4);
		head.next.next = new ListNode(6);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next =  new ListNode(2);
	//	head.next.next.next.next.next = new ListNode(6);
		
		System.out.println("LinkedList Start of  cycle == " + ELinkdListIsPalinDrome.eLinkdListIsPalinDrome(head));
		System.out.println("LinkedList Start of  cycle V2 == " + ELinkdListIsPalinDrome.eLinkdListIsPalinDromeV2(head));
		
		head.next.next.next.next.next = new ListNode(2);
		System.out.println("LinkedList Start of  cycle == " + ELinkdListIsPalinDrome.eLinkdListIsPalinDrome(head));
		System.out.println("LinkedList Start of  cycle V2 == " + ELinkdListIsPalinDrome.eLinkdListIsPalinDromeV2(head));
		
//		head.next.next.next.next.next.next = head.next.next.next;
//		System.out.println("LinkedList Start of  cycle == " + ELinkdListIsPalinDrome.eLinkdListIsPalinDrome(head));
//		System.out.println("LinkedList Start of  cycle V2 == " + ELinkdListIsPalinDrome.eLinkdListIsPalinDrome(head));
//		
//		head.next.next.next.next.next.next = head;
//		System.out.println("LinkedList Start of  cycle == " + ELinkdListIsPalinDrome.eLinkdListIsPalinDrome(head));
//		System.out.println("LinkedList Start of  cycle V2 == " + ELinkdListIsPalinDrome.eLinkdListIsPalinDrome(head));

	
	}

	private static String eLinkdListIsPalinDrome(ListNode head) {
		// TODO Auto-generated method stub
		return null;
	}

	private static String eLinkdListIsPalinDromeV2(ListNode head) {
		// TODO Auto-generated method stub
		return null;
	}
}
