  package com.practice.b.two.pointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EFindTripletsFrTargtSum {

	public static void main(String[] args) {
		
		List<List<Integer>> result = EFindTripletsFrTargtSum.eFindTripletsFrTargtSum(0, new int[] {-2, -1, 0, 1, 4, 6 }); 
		List<List<Integer>> result1 = EFindTripletsFrTargtSum.eFindTripletsFrTargtSum(0, new int[] {-9, -5, 0, 1, 5, 8 });
		List<List<Integer>> result2 = EFindTripletsFrTargtSum.eFindTripletsFrTargtSum(4, new int[] {-4, -2, 1, 1, 2, 8 });
		List<List<Integer>> result3 = EFindTripletsFrTargtSum.eFindTripletsFrTargtSum(5, new int[] {-3, 2, 0, 1, 2, 8 });
			
		System.out.println("EFindTripletsFrTargtSum == " + (result));
		System.out.println("EFindTripletsFrTargtSum == " + (result1));
		System.out.println("EFindTripletsFrTargtSum == " + (result2));
		System.out.println("EFindTripletsFrTargtSum == " + (result3));
	}

	private static List<List<Integer>> eFindTripletsFrTargtSum(int tSum, int[] arr) {
		Arrays.sort(arr);
		List<List<Integer>> resultList = new ArrayList<>();
		int newTargetSum;
		
		for(int i = 0; i<arr.length-2; i++) {
			
			// Check for duplicates in outer loop
			if(i>0 && arr[i] == arr[i-1])
				continue;
			newTargetSum = tSum-arr[i]; //  in case tsum = 0 then newTargetSum = 0-arr[i] = -arr[i]
			int left = i+1;
			int right = arr.length-1;
			while(left < right) {
				int sum = arr[left] + arr[right];
				if(newTargetSum == sum) {
					resultList.add(Arrays.asList(arr[i], arr[left], arr[right] ));
					left++;
					right--;
					// if duplicate next element ignore the element and move towards left
					while(left < right && arr[right] == arr[right+1]){ 
						right--;
					}
					// if duplicate next element ignore the element and move towards right
					while(left < right && arr[left] == arr[left-1]) 
						left++;
				}else if(sum < newTargetSum){  //when sum < newTargetSum means we need to increase the sum thus move towards right
					left++;
				}else if(sum > newTargetSum) //when sum < newTargetSum means we need to decrease the sum thus move towards left
					right--;
			}
		}
		return resultList;
	}

}
