package com.practice.e.cyclic.sort;

import java.util.ArrayList;
import java.util.List;

public class HFirstKMissingPositiveIntegers {

	public static void main(String[] args) {
		
		//Refer Video = https://www.youtube.com/watch?v=uZ0N_hZpyps
		//Refer Video - https://www.youtube.com/watch?v=rrXPOQ3W_8g

		List<Integer> result = HFirstKMissingPositiveIntegers.hFirstKMissingPositiveIntegers(3, new int[] {3, -1, 4, 5, 5});
		System.out.println("Duplicate Number = " + result);
				
		List<Integer> result1 = HFirstKMissingPositiveIntegers.hFirstKMissingPositiveIntegers(3, new int[] {2, 3, 4});
		System.out.println("Duplicate Number = " + result1);
				
		List<Integer> result3 = HFirstKMissingPositiveIntegers.hFirstKMissingPositiveIntegers(2, new int[] {-2, -3, -4});
		System.out.println("Duplicate Number = " + result3);

		List<Integer> result9 = HFirstKMissingPositiveIntegers.hFirstKMissingPositiveIntegersV1(new int[] {3, 1, 2, 5, 2});
		System.out.println("Duplicate Number = " + result9);
				
		List<Integer> result10 = HFirstKMissingPositiveIntegers.hFirstKMissingPositiveIntegersV1(new int[] {3, 1, 2, 3, 6, 4});
		System.out.println("Duplicate Number = " + result10);
				
		List<Integer> result4 = HFirstKMissingPositiveIntegers.hFirstKMissingPositiveIntegersV1(new int[] {4, 3, 4, 5, 1});
		System.out.println("Duplicate Number = " + result4);

	}

	private static List<Integer> hFirstKMissingPositiveIntegers(int k, int[] arr) {
		int i = 0;
		while(i < arr.length) {
			if(arr[i] > 0 && arr[i] <= arr.length && arr[i] != arr[arr[i]-1]) {
				int dest = arr[i]-1;
				int temp = arr[i];
				arr[i] = arr[dest];
				arr[dest] = temp;
			}else {
				i++;
			}
		}
		
		List<Integer> missingNums = new ArrayList<>();
		List<Integer> extraNums = new ArrayList<>();
		
		for (i = 0; i < arr.length && missingNums.size() < k; i++) {
			if(arr[i] != i+1) {
				missingNums.add(i+1);
				extraNums.add(arr[i]);
			}	
		}
		
		for(i = 1; missingNums.size() < k; i++) {
			int candidateNum = arr.length + i;
			if(!extraNums.contains(candidateNum)) {
				missingNums.add(candidateNum);
			}
		}
		
		return missingNums;
	}

	private static List<Integer> hFirstKMissingPositiveIntegersV1(int[] is) {
		// TODO Auto-generated method stub
		return null;
	}


}
