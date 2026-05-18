package com.practice.k.binary.search;

public class JElemInRotatedArray {

	public static void main(String[] args) {

		System.out.println("value = " + JElemInRotatedArray.elemInRotatedArray(new int[] {10, 15, 1, 3, 8 }, 15));
		System.out.println("value = " + JElemInRotatedArray.elemInRotatedArray(new int[] {4, 5, 7, 9, 10, -1, 2}, 10));
		System.out.println("value = " + JElemInRotatedArray.elemInRotatedArray(new int[] {1, 3, 8, 12}, 12));
		System.out.println("value = " + JElemInRotatedArray.elemInRotatedArray(new int[] {10, 9, 8 }, 10));

	}

	private static int elemInRotatedArray(int[] arr, int key) {

		int start = 0, end = arr.length - 1;
		
		while(start <= end) {
			int mid = start + (end - start)/2;
			if(key == arr[mid]) {
				return mid;
			}
			if(arr[start] <= arr[mid]) {  // ascending  arr[start] can be equal to arr[mid]
				if(key >= arr[start] && key < arr[mid]) {
					end = mid - 1;
				}else {
					start = mid  + 1;
				}
			}else { // in descending order
				if(key > arr[mid] && key < arr[end]) {
					start = mid + 1;
				}else {
					end = mid - 1;
				}
				
			}
		}
		return -1;
	}

}
