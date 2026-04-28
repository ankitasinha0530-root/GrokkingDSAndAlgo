package com.practice.l.bitwise.xor;

import java.util.HashMap;
import java.util.Map;

public class BFindNonDuplicateNumber {

	public static void main(String[] args) {

		System.out.println("value = " + BFindNonDuplicateNumber.findNonDuplicateNumber(new int[] {1, 4, 2, 1, 3, 2, 3}));
		System.out.println("value V2 = " + BFindNonDuplicateNumber.findNonDuplicateNumberV2(new int[] {1, 4, 2, 1, 3, 2, 3}));
		

	}

	private static int findNonDuplicateNumber(int[] arr) {
		 
		int num = 0; // any number XOR will 0 will give that number
		
		for (int i = 0; i <= arr.length - 1; i++) {
			num = num ^ arr[i]; // all duplicate number will give zero and num will be left with the unique number
		}
		return num;
	}
	
	//Using HashMap
	private static int findNonDuplicateNumberV2(int[] arr) {
		 
		Map<Integer, Integer> duplicate = new HashMap<>();
		
		for (int i = 0; i < arr.length; i++) {
			if(duplicate.containsKey(arr[i])) {
				duplicate.remove(arr[i]);
				
			}else {
				duplicate.put(arr[i], 1);
			}
		}
		
		
		for(Map.Entry<Integer, Integer> map : duplicate.entrySet()){
			if(map.getValue().equals(1)){
			return	map.getKey();
			}
		}
		
//		duplicate.entrySet().stream()
//							.filter(entry -> entry.getValue().equals(1))
//							.forEach(entry -> System.out.println(entry.getKey()));
		
	    return 0;

	}

}
