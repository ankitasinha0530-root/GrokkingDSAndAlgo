package com.practice.j.subsets;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BSubSetsWithDuplicates {

	public static void main(String[] args) {
		
		// Refer Video = https://www.youtube.com/watch?v=qGyyzpNlMDU
		
		// Find all the elements and remove the duplicate subsets
		
		// this can be the soltion for Find Distict subsets
		
		List<List<Integer>> result = new ArrayList<>();
		result = BSubSetsWithDuplicates.findSubsetwithDuplicates(new int[] {1, 3});
		System.out.println("Result = " + result);
		
		List<List<Integer>> result1 = new ArrayList<>();
		result1 = BSubSetsWithDuplicates.findSubsetwithDuplicates(new int[] {1, 5, 3});
		System.out.println("Result 1 = " + result1);
		
		List<List<Integer>> result6 = new ArrayList<>();
		result6 = BSubSetsWithDuplicates.findSubsetwithDuplicates(new int[] {1, 3, 3});
		System.out.println("Result 6 = " + result6);
		
		List<List<Integer>> result7 = new ArrayList<>();
		result7 = BSubSetsWithDuplicates.findSubsetwithDuplicates(new int[] {1, 3, 3, 5});
		System.out.println("Result 7 = " + result7);
		
		List<List<Integer>> result2 = new ArrayList<>();
		result2 = BSubSetsWithDuplicates.findSubsetwithDuplicatesV2(new int[] {1, 3});
		System.out.println("Result 2 = " + result2);
		
		List<List<Integer>> result3 = new ArrayList<>();
		result3 = BSubSetsWithDuplicates.findSubsetwithDuplicatesV2(new int[] {1, 5, 3});
		System.out.println("Result 3 = " + result3);
		
		List<List<Integer>> result4 = new ArrayList<>();
		result4 = BSubSetsWithDuplicates.findSubsetwithDuplicatesV2(new int[] {1, 3, 3});
		System.out.println("Result 4 = " + result4);
		
		List<List<Integer>> result5 = new ArrayList<>();
		result5 = BSubSetsWithDuplicates.findSubsetwithDuplicatesV2(new int[] {1, 3, 3, 5});
		System.out.println("Result 5 = " + result5);

	}
	
	private static List<List<Integer>> findSubsetwithDuplicates(int[] nums) {
		Arrays.sort(nums);
		List<List<Integer>> subSets = new ArrayList<>();
		
		subSets.add(new ArrayList<>());
		int startIdx = 0, endIdx = 0;
		for (int i = 0; i < nums.length; i++) {
			startIdx = 0;
			
			// If previous number and current number are same then create subset 
			// only from the new subsets created in the previous step
			if( i> 0 && nums[i] == nums[i-1]) {
				startIdx = endIdx + 1; // in this step start index index will start from the new set created in the previous step
			}
			endIdx = subSets.size() - 1;
			for (int j = startIdx; j <= endIdx; j++) {
				List<Integer> set = new ArrayList<>(subSets.get(j));
				set.add(nums[j]);
				subSets.add(set);
			}
		}
		
		for(int currNum : nums) {
			int n = subSets.size();
			for (int i = 0; i < n; i++) {
				
				List<Integer> set = subSets.get(i);
				set.add(currNum);
				if(!subSets.contains(set)) {
					subSets.add(set);
				}
			}
		}
		return subSets;
	}

	public static List<List<Integer>> findSubsetwithDuplicatesV2(int[] nums) {

		List<List<Integer>> resultSets = new ArrayList<>();
		
		Arrays.sort(nums);
		
		BSubSetsWithDuplicates.backtrack(resultSets, new ArrayList<>(), nums, 0);
		
 		return resultSets;
	}

	private static void backtrack(List<List<Integer>> resultSets, List<Integer> tempSet, int[] nums, int start) {
		
		// If the subset is slaready present just continue
		if(resultSets.contains(tempSet)) {
			return;         // remove the duplicate subset
		}
		
		// Add temp set to result set
		resultSets.add(new ArrayList<>(tempSet));
		
		for (int i = start; i < nums.length; i++) { // for all nums one by ine
			
			// Considering the element to add in subset pre area of Euler
			tempSet.add(nums[i]);
			
			//backtracking logic
			backtrack(resultSets, tempSet, nums, i+1);
			
			// Considering the element to add in subset in post area of euler
			tempSet.remove(tempSet.size() - 1);
		}
		
	}
	

}
