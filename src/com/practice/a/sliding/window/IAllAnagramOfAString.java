package com.practice.a.sliding.window;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IAllAnagramOfAString {

	public static void main(String[] args) {
		List<Integer> result = IAllAnagramOfAString.iAllAnagramOfAString("abc", "aabccb");
		List<Integer> result1 = IAllAnagramOfAString.iAllAnagramOfAString("abc", "abccdefcba");
		List<Integer> result2 = IAllAnagramOfAString.iAllAnagramOfAString("cde", "euwhrjkhnkj");
			
		System.out.println("IAllAnagramOfAString == " + (result));
		System.out.println("IAllAnagramOfAString == " + (result1));
		System.out.println("IAllAnagramOfAString == " + (result2));

	}

	private static List<Integer> iAllAnagramOfAString(String s1, String s2) {
		int ws =0;
		int matched = 0;
		Map<Character, Integer> charFreqCount= new HashMap<>();
		List<Integer> resultIndices = new ArrayList<>();
		for(char cr : s1.toCharArray()) {
			charFreqCount.put(cr, charFreqCount.getOrDefault(cr, 0) + 1);
		}
		
		for(int we = 0; we < s2.length(); we++) {
			char right = s2.charAt(we);
			
			if(charFreqCount.containsKey(right)) {
				charFreqCount.put(right, charFreqCount.get(right) - 1);
				if(charFreqCount.get(right) == 0)
				matched++;
			}
			
			if(matched == charFreqCount.size()) {
				resultIndices.add(ws);     // this will store the starting point of the window which has an anagram
			}
			
			if(we >= s1.length()-1) {
				char left = s2.charAt(ws); //can also be written as char left = s2.charAt(ws++) which does w++ opn as well
				ws++;
				if(charFreqCount.containsKey(left)) {
					if(charFreqCount.get(left) == 0)
						matched--;
					charFreqCount.put(left, charFreqCount.get(left) + 1);
				}
			}
			
		}
		return resultIndices;
	}

}
