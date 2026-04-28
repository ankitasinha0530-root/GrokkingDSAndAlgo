package com.practice.k.binary.search;

public class KRotationCount {

	public static void main(String[] args) {

		System.out.println("value = " + KRotationCount.rotationCount(new int[] {10, 15, 1, 3, 8 }));
		System.out.println("value = " + KRotationCount.rotationCount(new int[] {4, 5, 7, 9, 10, -1, 2}));
		System.out.println("value = " + KRotationCount.rotationCount(new int[] {1, 3, 8, 12}));
		System.out.println("value = " + KRotationCount.rotationCount(new int[] {1, 3, 8, 10 }));
		
	}

	private static int rotationCount(int[] arr) {
		// find the index of smallest number as smallest number will be the number lower than both its left and right element
		// index of lowest number in rotated array is equql to number of times it is rotated.
		int start = 0, end = arr.length - 1;
		
		while (start < end) {
			int mid = start + (end - start)/2;
			
			if(mid < end && arr[mid] > arr[mid + 1]) {
				return mid + 1;
			}
			if(start < mid && arr[mid - 1] > arr[mid]) {
				return mid;
			}
			if(arr[start] < arr[mid]){   // left of mid is sorted, hence the pivot is on the right hand side
				start = mid + 1;
			}else {
				end = mid - 1;  // if right hand side is sorted then pivot is on left hand side
			}
			
		}
		
		return 0;
	}

}
