package com.practice.g.tree.breadth.search;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BReversalBinaryTreeLevelOrder {

	// Refer Video = 
	// Step 1 : create a queue and push the root node.
	// step 2 : make sure to create result as linkedlist
	// Step 2 : Remove from queue, print/add to result, check if left/right is present then add in the queue.

	public static void main(String[] args) {
		TreeNode root = new TreeNode(12);
		root.left = new TreeNode(7);
		root.right = new TreeNode(1);
		root.left.left = new TreeNode(9);
		root.right.left = new TreeNode(10);
		root.right.right= new TreeNode(5);
//		root.left = new TreeNode(7);
//		root.left = new TreeNode(7);
		
		List<List<Integer>> result = BReversalBinaryTreeLevelOrder.traverseReverse(root);
		System.out.println("Level Order Traversal = " + result);

	}

	private static List<List<Integer>> traverseReverse(TreeNode root) {
		
		List<List<Integer>> result = new LinkedList<List<Integer>>();
		
//		List<List<Integer>> result = new ArrayList<List<Integer>>();
		
		if(root == null) return result;
		
		Queue<TreeNode> mq = new LinkedList<>();
		mq.add(root);
		
		while(!mq.isEmpty()) {
			List<Integer> currLevel = new LinkedList<>();
			int levelSize = mq.size();
			
			for(int i = 0; i < levelSize; i++) {
				
				TreeNode currNode = mq.poll();
				currLevel.add(currNode.val);
				
				if(currNode.left != null) {
					mq.offer(currNode.left);
				}
				if(currNode.right != null) {
					mq.offer(currNode.right);
				}
			}
			result.add(0, currLevel);
		}
		return result;
	}

}
