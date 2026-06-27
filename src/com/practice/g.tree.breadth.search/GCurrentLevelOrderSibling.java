package com.practice.g.tree.breadth.search;

import java.util.LinkedList;
import java.util.Queue;

public class GCurrentLevelOrderSibling {
	
	static class TreeNode {
		int val = 0;
		TreeNode left;
		TreeNode right;
		TreeNode next;
		
		public TreeNode(int val){
			this.val = val;
		}
		
	//	level order traversal using next pointer
		void printLevelOrder() {
			TreeNode nextLevelRoot = this;
			while(nextLevelRoot != null) {
				TreeNode current = nextLevelRoot;
				nextLevelRoot = null;
				while(current != null) {
					System.out.print(current.val + " ");
					if(nextLevelRoot == null) {
						if(current.left != null) {
							nextLevelRoot = current.left;
						}else if(current.right != null) {
							nextLevelRoot = right.left;
						}
					}
					current = current.next;
				}
				System.out.println();
			}
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
		

		GCurrentLevelOrderSibling.traverseConnect(root);
		System.out.println("Level Order Traversal using next pointer = ");
		root.printLevelOrder();

	}

	private static void traverseConnect(TreeNode root) {

		if(root == null) return;
		
		Queue<TreeNode> mq = new LinkedList<>();
		mq.add(root);
		
		while(!mq.isEmpty()) {

			TreeNode prevNode = null;

			int levelSize = mq.size();

			for (int i = 0; i < levelSize; i++) {
				TreeNode currNode = mq.poll();
				
				if(prevNode != null) {
					prevNode.next = currNode;
				}
				prevNode = currNode;

				if(currNode.left != null) {
					mq.add(currNode.left);
				}
				if(currNode.right != null) {
					mq.add(currNode.right);
				}
			}	
		}
	}

}
