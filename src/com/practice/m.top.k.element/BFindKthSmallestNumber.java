package com.practice.m.top.k.element;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class BFindKthSmallestNumber {
	
	// Any problem that asks us to find the top/smallest/frequent ‘K’ elements among a given set falls under this pattern.

	// The best data structure that comes to mind to keep track of ‘K’ elements is Heap. 
	// This pattern will make use of the Heap to solve multiple problems dealing with ‘K’ elements at a time from a set of given elements.

	public static void main(String[] args) {

		System.out.println("value = " + BFindKthSmallestNumber.findKLargestNumber(new int[] {3, 1, 5, 12, 2, 11 }, 3));
		System.out.println("value = " + BFindKthSmallestNumber.findKLargestNumber(new int[] {5, 12, 11, -1, 12}, 3));
		System.out.println("value = " + BFindKthSmallestNumber.findKLargestNumber(new int[] {3, 5, 0, 1, 6, 4, 7, 2, 9}, 3));

	}

	private static List<Integer> findKLargestNumber(int[] arr, int k) {

		PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>((i1, i2) -> i2 - i1);
		
		for (int i = 0; i < k; i++) {
			maxHeap.offer(arr[i]);
		}
		for (int i = k; i < arr.length; i++) {
			if(maxHeap.peek() > arr[i]) {
				maxHeap.poll();
				maxHeap.add(arr[i]);
			}
		}
		return new ArrayList<>(maxHeap);
		}
	}


