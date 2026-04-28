package com.practice.j.subsets;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class FGenerateBalancedParanthesis {
	
	static class Paranthesis{
		String str;
		int openC;
		int closeC;
		
		public Paranthesis(String str, int openC, int closeC) {
			this.str = str;
			this.openC = openC;
			this.closeC = closeC;
		}
	}

	public static void main(String[] args) {

		// Refer Video = https://www.youtube.com/watch?v=eyCj_u3PoJE
		
		List<String> result = FGenerateBalancedParanthesis.generateBalancedParanthesis(2);
		System.out.println("result == " + result);
		
		List<String> result1 = FGenerateBalancedParanthesis.generateBalancedParanthesis(3);
		System.out.println("result1 == " + result1);
		
		List<String> result2 = FGenerateBalancedParanthesis.generateBalancedParanthesis(4);
		System.out.println("result2 == " + result2);
		
		List<String> result3 = FGenerateBalancedParanthesis.generateBalancedParanthesisV2(2);
		System.out.println("result 3 == " + result3);
		
		List<String> result4 = FGenerateBalancedParanthesis.generateBalancedParanthesisV2(3);
		System.out.println("result 4 == " + result4);
		
		List<String> result5 = FGenerateBalancedParanthesis.generateBalancedParanthesisV2(4);
		System.out.println("result 5 == " + result5);

	}

	private static List<String> generateBalancedParanthesisV2(int num) {
		List<String> result = new ArrayList<>();
		Queue<Paranthesis> queue = new LinkedList<>();
		Paranthesis paran = new Paranthesis("", 0, 0);
		
		queue.add(paran);
		
		while(!queue.isEmpty()) {
			Paranthesis ps = queue.poll();
			if(ps.openC == num && ps.closeC == num) {
				result.add(ps.str);
			}else {
				if(ps.openC < num) {
					queue.add(new Paranthesis(ps.str + "(", ps.openC+1, ps.closeC));
				}
				if(ps.openC > ps.closeC) {
					queue.add(new Paranthesis(ps.str + ")", ps.openC, ps.closeC+1));
				}
			}
			
		}
		return result;
	}

	private static List<String> generateBalancedParanthesis(int num) {
		List<String> result = new ArrayList<String>();
		int openC = num;
		int closeC = num;
		String output = "";
				
		result = FGenerateBalancedParanthesis.generateParanthesis(openC, closeC, output, result);
		return result;
	}

	private static List<String> generateParanthesis(int openC, int closeC, String output, List<String> result) {

		if(openC == 0 && closeC == 0) {
			result.add(output);
			return result;
		}
		
		if(openC >= 0) {		
			String op1 = output + "(";
			generateParanthesis(openC-1, closeC, op1, result);
		}
		if(closeC > openC) {
			String op2 = output + ")";
			generateParanthesis(openC, closeC-1, op2, result);
		}
		return result;
	}

}
