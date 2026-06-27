package com.practice.g.tree.breadth.search;

import java.util.LinkedList;
import java.util.Queue;

public class HConnectAllLevelOrderSibling {
	
	static class TreeNode {
		int val = 0;
		TreeNode left;
		TreeNode right;
		TreeNode next;
		
		public TreeNode(int val){
			this.val = val;
		}

	}

	public static void main(String[] args) {

		TreeNode root = new TreeNode(12);
		root.left = new TreeNode(7);
		root.right = new TreeNode(1);
		root.left.left = new TreeNode(9);
		root.right.left = new TreeNode(10);
		root.right.right= new TreeNode(5);
		root.right.left.left = new TreeNode(20);
		root.right.left.right = new TreeNode(17);

		TreeNode current = root;
		HConnectAllLevelOrderSibling.connectAllLevelOrderSiblings(root);
		System.out.println("Level Order Traversal using next pointer = ");
		while(current != null) {
			System.out.print(current.val + " ");
			current = current.next;
		}
	}

	private static void connectAllLevelOrderSiblings(TreeNode root) {

		Queue<TreeNode> queue = new LinkedList<>();

		queue.add(root);

		TreeNode prev = null;

		while (!queue.isEmpty()) {

			int levelSize = queue.size();

			for (int i = 0; i < levelSize; i++) {

				TreeNode currNode = queue.poll();

				if(prev != null) {
					prev.next = currNode;
				}
				prev = currNode;

				if (currNode.left != null){
					queue.add(currNode.left);
				}
				if (currNode.right != null){
					queue.add(currNode.right);
				}
			}

		}

	}

}
