package com.practice.m.top.k.element;

import java.util.PriorityQueue;

public class JSumOfElemBTWK1AndK2Smallest {

	public static void main(String[] args) {

		System.out.println("sum betweek k1 and k2 smallest number = " + JSumOfElemBTWK1AndK2Smallest.sumOfElemBTWK1AndK2Smallest(new int[] {1, 3, 12, 5, 15, 11 }, 3, 6));
		System.out.println("sum betweek k1 and k2 smallest number  = " + JSumOfElemBTWK1AndK2Smallest.sumOfElemBTWK1AndK2Smallest(new int[] {3, 5, 8, 7 }, 1, 4));
	//	System.out.println("sum betweek k1 and k2 smallest number  = " + JSumOfElemBTWK1AndK2Smallest.sumOfElemBTWK1AndK2Smallest(new int[] {1, 2, 3, 3 ,3, 3, 4, 4, 5, 5 ,5}));

	}

	private static int sumOfElemBTWK1AndK2Smallest(int[] arr, int k1, int k2) {

		int sum = 0;

		PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>((i1, i2) -> i1 - i2);
		
		for (int i = 0; i < arr.length; i++) {	
			minHeap.offer(arr[i]);
		}
		
		for (int i = 0; i < k1; i++) {
			minHeap.poll();
		}
		
		for (int i = 0; i < k2-k1-1; i++) { // since we just need 2 elements
			sum += minHeap.poll();
		}
		return sum;
	}

}
