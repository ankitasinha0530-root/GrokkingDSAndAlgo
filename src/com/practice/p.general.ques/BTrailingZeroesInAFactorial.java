package com.practice.p.general.ques;

public class BTrailingZeroesInAFactorial {

	public static void main(String[] args) {
		
		// every 5th time 5 occurs so i = 5
		// everytime a number has 25 it means it has 2 times 5 in it
		// hence i will increment with i*5 times to consider number containing 25

		int n = 30;
		int res = 0;
		
		for (int i = 5; i <= n; i = i*5) {
			res = res + n/i;
		}
		
		System.out.println(res);

	}

}
