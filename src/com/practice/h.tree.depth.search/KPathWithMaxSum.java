package com.practice.h.tree.depth.search;

import java.util.List;

public class KPathWithMaxSum {
	
	//Refer Video = https://www.youtube.com/watch?v=ElKcXGkYldA
	//Refer Vodeo = https://www.youtube.com/watch?v=WszrfSwMz58&t=889s
	
	//Find the path with the maximum sum in a given binary tree. 
	//Write a function that returns the maximum sum. 
	//A path can be defined as a sequence of nodes between any two nodes and doesn’t necessarily pass through the root.
	

	public static void main(String[] args) {
		TreeNode root = new TreeNode(12);
		root.left = new TreeNode(7);
		root.right = new TreeNode(1);
		root.left.left = new TreeNode(9);
		root.right.left = new TreeNode(10);
		root.right.right= new TreeNode(5);
		root.right.left.left = new TreeNode(20);
		root.right.left.right = new TreeNode(17);
		
		int result = pathWithMaxSum(root, 0);
		System.out.println("Level Order Traversal = " + result);


	}

	private static int pathWithMaxSum(TreeNode root, int maxSumPath) {
		
		if(root == null) {
			return 0;
		}
		if(root.left == null & root.right == null) {
			return root.val;
		}
		
		int leftSum = pathWithMaxSum(root.left, maxSumPath);
		int rightSum = pathWithMaxSum(root.right, maxSumPath);

		maxSumPath = Math.max(maxSumPath, root.val + leftSum + rightSum);
		
		return root.val + Math.max(leftSum, rightSum);
	}

}
