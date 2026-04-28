package com.practice.b.two.pointers;


public class KCompareStringContainingBackSpaces {

	public static void main(String[] args) {
		
		// Video - https://www.youtube.com/watch?v=MGOjHoeMlsM

		 boolean result = KCompareStringContainingBackSpaces.kCompareStringContainingBackSpaces("xy#z", "xzz#");
		 boolean result1 = KCompareStringContainingBackSpaces.kCompareStringContainingBackSpaces("xy#z", "xyz#");
		 boolean result2 = KCompareStringContainingBackSpaces.kCompareStringContainingBackSpaces("xp#", "xyz##");
		 boolean result3 = KCompareStringContainingBackSpaces.kCompareStringContainingBackSpaces("xywrrmp", "xywrrmu#p");
		 boolean result4 = KCompareStringContainingBackSpaces.kCompareStringContainingBackSpaces("ay#z", "xzz#");
			
			System.out.println("KCompareStringContainingBackSpaces == " + (result));
			System.out.println("KCompareStringContainingBackSpaces == " + (result1));
			System.out.println("KCompareStringContainingBackSpaces == " + (result2));
			System.out.println("KCompareStringContainingBackSpaces == " + (result3));
			System.out.println("KCompareStringContainingBackSpaces == " + (result4));
	}

	private static boolean kCompareStringContainingBackSpaces(String s1, String s2) {

		String str1 = createActualString(s1);
		String str2 = createActualString(s2);
			
		return str1.equals(str2);
	}

	private static String createActualString(String input) {
		int hashCount = 0;
		StringBuilder newString = new StringBuilder();
		
		for (int i = input.length()-1; i>= 0; i--) {
			
			if(input.charAt(i) == '#'){
				hashCount++;
				continue;
			}
			
			if(hashCount > 0) {
				hashCount--;
			}else {
				newString.insert(0, input.charAt(i)) ;  
			}
		}
		System.out.println("String in createActualString == " + newString.toString());
		return newString.toString();
	}

}
