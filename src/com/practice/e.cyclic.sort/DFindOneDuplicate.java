package com.practice.e.cyclic.sort;

public class DFindOneDuplicate {

	public static void main(String[] args) {
		
		// Refer video = https://www.youtube.com/watch?v=_n5MR8IxR6c
		// 1. when there is only one duplicate it forms a cycle like linkedlist cycle
		// we can also solve using slow and fast pointer, starting point of the cycle is the duplicate value
		// 2. One more way to solve is by using a Hashet. start iteratinf and compare the number in hashshet
		// if the number is not founf then add the number in hashset, if the number is found that is our answer.
		// 3. we can also start to solve using cyclic sort, if the number is not at correct position, 
		// move ahead and try to swap before comoare the with the number at dest position if its same, that is our answer.
		
		int result = DFindOneDuplicate.dFindOneDuplicate(new int[] {1, 4, 4, 3, 2});
		System.out.println("Duplicate Number = " + result);
		
		int result1 = DFindOneDuplicate.dFindOneDuplicate(new int[] {2, 1, 3, 3, 5, 4});
		System.out.println("Duplicate Number = " + result1);
		
		int result3 = DFindOneDuplicate.dFindOneDuplicate(new int[] {2, 4, 1, 4, 4});
		System.out.println("Duplicate Number = " + result3);
		
		int result4 = DFindOneDuplicate.dFindOneDuplicateV1(new int[] {1, 4, 4, 3, 2});
		System.out.println("Duplicate Number = " + result4);
		
		int result5 = DFindOneDuplicate.dFindOneDuplicateV1(new int[] {2, 1, 3, 3, 5, 4});
		System.out.println("Duplicate Number = " + result5);
		
		int result6 = DFindOneDuplicate.dFindOneDuplicateV1(new int[] {2, 4, 1, 4, 4});
		System.out.println("Duplicate Number = " + result6);

	}

	private static int dFindOneDuplicateV1(int[] arr) {
		int i = 0;
		
		while(i < arr.length){
			if(arr[i] != i+1) {  // to check if the number is at correct index
				if(arr[i] != arr[arr[i] -1]) { // to check if there is a duplicate
					int dest = arr[i] - 1; 
					int temp = arr[i];
					arr[i] = arr[dest];
					arr[dest] = temp;
				}else {
					return arr[i];
				}
			}else i++;
		}
		return -1;
	}

	private static int dFindOneDuplicate(int[] arr) {
		int slow = 0;
		int fast = 0;
		
		do {
			slow = arr[slow];
			fast = arr[arr[fast]];
		}while(slow != fast);
		
		slow = 0;
		
		while(slow != fast) {
			slow = arr[slow];
			fast = arr[fast];
		}
		return slow;
	}

}
