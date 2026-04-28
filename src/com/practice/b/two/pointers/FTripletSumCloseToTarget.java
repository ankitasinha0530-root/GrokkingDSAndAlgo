package com.practice.b.two.pointers;

import java.util.Arrays;

public class FTripletSumCloseToTarget {

	public static void main(String[] args) {

		// link of video https://www.youtube.com/watch?v=uSpJQa6MRZ8

		int result = FTripletSumCloseToTarget.fTripletSumCloseToTarget(3, new int[] { -2, -1, 0, 1, 4, 6 });
		int result1 = FTripletSumCloseToTarget.fTripletSumCloseToTarget(8, new int[] { -9, -5, 0, 1, 5, 8 });
		int result2 = FTripletSumCloseToTarget.fTripletSumCloseToTarget(5, new int[] { -4, -2, 1, 1, 2, 8 });
		int result3 = FTripletSumCloseToTarget.fTripletSumCloseToTarget(7, new int[] { -3, 2, 0, 1, 2, 8 });

		System.out.println("FTripletSumCloseToTarget == " + (result));
		System.out.println("FTripletSumCloseToTarget == " + (result1));
		System.out.println("FTripletSumCloseToTarget == " + (result2));
		System.out.println("FTripletSumCloseToTarget == " + (result3));

		System.out.println("FTripletSumCloseToTarget == "
				+ FTripletSumCloseToTarget.fTripletSumCloseToTargetV2(5, new int[] { -4, -2, 1, 1, 2, 8 }));
		System.out.println("FTripletSumCloseToTarget == "
				+ FTripletSumCloseToTarget.fTripletSumCloseToTargetV2(7, new int[] { -3, 2, 0, 1, 2, 8 }));

	}

	private static String fTripletSumCloseToTargetV2(int tSum, int[] arr) {
		// TODO Auto-generated method stub
		return null;
	}

	private static int fTripletSumCloseToTarget(int tSum, int[] arr) {
		Arrays.sort(arr);
		int minDiff = Integer.MAX_VALUE;
		int resultSum = 0;
		for (int i = 0; i < arr.length - 2; i++) {

			int left = i + 1;
			int right = arr.length - 1;
			while (left < right) {
				int sum = arr[i] + arr[left] + arr[right];

				if (sum == tSum) {
					return tSum;
				}
				if (sum < tSum) {
					left++;
				} else {
					right--;
				}
				
				int diffToTarget = Math.abs(tSum - sum);
				if (diffToTarget < minDiff) {
					minDiff = diffToTarget;
					resultSum = sum;
				}
			}
		}
		return resultSum;
	}
}
