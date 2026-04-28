package com.practice.e.cyclic.sort;

public class BMissingNumUsingCyclicSort {
	
	public static void main(String[] args) {
		
		// Refer Video - https://www.youtube.com/watch?v=iCrQG_kbuP0
		// numbers will start from 0
		
		int result = BMissingNumUsingCyclicSort.bMissingNumUsingCyclicSort(new int[] {3, 1, 0, 4, 2, 6, 7});
		System.out.println("Missing Number = " + result);
		int result1 = BMissingNumUsingCyclicSort.bMissingNumUsingCyclicSort(new int[] {3, 0, 4, 2, 6, 5});
		System.out.println("Missing Number = " + result1);
		
		int result3 = BMissingNumUsingCyclicSort.bMissingNumUsingCyclicSortV1(new int[] {3, 1, 0, 4, 2, 6, 7});
		System.out.println("Missing Number = " + result3);
		int result4 = BMissingNumUsingCyclicSort.bMissingNumUsingCyclicSortV1(new int[] {3, 0, 4, 2, 6, 5});
		System.out.println("Missing Number = " + result4);
		
		int result5 = BMissingNumUsingCyclicSort.bMissingNumUsingCyclicSortV2(new int[] {3, 1, 0, 4, 2, 6, 7});
		System.out.println("Missing Number = " + result5);
		int result6 = BMissingNumUsingCyclicSort.bMissingNumUsingCyclicSortV2(new int[] {3, 0, 4, 2, 6, 5});
		System.out.println("Missing Number = " + result6);

	}

	private static int bMissingNumUsingCyclicSort(int[] arr) {
		if(arr.length < 1) {
			return 0;
		}
		int i = 0;
		while( i < arr.length ) {
			if(arr[i] < arr.length && arr[i] != arr[arr[i]]) {
				int destIndex = arr[i];
				int temp = arr[i];
				arr[i] = arr[destIndex];
				arr[destIndex] = temp;
			}else {
				i++;
			}
		}
		
		for (i = 0; i < arr.length; i++) {
			if(arr[i] != i) {
				return i;
			}
		}
		return arr.length;
		
	}

	
	private static int bMissingNumUsingCyclicSortV1(int[] arr) {
		if(arr.length < 1) {
			return 0;
		}
		
		int allXOR = 0;
		for (int i = 0; i <= arr.length; i++) { // take xor of all elements upto arr.length and not arr.length-1 since 1 numbet is missing
			allXOR = allXOR ^ i;
		}
		
		for(int num : arr) {
			allXOR = allXOR ^ num;
		}
		return allXOR;
	}
	
	private static int bMissingNumUsingCyclicSortV2(int[] arr) {
		if(arr.length < 1) {
			return 0;
		}
		int n = arr.length;
		int sumOfArr = (n * (n + 1))/2;
		System.out.println("sumOfArr = " + sumOfArr);
		
		for (int i = 0; i < arr.length; i++) {
			sumOfArr = sumOfArr - arr[i];
			System.out.println(sumOfArr);
		}
		
		return sumOfArr;
	}
		
}


