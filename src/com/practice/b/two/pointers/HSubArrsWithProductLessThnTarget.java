package com.practice.b.two.pointers;

import java.util.ArrayList;
import java.util.List;

public class HSubArrsWithProductLessThnTarget {

	public static void main(String[] args) {
		
		// Video to refer - https://www.youtube.com/watch?v=7rGxOMEBWKE
		//                 https://www.youtube.com/watch?v=SxtxCSfSGlo
		// Use two pointers and sliding window
		
		System.out.println("HSubArrsWithProductLessThnTarget == " + 
				HSubArrsWithProductLessThnTarget.hSubArrsWithProductLessThnTargetPrintSubArrsV2(30, new int[] {2,5,3,10}));
		
		System.out.println("HSubArrsWithProductLessThnTarget == " + 
				HSubArrsWithProductLessThnTarget.hSubArrsWithProductLessThnTargetPrintSubArrs(30, new int[] {2,5,3,10}));

		System.out.println("HSubArrsWithProductLessThnTarget == " + 
				HSubArrsWithProductLessThnTarget.hSubArrsWithProductLessThnTarget(30, new int[] {2,5,3,10}));
		
		System.out.println("HSubArrsWithProductLessThnTarget == " + 
				HSubArrsWithProductLessThnTarget.hSubArrsWithProductLessThnTarget(50, new int[] {8,2,6,5}));

//		List<List<Integer>> result = HSubArrsWithProductLessThnTarget.hSubArrsWithProductLessThnTargetPrintSubArrs(30, new int[] {2,5,3,10}); 
//		List<List<Integer>> result1 = HSubArrsWithProductLessThnTarget.hSubArrsWithProductLessThnTargetPrintSubArrsV2(30, new int[] {2,5,3,10});
//		int result2 = HSubArrsWithProductLessThnTarget.HSubArrsWithProductLessThnTarget(5, new int[] {-4, -2, 1, 1, 2, 8 });
//		int result3 = HSubArrsWithProductLessThnTarget.HSubArrsWithProductLessThnTarget(7, new int[] {-3, 2, 0, 1, 2, 8 });
			
//		System.out.println("HSubArrsWithProductLessThnTarget == " + (result));
//		System.out.println("HSubArrsWithProductLessThnTarget == " + (result1));
//		System.out.println("HSubArrsWithProductLessThnTarget == " + (result2));
//		System.out.println("HSubArrsWithProductLessThnTarget == " + (result3));

	}

	private static int hSubArrsWithProductLessThnTarget(int pr, int[] arr) {
		int ws = 0, we = 0;  // start and end both will be at zeroth position.s
		int countOfSubstr = 0;
		int newPr = 1;
		while(we < arr.length) {
			newPr *=  arr[we];
			
			while(ws < arr.length && newPr >= pr) {
				newPr = newPr/arr[ws];
				ws++;
			}
			
			if(newPr < pr) {
				countOfSubstr += we-ws+1; //Count would be the size of window
				we++;
			}
		}
		return countOfSubstr;
	}
	
	
	private static List<List<Integer>> hSubArrsWithProductLessThnTargetPrintSubArrs(int pr, int[] arr) { //30, new int[] {2,5,3,10}
		// start and end both will be at zeroth position and we will start with incrementing right
		List<List<Integer>> subArrsList = new ArrayList<>();
		
		int left = 0; //left starts with zero 
		int newPr = 1;
		for(int right = 0; right < arr.length; right++) { // right also starts from zero
			
			newPr *= arr[right];
			
			while(left < arr.length && newPr >= pr) {
				newPr = newPr/arr[left];
				left++;
			}
			if(newPr < pr ) {
				List<Integer> tempList = new ArrayList<>();
				for(int i=right; i>=left; i--) {
					tempList.add(0, arr[i]);
					subArrsList.add(new ArrayList<>(tempList));
				}
			}
		}
			
		return subArrsList;
	}
	
	
	//this is for Debugging purpose
	private static List<List<Integer>> hSubArrsWithProductLessThnTargetPrintSubArrsV2(int pr, int[] arr) { //30, new int[] {2,5,3,10}
		
		List<List<Integer>> subArrsList = new ArrayList<>(); 
		 
		int left = 0; //30, new int[] {2,5,3,10}
		int newPr = 1;
		for(int right = 0; right < arr.length; right++) {
			
			newPr *= arr[right];
			
			while(left < arr.length && newPr >= pr) {
				newPr = newPr/arr[left];
				left++;
			}
			if(newPr < pr ) {
				List<Integer> tempList = new ArrayList<>();

				for(int i=right; i>=left; i--) {
					int tempVal = arr[i];
					tempList.add(0, tempVal);
					subArrsList.add(new ArrayList<>(tempList));
					System.out.println("tempList == " + tempList);
					System.out.println("subArrsList == " + subArrsList);
				}
			}
		}
			
		return subArrsList;
	}

}
