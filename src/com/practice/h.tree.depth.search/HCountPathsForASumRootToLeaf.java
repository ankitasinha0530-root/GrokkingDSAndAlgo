package com.practice.h.tree.depth.search;

public class HCountPathsForASumRootToLeaf {

	public static void main(String[] args) {
		
	//	refer video = https://www.youtube.com/watch?v=o5pVtHqiOdE
		
		TreeNode root = new TreeNode(2);
		root.left = new TreeNode(7);
		root.right = new TreeNode(1);
		root.left.left = new TreeNode(9);
		root.right.left = new TreeNode(4);
		root.right.right= new TreeNode(5);
		root.right.left.left = new TreeNode(3);
		root.right.left.right = new TreeNode(8);
		
		System.out.println(" Sum of Path Numbers = " + HCountPathsForASum(root, 10));
		
		System.out.println(" Sum of Path Numbers = " + HCountPathsForASumV2(root, 11));

	}
	
	static int pathCount = 0, pathSum = 0;
	private static int HCountPathsForASumV2(TreeNode node, int tSum) {
		
		if(node == null)
			return 0;
		
		pathSum += node.val;
		
		if(node.left == null && node.right == null && tSum == pathSum) {
			pathCount++;
		}
		
		HCountPathsForASum(node.left, tSum);
		HCountPathsForASum(node.right, tSum);
		
		return pathCount;
	}

	private static int HCountPathsForASum(TreeNode node, int tSum) {
		
		if(node == null)
			return 0;
		
//		if(node.left == null && node.right == null && tSum == node.val) {
//			count += count;
//			System.out.println("count = " + count);
//		}
		
		return HCountPathsForASum(node.left, tSum-node.val) + HCountPathsForASum(node.right, tSum-node.val);
	}

}
