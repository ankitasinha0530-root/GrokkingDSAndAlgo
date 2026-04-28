package com.practice.a.sliding.window;

import java.util.HashMap;

public class HFindPermutInAString {

	public static void main(String[] args) {
		 boolean result = HFindPermutInAString.gFindPermutInAString("abc", "aabccb");
		 boolean result1 = HFindPermutInAString.gFindPermutInAString("cde", "abccdef");
		 boolean result2 = HFindPermutInAString.gFindPermutInAString("cde", "euwhrjkhnkj");
			
			System.out.println("HFindPermutInAString == " + (result));
			System.out.println("HFindPermutInAString == " + (result1));
			System.out.println("HFindPermutInAString == " + (result2));

	}

	private static boolean gFindPermutInAString(String s1, String s2) {
		int matched =0;
		int ws = 0;
		HashMap<Character, Integer> charFreqMap = new HashMap<>();
		if(s1.length() > s2.length() || s2.length() == 0) return false;
		
		for(int i=0; i<s1.length(); i++) {
			charFreqMap.put(s1.charAt(i), charFreqMap.getOrDefault(s1.charAt(i), 0) + 1);
		}
		
		for(int we=0; we<s2.length(); we++) {
			char right = s2.charAt(we);
			if(charFreqMap.containsKey(s2.charAt(we))){
				charFreqMap.put(right, charFreqMap.get(right)-1);
				matched++;				
			}
			if(matched == s1.length()) {
				return true;
			}
			if(we >= s1.length()-1) {    //length of window is now greater than s1 so start sliding the window
				char left = s2.charAt(ws);
				if(charFreqMap.containsKey(left)){
					charFreqMap.put(left, charFreqMap.get(left)+1);
					matched--;
				}
				ws++;
			}
		}

		return false;
	}

}
