package com.practice.q.recurrsion.concept;

public class BNumberOfPathinNxMMatrix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	static int count(int n, int m) {
		if(m==1 || n ==1) {
			return 1;
		}
		
		return count(n, m-1) +count(n-1, m);
	}
}
