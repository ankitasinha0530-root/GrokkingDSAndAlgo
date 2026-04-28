package com.practice.o.topological.sort.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class BSchedulingAtaskBoolean {

	public static void main(String[] args) {

		boolean result = BSchedulingAtaskBoolean.isSchedulingPossible(3, new int[][] { new int[] { 0, 1}, new int[] { 1, 2}}); 
		System.out.println(result);

		result = BSchedulingAtaskBoolean.isSchedulingPossible(3, new int[][] { new int[] { 0, 1}, new int[] { 1, 2 }, new int[] { 2, 0 }});
		System.out.println(result);

		result = BSchedulingAtaskBoolean.isSchedulingPossible(6, new int[][] { new int[] { 2, 5 }, new int[] { 0, 5 }, new int[] { 0, 4 }, new int[] { 5, 4 },
					new int[] { 1, 4 }, new int[] { 3, 2 }, new int[] { 1, 3}}); 
		System.out.println(result);

	}

	private static boolean isSchedulingPossible(int tasks, int[][] prerequisites) {

		List<Integer> sortedTasks = new ArrayList<>();
		
		// Step 1 : Initialize the map
		Map<Integer, Integer> inDegree = new HashMap<>();
		Map<Integer, List<Integer>> graph = new HashMap<>();
		for (int i = 0; i < tasks; i++) {
			inDegree.put(i, 0);
			graph.put(i, new ArrayList<>());
		}
		
		// Step 2 : Create the graph
		for (int i = 0; i < prerequisites.length; i++) {
			int parent = prerequisites[i][0];
			int child = prerequisites[i][1];
			graph.get(parent).add(child);
			inDegree.put(child, inDegree.get(child) + 1);
		}
		
		// step 3 : create the source
		Queue<Integer> source = new LinkedList<>();
		for(Map.Entry<Integer, Integer> entry : inDegree.entrySet()) {
			if(entry.getValue() == 0) {
				source.add(entry.getKey());
			}
		}
		
		//Step 4 : Iterate over the Source
		while(!source.isEmpty()) {
			int vertex = source.poll();
			sortedTasks.add(vertex);
			List<Integer> children = graph.get(vertex);
			for(int child : children) {
				inDegree.put(child, inDegree.get(child) - 1);
				if(inDegree.get(child) == 0) {
					source.add(child);
				}
			}
		}
		
		return sortedTasks.size() == tasks;
	}

}
