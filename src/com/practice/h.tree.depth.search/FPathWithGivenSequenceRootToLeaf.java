package com.practice.h.tree.depth.search;

public class FPathWithGivenSequenceRootToLeaf {

	public static void main(String[] args) {
		
		// refer video - https://www.youtube.com/watch?v=4u7KW3t-vt0

		TreeNode root = new TreeNode(2);
		root.left = new TreeNode(7);
		root.right = new TreeNode(1);

		root.left.left = new TreeNode(9);

		root.right.left = new TreeNode(4);

		root.right.right= new TreeNode(5);

		root.right.left.left = new TreeNode(3);
		root.right.left.right = new TreeNode(8);
		
		System.out.println(" Sum of Path Numbers = " + pathWithGivenSequence(root, new int[] {2, 1, 5}));
		
		System.out.println(" Sum of Path Numbers = " + pathWithGivenSequence(root, new int[] {1, 4, 3}));

	}

	private static boolean pathWithGivenSequence(TreeNode root, int[] sequence) {
		
		int length = sequence.length;
		
		System.out.println(length);
		
		return pathWithGivenSequence(root, sequence, 0);
	}

	private static boolean pathWithGivenSequence(TreeNode currNode, int[] sequence, int index) {
		
		// return false when
		// 1. index becomes >= sequence length which means that the root to leaf path no. of Nodes 
		//    is greater than the sequence length 
		// 2. and currenNode value ! = sequence[index]
		
		// return true when 
		// 1. current node is leaf node which means no left and right nodes and index == sequence.length-1
		
		if(currNode == null) 
				return false;
		
		if(index >= sequence.length || currNode.val != sequence[index]) {
			return false;
		}
		
		if(currNode.left == null && currNode.right == null && index == sequence.length-1){
			return true;
		}

		return pathWithGivenSequence(currNode.left, sequence, index+1) || pathWithGivenSequence(currNode.right, sequence, index+1);
	}


}
