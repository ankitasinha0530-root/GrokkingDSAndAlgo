package com.practice.q.recurrsion.concept;

import java.util.ArrayList;
import java.util.List;

public class FPrintAllPermutationOfAString {

	public static void main(String[] args) {
		
		String str = "abc";
		
		List<String> result = new ArrayList<>();

		permutation(str, 0, str.length()-1, result);
		System.out.println(result);
		
		printAllPermutation(str, "");

	}
	
private static void printAllPermutation(String str, String asf) {
		
		if(str.length() == 0) {
			System.out.print(asf + " ");
		}
		
		for(int i = 0; i < str.length(); i++) {
			
			char ch = str.charAt(i);
			String lroq = str.substring(0,i);
			String rroq = str.substring(i+1);
			String roq = lroq + rroq;
	//		String roq = str.substring(0,i) + str.substring(i+1);
			printAllPermutation(roq, asf + ch);
		}
		
	}

	private static void permutation(String str, int st, int len, List<String> result) {

		if(st == len) {
			result.add(str);
			return;
		}
		
		for (int i = st; i <=len ; i++) { // iterate until the end of string
			
			str = swap(str, st, i); // swap the characters in a string
			permutation(str, st+1, len, result);
			str = swap(str, st, i); // for backtracking
		}
	}

	private static String swap(String str, int st, int i) {
		
		StringBuilder sb = new StringBuilder(str);
			
		sb.setCharAt(i, str.charAt(st));
		sb.setCharAt(st, str.charAt(i));
		return sb.toString();
	}

}
