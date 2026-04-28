package com.practice.k.binary.search;

public class GMinDiffWithAGivenKey {

	public static void main(String[] args) {

		System.out.println("value = " + GMinDiffWithAGivenKey.minDiffWithAGivenKey(new int[] {1, 3, 10, 15 }, 12));
		System.out.println("value = " + GMinDiffWithAGivenKey.minDiffWithAGivenKey(new int[] {4, 6, 10}, 4));
		System.out.println("value = " + GMinDiffWithAGivenKey.minDiffWithAGivenKey(new int[] {4, 6, 10}, 7));
		System.out.println("value = " + GMinDiffWithAGivenKey.minDiffWithAGivenKey(new int[] {4, 6, 10}, 17));
		System.out.println("value = " + GMinDiffWithAGivenKey.minDiffWithAGivenKey(new int[] {1, 2, 3 , 4, 5, 6, 7,}, 6 ));

	}

	private static int minDiffWithAGivenKey(int[] arr, int key) {
		if(arr[0] > key) {
			return arr[0];
		}
		if(arr[arr.length - 1] < key ) {
			return arr[arr.length - 1];
		}
		int start = 0, end = arr.length - 1;
		
		while(start <= end) {
			int mid = start + (end - start)/2;
			
			if(key < arr[mid]) {
				end = mid - 1;
			}else if(key > arr[mid]) {
				start = mid + 1;
			}else {
				return arr[mid];
			}
		}
		// we did not find the element and 
		//the loop will end at start = end + 1 , thus start is greater and end is smaller than key
		// now we will find the array with minm diff
		
		if(arr[start] - key <  key - arr[end]) {
			return arr[start];
		}
		return arr[end];
	}

}
