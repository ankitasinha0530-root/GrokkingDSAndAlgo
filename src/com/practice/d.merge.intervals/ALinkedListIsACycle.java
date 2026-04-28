package com.practice.c.slow.fast.pointers.d.merge.intervals;

public class ALinkedListIsACycle {
	
	static class ListNode {           // Always make LisNode class as Static
		int value = 0;
		ListNode next;
	
		ListNode(int value){
			this.value = value;
		}
	}

	public static void main(String[] args) {
		
		//Floyd's Loop detection algorithm is used with fast and slow pointers
			
		ListNode head ;
		head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next =  new ListNode(5);
		head.next.next.next.next.next = new ListNode(6);
		
		System.out.println("LinkedList has a cycle == " + ALinkedListIsACycle.linkedListHAsCycle(head));
		
		head.next.next.next.next.next = head.next.next;
		System.out.println("LinkedList has a cycle == " + ALinkedListIsACycle.linkedListHAsCycle(head));
		
		head.next.next.next.next.next.next = head.next.next.next;
		System.out.println("LinkedList has a cycle == " + ALinkedListIsACycle.linkedListHAsCycle(head));
		
	}
	
	private static boolean linkedListHAsCycle(ListNode head) {
		ListNode fast = head;
		ListNode slow = head;
		
		while(fast != null && fast.next != null) {
			fast = fast.next.next;
			slow = slow.next;
			if(fast == slow)
				return true;
		}
		
		return false;
	}

	
}
