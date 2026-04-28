package com.practice.j.subsets;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CPermutationsOfAnArray {
	
	// Refer video = https://www.youtube.com/watch?v=sPAT_DbvDj0 - for string permutation
	// Refer video = https://www.youtube.com/watch?v=H232aocj7bQ - for Array Permutation

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		List<List<Integer>> result = new ArrayList<>();
		result = CPermutationsOfAnArray.findPermutations(new int[] {1, 3});
		System.out.println("Result = " + result);
		
		List<List<Integer>> result1 = new ArrayList<>();
		result1 = CPermutationsOfAnArray.findPermutations(new int[] {1, 5, 3});
		System.out.println("Result 1 = " + result1);
		
		List<List<Integer>> result2 = new ArrayList<>();
		result2 = CPermutationsOfAnArray.findPermutationsV2(new int[] {1, 3});
		System.out.println("Result = " + result2);
		
		List<List<Integer>> result3 = new ArrayList<>();
		result3 = CPermutationsOfAnArray.findPermutationsV2(new int[] {1, 5, 3});
		System.out.println("Result 1 = " + result3);

	}

	private static List<List<Integer>> findPermutationsV2(int[] nums) {
		List<List<Integer>> resultSet = new ArrayList<>();
		
		CPermutationsOfAnArray.backTrack(resultSet, new ArrayList<>(), nums);
		return resultSet;
	}

	private static void backTrack(List<List<Integer>> resultSet, List<Integer> tempList, int[] nums) {
		
		if(tempList.size() == nums.length) {
			resultSet.add(new ArrayList<>(tempList));
			return;
		}
		
		for(int currNum : nums) {
			if(tempList.contains(currNum)) {
				continue;   // skips current iteration
			}
			
			tempList.add(currNum);
			
			backTrack(resultSet, tempList, nums);
			
			tempList.remove(tempList.size()-1);
		}

	}

	private static List<List<Integer>> findPermutations(int[] nums) {

		List<List<Integer>> result = new ArrayList<>();
		Queue<List<Integer>> permutations = new LinkedList<>();
 		permutations.add(new ArrayList<>());
		
 		for(int currNum : nums) {
 			int n = permutations.size();
			for (int i = 0; i < n; i++) {
				
				List<Integer> OldPermutation = permutations.poll();
				
				for (int j = 0; j <= OldPermutation.size(); j++) {
					List<Integer> newPermutation = new ArrayList<>(OldPermutation);
					newPermutation.add(j, currNum);
					if(newPermutation.size() == nums.length){
						result.add(newPermutation);
					}else {
						permutations.add(newPermutation);
					}
				}	
			}
 		}
		return result;
	}

}
