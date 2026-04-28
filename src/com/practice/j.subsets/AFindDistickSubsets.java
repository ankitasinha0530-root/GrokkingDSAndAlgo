package com.practice.j.subsets;

import java.util.ArrayList;
import java.util.List;

public class AFindDistickSubsets {

	public static void main(String[] args) {
		// Refer Video = https://www.youtube.com/watch?v=3tpjp5h3M6Y
		//we can use the Breadth First Search (BFS) approach, 
		//Backtracking algorithmic paradigm
//		1. Start with an empty set: [[]]
//		2. Add the first number (1) to all the existing subsets to create new subsets: [[], [1]];
//		3. Add the second number (5) to all the existing subsets: [[], [1], [5], [1,5]];
//		4. Add the third number (3) to all the existing subsets: [[], [1], [5], [1,5], [3], [1,3], [5,3], [1,5,3]].
		
		List<List<Integer>> result = new ArrayList<>();
		result = AFindDistickSubsets.findDistinctSubset(new int[] {1, 3});
		System.out.println("Result = " + result);
		
		List<List<Integer>> result1 = new ArrayList<>();
		result1 = AFindDistickSubsets.findDistinctSubset(new int[] {1, 5, 3});
		System.out.println("Result 1 = " + result1);
		
		List<List<Integer>> result2 = new ArrayList<>();
		result2 = AFindDistickSubsets.findDistinctSubsetV2(new int[] {1, 3});
		System.out.println("Result 2 = " + result2);
		
		List<List<Integer>> result3 = new ArrayList<>();
		result3 = AFindDistickSubsets.findDistinctSubsetV2(new int[] {1, 5, 3});
		System.out.println("Result 3 = " + result3);
		
	}


	private static List<List<Integer>> findDistinctSubset(int[] nums) {
		 List<List<Integer>> subSets = new ArrayList<>();
		 
		 // Start by adding the empty set
		 subSets.add(new ArrayList<>());
		 
		// for Each number present in nums array
		 for(int currNum : nums) {
			 
			// we will take all exsiting subsets and insert the current number in them to create new subsets
			 int n = subSets.size();  // take all existimng subset
			 for (int i = 0; i < n; i++) {
				// Create a new subset from existing subset and insert the current element to it
				List<Integer> eachSet = new ArrayList<>(subSets.get(i));
				eachSet.add(currNum);
				
				subSets.add(eachSet);
			}
		 }
		return subSets;
	}

	private static List<List<Integer>> findDistinctSubsetV2(int[] nums) {
		List<List<Integer>> resultSets = new ArrayList<>();
		
	//	Start BackTracking from the beginning
		AFindDistickSubsets.backTrack(resultSets, new ArrayList<>(), nums, 0);
		
		return resultSets;
	}


	private static void backTrack(List<List<Integer>> resultSets, List<Integer> tempSet, int[] nums, int start) {

		// Add the set to resultSet
		resultSets.add(new ArrayList<>(tempSet));
		
		for (int i = start; i < nums.length; i++) {
			//case of Including the number
			tempSet.add((nums[i]));
			
			// Backtrack the new Subset
			backTrack(resultSets, tempSet, nums, i+1);
			
			// Case of Not including the number
			tempSet.remove(tempSet.size()-1);
		}
	}


}
