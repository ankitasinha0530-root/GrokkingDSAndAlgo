package com.practice.h.tree.depth.search;

public class MTreeDiameter {
	//Given a binary tree, find the length of its diameter. 
	//The diameter of a tree is the number of nodes on the longest path between any two leaf nodes. 
	//The diameter of a tree may or may not pass through the root.
	
	// If the diameter passes through root then Diameter = leftHeight + RightHeight + 2
	
	// In order to find the diameter we need to find the height of left and right as well
	
	// refer video = https://www.youtube.com/watch?v=S0Bwgtn32uI
	// refer video = https://www.youtube.com/watch?v=zM9N_x_v_24
	
	public static void main(String[] args) {

		TreeNode root = new TreeNode(2);
		root.left = new TreeNode(7);
		root.right = new TreeNode(1);
		root.left.left = new TreeNode(9);
		root.right.left = new TreeNode(4);
		root.right.right= new TreeNode(5);
		root.right.left.left = new TreeNode(3);
		root.right.left.right = new TreeNode(8);
		
		System.out.println(" Diameter of a tree = " + treeDiameter(root));
		System.out.println(" Diameter of a tree V2 = " + treeDiameterV2(root));
		
	}
	
	// Here we are extracting both maximum height and maximum diameter in the same call
	private static int treeDiameter(TreeNode root) {
		
//		int diameter = treeDiameter1(root); //Non optimized solution 
		
		Diapair dp = treeDiameter2(root);  // Optimized solution
		int height = dp.ht;
		int diameter = dp.dia;
		
		return diameter;
	}
	static class Diapair{
		int ht;
		int dia;
	}
	// Optimized way of solution 
	// create an object to hold height and diameter
	private static Diapair treeDiameter2(TreeNode root) {

		if(root == null) {
			Diapair dp = new Diapair();
			dp.ht = -1;
			dp.dia = 0;
			return dp;
		}
		
		Diapair lp = treeDiameter2(root.left);
		Diapair rp = treeDiameter2(root.right);
		
		Diapair dp = new Diapair();
		
		dp.ht = Math.max(lp.ht, rp.ht) +1;
		int fes = lp.ht + rp.ht + 2; // diameter with root
		dp.dia = Math.max(fes, Math.max(lp.dia, rp.dia));
		
		return dp;
	}
	
	private static int treeDiameterV2(TreeNode root) {
		
		int diameter = treeDiameter1(root); //Non optimized solution // out is wrong check again
		
		return diameter;
	}
	
	private static int treeDiameter1(TreeNode root) { // this takes O(N^2)
		if(root == null) {
			return 0;
		}
		
		int ld = treeDiameter1(root.left);
		int rd = treeDiameter1(root.right);
		
		int fes = maxHeight(root.left) + maxHeight(root.right) + 2;
		int diameter = Math.max(fes, Math.max(ld, rd));
		
		return diameter;
	}

	private static int maxHeight(TreeNode root) {

		if(root == null) {
			return 0;
		}
		
		int lh = maxHeight(root.left);
		int rh = maxHeight(root.right);
		
		int ht = Math.max(lh, rh) + 1;
		
		return ht;
	}

}
