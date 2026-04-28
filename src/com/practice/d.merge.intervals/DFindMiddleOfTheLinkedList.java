package com.practice.c.slow.fast.pointers.d.merge.intervals;

public class DFindMiddleOfTheLinkedList {
	
	static class ListNode{
		int value = 0;
		ListNode next;
		
		ListNode(int value){
			this.value = value;
		}

	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next =  new ListNode(5);
		
		System.out.println("LinkedList Start of  cycle == " + DFindMiddleOfTheLinkedList.dFindMiddleOfTheLinkedList(head).value);
		System.out.println("LinkedList Start of  cycle V2 == " + DFindMiddleOfTheLinkedList.dFindMiddleOfTheLinkedListV2(head).value);
		
		head.next.next.next.next.next = new ListNode(6);
		
		System.out.println("LinkedList Start of  cycle == " + DFindMiddleOfTheLinkedList.dFindMiddleOfTheLinkedList(head).value);
		System.out.println("LinkedList Start of  cycle V2 == " + DFindMiddleOfTheLinkedList.dFindMiddleOfTheLinkedListV2(head).value);
		
		head.next.next.next.next.next.next = new ListNode(7);
		
		System.out.println("LinkedList Start of  cycle == " + DFindMiddleOfTheLinkedList.dFindMiddleOfTheLinkedList(head).value);
		System.out.println("LinkedList Start of  cycle V2 == " + DFindMiddleOfTheLinkedList.dFindMiddleOfTheLinkedListV2(head).value);
		
		head.next.next.next.next.next.next.next = new ListNode(8);
		
		System.out.println("LinkedList Start of  cycle == " + DFindMiddleOfTheLinkedList.dFindMiddleOfTheLinkedList(head).value);
		System.out.println("LinkedList Start of  cycle V2 == " + DFindMiddleOfTheLinkedList.dFindMiddleOfTheLinkedListV2(head).value);
		
	}

}
	// Using Hare and Tortoise Algorithm, To find middle of the list
	//when fast reaches end of the list 
	//then Slow reaches till middle of the list and thus, return slow
	public static ListNode dFindMiddleOfTheLinkedList(ListNode head) {
		ListNode slow = head;
		ListNode fast = head;
		
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		
		return slow;
	}

	//We can also two pointers to solve the problem
	public static ListNode dFindMiddleOfTheLinkedListV2(ListNode head) {
		ListNode slow = head;
		ListNode fast = head;
		
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		
		return slow;
	}
}
