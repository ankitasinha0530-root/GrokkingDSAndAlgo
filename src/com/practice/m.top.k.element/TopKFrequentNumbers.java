 package com.practice.m.top.k.element;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequentNumbers {

	public static void main(String[] args) {
		System.out.println("Elements 1 = " + topKFrequentNumbers(new int[] {1, 3, 5, 12, 11, 12, 11 }, 3));
		System.out.println("Elements 2 = " + topKFrequentNumbers(new int[] {5, 12, 11, 3, 11}, 2));
	}

	private static int[] topKFrequentNumbers(int[] arr, int k) {

		Map<Integer, Integer> freqMap = new HashMap<Integer, Integer>();
		
		// add all the elements and its frequency in hashmap
		for (int i = 0; i < arr.length; i++) {
			freqMap.put(arr[i],  freqMap.getOrDefault(arr[i], 0) +1);
		}
		
		// defina priorityQueue min heap
		PriorityQueue<Map.Entry<Integer, Integer>> minHeap = 
				new PriorityQueue<Map.Entry<Integer, Integer>>((i1, i2) -> i1.getValue() - i2.getValue());
		
		// add elements in minHeap and remove element if the size becomes greater than k
		for(Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
			minHeap.add(entry);
			if(minHeap.size() > k) {
				minHeap.poll();
			}
		}
		// add all the keys present from hashmap to an array
		int[] resArr = new int[k];
		int i = 0;
		while (minHeap.size() > 0) {
			resArr[i] = minHeap.poll().getKey();
			i++;
		}
		return resArr;
		
		// add all the keys present from hashmap to an array list
//		List<Integer> result = new ArrayList<>();
//		while(minHeap.size() > 0) {
//			result.add(minHeap.poll().getKey());
//		}
//		return result;
		
	}

}
