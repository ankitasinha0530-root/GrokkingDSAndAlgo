package com.practice.k.binary.search;

public class DFindNextLetter {

	public static void main(String[] args) {
		
		System.out.println("Index = " + DFindNextLetter.findNextLetter(new char[] {'a', 'c', 'f', 'h'}, 'f'));
		System.out.println("Index = " + DFindNextLetter.findNextLetter(new char[] {'a', 'c', 'f', 'h'}, 'b'));
		System.out.println("Index = " + DFindNextLetter.findNextLetter(new char[] {'a', 'c', 'f', 'h'}, 'm'));
		System.out.println("Index = " + DFindNextLetter.findNextLetter(new char[] {'a', 'c', 'f', 'h'}, 'n'));
		System.out.println("Index = " + DFindNextLetter.findNextLetter(new char[] {'a', 'c', 'f', 'h', 'j'}, 'i'));

	}

	private static char findNextLetter(char[] letters, char key) {
		int n = letters.length;
		if(key < letters[0] || key > letters[n-1]) {
			return letters[0];
		}
		
		int start = 0, end = n - 1;   
		
		while(start <= end) {
			int mid = start + (end - start)/2;
			if(key < letters[mid]) {
				end = mid - 1;
			}else {
				start = mid + 1;
			}
		}
		// since loop is running start <= end then, at the end start =  end + 1
		return letters[start%n];
	}

}
