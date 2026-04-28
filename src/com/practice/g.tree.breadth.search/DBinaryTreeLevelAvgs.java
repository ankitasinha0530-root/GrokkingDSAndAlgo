package com.practice.g.tree.breadth.search;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class DBinaryTreeLevelAvgs {

	public static void main(String[] args) {
		
		ABinaryTreeLevelOrder.TreeNode root = new ABinaryTreeLevelOrder.TreeNode(12);
		root.left = new ABinaryTreeLevelOrder.TreeNode(7);
		root.right = new ABinaryTreeLevelOrder.TreeNode(1);
		root.left.left = new ABinaryTreeLevelOrder.TreeNode(9);
		root.right.left = new ABinaryTreeLevelOrder.TreeNode(10);
		root.right.right= new ABinaryTreeLevelOrder.TreeNode(5);
		root.right.left.left = new ABinaryTreeLevelOrder.TreeNode(20);
		root.right.left.right = new ABinaryTreeLevelOrder.TreeNode(17);
		
		List<Double> result = DBinaryTreeLevelAvgs.traverseLevelAvgs(root);
		System.out.println("Level Order Traversal = " + result);
		
		root.right.left.right.left = new ABinaryTreeLevelOrder.TreeNode(21);

	}
	
	public static List<Double> traverseLevelAvgs(ABinaryTreeLevelOrder.TreeNode root) {

		List<Double> result = new ArrayList<>();
		if(root == null) return result;
		
		Queue<ABinaryTreeLevelOrder.TreeNode> mq = new LinkedList<>();
		mq.add(root);
		
		while(mq.size() > 0) {
			int sum = 0;
			int levelSize = mq.size();
			
			for(int i = 0; i < levelSize; i++) {
				ABinaryTreeLevelOrder.TreeNode currNode = mq.poll();
				
				sum += currNode.val;
				
				if(currNode.left != null) {
					mq.add(currNode.left);
				}
				if(currNode.right != null) {
					mq.add(currNode.right);
				}
			}
			double avg = (double) sum/levelSize;  // cast right side of equation to avoid rounding off
			System.out.println(avg);
			result.add(avg);
		}
		return result;
	}

	public static List<Double> cpnnectAllLvlOrdrSib(TreeNode root) {

		// TODO Auto-generated method stub
		return null;
	}

}
