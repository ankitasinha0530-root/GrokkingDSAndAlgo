  package com.practice.k.binary.search;

public class AFindAgivenEleminArray {

	public static void main(String[] args) {
		
		// Array can be sorted in ascending or descending
		// step 1 : find if ascending arr[start] < arr[end]
		// step 2 : if middle in both cases and repeat the step
		
		System.out.println("Index = " + AFindAgivenEleminArray.binarySearch(new int[] {4, 6, 10}, 10));
		System.out.println("Index = " + AFindAgivenEleminArray.binarySearch(new int[] {1, 2, 3 , 4, 5, 6, 7,}, 5 ));
		System.out.println("Index = " + AFindAgivenEleminArray.binarySearch(new int[] {10, 6, 4}, 10));
		System.out.println("Index = " + AFindAgivenEleminArray.binarySearch(new int[] {10, 6, 4}, 4));
		System.out.println("Index = " + AFindAgivenEleminArray.binarySearch(new int[] {8, 7, 6, 5, 4, 3, 2, 1}, 2));
		System.out.println("Index = " + AFindAgivenEleminArray.binarySearch(new int[] {8, 7, 6, 5, 4, 3, 2, 1}, 9));
		
		System.out.println("Index v2 = " + AFindAgivenEleminArray.binarySearchV2(new int[] {1, 2, 3 , 4, 5, 6, 7,}, 5 ));

	}

	private static int binarySearchV2(int[] arr, int key) {
		int low = 0;
		int high = arr.length-1;
		
		int result = binarySearchRecurr(arr, key, low, high);
		return result;
	}

	// time complexity will be log n
	private static int binarySearchRecurr(int[] arr, int key, int low, int high) {
		if(low > high) {
			return -1;
		}
		int mid = low + (high-low)/2;
		if(arr[mid] == key) {
			return mid;
		}
		if(arr[mid] < key) {
			return binarySearchRecurr(arr, key, mid+1, high);
		}else {
			return binarySearchRecurr(arr, key, low, mid-1);
		}
		
	}

	// best approach is iterative , time complexity will be constant
	private static int binarySearch(int[] arr, int key) {

		int start = 0, end = arr.length-1;
		boolean isAscending = arr[start] < arr[end];
		
		while(start <= end) {
			
			int mid = start + (end - start)/2;
			if(key == arr[mid]) {
				return mid;
			}
			
			if(isAscending) {
				if(key < arr[mid]) {
					end = mid - 1;
				}else {
					start = mid + 1;
				}
			}else {
				if(key > arr[mid]) {
					end = mid - 1;
				}else {
					start = mid+1;
				}
			}
		}
		return -1;
	}

}
