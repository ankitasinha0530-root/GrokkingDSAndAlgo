package com.practice.e.cyclic.sort;

import java.util.ArrayList;
import java.util.List;

public class EFindAllDuplicates {

	public static void main(String[] args) {

		// Refer video = https://www.youtube.com/watch?v=lFhiz9ntwqk
		// 1. One more way to solve is by using a Hashet. start iterating and compare the number in hashshet
		// if the number is not found then add the number in hashset, if the number is found then add to the resultlist.
		// 2. For Every Index to check, If wlwment is positive- change to begative
		// If element is already negative add it to result set.
		
		List<Integer> result = EFindAllDuplicates.eFindAllDuplicates(new int[] {2, 3, 1, 8, 2, 3, 5, 1});
		System.out.println("Duplicate Number = " + result);
		
		List<Integer> result1 = EFindAllDuplicates.eFindAllDuplicates(new int[] {2, 3, 2, 1});
		System.out.println("Duplicate Number = " + result1);
		
		List<Integer> result3 = EFindAllDuplicates.eFindAllDuplicates(new int[] {2, 4, 1, 2});
		System.out.println("Duplicate Number = " + result3);
		
		List<Integer> result7 = EFindAllDuplicates.eFindAllDuplicates(new int[] {3, 4, 4, 5, 5});
		System.out.println("Duplicate Number = " + result7);
		
		List<Integer> result8 = EFindAllDuplicates.eFindAllDuplicates(new int[] {5, 4, 7, 2, 3, 5 , 3});
		System.out.println("Duplicate Number = " + result8);
		
		List<Integer> result9 = EFindAllDuplicates.eFindAllDuplicatesV1(new int[] {3, 4, 4, 5, 5});
		System.out.println("Duplicate Number = " + result9);
		
		List<Integer> result10 = EFindAllDuplicates.eFindAllDuplicatesV1(new int[] {5, 4, 7, 2, 3, 5 , 3});
		System.out.println("Duplicate Number = " + result10);
		
		List<Integer> result4 = EFindAllDuplicates.eFindAllDuplicatesV1(new int[] {2, 3, 1, 8, 2, 3, 5, 1});
		System.out.println("Duplicate Number = " + result4);
		
		List<Integer> result5 = EFindAllDuplicates.eFindAllDuplicatesV1(new int[] {2, 3, 2, 1});
		System.out.println("Duplicate Number = " + result5);
		
		List<Integer> result6 = EFindAllDuplicates.eFindAllDuplicatesV1(new int[] {2, 4, 1, 2});
		System.out.println("Duplicate Number = " + result6);

	}

	private static List<Integer> eFindAllDuplicates(int[] arr) {
		
		int i = 0;
		
		while(i < arr.length) {
			if(arr[i] != arr[arr[i] - 1]) {
				int dest = arr[i] - 1;
				int temp = arr[i];
				arr[i] = arr[dest];
				arr[dest] = temp;
			} else {
				i++;
			}
		}

		// after sorting array becomes - 1, 2, 3, 1, 5, ,3 ,2 ,8 index - 3, 6 and 7 does not correct element
		// the answer would be the elements present at index - 3, 6 and 7
		// Here every element will be added to its correct Index, if any element is not present 
		// at its correct index then add those numbers to resultset those are duplicates
		
		List<Integer> duplicates = new ArrayList<>();
		
		for (i= 0; i < arr.length; i++) {
			
			if(arr[i] != i+1) {
				duplicates.add(arr[i]);
			}
			
		}
		return duplicates;
	}

	private static List<Integer> eFindAllDuplicatesV1(int[] arr) {

		List<Integer> duplicates = new ArrayList<>();
		
		for (int i = 0; i < arr.length; i++) {
			
			int index = Math.abs(arr[i]) - 1;
			if(arr[index] < 0) {
				duplicates.add(index + 1); //or duplicates.add(Math.abs(arr[i])); 
			}
			arr[index] *= -1;
		}
		return duplicates;
	}

	//Using HashSet #Extra Space, compare
//	private static List<Integer> eFindAllDuplicatesV2(int[] arr) {
//		// TODO Auto-generated method stub
//		return null;
//	}



}
