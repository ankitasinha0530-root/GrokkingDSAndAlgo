package com.practice.a.sliding.window;

import java.util.PriorityQueue;

public class SlidingWindowMaximumInEachWindow {
	static class Pair implements Comparable<Pair> {
		int val;
		int idx;

		public Pair(int val, int idx) {
			this.val = val;
			this.idx = idx;
		}

		@Override
		public int compareTo(Pair p2) {
			return p2.val - this.val;
		}
	}

	public static int[] maxSlidingWindow(int[] nums, int k) {
		int[] ans = new int[nums.length - k + 1];
		PriorityQueue<Pair> pq = new PriorityQueue<>();
		for (int i = 0; i < k; i++) {
			pq.add(new Pair(nums[i], i));
		}
		ans[0] = pq.peek().val;

		for (int i = k; i < nums.length; i++) {
			while (pq.size() > 0 && pq.peek().idx <= (i - k)) {
				pq.remove();
			}
			pq.add(new Pair(nums[i], i));
			ans[i - k + 1] = pq.peek().val;
		}
		return ans;
	}

	public static void main(String[] args) {
		int[] nums = { 1, 3, -1, -3, 5, 3, 6, 7 };
		int k = 3;
		int[] res = maxSlidingWindow(nums, k);

		for (int i = 0; i < res.length; i++) {
			System.out.print(res[i] + ", ");
		}

		System.out.println();
		int[] nums1 = { 1, -1 };
		int k1 = 1;
		int[] res1 = maxSlidingWindow(nums1, k1);
		for (int i = 0; i < res1.length; i++) {
			System.out.print(res1[i] + ", ");
		}

	}

}
