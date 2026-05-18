package com.practice.d.merge.intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class AMergeIntervals {
	// refer video - https://www.youtube.com/watch?v=dzNIPX7HY6A
	public static void main(String[] args) {

		int[][] intervals =  {{1,2}, {6,8}, {2,5}};
		
		int[][] result = mergeIntervals(intervals);
		for (int i = 0; i < result.length; i++) {
			System.out.println(result[i][0] + ", " + result[i][1]);
		}
		System.out.println(mergeIntervals(intervals)); 
	}

	static int[][] mergeIntervals(int[][] intervals) {

		if (intervals.length <= 1) {
			return intervals;
		}
		//this is a must step sort intervals on its 1st element of each small array
		Arrays.sort(intervals, Comparator.comparing((i) -> i[0]));
		
		List<int[]> result = new ArrayList<>();
		
		int[] newInterval = intervals[0];
		
		for (int[] interval : intervals) {

			if (interval[0] <= newInterval[1]) {
				newInterval[1] = Math.max(interval[1], newInterval[1]);
				
			} else {
				newInterval = interval;
				result.add(newInterval);
			}
		}
		return result.toArray(new int[result.size()][]);
	}

}
