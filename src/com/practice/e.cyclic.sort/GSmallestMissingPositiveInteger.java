package com.practice.e.cyclic.sort;

public class GSmallestMissingPositiveInteger {

	public static void main(String[] args) {


		//Refer Video - https://www.youtube.com/watch?v=qGk-4qa226s

		int result = GSmallestMissingPositiveInteger.gSmallestMissingPositiveInteger(new int[] {3, 1, 2, 5, 2});
		System.out.println("Duplicate Number = " + result);
				
		int result1 = GSmallestMissingPositiveInteger.gSmallestMissingPositiveInteger(new int[] {-3, 1, 5, 4, 2});
		System.out.println("Duplicate Number = " + result1);
			
		int result3 = GSmallestMissingPositiveInteger.gSmallestMissingPositiveInteger(new int[] {3, -2, 0, 1, 2});
		System.out.println("Duplicate Number = " + result3);

		int result9 = GSmallestMissingPositiveInteger.gSmallestMissingPositiveInteger(new int[] {3, 2, 5, 1});
		System.out.println("Duplicate Number = " + result9);
				
		int result10 = GSmallestMissingPositiveInteger.gSmallestMissingPositiveIntegerV1(new int[] {3, 1, 2, 3, 6, 4});
		System.out.println("Duplicate Number = " + result10);
				
		int result4 = GSmallestMissingPositiveInteger.gSmallestMissingPositiveIntegerV1(new int[] {4, 3, 4, 5, 1});
		System.out.println("Duplicate Number = " + result4);

	}

	private static int gSmallestMissingPositiveInteger(int[] arr) {

		int i = 0;
		
		while(i < arr.length) {
			
			if(arr[i] > 0 && arr[i] <= arr.length && arr[i] != arr[arr[i] -1]) {
				int dest = arr[i] - 1;
				int temp = arr[i];
				arr[i] = arr[dest];
				arr[dest] = temp;
			}else {
				i++;
			}
		}
		
		for (i = 0; i < arr.length; i++) {
			if(arr[i] != i+1) {
				return i+1;
			}
		}
		return arr.length + 1;
	}

	// sort the element first and keep on traversing untill we find the first non continuous element
	private static int gSmallestMissingPositiveIntegerV1(int[] is) {
		// TODO Auto-generated method stub
		return 0;
	}


}
