package com.practice.a.sliding.window;

import java.util.ArrayDeque;
import java.util.Deque;

public class SlidingWindowMaximumInEachWindow3 {

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
        if (nums.length == 0 || k == 0) {
            return new int[0];
        }

        int[] result = new int[nums.length - k +1];
        int wStart = 0;
        // There are `nums.length - k + 1` of size k window so assign the space in begining
        Deque<Integer> window = new ArrayDeque<>();
        
        for(int wEnd = 0 ; wEnd < nums.length; wEnd++) {
            // pop from last all elemnts which are shorter then current elements.
            while(!window.isEmpty() && window.peekLast() < nums[wEnd]) {
                window.removeLast();
            }
            window.add(nums[wEnd]);

            // Window size is K and size is maintained
            if(wEnd >= k - 1) {
                // Always peek is Max of current window
                result[wStart] = window.peekFirst();
                // When leaving element (wStart) is same as Max, make sure to to pop it
                if(window.peekFirst() == nums[wStart]) {
                    window.removeFirst();
                }
                wStart++;
            }
        }
        return result;
    }

}
