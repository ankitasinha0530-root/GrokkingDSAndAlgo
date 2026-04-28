package com.practice.m.top.k.element;

import java.util.PriorityQueue;

public class GFindKthLargestAftrAddEachElemnt {
	
	PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>((i1, i2) -> i1 - i2);
	int k;
	
	// create a constructor to take input as arry of numbers and k
	// find the Kth Largest number everytime we add an element to stream
	
	public GFindKthLargestAftrAddEachElemnt(int[] nums, int k) {
		this.k=k;
		for (int i = 0; i < nums.length; i++) {
			add(nums[i]);
		}
		
	}
	
	private int add(int num) {

		minHeap.add(num);
		
		if(minHeap.size() > k) {
			minHeap.poll();
		}
		return minHeap.peek();
		
	}

	public static void main(String[] args) {
		
		int[] input = new int[] {5, 12, 11, 3, 11};
		GFindKthLargestAftrAddEachElemnt kthLargest = new GFindKthLargestAftrAddEachElemnt(input, 3);
		System.out.println("3rd largest element == " + kthLargest.add(7));
		System.out.println("3rd largest element == " + kthLargest.add(14));
		System.out.println("3rd largest element == " + kthLargest.add(18));
	}

}
