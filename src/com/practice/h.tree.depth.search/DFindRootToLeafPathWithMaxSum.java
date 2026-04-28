package com.practice.h.tree.depth.search;

import java.util.ArrayList;
import java.util.List;

public class DFindRootToLeafPathWithMaxSum {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(12);
		root.left = new TreeNode(7);
		root.right = new TreeNode(1);
		root.left.left = new TreeNode(9);
		root.right.left = new TreeNode(10);
		root.right.right= new TreeNode(5);
		root.right.left.left = new TreeNode(20);
		root.right.left.right = new TreeNode(17);
		
		List<Integer> result = DFindRootToLeafPathWithMaxSum.rootToLeafPathWithMaxSum(root);
		System.out.println("Root To leaf path mith maximum sum = " + result);

	}

	static int maxSum = 0;
	static List<Integer> ansPath = new ArrayList<>();
	
	private static List<Integer> rootToLeafPathWithMaxSum(TreeNode root) {
		
		List<Integer> currPath = new ArrayList<>();
		allPathsRootToLeaf(root, currPath, 0);
		return ansPath;
	}

	private static void allPathsRootToLeaf(TreeNode currNode, List<Integer> currPath, int sum) {

		if(currNode == null) {
			return;
		}
		currPath.add(currNode.val);
		sum += currNode.val;
		
		if(currNode.left == null && currNode.right == null) {
			if(sum > maxSum) {	
				maxSum = sum;
				ansPath = new ArrayList<>(currPath);
			}
		}
		allPathsRootToLeaf(currNode.left, currPath,  sum);
		allPathsRootToLeaf(currNode.right, currPath, sum);
		
		currPath.remove(currPath.size() - 1); // while backtracking remove the path from end of the list
	}
	
	
	
	
	
	
	
	
	
	
	private static void allPathsRootToLeafV2(TreeNode currNode, List<Integer> currPath, int sum) {

		if(currNode == null) {
			return;
		}
		currPath.add(currNode.val);
		sum += currNode.val;
		
		if(currNode.left == null && currNode.right == null) {
			
			if(sum > maxSum) {	
				maxSum = sum;
				ansPath = new ArrayList<>(currPath);
			}
		}
		
		allPathsRootToLeaf(currNode.left, currPath,  sum);
		allPathsRootToLeaf(currNode.right, currPath, sum);
		
		currPath.remove(currPath.size() - 1); // while backtracking remove the path from end of the list
	}
	


}
