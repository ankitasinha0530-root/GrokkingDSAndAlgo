package com.practice.e.cyclic.sort;

import java.util.ArrayList;
import java.util.List;

public class CFindAllMissingNiumbers {

	public static void main(String[] args) {

		// Refer video = https://www.youtube.com/watch?v=oEBHLcucDYg
		
		List<Integer> result = CFindAllMissingNiumbers.cFindAllMissingNiumbers(new int[] {2, 3, 1, 8, 2, 3, 5, 1});
		System.out.println("Missing Number = " + result);
		
		List<Integer> result1 = CFindAllMissingNiumbers.cFindAllMissingNiumbers(new int[] {2, 3, 2, 1});
		System.out.println("Missing Number = " + result1);
		
		List<Integer> result3 = CFindAllMissingNiumbers.cFindAllMissingNiumbers(new int[] {2, 4, 1, 2});
		System.out.println("Missing Number = " + result3);
		
		List<Integer> result4 = CFindAllMissingNiumbers.cFindAllMissingNiumbersV1(new int[] {2, 3, 1, 8, 2, 3, 5, 1});
		System.out.println("Missing Number = " + result4);
		
		List<Integer> result5 = CFindAllMissingNiumbers.cFindAllMissingNiumbersV1(new int[] {2, 3, 2, 1});
		System.out.println("Missing Number = " + result5);
		
		List<Integer> result6 = CFindAllMissingNiumbers.cFindAllMissingNiumbersV1(new int[] {2, 4, 1, 2});
		System.out.println("Missing Number = " + result6);

	}

	//multiply the available number with -1 and make it negative 
	//then the indexes not marked as -tive index+1 are the missing numbers
	private static List<Integer> cFindAllMissingNiumbers(int[] arr) {
		List<Integer> missing = new ArrayList<>();
		
		for(int i = 0; i < arr.length; i++) { // {2, 3, 2, 1}
			//Since we are marking element at index as -gative, thus while calculating next index 
			//first make it positive by using Math.abs(arr[i]) then calculate index
			int index = Math.abs(arr[i]) - 1;   
			if(arr[index] < 0) continue;
			
			arr[index] *= -1;
		}
		
		for(int i = 0; i< arr.length; i++) {
			if(arr[i] > 0) {
				missing.add(i+1);
			}
		}
		return missing;
	}
	
	
	// we have used cyclic sort, arrange the element in cycclic oredr first then find teh missing numbre
	private static List<Integer> cFindAllMissingNiumbersV1(int[] arr) {
		List<Integer> missing = new ArrayList<>();
		int i = 0;
		while(i < arr.length) {
			if(arr[i] != arr[arr[i] - 1]) {
				int dest = arr[i] - 1;
				int temp = arr[i];
				arr[i] = arr[dest];
				arr[dest] = temp;
			}else {
				i++;
			}
		}
		
		for (int j = 0; j < arr.length; j++) {
			if(j != arr[j] -1) {
				missing.add(j+1);
			}
		}
		return missing;
	}

}
