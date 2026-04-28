package com.practice.c.slow.fast.pointers.d.merge.intervals;

import java.util.HashSet;
import java.util.Set;

public class CHappyNumber {

	public static void main(String[] args) {
		
		//refer video = https://www.youtube.com/watch?v=X_kwcctaQ4M
		//refer video = https://www.youtube.com/watch?v=ZOLCI-liNb0
		//refer video = https://www.youtube.com/watch?v=Egw03gI-Tf0&t=529s
		
		System.out.println("LinkedList Start of  cycle == " + CHappyNumber.cHappyNumber(23));
		System.out.println("LinkedList Start of  cycle == " + CHappyNumber.cHappyNumber(19));
		System.out.println("LinkedList Start of  cycle == " + CHappyNumber.cHappyNumber(12));
		System.out.println("LinkedList Start of  cycle == " + CHappyNumber.cHappyNumber(82));
		System.out.println();
		System.out.println("LinkedList Start of  cycle V2 == " + CHappyNumber.cHappyNumberV2(23));
		System.out.println("LinkedList Start of  cycle V2 == " + CHappyNumber.cHappyNumberV2(19));
		System.out.println("LinkedList Start of  cycle V2 == " + CHappyNumber.cHappyNumberV2(12));
		System.out.println("LinkedList Start of  cycle V2 == " + CHappyNumber.cHappyNumberV2(82));
		System.out.println();
		System.out.println("LinkedList Start of  cycle V3 == " + CHappyNumber.cHappyNumberV3(23));
		System.out.println("LinkedList Start of  cycle V3 == " + CHappyNumber.cHappyNumberV3(19));
		System.out.println("LinkedList Start of  cycle V3 == " + CHappyNumber.cHappyNumberV3(12));
		System.out.println("LinkedList Start of  cycle V3 == " + CHappyNumber.cHappyNumberV3(82));
		
		//Use HashSet to store the sums of numbers in cHappyNumber and cHappyNumberV2
		// Use Hare and Tortoise Algorithm to find the cycle cHappyNumberV3
	}

	// Use Hare and Tortoise Algorithm to find the cycle cHappyNumberV3 slow-one step and fast-two step
	private static boolean cHappyNumberV3(int num) {
		int slow = num;
		int fast = num;
		do {
			slow = findSquareSum(slow); // slow - move one step
			fast = findSquareSum(findSquareSum(fast)); // fast - move two step
		}while(slow != fast);
		
		return slow == 1;
	}

	private static int findSquareSum(int num) {
		int sum = 0; 
		int numDigit;
		
		while(num > 0) {
			numDigit = num%10;
			sum += numDigit * numDigit;
			num = num/10;
		}
		return sum;
	}

//	Use HashSet to store the sums of numbers and compare if num exists in set then return false
	private static boolean cHappyNumberV2(int num) {
		Set<Integer> usedInts = new HashSet<>();
		
		while(true) {
			int sum = 0; // initialize sum for every Iteration 
			while(num > 0) {
				sum += Math.pow(num%10, 2);  //Math.pow(number, power) to calculate power of a number
				num = num/10;
			}
			
			if(sum == 1) {
				return true;
			}
//	code v1
			else if(usedInts.contains(sum)) {
				return false;
			}else {
				num = sum;
				usedInts.add(num);
			}

//	code v2
//			num = sum;
//			if(usedInts.contains(sum)) {
//				return false;
//			}
//			usedInts.add(num);
			
		}
	}

//	Use HashSet to store the sums of numbers and compare if num exists in set then return false
	private static boolean cHappyNumber(int num) { // using hashset
		Set<Integer> set = new HashSet<>();
		
		while (num!=1 && !set.contains(num)) {
			set.add(num);
			int sum = 0;
			while(num>0) {
				sum += (int) Math.pow(num%10, 2);
				num = num/10;
			}
			
			num = sum;   //put the sum in num to calculate further sum 
		}
			
		return num==1;
	}

}
