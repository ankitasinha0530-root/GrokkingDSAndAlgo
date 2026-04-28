package com.practice.a.sliding.window;

import java.util.HashMap;

public class DLongstSubstringWithKDistinctChars {

	public static void main(String[] args) {
		 int result = DLongstSubstringWithKDistinctChars.longstSubstringWithKDistinctChars(2, new char[] {'A', 'B', 'C', 'A', 'C'});
		 int result1 = DLongstSubstringWithKDistinctChars.longstSubstringWithKDistinctChars(2, new char[] {'A', 'B', 'C', 'B', 'B', 'C' });
			
			System.out.println("LongstSubstringWithKDistinctChars == " + (result));
			System.out.println("LongstSubstringWithKDistinctChars == " + (result1));

	}

	private static int longstSubstringWithKDistinctChars(int k, char[] arr) {
	
		int windStart = 0;
		int maxLength = 0;
		HashMap<Character, Integer> frqncyMap = new HashMap<>();
		
		for(int windEnd = 0; windEnd < arr.length; windEnd++) {
			frqncyMap.put(arr[windEnd], frqncyMap.getOrDefault(arr[windEnd], 0) + 1);
			
			while(frqncyMap.size() > k) {
				frqncyMap.put(arr[windStart], frqncyMap.get(arr[windStart]) -1);
				
				if(frqncyMap.get(arr[windStart]) == 0) {
					frqncyMap.remove(arr[windStart]);
				}
			windStart++;
			}
			maxLength = Math.max(maxLength, (windEnd-windStart) +1 );
		}
		
		return maxLength;
	}
	
//	private static int longstSubstringWithKDistinctChars(int k, char[] arr) {
//		
//		int windStart = 0;
//		int maxLength = 0;
//		Set<Character, Integer> frqncyMap = new HashMap<>();
//		
//		for(int windEnd = 0; windEnd < arr.length; windEnd++) {
//			frqncyMap.put(arr[windEnd], frqncyMap.getOrDefault(arr[windEnd], 0) + 1);
//			
//			while(frqncyMap.size() > k) {
//				frqncyMap.put(arr[windStart], frqncyMap.get(arr[windStart]) -1);
//				
//				if(frqncyMap.get(arr[windStart]) == 0) {
//					frqncyMap.remove(arr[windStart]);
//				}
//			windStart++;
//			}
//			maxLength = Math.max(maxLength, (windEnd-windStart) +1 );
//		}
//		
//		return maxLength;
//	}

}
