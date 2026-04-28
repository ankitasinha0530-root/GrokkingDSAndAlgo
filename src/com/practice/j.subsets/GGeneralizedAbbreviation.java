package com.practice.j.subsets;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class GGeneralizedAbbreviation {
	
	static class Abbreviation{
		String str;
		int start;
		int count;
		
		public Abbreviation(String str, int start, int count){
			this.str = str;
			this.start = start;
			this.count = count;
		}
	}

	public static void main(String[] args) {
		
		// Refer Video = https://www.youtube.com/watch?v=LliQjLnbhx8
		// 2 calls one for including the element and the other for excluding the element
		
		List<String> result  = GGeneralizedAbbreviation.generategeneralizedAbbreviation("BAT");
		System.out.println("result == " + result);
		
		List<String> result1  = GGeneralizedAbbreviation.generategeneralizedAbbreviation("CODE");
		System.out.println("result 1 == " + result1);
		
		List<String> result2 = GGeneralizedAbbreviation.generategeneralizedAbbreviationV2("BAT");
		System.out.println("result2 == " + result2);
		
		List<String> result3  = GGeneralizedAbbreviation.generategeneralizedAbbreviationV2("CODE");
		System.out.println("result3 == " + result3);
	}

	private static List<String> generategeneralizedAbbreviationV2(String word) {
		List<String> result = new ArrayList<>();
		Queue<Abbreviation> queueAbr =  new LinkedList<>();
		
		queueAbr.add(new Abbreviation("", 0, 0));
		
		while(!queueAbr.isEmpty()) {
			Abbreviation abr = queueAbr.poll();
			
			if(abr.start == word.length() -1 ) {
				if(abr.count == 0) {
					result.add(abr.str.toString());
				}else {
					result.add((abr.str + abr.count).toString());
				}
			}
			
			queueAbr.add(new Abbreviation(abr.str, abr.start + 1, abr.count + 1));
			
			if(abr.count != 0) {
				abr.str += abr.count;
			}
			queueAbr.add(new Abbreviation(abr.str + word.charAt(abr.start), abr.start + 1 ,0));
		}
		return result;
	}

	private static List<String> generategeneralizedAbbreviation(String str) {
		List<String> resultAbb = new ArrayList<>();		
		String asf = "";
		GGeneralizedAbbreviation.generateAbbreviation(str, asf, 0, 0, resultAbb);
		return resultAbb;
	}

	private static void generateAbbreviation(String str, String asf, int count, int pos, List<String> resultAbb) {

		if(pos == str.length()){
			if(count == 0) {
				resultAbb.add(asf);
			}else {
				resultAbb.add(asf + count);
			}
			return;
		}
		
		// Since we are not adding the character, hence count+1 is sent
		generateAbbreviation(str, asf, count + 1, pos + 1, resultAbb);
		
		if(count == 0) {
			// Since we are adding the character, hence count 0 is sent
			generateAbbreviation(str, asf + str.charAt(pos), 0, pos+1, resultAbb); 
		}else {
			// Since we are adding the character, hence count 0 is sent
			generateAbbreviation(str, asf + count + str.charAt(pos), 0, pos+1, resultAbb);
		}
	}

}
