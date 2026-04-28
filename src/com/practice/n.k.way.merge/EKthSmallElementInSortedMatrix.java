package com.practice.n.k.way.merge;

import java.util.PriorityQueue;

class NodeM{
	int row;
	int col;
	
	public NodeM(int row, int col) {
		this.row = row;
		this.col = col;
	}
}
public class EKthSmallElementInSortedMatrix {

	public static void main(String[] args) {

		int[][] matrix = new int[][] {{2, 6, 8}, {3, 7, 10}, {5, 8, 11}};
		
		System.out.println(EKthSmallElementInSortedMatrix.kthSmallElementInSortedMatrix(matrix, 5));
		
	}

	private static int kthSmallElementInSortedMatrix(int[][] matrix, int k) {
		
		PriorityQueue<NodeM> minHeap = 
				new PriorityQueue<NodeM>((n1, n2) -> matrix[n1.row][n1.col] - matrix[n2.row][n2.col]);
		
		for (int i = 0; i < matrix.length && i < k; i++) {
			minHeap.add(new NodeM(i, 0));
		}
		
		int result = 0, numCount = 0;
		
		while(!minHeap.isEmpty()) {
			NodeM node = minHeap.poll();
			result = matrix[node.row][node.col];
			numCount++;
			if(numCount == k) {
				break;
			}
			node.col++;
			if(matrix[node.row].length > node.col) {
				minHeap.add(node);
			}
		}
		return result;
	}

}
