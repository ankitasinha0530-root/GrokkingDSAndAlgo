package com.practice.b.two.pointers;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class BAllSortedArrPairSumEqualsTarget {

	public static void main(String[] args) {
//		int[][] resultArr = BAllSortedArrPairSumEqualsTarget.aSortedArrPairSumEqualsTarget(6, new int[] {2, 3, 4, 6, 7, 8, 9});
//		int[][] resultArr1 = BAllSortedArrPairSumEqualsTarget.aSortedArrPairSumEqualsTarget(5, new int[] {1, 2, 3, 4, 5, 6, 8, 9});
		
		int[][] resultArrV2 = BAllSortedArrPairSumEqualsTarget.aSortedArrPairSumEqualsTargetV2(6, new int[] {2, 3, 4, 6, 7, 8, 9});
		int[][] resultArr1V2 = BAllSortedArrPairSumEqualsTarget.aSortedArrPairSumEqualsTargetV2(5, new int[] {1, 2, 3, 4, 5, 6, 8, 9});
		
//		System.out.println("Pair of Indices with Target sum = [" + resultArr[0] + ", " +resultArr[1] + "]" );
//		System.out.println("Pair of Indices with Target sum = [" + resultArr1[0] + ", " +resultArr1[1] + "]" );
		
		System.out.println("Pair of Indices with Target sum = [" + resultArrV2[0] + ", " +resultArrV2[1] + "]" );
		System.out.println("Pair of Indices with Target sum = [" + resultArr1V2[0] + ", " +resultArr1V2[1] + "]" );
		
		for (int[] row : resultArrV2)
            // converting each row as string
            // and then printing in a separate line
            System.out.println(Arrays.toString(row));
		
		 System.out.println();
		
		for (int[] row : resultArr1V2)
            // converting each row as string
            // and then printing in a separate line
            System.out.println(Arrays.toString(row));

	}

//	private static int[][] aSortedArrPairSumEqualsTarget(int tSum, int[] arr) {
//		// TODO Auto-generated method stub
//		return null;
//	}

	private static int[][] aSortedArrPairSumEqualsTargetV2(int tSum, int[] arr) {
		Map<Integer, Integer> nums = new HashMap<>();
		int a = 0;
		int rows = (arr.length - 1)/2;
		int columns = 2;
		int[][] resultArr = new int[rows][columns];
		     
		for(int i = 0; i<arr.length; i++) {
			if(nums.containsKey(tSum - arr[i])) {
				resultArr[a][0] = nums.get(tSum - arr[i]);
				resultArr[a][1] = i;
				a++;	
		     }
			nums.put(arr[i], i);
		 }
		return resultArr;
	}

}
