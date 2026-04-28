package com.practice.p.general.ques;

public class HReverseANumber {

	public static void main(String[] args) {

		int num = 12436;
		
		int num1= 1;
		
		reverseNumUsingRecurssion(num);
		reverseNum(num);
	}

	private static void reverseNum(int num) {
		
		int reverse = 0; // initialize reverse with 0;
		while(num != 0) {
			int remainder = num % 10;     // Find remainder 
			reverse = reverse*10 + remainder;  // reverse by multiplying 10 in the reverse number and then adding remainder
			num = num / 10; // divide the number by 10 to remove the last element
		}
		
		System.out.println(reverse);
		
	}

	private static void reverseNumUsingRecurssion(int num) {

		if(num < 10) {
			System.out.println(num);
		}else {
			System.out.print(num%10);
			reverseNumUsingRecurssion(num/10);
		}

	}

}
