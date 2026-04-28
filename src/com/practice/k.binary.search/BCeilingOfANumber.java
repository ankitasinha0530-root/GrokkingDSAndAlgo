package com.practice.k.binary.search;

public class BCeilingOfANumber {

	public static void main(String[] args) {
		
		// The ceiling of the ‘key’ will be the smallest element in the given array greater than or equal to the ‘key’.
		
		System.out.println("Index = " + BCeilingOfANumber.ceilingOfANumber(new int[] {4, 6, 10}, 10));
		System.out.println("Index = " + BCeilingOfANumber.ceilingOfANumber(new int[] {1, 2, 3 , 4, 5, 6, 7,}, 5 ));
		System.out.println("Index = " + BCeilingOfANumber.ceilingOfANumber(new int[] {4, 6, 10, 15}, 12));
		System.out.println("Index = " + BCeilingOfANumber.ceilingOfANumber(new int[] {4, 6, 10}, 17));
		System.out.println("Index = " + BCeilingOfANumber.ceilingOfANumber(new int[] {4, 6, 10, }, -1));
	}

	private static int ceilingOfANumber(int[] arr, int key) {
		
		int start = 0, end = arr.length - 1;
		
		if(key > arr[end]) {
			return -1;
		}
		
		// when array is sorted in ascending order
		while(start <= end) {
			
			int mid = start + (end - start)/2;
			
			if(key == arr[mid])
			 return mid;
			
			if(key < arr[mid]) {
				end = mid - 1;
			}else if(key > arr[mid]){
				start = mid + 1;
			}
		}
		return start; // since we have to return index which has key or  number which is immediately lower than key
	}



}
