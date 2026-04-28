package com.practice.p.general.ques;

import java.util.Iterator;

public class AFactorialOfANum {
	static int prod = 1;

	public static void main(String[] args) {

		int n = 6;
		long fact = 1;

		for (int i = n; i > 0; i--) {
			fact *= i;
		}
		System.out.println(fact);

		System.out.println("factorial recursion = " + factorialUsingrecurr(n));
		
		System.out.println("factorial recursion and Ternary = " + factorialRecurssionAndTernary(n));

	}

	private static int factorialUsingrecurr(int n) {

		if (n == 0) {
			return 1;
		}
		return n * factorialUsingrecurr(n - 1);
	}

	static int factorialRecurssionAndTernary(int n) {
		
		return (n == 1 || n == 0) ? 1 : n * factorialRecurssionAndTernary(n - 1);
	}

}
