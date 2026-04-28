package com.practice.p.general.problems;

import java.util.Stack;

public class ValidParenthesis {

	public static void main(String[] args) {

		String str = "()[]{}";
		String str2 = "()[]{(}";
		
		System.out.println(IsValidParanthesis(str));
		System.out.println(IsValidParanthesis(str2));
	}

	private static boolean IsValidParanthesis(String str) {

		Stack<Character> stack = new Stack<>();
		
		for(char ch : str.toCharArray()) {
			if(ch == '(') {
				stack.push(')');
			}else if(ch == '{') {
				stack.push('}');
			}else if(ch == '[') {
				stack.push(']');
			}else if(stack.isEmpty() || stack.pop() != ch) {
				return false;
			}
		}
		
		return true;
	}

}
