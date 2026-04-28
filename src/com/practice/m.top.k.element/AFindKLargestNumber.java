package com.practice.m.top.k.element;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class AFindKLargestNumber {
	
	// Any problem that asks us to find the top/smallest/frequent ‘K’ elements among a given set falls under this pattern.

	// The best data structure that comes to mind to keep track of ‘K’ elements is Heap. 
	// This pattern will make use of the Heap to solve multiple problems dealing with ‘K’ elements at a time from a set of given elements.

	public static void main(String[] args) {

		System.out.println("value = " + AFindKLargestNumber.findKLargestNumber(new int[] {3, 1, 5, 12, 2, 11 }, 3));
		System.out.println("value = " + AFindKLargestNumber.findKLargestNumber(new int[] {3, 1, 5, 12, 2, 11 }, 4));
		System.out.println("value = " + AFindKLargestNumber.findKLargestNumber(new int[] {5, 12, 11, -1, 12}, 3));
		System.out.println("value = " + AFindKLargestNumber.findKLargestNumber(new int[] {3, 5, 0, 1, 6, 4, 7, 2, 9}, 3));
		System.out.println("value = " + AFindKLargestNumber.findKLargestNumberV2(new int[] {3, 1, 5, 12, 2, 11 }, 4));

	}

	private static List<Integer> findKLargestNumber(int[] arr, int k) {

		PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>((i1, i2) -> i1 - i2);
		
		for (int i = 0; i <= k-1; i++) {
			minHeap.offer(arr[i]);
		}
		for (int j = k; j < arr.length; j++) {
			if(minHeap.peek() < arr[j]) {
				minHeap.poll();
				minHeap.add(arr[j]);  
			
			}
		}
		return new ArrayList<>(minHeap);
	}
	

	private static List<Integer> findKLargestNumberV2(int[] arr, int k) {

	PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>((i1, i2) -> i1 - i2);
	
		for (int i = 0; i <= arr.length-1; i++) {
			if(minHeap.size() == k) {
				if(minHeap.peek() < arr[i]) {
					minHeap.poll();
					minHeap.add(arr[i]);  
				
				}
			}else {
				minHeap.offer(arr[i]);
			}
		}
		return new ArrayList<>(minHeap);
	}
}


