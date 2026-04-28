package com.practice.k.binary.search;

public class HMaxElementInBitonicArray {

	public static void main(String[] args) {

		System.out.println("value = " + HMaxElementInBitonicArray.maxElementInBitonicArray(new int[] {1, 3, 8, 12, 4, 2 }));
		System.out.println("value = " + HMaxElementInBitonicArray.maxElementInBitonicArray(new int[] {3, 8, 3, 1}));
		System.out.println("value = " + HMaxElementInBitonicArray.maxElementInBitonicArray(new int[] {1, 3, 8, 12}));
		System.out.println("value = " + HMaxElementInBitonicArray.maxElementInBitonicArray(new int[] {10, 9, 8}));

	}

	private static int maxElementInBitonicArray(int[] arr) {

		int start = 0, end = arr.length - 1;
		
		while(start <  end) { 		// let the loop run while start < end , thus, the loop will exit when start = end 
			int mid = start + (end - start)/2;
			
			if(arr[mid] < arr[mid + 1]) { // if true, highest number will be on the right of the middle
				start = mid + 1;   
			}else if(arr[mid] > arr[mid + 1]){ // // if true, highes number will be on the left of the middle
				end = mid;
			}
		}
		
		// here since loop was valid only till start < end so at the end of the loop "start = end "
		// and both will be point to the highest element
		return arr[start];
	}

}
