package com.practice.l.bitwise.xor;

public class AFindAMissingNumber {

	public static void main(String[] args) {
		
		// Refer Video = https://www.youtube.com/watch?v=iCrQG_kbuP0

		System.out.println("value = " + AFindAMissingNumber.findAMissingNumber(new int[] {3, 2, 0, 1, 5, 6 }));
		System.out.println("value = " + AFindAMissingNumber.findAMissingNumber(new int[] {3, 5, 0, 1, 4, 6}));
		System.out.println("value = " + AFindAMissingNumber.findAMissingNumber(new int[] {3, 5, 0, 1, 6, 4, 7, 2, 9}));
		
		//Using XOR operation
		System.out.println("value V2 = " + AFindAMissingNumber.findAMissingNumberV2(new int[] {3, 2, 0, 1, 5, 6 }));
		System.out.println("value V2 = " + AFindAMissingNumber.findAMissingNumberV2(new int[] {3, 5, 0, 1, 4, 6}));
		System.out.println("value V2 = " + AFindAMissingNumber.findAMissingNumberV2(new int[] {3, 5, 0, 1, 6, 4, 7, 2, 9}));
	}

	private static int findAMissingNumberV2(int[] arr) {
		
		int n = arr.length;
		
		int xorAll = 0;
		
		for (int i = 1; i < arr.length; i++) {
			xorAll = xorAll ^ i;
		}
		
		int X2 = arr[0];
		for (int i = 1; i < arr.length - 1 ; i++) {
			X2 = X2 ^ arr[i];
		}
		return xorAll ^ X2;
	}

	private static int findAMissingNumber(int[] arr) {
		int n = arr.length ; // total length of array will be length+1 , since 1 number is missing
		
		int sum = (n*(n+1))/2;
		System.out.println("sum = " + sum);
		
		for(int currNum : arr) {
			sum = sum - currNum;
//			System.out.println("sum after = " + sum);
			
		}
		
		return sum;
	}

}
