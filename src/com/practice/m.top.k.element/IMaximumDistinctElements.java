	package com.practice.m.top.k.element;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class IMaximumDistinctElements {

	public static void main(String[] args) {
		System.out.println("'K' closest elements to 'X' are = " + IMaximumDistinctElements.maximumDistinctElements(new int[] {7, 5, 3, 8, 5, 3, 3 }, 2));
		System.out.println("'K' closest elements to 'X' are = " + IMaximumDistinctElements.maximumDistinctElements(new int[] {3, 5, 11, 12, 11 }, 2));
		System.out.println("'K' closest elements to 'X' are = " + IMaximumDistinctElements.maximumDistinctElements(new int[] {1, 2, 3, 3 ,3, 3, 4, 4, 5, 5 ,5}, 2));

	}

	private static int maximumDistinctElements(int[] arr, int k) {

		int distinctCount = 0;
		
		Map<Integer, Integer> freqMap = new HashMap<>();
		
	//	Add all elements in freqMap with key as the element and value as the no of occurrence of the elmnt
		for (int i = 0; i < arr.length; i++) {
			freqMap.put(arr[i], freqMap.getOrDefault(arr[i], 0) + 1);
		}
		
		PriorityQueue<Map.Entry<Integer, Integer>> minHeap = 
				new PriorityQueue<Map.Entry<Integer, Integer>>((n1, n2) -> n1.getValue() - n2.getValue()); 
		
		// add all elements which has frequency greater than 1 to minHeap
		for(Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
			if(entry.getValue() == 1) { // if count == 1 
				distinctCount += 1;		// increment the distinctCount	
			}else {
				minHeap.add(entry);		// if freq is > 1 then add in minHeap
			}
		}
		
	//	Use Greedy approach try removing the least frequent numbers first from the min heap
	//	Step 1 : take 1st element from minHeap, and remove all the occurence except 1
	//	Step 2 : If after removing  frequencies still k >= 0 , increase the count by 1
	//  Step 3 : if K > 0 then poll() next element from minHEap and repeat step 1 and step 2 and so on
		while(k > 0 && !minHeap.isEmpty()) {
			Map.Entry<Integer, Integer> ele = minHeap.poll();
			
			k = k - ele.getValue() + 1;
			if( k >= 0) {
				distinctCount += 1;
			}
		}
		return distinctCount;
	}

}
