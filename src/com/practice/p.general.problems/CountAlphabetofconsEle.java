package com.practice.p.general.problems;

public class CountAlphabetofconsEle {

	public static void main(String[] args) {
			
		String s = "aaabbaacccc";
		System.out.println(countAlphabets("aaabbaacccc"));
		//Output = a3b2a2c4 
	}
	
	public static String countAlphabets(String str) {
		int i = 0;
		int count = 0;
		StringBuilder strb = new StringBuilder();
		
		char[] strArray = str.toCharArray();
		
		for (i = 0; i < strArray.length-1; i++) {
			
			if(strArray[i]== strArray[i+1] ) {
				count++;
			}else {
				count++;
				strb.append(strArray[i]);
				strb.append(count);
				count = 0;
			}
		}
		count++;
		strb.append(strArray[i]);
		strb.append(count);
		count = 0;
		
		return strb.toString();
	}

}
