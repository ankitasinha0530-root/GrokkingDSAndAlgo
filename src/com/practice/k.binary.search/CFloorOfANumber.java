package com.practice.k.binary.search;

public class CFloorOfANumber {

	public static void main(String[] args) {
		
		// The floor of the ‘key’ will be the biggest element in the given array smaller than or equal to the ‘key’
		
		System.out.println("Index = " + CFloorOfANumber.floorOfANumber(new int[] {4, 6, 10}, 10));
		System.out.println("Index = " + CFloorOfANumber.floorOfANumber(new int[] {1, 2, 3 , 4, 5, 6, 7,}, 5 ));
		System.out.println("Index = " + CFloorOfANumber.floorOfANumber(new int[] {4, 6, 10, 15}, 12));
		System.out.println("Index = " + CFloorOfANumber.floorOfANumber(new int[] {4, 6, 10, 12, 15}, 15));
		System.out.println("Index = " + CFloorOfANumber.floorOfANumber(new int[] {4, 6, 10, 12, 15}, -1));
	}

	private static int floorOfANumber(int[] arr, int key) {
		int start = 0, end = arr.length - 1;
		
		if(key < arr[0]) {
			return -1;
		}
		
		while(start <= end) {
			int mid = start + (end - start)/2;
			
			if(key < arr[mid]) {
				end = mid - 1;
			}else if(key > arr[mid]){
				start = mid + 1;
			}else {
				return mid;
			}
		}
		return end;
	}

}
