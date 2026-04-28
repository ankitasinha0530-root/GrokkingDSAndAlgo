package com.practice.h.tree.depth.search;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class JCountPathsForASumFromAnyNode {

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
		
		System.out.println(" no of paths = " + JCountPathsForASumFromAnyNode(root, 8));
		
		System.out.println(" no of paths v2 = " + JCountPathsForASumFromAnyNodeV2(root, 8));
		
		System.out.println(" No of paths = " + JCountPathsForASumFromAnyNode(root, 11));
	}

	private static int JCountPathsForASumFromAnyNode(TreeNode root, int sum) {
		
		//Case 1 = Including root, sum <-- sum-root.val
		//case 2 = Excluding root, sum <-- sum
		
		if(root == null) return 0;
		
		int a = JCountPathsForASumFromAnyNode(root.left, sum);
		int b = JCountPathsForASumFromAnyNode_a(root, sum);   // this method call is to include the root
		int c = JCountPathsForASumFromAnyNode(root.right, sum);
		return a+b+c;
		
//		return JCountPathsForASumFromAnyNode(root.right, sum) + JCountPathsForASumFromAnyNode_a(root, sum) + JCountPathsForASumFromAnyNode(root.right, sum);
		
	}

	private static int JCountPathsForASumFromAnyNode_a(TreeNode currNode, int sum) {

		if(currNode == null) return 0;
		
		int res = 0; //for every node when the code reaches here, res should be initialized with 0;
		
		if(sum == currNode.val) res++;
		
		res += JCountPathsForASumFromAnyNode_a(currNode.left, sum - currNode.val);
		res += JCountPathsForASumFromAnyNode_a(currNode.right, sum - currNode.val);
		return res;
	}

	
	private static int JCountPathsForASumFromAnyNodeV2(TreeNode root, int sum) {
		List<Integer> currPath = new ArrayList<>();
		
		return getPathCount(root, sum, currPath);
	}
	
	static List<List<Integer>> allPaths = new ArrayList<>();
	
	private static int getPathCount(TreeNode currNode, int sum, List<Integer> currPath) {
		if(currNode == null) return 0;
		
		currPath.add(currNode.val);
		
		int pathSum = 0, pathCount = 0;
		
		ListIterator<Integer> pathIterator = currPath.listIterator();
		
		while(pathIterator.hasPrevious()) {
			
			pathSum += pathIterator.previous();
			
			if(sum == pathSum);
			pathCount++;	

		}		
		
		pathCount += getPathCount(currNode.left, sum, currPath);
		pathCount += getPathCount(currNode.right, sum, currPath);
		
		currPath.remove(currPath.size() - 1);
		return pathCount;
	}



}
