 package com.practice.h.tree.depth.search;

import java.util.ArrayList;
import java.util.List;

public class BAllPathsForATargetSumRootToLeaf {

	public static void main(String[] args) {
		
		//Refer Video = https://www.youtube.com/watch?v=ojxo9QjPKvA
		// refer video = https://www.youtube.com/watch?v=HyNczj2pEEY

		TreeNode root = new TreeNode(12);
		root.left = new TreeNode(7);
		root.right = new TreeNode(1);
		root.left.left = new TreeNode(9);
		root.right.left = new TreeNode(10);
		root.right.right= new TreeNode(6);
		root.left.left.left = new TreeNode(20);
		root.left.left.right = new TreeNode(17);
		root.right.right.left= new TreeNode(4);
		
		List<List<Integer>> result = allPathsForASum(root, 23);
		System.out.println("Level Order Traversal = " + result);
		
		List<List<Integer>> result1 = allPathsForASum(root, 28);
		System.out.println("Level Order Traversal = " + result1);
		
		List<List<Integer>> result2 = allPathsForASum(root, 18);
		System.out.println("Level Order Traversal = " + result2);
		
		List<List<Integer>> result3 = allPathsForASum(root, 21);
		System.out.println("Level Order Traversal = " + result3);

	}

	private static List<List<Integer>> allPathsForASum(TreeNode root, int sum) {
		
		List<List<Integer>> result = new ArrayList<>();
		List<Integer> currPath = new ArrayList<>();
		
		allPathsForASum(root, sum, currPath, result);
		
		return result;
	}

	private static void allPathsForASum(TreeNode currNode, int sum, List<Integer> currPath, List<List<Integer>> allPathss) {

		if(currNode == null) return;
		
		currPath.add(currNode.val);
		
		if(currNode.left == null && currNode.right == null && sum == currNode.val ) {
			allPathss.add(new ArrayList<>(currPath));
		}else {
			allPathsForASum(currNode.left, sum - currNode.val,  currPath, allPathss);
			allPathsForASum(currNode.right, sum - currNode.val, currPath, allPathss);
		}
		
		currPath.remove(currPath.size() - 1);
	}


}
