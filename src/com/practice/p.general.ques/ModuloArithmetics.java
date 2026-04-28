package com.practice.p.general.ques;

public class ModuloArithmetics {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Modulo operation returns remainder after division
		// eg 7 % 4 = 3 when we divide 7 by 4 the remiander is 3
		// (a+b)%n = (a%n + b%n) % n
		// (a*b)%n = (a%n * b%n) % n
		// (a-b)%n = (a%n - b%n) % n
		
		System.out.println("fastPower = " + fastPower(4, 3));
		System.out.println("fastPower = " + fastPower(3, 5));
		
		System.out.println("fastPowerForLargeNum = " + fastPowerForLargeNum(372364832, 5, 10000000));
	}
	
	static int fastPower(int a, int b) {
		int res = 1;
		
		while(b > 0) {
	//		if((b % 2) != 0) { /odd/ to find even  even and odd number
			if((b&1) != 0) { //odd/ since modulo is costly we use but wise &
				res = res* a;
			}
			a = a*a;
			b = b >> 1;        // since b/2 is costly so use bit rightshift
		}
		
		return res;
	}
	
	static long fastPowerForLargeNum(long a, long b, int n) {
		long res = 1;
		
		while(b > 0) {
	//		if((b % 2) != 0) { /odd/ to find even  even and odd number
			if((b&1) != 0) { //odd/ since modulo is costly we use but wise &
				res = ( res * a % n) % n;
			}
			a = (a % n * a % n) %n;
			b = b >> 1;        // since b/2 is costly so use bit rightshift
		}
		
		return res;
	}

}
