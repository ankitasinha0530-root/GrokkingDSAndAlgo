package com.practice.m.top.k.element;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class FSortBasedonFrquencyOfOccur {

	public static void main(String[] args) {

		System.out.println(FSortBasedonFrquencyOfOccur.sortBasedonFrquencyOfOccur("Programming"));
		System.out.println(FSortBasedonFrquencyOfOccur.sortBasedonFrquencyOfOccur("abcbab"));

	}

	private static String sortBasedonFrquencyOfOccur(String str) {
		StringBuilder result = new StringBuilder();
		
		// Create a frequency Map
		Map<Character, Integer> freqMap = new HashMap<Character, Integer>();
		
		// Add each character and its frequency to freqMap
		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			freqMap.put(ch, freqMap.getOrDefault(ch, 0) + 1);
		}
		
		//Create a maxHeap, sorting in descending order is required
		PriorityQueue<Map.Entry<Character, Integer>> maxHeap = 
				new PriorityQueue<Map.Entry<Character, Integer>>((i1, i2) -> i2.getValue() - i1.getValue());
		
		// add freqMap to maxHEap
		maxHeap.addAll(freqMap.entrySet()); // add freqMap.entryset to iterate over each element
		
		// elemnts are sorted in descending order based on the value, 
		// extract element from maxHEap and loop over to the value of freq and keep adding in the StringBuilder
		while(maxHeap.size() > 0) {
			Map.Entry<Character, Integer> entry = maxHeap.poll();
			for (int i = 0; i < entry.getValue(); i++) {
				result.append(entry.getKey());
			}
		}
		
		return result.toString();
	}

}
