package com.practice.m.top.k.element;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class MShedulingATask {

	public static void main(String[] args) {

		System.out.println("value = " + MShedulingATask.shedulingATask(new char[] {'a', 'a', 'a', 'b', 'c', 'c' }, 2));
		System.out.println("value = " + MShedulingATask.shedulingATask(new char[] {'a', 'b', 'a',}, 3));

	}

	private static int shedulingATask(char[] arr, int k) {
		Map<Character, Integer> freqMap = new HashMap<Character, Integer>();
		
		for (int i = 0; i < arr.length; i++) {
			char ch = arr[i];
			freqMap.put(ch, freqMap.getOrDefault(ch, 0) + 1);
		}
		
		PriorityQueue<Map.Entry<Character, Integer>> maxHeap =
				new PriorityQueue<Map.Entry<Character, Integer>>((n1, n2) -> n2.getValue() - n1.getValue());
		
		maxHeap.addAll(freqMap.entrySet());
		
		int intervalCount = 0;
		while(!maxHeap.isEmpty()) {
			List<Map.Entry<Character, Integer>> waitList = new ArrayList<>(); 
			
			int n = k+1; // try to execute k+1 task from the heap
			
	//		for(int i = n; n > 0 &&!maxHeap.isEmpty(); --n) {//
			for(; n > 0 &&!maxHeap.isEmpty(); n--) {
				intervalCount++;
				Map.Entry<Character, Integer> currEntry = maxHeap.poll();
				if(currEntry.getValue() > 1) {  
					currEntry.setValue(currEntry.getValue() - 1);
					waitList.add(currEntry); // add element in waitlist if its not zero
				}
				
				} 
			maxHeap.addAll(waitList);  // add all waitlist to maxHeap to process it again for next iteration
			if(!maxHeap.isEmpty()) { // if maxHeap is not empty then add remaining n to the interval .. as it will be idle
				intervalCount += n;
				// if maxHeap is empty then all the tasks is complete so we can ignore the n now
			}
		}
		
		return intervalCount;
	}

}
