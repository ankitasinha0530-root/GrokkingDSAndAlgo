package com.practice.b.two.pointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class JUniqueQuadruplesSumEqlTarget {

	public static void main(String[] args) {
		List<List<Integer>> result = JUniqueQuadruplesSumEqlTarget.jUniqueQuadruplesSumEqlTarget(1, new int[] {4, 1, 2, -1, 1, -3 }); 
		List<List<Integer>> result1 = JUniqueQuadruplesSumEqlTarget.jUniqueQuadruplesSumEqlTarget(2, new int[] {2, 0, -1, 1, -2, 2 });
		List<List<Integer>> result2 = JUniqueQuadruplesSumEqlTarget.jUniqueQuadruplesSumEqlTarget(4, new int[] {-4, -2, 1, 1, 2, 8 });
		List<List<Integer>> result3 = JUniqueQuadruplesSumEqlTarget.jUniqueQuadruplesSumEqlTarget(5, new int[] {-3, 2, 0, 1, 2, 8 });
			
		System.out.println("JUniqueQuadruplesSumEqlTarget == " + (result));
		System.out.println("JUniqueQuadruplesSumEqlTarget == " + (result1));
		System.out.println("JUniqueQuadruplesSumEqlTarget == " + (result2));
		System.out.println("JUniqueQuadruplesSumEqlTarget == " + (result3));

	}

	private static List<List<Integer>> jUniqueQuadruplesSumEqlTarget(int tSum, int[] arr) {
		List<List<Integer>> quadruples = new ArrayList<>();
		Arrays.sort(arr);
		for (int i = 0; i< arr.length-3; i++) {
			if(i>0 && arr[i] == arr[i-1]) continue;   // check if current element is ==last element if yes then skip the current element
			for (int j = i+1; j< arr.length-2; j++) {
				
				if(j> i+1 && arr[j] == arr[j-1]) continue; // if current element is == last element if yes then skip the current element
				
				int left = j+1, right = arr.length-1;
				
				while (left < right) {
					int newSum = arr[i] +arr[j] + arr [left] + arr[right];
					if(newSum == tSum) {
						quadruples.add(Arrays.asList(arr[i],arr[j],arr[left],arr[right]));
						right--;
						left++;
						while(left<right && arr[right] == arr[right+1]) // if current element is == last element if yes then skip the current element
							right--;
						while(left<right && arr[left] == arr[left-1]) // if current element is == last element if yes then skip the current element
							left++;
					}else if(newSum < tSum) {
						left++;
					}else {
						right--;
						}
					}
				}
			}
		return quadruples;
	}

}
