package com.practice.n.k.way.merge;

import java.util.PriorityQueue;

class ListNode{
	int val;
	ListNode next;
	
	public ListNode(int val){
		this.val = val;
	}
}

public class AMergeKSortedLists {
	
	private static ListNode mergeSortedLists(ListNode[] lists) {
		PriorityQueue<ListNode> minHeap = new PriorityQueue<ListNode>((n1, n2) -> n1.val - n2.val);
		
		ListNode resultHead = null;
		ListNode resultTail = null;
		
		for(ListNode root : lists) {
			minHeap.offer(root);
		}
		
		while(!minHeap.isEmpty()) {
			ListNode node = minHeap.poll(); 

			if(resultHead == null) {   // if no result element  then resultHead and resultTail will point to the same element
				resultHead = resultTail = node;
			}else {
				resultTail.next = node; //else add element to the next of current resultTAil and resulTail will become the next element added
	//			resultTail = node;
				resultTail = resultTail.next;
			}
			
			if(node.next != null) {   // if currentNode.next ! = null then add the next node to minHeap
				minHeap.add(node.next);
			}
		}
		
		return resultHead;
	}
	
	public static void main(String[] args) {

		ListNode l1 = new ListNode(2);
		l1.next = new ListNode(6);
		l1.next.next = new ListNode(8);
		
		ListNode l2 = new ListNode(3);
		l2.next = new ListNode(6);
		l2.next.next = new ListNode(7);
		
		ListNode l3 = new ListNode(1);
		l3.next = new ListNode(3);
		l3.next.next = new ListNode(4);
		

		ListNode result = AMergeKSortedLists.mergeSortedLists(new ListNode [] {l1, l2, l3});
		
		System.out.println("Elements from k sorted Merged lists = ");
		while (result != null) {
			System.out.print(result.val + " ");
			result = result.next;
		}
		System.out.println();
	}

}
