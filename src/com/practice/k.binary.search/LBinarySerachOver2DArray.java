package com.practice.k.binary.search;

public class LBinarySerachOver2DArray {

	public static void main(String[] args) {
		
	//	refer video = https://www.youtube.com/watch?v=RhPqIIOUiS8

		int[][] matrix = new int[][] {{1, 3, 5, 7}, 
									  {10, 11, 16, 20}, 
									  {23, 30, 34, 60}};
			
		int[] result = LBinarySerachOver2DArray.binarySerachOver2DArray(matrix, 16);
		
		System.out.println(result[0] + ", " + result[1]);

	}

	private static int[] binarySerachOver2DArray(int[][] matrix, int target) {

		// search Potential Row
		
		int rowIdx = searchPotentialRow(matrix, target);
		System.out.println("rowIdx = " + rowIdx);
		if(rowIdx != -1) {
			return binarySearch2DarrOnRow(matrix, rowIdx, target);
		}
		return new int[] {-1, -1};
	}

	private static int[] binarySearch2DarrOnRow(int[][] matrix, int rowIdx, int target) {
		int start = 0; 
		int end = matrix[rowIdx].length - 1;
		int[] result = new int[2];
		result[0] = rowIdx;
		
		while(start <= end) {
			int mid = start + (end - start)/2;
			if(matrix[rowIdx][mid] == target) {
				result[1] = mid;
				System.out.println("true");
				return result;
			}else {
				if(matrix[rowIdx][mid] < target) {
					start = start + 1;
				}else {
					end = end - 1;
				}
			}
		}
		return new int[] {-1, -1};
	}

	private static int searchPotentialRow(int[][] matrix, int target) {
		int start = 0;
		int end = matrix.length - 1;
		
		while(start <= end) {
			int mid = start + (end - start)/2;
			if(matrix[mid][0] <= target && target <= matrix[mid][matrix[0].length - 1]) {
				return mid;
			}else {
				if(matrix[mid][0] < target) {
					end = mid - 1;
				}else {
					start = mid + 1;
				}
			}
		}
		return -1;
	}

}
