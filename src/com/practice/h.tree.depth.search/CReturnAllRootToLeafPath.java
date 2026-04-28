package com.practice.h.tree.depth.search;

import java.util.ArrayList;
import java.util.List;

public class CReturnAllRootToLeafPath {

	public static void main(String[] args) {

		TreeNode root = new TreeNode(12);
		root.left = new TreeNode(7);
		root.right = new TreeNode(1);
		root.left.left = new TreeNode(9);
		root.right.left = new TreeNode(10);
		root.right.right= new TreeNode(5);
		root.right.left.left = new TreeNode(20);
		root.right.left.right = new TreeNode(17);
		
		List<List<Integer>> result = CReturnAllRootToLeafPath.allPathsRootToLeaf(root);
		System.out.println("Level Order Traversal = " + result);

	}

	private static List<List<Integer>> allPathsRootToLeaf(TreeNode root) {
		
		List<List<Integer>> allPaths = new ArrayList<>();
		
		List<Integer> currPath = new ArrayList<>();
		
		allPathsRootToLeaf(root, currPath, allPaths);
		
		return allPaths;
	}

	private static void allPathsRootToLeaf(TreeNode currNode, List<Integer> currPath, List<List<Integer>> allPaths) {

		if(currNode == null) return;
		
		currPath.add(currNode.val);
		
		if(currNode.left == null && currNode.right == null) {
			allPaths.add(new ArrayList<>(currPath));
		}
		
		allPathsRootToLeaf(currNode.left, currPath, allPaths);
		allPathsRootToLeaf(currNode.right, currPath, allPaths);
		
		currPath.remove(currPath.size()-1);
	}
	

}
