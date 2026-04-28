package com.practice.j.subsets;

import java.util.ArrayList;
import java.util.List;

public class EPermutationByChangeCaseMaintainOrder {
	
	// Refer Video = https://www.youtube.com/watch?v=J2Er5XceU_I
	// Refer Video = https://www.youtube.com/watch?v=jpw0n7tLNgc
	// Refer Video = https://www.youtube.com/watch?v=4eOPYDOiwFo&t=87s
	
	static List<String> resultList = null;
	public static void main(String[] args) {

		resultList = new ArrayList<>();
		EPermutationByChangeCaseMaintainOrder.findPermutationsByCaseChange("abc", "");
		System.out.println("Result = " + resultList + "  size == " + resultList.size());
		// Result = [abc, abC, aBc, aBC, Abc, AbC, ABc, ABC]  size == 8

		resultList = new ArrayList<>();
		EPermutationByChangeCaseMaintainOrder.findPermutationsByCaseChange("de7fg", "");
		System.out.println("Result = " + resultList + "  size == " + resultList.size());
		
		resultList = new ArrayList<>();
		List<String> result2 = EPermutationByChangeCaseMaintainOrder.findPermutationsByCaseChangeV2("abc");
		System.out.println("Result 2 = " + result2 + "  size == " + result2.size());
		// Result = [abc, abC, aBc, aBC, Abc, AbC, ABc, ABC]  size == 8

		List<String> result3 = EPermutationByChangeCaseMaintainOrder.findPermutationsByCaseChangeV2("de7fg");
		System.out.println("Result 3 = " + result3 + "  size == " + result3.size());

	}


	private static List<String> findPermutationsByCaseChangeV2(String str) {

		List<String> permutations = new ArrayList<>();
		
		permutations.add(str);
		
		for (int i = 0; i < str.length(); i++) {
			
			if(Character.isLetter(str.charAt(i))) {
				int n = permutations.size();
				for (int j = 0; j < n; j++) {
					char[] chs = permutations.get(j).toCharArray();
					
					if(Character.isUpperCase(chs[i])) {
						chs[i] = Character.toLowerCase(chs[i]);
					}else {
						chs[i] = Character.toUpperCase(chs[i]);
					}
					permutations.add(String.valueOf(chs));
 				}
			}
			
		}
		return permutations;
		
	}


	private static void findPermutationsByCaseChange(String str, String asf) {
		if(str.length() == 0) {
			resultList.add(asf);
			return;
		}
			if(Character.isLetter(str.charAt(0))) {
				String op1 = asf + Character.toLowerCase(str.charAt(0));
				String op2 = asf + Character.toUpperCase(str.charAt(0));
				str = str.substring(1);
				findPermutationsByCaseChange(str, op1); // call for left side for lower case
				findPermutationsByCaseChange(str, op2); // call for right side for Upper case
			}else {
				String op1 = asf + str.charAt(0);
				str = str.substring(1);
				findPermutationsByCaseChange(str, op1);
			}

	}

}
