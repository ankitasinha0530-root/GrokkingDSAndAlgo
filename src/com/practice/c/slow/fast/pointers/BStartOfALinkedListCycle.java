package com.practice.c.slow.fast.pointers;

public class BStartOfALinkedListCycle {

	public static void main(String[] args) {

		//Floyd's Loop detection algorithm slow and fast pointers meet at some point
		// refer video = https://www.youtube.com/watch?v=X_kwcctaQ4M
		
				ListNode head = new ListNode(1);
				head.next = new ListNode(2);
				head.next.next = new ListNode(3);
				head.next.next.next = new ListNode(4);
				head.next.next.next.next =  new ListNode(5);
				head.next.next.next.next.next = new ListNode(6);
				
				System.out.println("LinkedList Start of  cycle == " + BStartOfALinkedListCycle.blinkedListHAsCycle(head));
				System.out.println("LinkedList Start of  cycle V2 == " + BStartOfALinkedListCycle.blinkedListHAsCycleV2(head).value);
				
				head.next.next.next.next.next.next = head.next.next;
				System.out.println("LinkedList Start of  cycle == " + BStartOfALinkedListCycle.blinkedListHAsCycle(head));
				System.out.println("LinkedList Start of  cycle V2 == " + BStartOfALinkedListCycle.blinkedListHAsCycleV2(head).value);
				
				head.next.next.next.next.next.next = head.next.next.next;
				System.out.println("LinkedList Start of  cycle == " + BStartOfALinkedListCycle.blinkedListHAsCycle(head));
				System.out.println("LinkedList Start of  cycle V2 == " + BStartOfALinkedListCycle.blinkedListHAsCycleV2(head).value);
				
				head.next.next.next.next.next.next = head;
				System.out.println("LinkedList Start of  cycle == " + BStartOfALinkedListCycle.blinkedListHAsCycle(head));
				System.out.println("LinkedList Start of  cycle V2 == " + BStartOfALinkedListCycle.blinkedListHAsCycleV2(head).value);

	}
	
	private static int blinkedListHAsCycle(ListNode head) {
		int cycleStartVal = 0;
		
		ListNode slow = head;
		ListNode fast = head;
		
		while (fast != null && fast.next != null) {
			fast = fast.next.next;
			slow = slow.next;
			if(fast == slow) {
				System.out.println("true");
				break;
			}
		}	
		if(slow != fast) {
			return -1;
		}
		slow = head; 
		while (slow != fast) {//after detecting the loop move fast by one step only;
			fast = fast.next;
			slow = slow.next;
		}
		cycleStartVal = slow.value;
	return cycleStartVal;
}
	
	private static ListNode blinkedListHAsCycleV2(ListNode head) {

		 int cntElmInCycle = 0;
		 
		 ListNode slow = head;
		 ListNode fast = head;
		 
		 while (fast != null && fast.next != null) {
			 fast = fast.next.next;
			 slow = slow.next;
			 if(slow == fast) {
				 cntElmInCycle = cntElmInCycle(slow);
				 break;
			 }
		 }
		 if(slow != fast) {
				return new ListNode(-1);
			}
		 return firstNodeOfCycle(head, cntElmInCycle);

	}

	private static ListNode firstNodeOfCycle(ListNode head, int cntElmInCycle) {
		ListNode pointer1 = head;
		ListNode pointer2 = head;
		
		while(cntElmInCycle > 0) {
			pointer2 = pointer2.next;
			cntElmInCycle--;
		}
		
		while(pointer1 != pointer2) {
			pointer1 = pointer1.next;
			pointer2 = pointer2.next;
		}
		
		return pointer1;
	}

	private static int cntElmInCycle(ListNode slow) {
		ListNode current = slow;
			
		int cntElmInCycle = 0;

		do{	//Use do while loop here since current is already = slow thus "while loop" will never execute instead use "do while loop"
			current = current.next;
			cntElmInCycle++;
			}while(current != slow);

		System.out.println("cntElmInCycle == " +  cntElmInCycle);
		return cntElmInCycle;
	}

	static class ListNode{
		int value = 0;
		ListNode next;
		
		ListNode(int value){
			this.value = value;
		}
	}
	

}
