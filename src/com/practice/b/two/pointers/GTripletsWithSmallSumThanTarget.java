package com.practice.b.two.pointers;

import java.util.Arrays;

public class GTripletsWithSmallSumThanTarget {

	public static void main(String[] args) {
		
		System.out.println("gTripletsWithSmallSumThanTarget == " + 
				GTripletsWithSmallSumThanTarget.gTripletsWithSmallSumThanTarget(3, new int[] {-1, 0, 2, 3}));
		
		System.out.println("gTripletsWithSmallSumThanTarget == " + 
				GTripletsWithSmallSumThanTarget.gTripletsWithSmallSumThanTarget(5, new int[] {-1, 4, 2, 1, 3}));
//
//		int result = GTripletsWithSmallSumThanTarget.gTripletsWithSmallSumThanTarget(3, new int[] {-2, -1, 0, 1, 4, 6 }); 
//		int result1 = GTripletsWithSmallSumThanTarget.gTripletsWithSmallSumThanTarget(8, new int[] {-9, -5, 0, 1, 5, 8 });
//		int result2 = GTripletsWithSmallSumThanTarget.gTripletsWithSmallSumThanTarget(5, new int[] {-4, -2, 1, 1, 2, 8 });
//		int result3 = GTripletsWithSmallSumThanTarget.gTripletsWithSmallSumThanTarget(7, new int[] {-3, 2, 0, 1, 2, 8 });
//			
//		System.out.println("GTripletsWithSmallSumThanTarget == " + (result));
//		System.out.println("GTripletsWithSmallSumThanTarget == " + (result1));
//		System.out.println("GTripletsWithSmallSumThanTarget == " + (result2));
//		System.out.println("GTripletsWithSmallSumThanTarget == " + (result3));
//		
//		System.out.println("gTripletsWithSmallSumThanTarget == " + 
//						GTripletsWithSmallSumThanTarget.gTripletsWithSmallSumThanTarget(3, new int[] {-1, 0, 2, 3}));
//		System.out.println("gTripletsWithSmallSumThanTarget == " + 
//						GTripletsWithSmallSumThanTarget.gTripletsWithSmallSumThanTargetV2(5, new int[] {-1, 4, 2, 1, 3}));

	}

	private static int gTripletsWithSmallSumThanTarget(int tSum, int[] arr) {
		int cntOfTriplFnd = 0;
		Arrays.sort(arr);
		for(int i = 0; i < arr.length-2; i++) {
			int left = i+1, right = arr.length-1;
			int newSum = 0;
			
			while(left < right) {
				newSum = arr[i] + arr[left] + arr[right];
				if(newSum >= tSum) {
					right--;
				}else {
					cntOfTriplFnd += right-left; //as soon the sum is smaller than given Sum, 
												//so any number which is present left of right index will give smaller sum only, 
												// then we can have count as the number of elements between left and right
												// there can be right-left number of third element.
					left++;
				}
			}
		}
		return cntOfTriplFnd;
	}

//	private static String gTripletsWithSmallSumThanTargetV2(int i, int[] js) {
//		// TODO Auto-generated method stub
//		return null;
//	}

}
