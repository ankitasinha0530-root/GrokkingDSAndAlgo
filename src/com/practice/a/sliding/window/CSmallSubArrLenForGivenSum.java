package com.practice.a.sliding.window;

public class CSmallSubArrLenForGivenSum {

	public static void main(String[] args) {
		 int result = CSmallSubArrLenForGivenSum.smallSubArrLenForGivenSum(8, new int[] {2, 6, 7, 4, -1, 6, 4, 5,3 });
		 int result1 = CSmallSubArrLenForGivenSum.smallSubArrLenForGivenSum(7, new int[] {2, 1, 5, 2, 3, 2 });
			
			System.out.println("ELongstSubStrWithNoRptChars == " + (result));
			System.out.println("ELongstSubStrWithNoRptChars == " + (result1));

	}

	private static int smallSubArrLenForGivenSum(int sum, int[] arr) {
		Integer minLength = Integer.MAX_VALUE;
		int windStart = 0;
		int windSum = 0;
		
		for (int windEnd = 0; windEnd < arr.length; windEnd ++) {
			windSum += arr[windEnd];
			
			while(windSum >= sum) {
				minLength = Math.min(minLength, windEnd-windStart+1);
				windSum -= arr[windStart];
				windStart++;
			}
		}
		
		return minLength == Integer.MAX_VALUE ? 0 : minLength;
	}

}
