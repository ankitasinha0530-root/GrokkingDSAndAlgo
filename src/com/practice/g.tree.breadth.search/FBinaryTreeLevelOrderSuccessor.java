package com.practice.g.tree.breadth.search;

import java.util.LinkedList;
import java.util.Queue;

public class FBinaryTreeLevelOrderSuccessor {

	public static void main(String[] args) {

		TreeNode root = new TreeNode(12);
		root.left = new TreeNode(7);
		root.right = new TreeNode(1);
		root.left.left = new TreeNode(9);
		root.right.left = new TreeNode(10);
		root.right.right= new TreeNode(5);
		root.right.left.left = new TreeNode(20);
		root.right.left.right = new TreeNode(17);
		
		TreeNode result = FBinaryTreeLevelOrderSuccessor.traverseLevelOrdrSuccesr(root, 1);
		if(result != null) {
			System.out.println("Level Order Traversal = " + result.val);
		}
		TreeNode result1 = FBinaryTreeLevelOrderSuccessor.traverseLevelOrdrSuccesr(root, 20);
		if(result1 != null) {
			System.out.println("Level Order Traversal = " + result1.val);
		}
		
		TreeNode result2 = FBinaryTreeLevelOrderSuccessor.traverseLevelOrdrSuccesr(root, 17);
		if(result2 != null) {
			System.out.println("Level Order Traversal = " + result2.val);
		}
	}

	private static TreeNode traverseLevelOrdrSuccesr(TreeNode root, int target) {

		if(root == null) return null;
		
		Queue<TreeNode> mq = new LinkedList<>();
		
		mq.add(root);
		
		while(!mq.isEmpty()) {  // We don't need for loop here as we don't need to keep track of levels
			
			TreeNode currNode = mq.poll();
				
			if(currNode.left != null) {
				mq.add(currNode.left);
			}
				
			if(currNode.right != null) {
				mq.add(currNode.right);
			}
				
			if(currNode.val == target) {
				break;
			}
		}
		return mq.peek();
	}

}
