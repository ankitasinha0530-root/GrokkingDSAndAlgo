package com.practice.b.two.pointers;

import java.util.Arrays;

public class CRemoveDupliAndFindLenthNewArr {

	public static void main(String[] args) {
		
		int result = CRemoveDupliAndFindLenthNewArr.cRemoveDupliAndFindLenthNewArr(new int[] {2, 6, 4, 4, 4, 6, 4, 5, 3 }); 
		// 2, 3, 4, 4, 4, 4, 5, 6, 6
		int result1 = CRemoveDupliAndFindLenthNewArr.cRemoveDupliAndFindLenthNewArr(new int[] {2, 3, 5, 2, 5, 2, 3 });
			
		System.out.println("CRemoveDupliAndFindLenthNewArr == " + (result));
		System.out.println("CRemoveDupliAndFindLenthNewArr == " + (result1));

	}

	private static int cRemoveDupliAndFindLenthNewArr(int[] arr) {
		int nextNonDulicate = 1;
		
		Arrays.sort(arr);
		
		for(int i = 0; i < arr.length -1 ; i++) {
			
			if(arr[nextNonDulicate -1 ] != arr[i]) { // start with both pointers at same element, if duplicate is found then 
													// next non-duplicate will not increment and only i will increment'
				arr[nextNonDulicate] = arr[i];
				nextNonDulicate++;
			}
		}
		return nextNonDulicate;
	}
}
