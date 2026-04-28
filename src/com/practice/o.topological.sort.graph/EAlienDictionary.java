package com.practice.o.topological.sort.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class EAlienDictionary {

	public static void main(String[] args) {
		
		String result = EAlienDictionary.findorder(new String[] { "ba", "bc", "ac", "cab" });
		System.out.println("Character order: " + result);

		result = EAlienDictionary.findorder(new String[] { "cab", "aaa", "aab" });
		System.out.println("Character order: " + result);
						
		result = EAlienDictionary.findorder(new String[] { "ywx", "wz", "xww", "xz", "zyy", "zwz" });
		System.out.println("Character order: " + result);

	}

	private static String findorder(String[] words) {
		StringBuilder alienSorted = new StringBuilder();
		
	//	initialize the graph
		
		Map<Character, Integer> inDegree = new HashMap<>();
		Map<Character, List<Character>> graph = new HashMap<>();
		
		for(String word : words) {
			for(Character ch : word.toCharArray()) {
				inDegree.put(ch, 0);
				graph.put(ch, new ArrayList<Character>());
			}
		}
		
		// Build the graph
		for (int i = 0; i < words.length - 1; i++) {
			String w1 = words[i];
			String w2 = words[i+1];
			for (int j = 0; j < Math.min(w1.length(), w2.length()); j++) {
				char parent = w1.charAt(j);
				char child = w2.charAt(j);
				if(parent != child) {
					graph.get(parent).add(child);
					inDegree.put(child, inDegree.get(child) + 1);
					break;
				}
			}
		}
		
		Queue<Character> sources = new LinkedList<>();
		for(Map.Entry<Character, Integer> entry : inDegree.entrySet()){
			if(entry.getValue() == 0) {
				sources.add(entry.getKey());
			}
		}
		
		while(!sources.isEmpty()) {
			char ch = sources.poll();
			alienSorted.append(ch);
			List<Character> children = graph.get(ch);
			for(char child : children) {
				inDegree.put(child, inDegree.get(child) - 1);
				if(inDegree.get(child) == 0) {
					sources.add(child);
				}
			}
		}
		if(alienSorted.length() == inDegree.size()) {
			return alienSorted.toString();
		}
		return "none";
	}
}