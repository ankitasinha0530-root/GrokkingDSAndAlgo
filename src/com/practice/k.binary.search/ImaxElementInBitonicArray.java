package com.practice.k.binary.search;

public class ImaxElementInBitonicArray {

	public static void main(String[] args) {

		System.out.println("value = " + ImaxElementInBitonicArray.maxElementInBitonicArray(new int[] {1, 3, 8, 4, 3 }, 4));
		System.out.println("value = " + ImaxElementInBitonicArray.maxElementInBitonicArray(new int[] {3, 8, 3, 1}, 8));
		System.out.println("value = " + ImaxElementInBitonicArray.maxElementInBitonicArray(new int[] {1, 3, 8, 12}, 12));
		System.out.println("value = " + ImaxElementInBitonicArray.maxElementInBitonicArray(new int[] {10, 9, 8 }, 10));

	}

	private static int maxElementInBitonicArray(int[] arr, int key) {
			
		int start = 0, end = arr.length - 1;
		// first find the highest element
		while(start < end) {
			int mid = start + (end - start)/2;
			if(arr[mid] < arr[mid + 1]) {
				start = mid + 1;
			}else if(arr[mid] > arr[mid + 1]) {
				end = mid;
			}
		}
		int maxEleInd = start;
		int val = ImaxElementInBitonicArray.findElement(arr, 0, maxEleInd, key,  true);
		if(val != -1) {
			return val;
		}else {
			return ImaxElementInBitonicArray.findElement(arr, maxEleInd, arr.length - 1, key,  true);
		}
		
	}

	private static int findElement(int[] arr, int start, int end, int key, boolean isAsc) {
		
		while(start <= end) {
			int mid = start + (end - start)/2;
			if(arr[start] < arr[end]) {   // to find the ascending part of the array
				if(arr[mid] < key) {
					start = mid + 1;
				}else if(arr[mid] > key) {
					end = mid - 1;
				}else {
					return mid;
				}
			}else {
				if(arr[mid] < key) {
					end = mid - 1;
				}else if(arr[mid] > key){
					start = mid + 1;
				}else {
					return mid;
				}
			}
		}
		
		return -1;
		// TODO Auto-generated method stub
		
	}

}
