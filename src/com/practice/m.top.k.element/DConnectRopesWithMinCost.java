package com.practice.m.top.k.element;

import java.util.PriorityQueue;

public class DConnectRopesWithMinCost {

	public static void main(String[] args) {

		System.out.println("Min cost = " + DConnectRopesWithMinCost.connectRopesWithMinCost(new int[] {1, 3, 11, 5 }));
		System.out.println("Min cost = " + DConnectRopesWithMinCost.connectRopesWithMinCost(new int[] {3, 4, 5, 6}));
		System.out.println("Min cost = " + DConnectRopesWithMinCost.connectRopesWithMinCost(new int[] {1, 3, 11, 5, 2}));

	}

	private static int connectRopesWithMinCost(int[] arr) {

		PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>((i1, i2) -> i1 - i2);

		for (int i = 0; i < arr.length; i++) {
			minHeap.offer(arr[i]);
		}
		
		// Go through the values of the heap, in each step take top (lowest) rope lengths from the min heap
		// connect them and push the result back to the min heap.
		// keep doing this untill the heap is left with only one rope.
		
		int result = 0, temp = 0; // keep looping untill the heap is left with only one rope
		while(minHeap.size() > 1) {
			temp = minHeap.poll() + minHeap.poll();
			result += temp;
			minHeap.add(temp);	 // connect the ropes and push the result back to minHeap
		}
		return result;
	}

}
