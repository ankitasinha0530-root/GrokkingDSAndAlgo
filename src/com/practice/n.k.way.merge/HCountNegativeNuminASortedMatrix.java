package com.practice.n.k.way.merge;

public class HCountNegativeNuminASortedMatrix {

	public static void main(String[] args) {

	//	Refer Video = https://www.youtube.com/watch?v=NoLIX84wLVc
	// elements are sorted in descending for both row and col
		
		int[][] matrix = new int[][] {{4, 3, 2, -1},
									  {3, 2, 1, -1},
									  {1, 1, -1, -2},
									  {-1, -1, -2, -3}};
		
		System.out.println(HCountNegativeNuminASortedMatrix.countNegativeNuminASortedMatrix(matrix));

	}

	private static int countNegativeNuminASortedMatrix(int[][] matrix) {
		int m = matrix.length;
		int row = m-1;
		int col = 0;
		int count = 0;
		while(row >= 0 && col < m) {
			if(matrix[row][col] < 0) { // if number ar row and col is -ve
				row--;
				count += m - col;  // since column will point to the 1st -ve number of the row and post that all the numbers will be -ve
			}else {
				col++;
			}
		}
			
		return count;
	}

}
