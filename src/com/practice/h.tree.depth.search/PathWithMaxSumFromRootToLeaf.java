package com.practice.h.tree.depth.search;

public class PathWithMaxSumFromRootToLeaf {
	
	//Refer Video = https://www.youtube.com/watch?v=WszrfSwMz58&t=754s

	public static void main(String[] args) {
		TreeNode root = new TreeNode(12);
		root.left = new TreeNode(7);
		root.right = new TreeNode(1);
		root.left.left = new TreeNode(9);
		root.right.left = new TreeNode(10);
		root.right.right= new TreeNode(5);
		root.right.left.left = new TreeNode(20);
		root.right.left.right = new TreeNode(17);
		
		int result = pathWithMaxSumFromRootToLeaf(root);
		System.out.println("Level Order Traversal = " + result);
	}

	private static int pathWithMaxSumFromRootToLeaf(TreeNode root) {
		
		if(root == null) {
			return 0;
		}
		if(root.left == null & root.right == null) {
			return root.val;
		}
		
		int leftSum = pathWithMaxSumFromRootToLeaf(root.left);
		int rightSum = pathWithMaxSumFromRootToLeaf(root.right);
		
		return root.val + Math.max(leftSum, rightSum);
	}

}
