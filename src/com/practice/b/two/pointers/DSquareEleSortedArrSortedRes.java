package com.practice.b.two.pointers;

public class DSquareEleSortedArrSortedRes {
	
	// Square each element and keep them in sorted order after squaring

	public static void main(String[] args) {
		int[] result = DSquareEleSortedArrSortedRes.dSquareEleSortedArrSortedRes(new int[] {-2, -1, 0, 1, 4, 6 }); 
		int[] result1 = DSquareEleSortedArrSortedRes.dSquareEleSortedArrSortedRes(new int[] {-9, -5, 0, 1, 4, 8 });
			
		System.out.println("DSquareEleSortedArrSortedRes == " + (result));
		System.out.println("DSquareEleSortedArrSortedRes == " + (result1));
		
		for (int row : result)
            System.out.print(row + " ");
		System.out.println();
		for (int row : result1)
            System.out.print(row + " ");
	}

	private static int[] dSquareEleSortedArrSortedRes(int[] arr) {

		int left = 0;
		int right = arr.length - 1;
		int[] squares = new int[arr.length];
		
		int highestSqIndex = arr.length-1;
		
		while(left <= right) {
			
			int leftSquare = arr[left] * arr[left];
			int rightSquare = arr[right] * arr[right];
			
			if(leftSquare > rightSquare) {
				squares[highestSqIndex] = leftSquare;
				highestSqIndex--;
				left++;
			}else {
				squares[highestSqIndex] = rightSquare;
				highestSqIndex--;
				right--;
			}
		}
		return squares;
	}

}
