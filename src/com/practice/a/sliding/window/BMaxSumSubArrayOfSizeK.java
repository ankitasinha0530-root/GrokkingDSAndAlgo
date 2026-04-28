package com.practice.a.sliding.window;

public class BMaxSumSubArrayOfSizeK {

	public static void main(String[] args) {
		
    int result = BMaxSumSubArrayOfSizeK.maxSumSubArraySizeK(3, new int[] {2, 6, 7, 8, 9, -1, 6, 4, 5,3 });
		
		System.out.println("BMaxSumSubArrayOfSizeK == " + (result));

	}
	
	public static int maxSumSubArraySizeK(int k, int[] arr) {
		
		int windowStart=0;
		int windowSum = 0;
		int maxSum = Integer.MIN_VALUE;
		
		for(int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
			windowSum += arr[windowEnd];
			
			if(windowEnd >= k-1) {
				maxSum = Math.max(maxSum, windowSum);
				windowSum = windowSum - arr[windowStart];
				windowStart++;
			}
		}
		return maxSum;
	}

}
