package com.practice.g.tree.breadth.search;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class IRightViewOFABinaryTree {

	public static void main(String[] args) {

		TreeNode root = new TreeNode(12);
		root.left = new TreeNode(7);
		root.right = new TreeNode(1);
		root.left.left = new TreeNode(9);
		root.right.left = new TreeNode(10);
		root.right.right= new TreeNode(5);
		root.right.left.left = new TreeNode(20);
		root.right.left.right = new TreeNode(17);
		
		List<Integer> result = IRightViewOFABinaryTree.traverseRightViewOnly(root);
		System.out.println("Level Order Traversal = " + result);
		
		root.right.left.right.left = new TreeNode(22);
		List<Integer> result1 = IRightViewOFABinaryTree.traverseRightViewOnly(root);
		System.out.println("Level Order Traversal = " + result1);
		
	}

	private static List<Integer> traverseRightViewOnly(TreeNode root) {
		
		List<Integer> result = new ArrayList<>();
		if(root == null) return result;
		
		Queue<TreeNode> mq = new LinkedList<>();
		mq.add(root);
		
		while(!mq.isEmpty()) {
			 
			int levelSize = mq.size();
			
			for (int i = 0; i < levelSize; i++) {
				TreeNode currNode = mq.poll();
				if(currNode.left != null) {
					mq.add(currNode.left);
				}
				if(currNode.right != null) {
					mq.add(currNode.right);
				}
				
				if(i == levelSize - 1) {
					result.add(currNode.val);
				}
			}
		}
		
		return result;
	}

}
