package com.practice.a.sliding.window;

import java.util.PriorityQueue;

public class SlidingWindowMaximumInEachWindow2 {

	public static void main(String[] args) {
		int[] nums = {1,3,-1,-3,5,3,6,7};
		int k = 3;
		int[] res = maxSlidingWindow(nums, k);
		
		for (int i = 0; i < res.length; i++) {
			System.out.print(res[i] + ", ");
		}
		
		System.out.println();
		int[] nums1 = {1, -1};
		int k1 = 1;
		int[] res1 = maxSlidingWindow(nums1, k1);
		for (int i = 0; i < res1.length; i++) {
			System.out.print(res1[i] + ", ");
		}

	}
	
	public static int[] maxSlidingWindow(int[] nums, int k) {
		int n = nums.length;
        if (n == 0 || k == 0) {
            return new int[0];
        }
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b-a);

        int[] result = new int[nums.length - k +1];
        int left = 0;
        for(int right = 0; right < nums.length; right ++){
            maxHeap.add(nums[right]);
            if(maxHeap.size() >= k){
                result[right-k+1] = maxHeap.peek();
                maxHeap.remove(nums[left]);
                left++;
            }
        }
        return result;
    }

}
