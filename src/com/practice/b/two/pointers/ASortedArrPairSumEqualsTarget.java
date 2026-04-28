package com.practice.b.two.pointers;

import java.util.HashMap;
import java.util.Map;

public class ASortedArrPairSumEqualsTarget {

	public static void main(String[] args) {
		int[] resultArr = ASortedArrPairSumEqualsTarget.aSortedArrPairSumEqualsTarget(6, new int[] {2, 3, 4, 6, 7, 8, 9});
		int[] resultArr1 = ASortedArrPairSumEqualsTarget.aSortedArrPairSumEqualsTarget(5, new int[] {1, 2, 3, 4, 5, 6, 8, 9});
		
		int[] resultArrV2 = ASortedArrPairSumEqualsTarget.aSortedArrPairSumEqualsTargetV2(6, new int[] {2, 3, 4, 6, 7, 8, 9});
		int[] resultArr1V2 = ASortedArrPairSumEqualsTarget.aSortedArrPairSumEqualsTargetV2(5, new int[] {1, 2, 3, 4, 5, 6, 8, 9});
		
		System.out.println("Pair of Indices with Target sum = [" + resultArr[0] + ", " +resultArr[1] + "]" );
		System.out.println("Pair of Indices with Target sum = [" + resultArr1[0] + ", " +resultArr1[1] + "]" );
		
		System.out.println("Pair of Indices with Target sum = [" + resultArrV2[0] + ", " +resultArrV2[1] + "]" );
		System.out.println("Pair of Indices with Target sum = [" + resultArr1V2[0] + ", " +resultArr1V2[1] + "]" );
	}

	private static int[] aSortedArrPairSumEqualsTarget(int tSum, int[] arr) {
		
		int left = 0, right = arr.length-1;
		
		while (left < right) {
			int sum = arr[left]+arr[right];
			if(sum == tSum) return new int[] {left, right};
			
			if(sum < tSum) {
				left++;
			}
			if(sum > tSum) {
				right--;
			}
		}
		return new int[] {-1, -1};
	}
	
	private static int[] aSortedArrPairSumEqualsTargetV2(int tSum, int[] arr) {
		
		Map<Integer, Integer> numAndIdxMap = new HashMap<>();
		
		for (int i=0; i<arr.length -1; i++) {
			if(numAndIdxMap.containsKey(tSum - arr[i])) {
				return new int[] {numAndIdxMap.get(tSum - arr[i]), i};
			}else {
				numAndIdxMap.put(arr[i], i);
			}
		}
		
		return new int[] {-1, -1};
	}

	
}
