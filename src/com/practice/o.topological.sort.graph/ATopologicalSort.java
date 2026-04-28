package com.practice.o.topological.sort.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class ATopologicalSort {

	public static void main(String[] args) {

		List<Integer> result = ATopologicalSort.sort(4, new int[][] { new int[] { 3, 2}, new int[] { 3, 0}, 
								new int[] { 2, 0 }, new int[] { 2, 1 } }); 
		System.out.println(result);
		
		result = ATopologicalSort.sort(5, new int[][] { new int[] { 4, 2 }, new int[] { 4, 3 }, new int[] { 2, 0 }, 
										new int[] { 2, 1}, new int[] { 3, 1 } });
		System.out.println(result);
		
		result = ATopologicalSort.sort(7, new int[][] { new int[] { 6, 4 }, new int[] { 6, 2 }, new int[] { 5, 3 }, new int[] { 5, 4 },
										new int[] { 3, 0 }, new int[] { 3, 1 }, new int[] { 3, 2 }, new int[] { 4, 1 } }); 
		System.out.println(result);

		}

	private static List<Integer> sort(int vertices, int[][] edges) {
		List<Integer> sortedList = new ArrayList<>();
	//	Step 1: Initialize the graph
		Map<Integer, Integer>  inDegree = new HashMap<>();
		Map<Integer, List<Integer>> graph = new HashMap<>();
	
		for (int i = 0; i < vertices; i++) {
			inDegree.put(i, 0);
			graph.put(i, new ArrayList<>());
		}
			
	//	Step 2 : Build the graph 
		for (int i = 0; i < edges.length; i++) {
			int parent = edges[i][0];
			int child = edges[i][1];
			graph.get(parent).add(child); // put child into its parent's list
			inDegree.put(child, inDegree.get(child) + 1); // increment child's inDegree
		}
	
	//	Find all sources with inDegree as 0 those are Parents/ source for 1st iteration
		Queue<Integer> sources = new LinkedList<>();
		for(Map.Entry<Integer, Integer> entry : inDegree.entrySet())
			if(entry.getValue() == 0) {
				sources.add(entry.getKey());
		}
		
		while(!sources.isEmpty()) {
			int vertex = sources.poll(); // poll the source vertex
			sortedList.add(vertex);
			List<Integer> children = graph.get(vertex); // extract all children of the Vertex
			for(int child : children) {
				inDegree.put(child, inDegree.get(child) - 1); // since parents of these childrens are removed, reduce the inDegree by 1
				if(inDegree.get(child) == 0) {   // if inDegree of the child becomes 0, this will become source for next iteration
					sources.add(child); //  since inDegree is zero add the child to source for next iteration
				}
			}
		}
		if(sortedList.size() != vertices) {
			return new ArrayList<>();  // topological sort is not possible as the graph has a cycle
		}
		
		return sortedList;
	}

}
