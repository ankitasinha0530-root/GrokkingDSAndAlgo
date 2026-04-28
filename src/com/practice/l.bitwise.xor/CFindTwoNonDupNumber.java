package com.practice.l.bitwise.xor;

public class CFindTwoNonDupNumber {

	public static void main(String[] args) {
		
		// Refer Video = https://www.youtube.com/watch?v=pnx5JA9LNM4 - pepcoding

		int[] result = CFindTwoNonDupNumber.findTwoNonDupNumber(new int[] {1, 4, 2, 1, 3, 5, 6, 2, 3, 5});
		System.out.println("value = " + result[0] +", " + result[1]);
		result = CFindTwoNonDupNumber.findTwoNonDupNumber(new int[] {2, 1, 3, 2});
		System.out.println("value = " + result[0] +", " + result[1]);

	}

	private static int[] findTwoNonDupNumber(int[] arr) {

		int xXorY= 0;
		
		for (int i = 0; i < arr.length; i++) {
			xXorY = xXorY ^ arr[i];  // find n1 * n2
		}
		
		int rightMostSetBit = xXorY & -xXorY; //
		
		int x = 0, y = 0;
		
		for(int num : arr) {
			if((num & rightMostSetBit) != 0){
				x = x ^ num;
			}else {
				y = y ^ num;
			}
		}
		return new int[] {x, y};
	}

}
