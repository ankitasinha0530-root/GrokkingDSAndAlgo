package com.practice.a.sliding.window;

import java.util.HashMap;

public class FLongstSubstrWithSameLetreAftrRepl {

	public static void main(String[] args) {
		 int result = FLongstSubstrWithSameLetreAftrRepl.fLongstSubstrWithSameLetreAftrRepl(2, "aabccb");
		 int result1 = FLongstSubstrWithSameLetreAftrRepl.fLongstSubstrWithSameLetreAftrRepl(2, "abccdef");
			
			System.out.println("FLongstSubstrWithSameLetreAftrRepl == " + (result));
			System.out.println("FLongstSubstrWithSameLetreAftrRepl == " + (result1));

	}

	private static int fLongstSubstrWithSameLetreAftrRepl(int k, String str) {
		int maxLength = 0;
		int ws = 0;
		int maxCharOccur = 0;   // to keep the count of maximum occuring chharacter, to keep track of the number of chars to be changed
		// by subtracting the maxoccurchar count from window size  charschange = windowsize(we-ws+1) - maxoccurrence 
		//(in this case if it exceeds k then start shrinking the window. )
		
		HashMap<Character, Integer> maxCharOccurFreq = new HashMap<>();
		
		for(int we = 0; we < str.length(); we++) {
			char rightChar = str.charAt(we);
			maxCharOccurFreq.put(rightChar, maxCharOccurFreq.getOrDefault(rightChar, 0)+1);
			maxCharOccur = Math.max(maxCharOccur, maxCharOccurFreq.get(rightChar));
			
			if((we-ws+1 - maxCharOccur) > k){    //if windowSize-maxoccurchar > k , start shrinking the window from left.
				char leftChar = str.charAt(ws);
				maxCharOccurFreq.put(leftChar, maxCharOccurFreq.get(leftChar) - 1 );
				ws++;
			}
			
			maxLength = Math.max(maxLength, we-ws+1);
		}
		
		return maxLength;
	}

}
