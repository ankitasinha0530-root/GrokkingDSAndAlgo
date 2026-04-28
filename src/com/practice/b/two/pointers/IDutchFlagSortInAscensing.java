package com.practice.b.two.pointers;

public class IDutchFlagSortInAscensing {

	public static void main(String[] args) {
		
		//Video -- https://www.youtube.com/watch?v=6sMssUHgaBs
		//Video -- 
		//Sort 0s, 1s and 2s, sort the array in-place(should be done in original array itself), 0 - red, 1 - white, 2 - blue
		//no inbilt Library to be used for sorting so use brute force and temp variables
		System.out.println("IDutchFlagSortInAscensing == " + 
				IDutchFlagSortInAscensing.iDutchFlagSortInAscensing(new int[] {1, 0, 2, 1, 0}));
		
		System.out.println("IDutchFlagSortInAscensing == " + 
				IDutchFlagSortInAscensing.iDutchFlagSortInAscensing(new int[] {2, 2, 0, 1, 2, 0}));
		
		int[] result = IDutchFlagSortInAscensing.iDutchFlagSortInAscensing(new int[] {1, 0, 2, 1, 0});
		int[] result1 = IDutchFlagSortInAscensing.iDutchFlagSortInAscensing(new int[] {2, 2, 0, 1, 2, 0});
		
		for (int value : result)
            System.out.print(value + " ");
		System.out.println();
		for (int row : result1)
            System.out.print(row + " ");

	}

	private static int[] iDutchFlagSortInAscensing(int[] arr) {
		int low = 0;
		int high = arr.length-1;
		
		for(int mid = 0; mid <= high;) {
			
			// we have to use else if here as only one of the condition needs to be true in a single iteration
			
			if(arr[mid] == 0) {
				swap(arr, mid, low);
				mid++;
				low++;
			}else if(arr[mid] == 1){
				mid++;
			}else{
				swap(arr, mid, high);
				high--;
			}
		}
		
		return arr;
	}

	private static void swap(int[] arr, int mid, int j) {
		int temp = arr[mid];
		arr[mid] = arr[j];
		arr[j] = temp;
		
	}

}
