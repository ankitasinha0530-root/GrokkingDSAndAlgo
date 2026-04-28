package com.practice.m.top.k.element;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class LReArrngWithsameletrKdistapart {

	public static void main(String[] args) {

		System.out.println("ReArranged String is = " + LReArrngWithsameletrKdistapart.reArrngWithsameletrKdistapart("aappp", 3));
		System.out.println("ReArranged String is = " + LReArrngWithsameletrKdistapart.reArrngWithsameletrKdistapart("Programming", 3));
		System.out.println("ReArranged String is = " + LReArrngWithsameletrKdistapart.reArrngWithsameletrKdistapart("aab", 2));

	}

	private static String reArrngWithsameletrKdistapart(String str, int k) {
		StringBuilder newStr = new StringBuilder(str.length());
		
		Map<Character, Integer> freqMap = new HashMap<>();
		
		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			freqMap.put(ch, freqMap.getOrDefault(ch, 0) + 1);
		}
		
		PriorityQueue<Map.Entry<Character, Integer>> maxHeap = 
				new PriorityQueue<Map.Entry<Character, Integer>>((n1, n2) -> n2.getValue() - n2.getValue());
		Queue<Map.Entry<Character, Integer>> queue = new LinkedList<>();
		maxHeap.addAll(freqMap.entrySet());

		while(!maxHeap.isEmpty()) {

				Map.Entry<Character, Integer> currEntry = maxHeap.poll();
				newStr.append(currEntry.getKey());
				currEntry.setValue(currEntry.getValue() - 1);
				queue.offer(currEntry);
				if(queue.size() == k) {
					Map.Entry<Character, Integer> entry = queue.poll();
					if(entry.getValue() > 0) {
						maxHeap.add(entry);
					}
				}
			}
		
		return newStr.length() == str.length() ? newStr.toString() : "";
		
	}

}
