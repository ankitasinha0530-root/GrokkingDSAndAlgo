package com.practice.n.k.way.merge;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class JKPairWithLargestSums {

	public static void main(String[] args) {

		int[] L1 = new int[] {9, 8, 2};
		int[] L2 = new int[] {6, 3, 1};
		
		List<int[]> result = JKPairWithLargestSums.kPairWithLargestSums(L1, L2, 3);
		for(int[] res : result) {
			System.out.println(res[0] + ", " +res[1]);
		}
	}

	private static ArrayList<int[]> kPairWithLargestSums(int[] l1, int[] l2, int k) {
		

		PriorityQueue<int[]> minHeap = 
				new PriorityQueue<int[]>((n1, n2) -> (n1[0] + n1[1]) - (n2[0] + n2[1]));
				
		for (int i = 0; i < l1.length; i++) {   
			for (int j = 0; j < l2.length; j++) {
				// since the array is sorted in descending order hence only insert k element to minHeap
				if(minHeap.size() < k) {
					minHeap.add(new int[] {l1[i], l2[j]});
				}else {
					if(l1[i] + l2[j] < minHeap.peek()[0] + minHeap.peek()[1]) {
						break;
					}else {
						minHeap.poll();
						minHeap.add(new int[] {l1[i], l2[j]});
					}
					
				}
			}
			
		}
		return new ArrayList<int[]>(minHeap);
	}

}
