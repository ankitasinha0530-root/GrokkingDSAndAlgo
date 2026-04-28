package com.practice.o.topological.sort.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class DFindAllSchedulingTaskOrder {
// Code is Incorrect
	public static void main(String[] args) {
		
		DFindAllSchedulingTaskOrder.findAllOrderOfTasks(3, new int[][] { new int[] { 0, 1}, new int[] { 1, 2}}); 
		

//		DFindAllSchedulingTaskOrder.findAllOrderOfTasks(3, new int[][] { new int[] { 0, 1}, new int[] { 1, 2 }, new int[] { 2, 0 }});
//
//		DFindAllSchedulingTaskOrder.findAllOrderOfTasks(6, new int[][] { new int[] { 2, 5 }, new int[] { 0, 5 }, new int[] { 0, 4 }, new int[] { 5, 4 },
//					new int[] { 1, 4 }, new int[] { 3, 2 }, new int[] { 1, 3}}); 

	}

	private static void findAllOrderOfTasks(int tasks, int[][] preRequisites) {
			
		List<Integer> orderTasks = new ArrayList<>();
		
		// Initialize the graph
		Map<Integer, Integer> inDegree = new HashMap<>();
		Map<Integer, List<Integer>> graph = new HashMap<>();
		
		for (int i = 0; i < tasks; i++) {
			inDegree.put(i, 0);
			graph.put(i, new ArrayList<Integer>());
		}
		
		for (int i = 0; i < preRequisites.length; i++) {
			int parent = preRequisites[i][0];
			int child = preRequisites[i][1];
			graph.get(parent).add(child);	
			inDegree.put(child, inDegree.get(child) + 1);
		}
		
		Queue<Integer> sources = new LinkedList<>();
		for(Map.Entry<Integer, Integer> entry : inDegree.entrySet()) {
			if(entry.getValue() == 0) {
				sources.add(entry.getKey());
			}
		}
		
		findAllOrderandPrint(sources, inDegree, graph, orderTasks);
	}

	private static void findAllOrderandPrint(Queue<Integer> sources, Map<Integer, Integer> inDegree,
			Map<Integer, List<Integer>> graph, List<Integer> orderTasks) {
		
		while(!sources.isEmpty()) {
			for(Integer vertex : sources) {
				orderTasks.add(vertex);
				Queue<Integer> sourcesForNextCall = deepCopy(sources);
				sourcesForNextCall.remove(vertex);
				
				List<Integer> children = graph.get(vertex);
				for(int child : children) {
					inDegree.put(child, inDegree.get(child) - 1);
					if(inDegree.get(child) == 0) {
						sourcesForNextCall.add(child);
					}
				}
				findAllOrderandPrint(sourcesForNextCall, inDegree, graph, orderTasks);
				
				orderTasks.remove(vertex);
				
				for(int child : children) {
					inDegree.put(child, inDegree.get(child) + 1);
				}
			}
		}
		
		if(orderTasks.size() == inDegree.size()) {
			System.out.println(orderTasks);
		}
	}

	private static Queue<Integer> deepCopy(Queue<Integer> sources) {
		Queue<Integer> newSource = new LinkedList<>();
		
		for(int source : sources) {
			newSource.add(source);
		}
		return newSource;
	}

}
