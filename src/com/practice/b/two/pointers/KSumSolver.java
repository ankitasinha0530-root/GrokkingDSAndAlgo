package com.practice.b.two.pointers;

import java.util.*;

public class KSumSolver {

    public static List<List<Integer>> kSum(int[] nums, int target, int k) {
        Arrays.sort(nums);
        return kSumHelper(nums, 0, target, k);
    }

    private static List<List<Integer>> kSumHelper(int[] nums, int start, long target, int k) {
        List<List<Integer>> result = new ArrayList<>();
        int n = nums.length;

        if (k == 2) {
            int left = start;
            int right = n - 1;

            while (left < right) {
                long sum = (long) nums[left] + nums[right];

                if (sum == target) {
                    result.add(Arrays.asList(nums[left], nums[right]));

                    left++;
                    right--;

                    while (left < right && nums[left] == nums[left - 1]) {
                        left++;
                    }

                    while (left < right && nums[right] == nums[right + 1]) {
                        right--;
                    }

                } else if (sum < target) {
                    left++;
                } else {
                    right--;
                }
            }

            return result;
        }

        for (int i = start; i < n - k + 1; i++) {

            if (i > start && nums[i] == nums[i - 1]) {
                continue;
            }

            List<List<Integer>> subResults =
                    kSumHelper(nums, i + 1, target - nums[i], k - 1);

            for (List<Integer> subset : subResults) {
                List<Integer> current = new ArrayList<>();
                current.add(nums[i]);
                current.addAll(subset);
                result.add(current);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1, 0, -1, 0, -2, 2};
        System.out.println(kSum(nums, 0, 3));
        System.out.println(kSum(nums, 0, 4));
    }
}
