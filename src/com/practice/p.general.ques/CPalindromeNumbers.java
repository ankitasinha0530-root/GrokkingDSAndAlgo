package com.practice.p.general.ques;

public class CPalindromeNumbers {

	public static void main(String[] args) {

		// original number equals reverse eg - aba, 363, 7887, racecar
		
		int n = 3663;
		
		int reverse = 0;
		int temp = n;
		
		while(temp != 0) {
			// take the rightmost digit from temp
			int rightmost = temp % 10;
			reverse = (reverse * 10) + rightmost; // add rightmost number
			// divide the number by 10 to reduce the number size from right
			temp = temp/10; 
		}
		System.out.println(reverse == n);

	}

}
