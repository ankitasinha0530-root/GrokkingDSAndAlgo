package com.practice.e.cyclic.sort;

import java.util.Arrays;

public class ASortElementInOrder {

	public static void main(String[] args) {
		// Refervide - https://www.youtube.com/watch?v=YvksaZhYYAk
		// Cyclic Sort is only applicable if we have an array of continuous manner
		// but not sorted
		
		ASortElementInOrder.aSortElementInOrder(new int[] {3, 1, 5, 4, 2});
		
		System.out.println("ASortElementInOrder == " + 
				ASortElementInOrder.aSortElementInOrder(new int[] {1, 5, 6, 4, 3, 2}));
		
		int[] result = ASortElementInOrder.aSortElementInOrder(new int[] {3, 1, 5, 4, 2});
		System.out.println(Arrays.toString(result));
//		int[] result1 = ASortElementInOrder.aSortElementInOrder(new int[] {1, 5, 6, 4, 3, 2});
		int[] result2 = ASortElementInOrder.aSortElementInOrder(new int[] {2, 6, 4, 3, 1, 5, 7});
		System.out.println(Arrays.toString(result2));
		int[] result3 = ASortElementInOrder.aSortElementInOrderV2(new int[] {12, 16, 14, 13, 11, 15});
		System.out.println(Arrays.toString(result3));
		int[] result4 = ASortElementInOrder.aSortElementInOrderV2(new int[] {21, 25, 26, 24, 23, 22});
		System.out.println(Arrays.toString(result4));
		
		int[] arr = new int[] {1, 5, 6, 4, 3, 2};
		ASortElementInOrder.aSortElementInOrder(arr);
		System.out.println();
		System.out.print("Check if Array acts as reference : ");
		for (int row : arr)
            System.out.print(row + " ");

	}

	private static int[] aSortElementInOrderV2(int[] arr) {
//		int i = 0;
//		int x = 0;
////		x = smallestNumber; // find the smallest number in the element
//		while(i < arr.length) {
//			if(arr[i] -x != i) { // or if(arr[i] != i + x)
//				int destIndex = arr[i]-x;
//				int temp = arr[i];
//				arr[i] = arr[destIndex];
//				arr[destIndex] = temp;
//			}else {
//				i++;
//			}
//			
//		}
		return arr;
	}


	private static int[] aSortElementInOrder(int[] arr) {
		if(arr.length < 1) {
			return arr;
		}
		int i = 0;
		
		while(i < arr.length) {
			if(arr[i] != i + 1) {  // or if(arr[i] - 1 != i)
				int destIndex = arr[i]-1;
				int temp = arr[i];
				arr[i] = arr[destIndex];
				arr[destIndex] = temp;
			}else {
				i++;
			}
			
		}
		return arr;
	}

}
