package com.practice.p.general.ques;

public class DEuclidGCD {

	public static void main(String[] args) {

		System.out.println("gcd = " + eucliedGcd(15, 27));
		System.out.println("gcd = " + eucliedGcd(24, 60));
		
		System.out.println("gcd v2 = " + eucliedGcdv2(15, 27));
		System.out.println("gcd v2 = " + eucliedGcdv2(24, 60));

	}
	
	static int eucliedGcd(int a, int b) {
		
		if(b == 0) {
			return a;
		}
		return eucliedGcd(b, a%b);
	}
	
	static int eucliedGcdv2(int a, int b) {
		// or below one liner
		return a % b == 0 ? b : eucliedGcd(b, a%b);
	}
}
