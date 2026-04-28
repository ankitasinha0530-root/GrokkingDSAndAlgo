package com.practice.e.cyclic.sort;

import java.util.ArrayList;
import java.util.List;

public class FFindACorruptPair {

	public static void main(String[] args) {
		
		//Refer Video - https://www.youtube.com/watch?v=qGk-4qa226s

		List<Integer> result = FFindACorruptPair.fFindACorruptPair(new int[] {3, 1, 2, 5, 2});
		System.out.println("Duplicate Number = " + result);
		
		List<Integer> result1 = FFindACorruptPair.fFindACorruptPair(new int[] {3, 1, 2, 3, 6, 4});
		System.out.println("Duplicate Number = " + result1);
		
		List<Integer> result3 = FFindACorruptPair.fFindACorruptPair(new int[] {4, 3, 4, 5, 1});
		System.out.println("Duplicate Number = " + result3);

		List<Integer> result9 = FFindACorruptPair.fFindACorruptPairV1(new int[] {3, 1, 2, 5, 2});
		System.out.println("Duplicate Number = " + result9);
		
		List<Integer> result10 = FFindACorruptPair.fFindACorruptPairV1(new int[] {3, 1, 2, 3, 6, 4});
		System.out.println("Duplicate Number = " + result10);
		
		List<Integer> result4 = FFindACorruptPair.fFindACorruptPairV1(new int[] {4, 3, 4, 5, 1});
		System.out.println("Duplicate Number = " + result4);

	}

	private static List<Integer> fFindACorruptPair(int[] arr) {

		int i = 0;
		
		while(i < arr.length) {
			if(arr[i] != arr[arr[i]-1]) {
				int dest = arr[i] - 1;
				int temp = arr[i];
				arr[i] = arr[dest];
				arr[dest] = temp;
			}else {
				i++;
			}
		}
		List<Integer> corruptPair = new ArrayList<>();
		for (i = 0; i < arr.length; i++) {
			if(arr[i] != i+1) {
				corruptPair.add(i+1);
				corruptPair.add(arr[i]);
			}
		}
		return corruptPair;
	}

	private static List<Integer> fFindACorruptPairV1(int[] is) {
		// TODO Auto-generated method stub
		return null;
	}

}
