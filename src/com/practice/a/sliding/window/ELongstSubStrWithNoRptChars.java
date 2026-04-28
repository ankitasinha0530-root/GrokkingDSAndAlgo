package com.practice.a.sliding.window;

import java.util.HashMap;

public class ELongstSubStrWithNoRptChars {

	public static void main(String[] args) {
		 int result = ELongstSubStrWithNoRptChars.eLongstSubStrWithNoRptChars("aabccb");
		 int result1 = ELongstSubStrWithNoRptChars.eLongstSubStrWithNoRptChars("abccdef");
			
			System.out.println("ELongstSubStrWithNoRptChars == " + (result));
			System.out.println("ELongstSubStrWithNoRptChars == " + (result1));

	}

	private static int eLongstSubStrWithNoRptChars(String str) {
		int maxLength = 0;
		int windStart = 0;
		HashMap<Character, Integer> charMap = new HashMap<>();
		
		for(int windEnd = 0; windEnd < str.length(); windEnd++) {
			
			char rightChar = str.charAt(windEnd);
			
			if(charMap.containsKey(rightChar)) {
				windStart = Math.max(windStart, charMap.get(rightChar) + 1);
			}
			charMap.put(rightChar, windEnd);
			maxLength = Math.max(maxLength, windEnd - windStart + 1);
				
		}
		// TODO Auto-generated method stub
		return maxLength;
	}

}
