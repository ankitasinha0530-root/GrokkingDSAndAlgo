package com.practice.h.tree.depth.search;

public class ESumOfPathNumbers {

	//Refer video = https://www.youtube.com/watch?v=Gi0202QawRQ
	
	public static void main(String[] args) {

		TreeNode root = new TreeNode(2);
		root.left = new TreeNode(7);
		root.right = new TreeNode(1);
		root.left.left = new TreeNode(9);
		root.right.left = new TreeNode(4);
		root.right.right= new TreeNode(5);
		root.right.left.left = new TreeNode(5);
		root.right.left.right = new TreeNode(8);
		
		System.out.println(" Sum of Path Numbers = " + sumOfPathNumbers(root));
		
		System.out.println(" Sum of Path Numbers = " + sumOfPathNumbersv2(root));

	}
	static int sum = 0;
	
	private static int sumOfPathNumbers(TreeNode root) {
		sumOfPathNumbers(root, 0); //since there are no nodes before root so pass val as 0
		return sum;
	}

	private static void sumOfPathNumbers(TreeNode currNode, int num) {

		if(currNode == null) return;
		
		num = 10*num + currNode.val;
		System.out.println("num == " + num);
		
		if(currNode.left == null && currNode.right == null) {
			sum += num;
			System.out.println(sum);
			return;
		}
		sumOfPathNumbers(currNode.left, num);
		sumOfPathNumbers(currNode.right, num);
		
	}
	
	// different method

	private static int sumOfPathNumbersv2(TreeNode root) {
		return sumOfPathNumbersv2(root, 0);
	}

	private static int sumOfPathNumbersv2(TreeNode currNode, int pathSum) {

		if(currNode == null) return 0;
		
		pathSum += 10*pathSum + currNode.val;
		
		if(currNode.left == null && currNode.right == null) {
			return pathSum;
		}
		
		return sumOfPathNumbersv2(currNode.left, pathSum) + sumOfPathNumbersv2(currNode.right, pathSum);
	}
	

}

