package com.practice.a.sliding.window;

import java.util.Arrays;

public class AvgOfContSubarray {

	public static void main(String[] args) {

		double[] result = AvgOfContSubarray.AvgOfContinSubarray(5, new int[] {2, 6, 7, 8, 9, -1, 6, 4, 5, 3 });

		System.out.println("AvgOfContSubarray == " + Arrays.toString(result));
	}

	public static double[] AvgOfContinSubarray(int k, int[] arr) {
		
		double[] sumArray = new double[arr.length -1];
		int windowStart = 0;
		double windowSum = 0;
		
		for(int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
			windowSum += arr[windowEnd];
			
			if(windowEnd >= k-1) {
				sumArray[windowStart] = windowSum/k;
				windowSum = windowSum - arr[windowStart];
				windowStart++;
			}
		}
		
		return sumArray;
	}

}
