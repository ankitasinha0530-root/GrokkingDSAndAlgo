package com.practice.n.k.way.merge;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

class Node{
	int arrIdx;
	int eleIdx;
	
	public Node(int arrIdx, int eleIdx) {
		this.arrIdx = arrIdx;
		this.eleIdx = eleIdx;
	}
}

public class BKthSmallestElementInMSortedList {

	public static void main(String[] args) {
		Integer[] l1 = new Integer[]{2, 6, 8};
		Integer[] l2 = new Integer[]{3, 6, 7};
		Integer[] l3 = new Integer[]{1, 3, 4};
		List<Integer[]> lists = new ArrayList<>();
		lists.add(l1);
		lists.add(l2);
		lists.add(l3);
		System.out.println(BKthSmallestElementInMSortedList.kthSmallestElementInMSortedList(lists, 5));
	}

	private static int kthSmallestElementInMSortedList(List<Integer[]> lists, int k) {
		
	//	define a minHeap using priority Queue to accept node element sorted based on each element
		
		PriorityQueue<Node> minHeap = 
				new PriorityQueue<Node>((n1, n2) -> lists.get(n1.arrIdx)[n1.eleIdx] - lists.get(n2.arrIdx)[n2.eleIdx]);

	//	since all the lists are sorted add 1st element of each array
	//	int arrIdx;
	//	int eleIdx;
		
		for (int i = 0; i < lists.size(); i++) {
			if(lists.get(i) != null) {
				minHeap.add(new Node(i, 0));
			}
		}
		int result = 0, numCount = 0;
		while(!minHeap.isEmpty()) {
			Node node = minHeap.poll();
			result = lists.get(node.arrIdx)[node.eleIdx];
			numCount++;
			if(numCount == k) {
				break;
			}
			node.eleIdx++;
			if(lists.get(node.arrIdx).length > node.eleIdx) {
				minHeap.add(node);
			}
		}
		return result;
	}

}
