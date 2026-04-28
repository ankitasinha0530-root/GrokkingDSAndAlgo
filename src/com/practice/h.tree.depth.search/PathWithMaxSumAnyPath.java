package com.practice.h.tree.depth.search;

//Refer Video = https://www.youtube.com/watch?v=ElKcXGkYldA 
//Refer Vodeo = https://www.youtube.com/watch?v=WszrfSwMz58&t=889s

//Find the path with the maximum sum in a given binary tree. Write a function that returns the maximum sum. 
//A path can be defined as a sequence of nodes between any two nodes and doesn’t necessarily pass through the root.

public class PathWithMaxSumAnyPath {
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(-12);
		root.left = new TreeNode(7);
		root.right = new TreeNode(1);
		root.left.left = new TreeNode(9);
		root.right.left = new TreeNode(10);
		root.right.right= new TreeNode(5);
		root.right.left.left = new TreeNode(20);
		root.right.left.right = new TreeNode(17);
		
		int result = pathWithMaxSum(root);
		System.out.println("Level Order Traversal = " + result);
	}

	private static int pathWithMaxSum(TreeNode root) {
		
		if(root == null){
			return 0;
		}
		// to Pass by reference
		int[] maxSum = new int[1];
		maxSum[0] = Integer.MIN_VALUE;
		pathWithMaxSumAnyPath(root, maxSum);
		return maxSum[0];
	}

	private static int pathWithMaxSumAnyPath(TreeNode root, int[] maxSum) {
		
		if(root == null) {
			return 0;
		}
		int leftPathVal = Math.max(0, pathWithMaxSumAnyPath(root.left, maxSum)); // 0 because we dont want negative value
		int rightPathVal = Math.max(0, pathWithMaxSumAnyPath(root.right, maxSum)); // 0 beacuse not taking -ve value
		
		maxSum[0] = Math.max(maxSum[0], root.val + leftPathVal + rightPathVal);
		
		return root.val + Math.max(leftPathVal, rightPathVal);
		
	}
	
	
	
	
	
	private static int pathWithMaxSumAnyPathV2(TreeNode root, int[] maxSum) {
		
		if(root == null) {
			return 0;
		}
		//we do Math.max because we dont want to consider negative child values
		int leftPathVal = Math.max(0, pathWithMaxSumAnyPath(root.left, maxSum));
		int rightPathVal = Math.max(0, pathWithMaxSumAnyPath(root.right, maxSum));
		
		// Keeps track of max sum of path for each node
		// maxSum is not required if we are calculating the max sum of path from root to leaf 
		maxSum[0] = Math.max(maxSum[0], root.val + leftPathVal + rightPathVal);
		
		// add to root val and Return the left or right path whichever will have max Value
		return root.val + Math.max(leftPathVal, rightPathVal);
		
	}

}
