package com.practice.h.tree.depth.search;

import java.util.Stack;

public class ABinaryTreeHasPathForTargetFromRootToLeaf{

	public static void main(String[] args) {
		
		// Refer Video = Using Recurssion - https://www.youtube.com/watch?v=3LKHFfuqlIg
		TreeNode root = new TreeNode(12);
		root.left = new TreeNode(7);
		root.right = new TreeNode(1);
		root.left.left = new TreeNode(9);
		root.right.left = new TreeNode(10);
		root.right.right= new TreeNode(5);
		root.right.left.left = new TreeNode(20);
		root.right.left.right = new TreeNode(17);
		
		boolean result = binaryTreeHasPath(root, 23);
		System.out.println("binaryTreeHasPath = " + result);
		boolean result1 = binaryTreeHasPath(root, 28);
		System.out.println("binaryTreeHasPath = " + result1);
		boolean result2 = binaryTreeHasPath(root, 18);
		System.out.println("binaryTreeHasPath = " + result2);
		System.out.println(binaryTreeHasPathV2(root, 23));
		System.out.println(binaryTreeHasPathV2(root, 28));
		System.out.println(binaryTreeHasPathV2(root, 18));
	}
	
	private static boolean binaryTreeHasPath(TreeNode root, int sum) {
		
		// if root == null then return false;
		if(root == null) return false;
		
		// ifroot.val == sum and current node is leaf node then we found the path hence return true
		if(root.left == null && root.right == null && sum == root.val) { 
			return true;
		}
		
		boolean findLeft  = binaryTreeHasPath(root.left, sum - root.val);
		boolean findRight  = binaryTreeHasPath(root.left, sum - root.val);
		
		return findLeft || findRight;
	//	return binaryTreeHasPath(root.left, sum - root.val) || binaryTreeHasPath(root.right, sum - root.val);
	}

	
	
	
	
	
	
	
	// using stack
	// ReferVideo = Using Stack and level order traversal- https://www.youtube.com/watch?v=7Y5DNwjjDMw , 
	// one for node and the other for Sum
	private static boolean binaryTreeHasPathV2(TreeNode root, int sum) { // Using 2 Stacks
		
		if(root == null) return false;
		
		Stack<TreeNode> path =  new Stack<>();
		Stack<Integer> pathSum = new Stack<>();
		
		path.add(root);
		pathSum.add(root.val);
		
		while(!path.isEmpty()) {
			
			TreeNode temp = path.pop();
			int tempVal = pathSum.pop();
			
			if(temp.left == null && temp.right == null && sum == tempVal) {
				return true;
			}
			
			if(temp.left != null) {
				path.push(temp.left);
				pathSum.push(temp.left.val + tempVal);
			}
			
			if(temp.right != null) {
				path.push(temp.right);
				pathSum.push(temp.right.val + tempVal);
			}
			
		}
		return false;
		
	}

}
