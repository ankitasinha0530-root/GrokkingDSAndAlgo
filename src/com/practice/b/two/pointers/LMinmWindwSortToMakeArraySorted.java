package com.practice.b.two.pointers;

public class LMinmWindwSortToMakeArraySorted {

	public static void main(String[] args) {
		//Video refer - https://www.youtube.com/watch?v=TGWkLukqnls
		
		int result = LMinmWindwSortToMakeArraySorted.lMinmWindwSortToMakeArraySorted(new int[] {1, 2, 5, 3, 7, 10, 9, 12}); 
		int result1 = LMinmWindwSortToMakeArraySorted.lMinmWindwSortToMakeArraySorted(new int[] {1, 3, 2, 0, -1, 7, 10 });
		int result2 = LMinmWindwSortToMakeArraySorted.lMinmWindwSortToMakeArraySorted(new int[] {1, 2, 3 });
		int result3 = LMinmWindwSortToMakeArraySorted.lMinmWindwSortToMakeArraySorted(new int[] {3, 2, 1,});
			
		System.out.println("LMinmWindwSortToMakeArraySorted == " + (result));
		System.out.println("LMinmWindwSortToMakeArraySorted == " + (result1));
		System.out.println("LMinmWindwSortToMakeArraySorted == " + (result2));
		System.out.println("LMinmWindwSortToMakeArraySorted == " + (result3));

	}

	private static int lMinmWindwSortToMakeArraySorted(int[] arr) {
		int left = 0, right = arr.length-1;
		int subArrMin = Integer.MAX_VALUE;
		int subArrMax = Integer.MIN_VALUE;
			
			while(left < arr.length-1 && arr[left] <= arr[left+1]) {
				left++;
			}

			if(left == arr.length-1) {
				return 0;
			}
			
			while(right > 0 && arr[right] >= arr[right-1]) {
				right--;
			}

			if(left == arr.length-1) {
				return arr.length-1;
			}
			
			for (int k = left; k<=right; k++) {
				
				subArrMax = Math.max(subArrMax, arr[k]);
				subArrMin = Math.min(subArrMin, arr[k]);
			}
			
			while (left > 0 && arr[left-1] > subArrMin) {
				left--;	
			}
			
			while (right < arr.length-1 && arr[right+1] < subArrMax) {
				right++;	
			}

		return right-left+1;
	}

}
