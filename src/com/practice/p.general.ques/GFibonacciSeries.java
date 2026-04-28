package com.practice.p.general.ques;

public class GFibonacciSeries {

	public static void main(String[] args) {
		
		int i = 0, j = 1; int sum; int n = 10 - 2;
		
		System.out.print(i + " " + j);

		while(n > 0) {
			
			sum = i + j;
			System.out.print(" " + sum);
			i = j;
			j = sum;
			n--;
		}

	}

}
