package com.practice.g.tree.breadth.search;

import java.util.LinkedList;
import java.util.Queue;

public class EBinaryTreeMinmDepth {

	public static void main(String[] args) {

		ABinaryTreeLevelOrder.TreeNode root = new ABinaryTreeLevelOrder.TreeNode(12);
		root.left = new ABinaryTreeLevelOrder.TreeNode(7);
		root.right = new ABinaryTreeLevelOrder.TreeNode(1);
		root.left.left = new ABinaryTreeLevelOrder.TreeNode(9);
		root.right.left = new ABinaryTreeLevelOrder.TreeNode(10);
		root.right.right= new ABinaryTreeLevelOrder.TreeNode(5);
		root.right.left.left = new ABinaryTreeLevelOrder.TreeNode(20);
		root.right.left.right = new ABinaryTreeLevelOrder.TreeNode(17);
		
		int result = EBinaryTreeMinmDepth.traverseMinmDepth(root);
		System.out.println("Level Order Traversal = " + result);
	}

	private static int traverseMinmDepth(ABinaryTreeLevelOrder.TreeNode root) {

		int minTreeDepth = 0;
		
		if(root == null) return 0;
		
		Queue<ABinaryTreeLevelOrder.TreeNode> mq = new LinkedList<>();
		mq.add(root);
		
		while(mq.size() > 0) {
//			List<Integer> currLevel = new ArrayList<>();
			minTreeDepth++;     // this will increase the depth per level
			int levelSize = mq.size();

			for(int i = 0; i < levelSize; i++) {
				ABinaryTreeLevelOrder.TreeNode currNode = mq.poll();
				
				if(currNode.left == null && currNode.right == null) {
					return minTreeDepth;
				}
				
				if(currNode.left != null) {
					mq.add(currNode.left);
				}
				
				if(currNode.right != null) {
					mq.add(currNode.right);
				}
			}
		}
		return minTreeDepth;
	}

}
