package com.practice.m.top.k.element;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class KReArrngWithNoSameLeteradjacnt {

	public static void main(String[] args) {

		System.out.println("ReArranged String is = " + KReArrngWithNoSameLeteradjacnt.reArrngWithNoSameLtradjacnt("aappp"));
		System.out.println("ReArranged String is = " + KReArrngWithNoSameLeteradjacnt.reArrngWithNoSameLtradjacnt("Programming"));
		System.out.println("ReArranged String is = " + KReArrngWithNoSameLeteradjacnt.reArrngWithNoSameLtradjacnt("aapa"));

	}

	private static String reArrngWithNoSameLtradjacnt(String str) {
		StringBuilder newStr = new StringBuilder(str.length());
		
		Map<Character, Integer> freqMap = new HashMap<>();
		
		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			freqMap.put(ch, freqMap.getOrDefault(ch, 0) + 1);
		}
		
		PriorityQueue<Map.Entry<Character, Integer>> maxHeap = 
				new PriorityQueue<Map.Entry<Character, Integer>>((n1, n2) -> n2.getValue() - n1.getValue());
		
		maxHeap.addAll(freqMap.entrySet());
		Map.Entry<Character, Integer> prevEntry = null;
		
		while(!maxHeap.isEmpty()) {
			Map.Entry<Character, Integer> currEntry = maxHeap.poll();
			
			newStr.append(currEntry.getKey());
			
			if(prevEntry != null && prevEntry.getValue() > 0) {
				maxHeap.add(prevEntry);
			}
			currEntry.setValue(currEntry.getValue() - 1);
			prevEntry = currEntry;
			
		}
		return newStr.length() == str.length() ? newStr.toString() : "";
	}

}
