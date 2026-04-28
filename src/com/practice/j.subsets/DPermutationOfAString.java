package com.practice.j.subsets;

import java.util.ArrayList;
import java.util.List;

public class DPermutationOfAString {

//	Refer video = pepcoding
//	Refer Video = https://www.youtube.com/watch?v=gDGw0cvFXPQ
	static List<String> resultList = null;
	
	public static void main(String[] args) {

		resultList = new ArrayList<>();
				DPermutationOfAString.findPermutationsofString("abc", "");
		System.out.println("Result = " + resultList + "  size == " + resultList.size());
//		Result = [abc, acb, bac, bca, cab, cba]  size == 6
		
		resultList = new ArrayList<>();
		DPermutationOfAString.findPermutationsofString("defg", "");
		System.out.println("Result 1 = " + resultList + "  size == " + resultList.size());
	}

	private static void findPermutationsofString(String str, String asf) {
		
		if(str.length() == 0) {
			resultList.add(asf);
		}

		for (int i = 0; i < str.length(); i++) {
			
			char ch = str.charAt(i);
			String LeftOfQues = str.substring(0,i);
			String RightOfQues = str.substring(i+1);
			String restOfQues = LeftOfQues + RightOfQues;
			
			findPermutationsofString(restOfQues, asf+ch);
			
		}
		
	}

}
