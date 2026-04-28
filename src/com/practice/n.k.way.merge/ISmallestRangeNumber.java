package com.practice.n.k.way.merge;

import java.util.PriorityQueue;

class NodeR{
	int arrIdx;
	int colIdx;
	
	public NodeR(int arrIdx, int colIdx){
		this.arrIdx = arrIdx;
		this.colIdx = colIdx;
	}
}

public class ISmallestRangeNumber {
	

	public static void main(String[] args) {
		
		int[][] matrix = new int[][] {{1, 5, 8}, {4, 12}, {7, 8, 10}};
		
		int[] result = new int[2];
		
		result = ISmallestRangeNumber.smallestRangeNumber(matrix);
		System.out.println(result[0] + ", " + result[1]);
		
		matrix = new int[][] {{2, 6, 8}, {3, 7, 10}, {5, 8, 11}};
		
		result = new int[2];
		
		result = ISmallestRangeNumber.smallestRangeNumber(matrix);
		System.out.println(result[0] + ", " + result[1]);

	}

	private static int[] smallestRangeNumber(int[][] matrix) {
			
		PriorityQueue<NodeR> minHeap = 
				new PriorityQueue<NodeR>((n1, n2) -> matrix[n1.arrIdx][n1.colIdx] - matrix[n2.arrIdx][n2.colIdx]);
		
		
		int rangeStart = 0;
		int rangeEnd  = Integer.MAX_VALUE;
		int currMax = Integer.MIN_VALUE;   // to find the max number in minHeap at anytime
		
		//add 1st element of all rows to heap , since its a sorted matrix , so all the numbers will be amallest
		for (int i = 0; i < matrix.length; i++) {
			minHeap.add(new NodeR(i, 0));
			currMax = Math.max(currMax, matrix[i][0]);
		}
		while(minHeap.size() == matrix.length) {
			NodeR node = minHeap.poll();
			if(rangeEnd - rangeStart > currMax - matrix[node.arrIdx][node.colIdx]) {
				rangeStart = matrix[node.arrIdx][node.colIdx];
				rangeEnd = currMax;
			}
			node.colIdx++;
			if(matrix[node.arrIdx].length > node.colIdx){
				minHeap.add(new NodeR(node.arrIdx, node.colIdx));
				currMax = Math.max(currMax, matrix[node.arrIdx][node.colIdx]);
			}
		}
		return new int[] {rangeStart, rangeEnd};
	}

}
