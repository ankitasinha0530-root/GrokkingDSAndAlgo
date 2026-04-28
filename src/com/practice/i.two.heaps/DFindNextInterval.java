package com.practice.i.two.heaps;

import java.util.PriorityQueue;

public class DFindNextInterval {
	
	static class Interval{
		int start = 0;
		int end = 0;
		
		public Interval(int start, int end) {
			this.start = start;
			this.end = end;
		}
	}

	public static void main(String[] args) {
		
		// Refer video = https://www.youtube.com/watch?v=zBuTgoUjynY
		
	//	We can utilize the Two Heaps approach. We can push all intervals into two heaps: 
	//	one heap to sort the intervals on maximum start time (let’s call it maxStartHeap) and the other on maximum end time 
	//	(let’s call it maxEndHeap). We can then iterate through all intervals of the `maxEndHeap’ to find their next interval. 
	//	Our algorithm will have the following steps:

	// 1. Take out the top (having highest end) interval from the maxEndHeap to find its next interval. Let’s call this interval topEnd.
	// 2. Find an interval in the maxStartHeap with the closest start greater than or equal to the start of topEnd. 
	//		Since maxStartHeap is sorted by ‘start’ of intervals, it is easy to find the interval with the highest ‘start’. 
	//		Let’s call this interval topStart.
	// 3. Add the index of topStart in the result array as the next interval of topEnd. If we can’t find the next interval, 
	//		add ‘-1’ in the result array.
	// 4. Put the topStart back in the maxStartHeap, as it could be the next interval of other intervals.
	// 5. Repeat the steps 1-4 until we have no intervals left in maxEndHeap.

		// two Max Heaps
		// Fill both MAx heaps, one with start time and one with end time 
		// sort the heaps in ascending order
		// compare if any maxStart heap interval's start >= end
		// keep on dequeing max start hep (while to get the closest right interval
		
		Interval[] intervals = new Interval[]{ new Interval(2, 3), new Interval(3, 4), new Interval(5, 6)};
		int[] result = DFindNextInterval.dFindNextInterval(intervals);
		
		System.out.print("Next Interval indices are = ");
		for (int index : result) {
			System.out.print(index + ", " );
		}
		System.out.println();
		intervals = new Interval[]{ new Interval(3, 4), new Interval(1, 5), new Interval(4, 6)};
		int[] result1 = DFindNextInterval.dFindNextInterval(intervals);
		
		System.out.print("Next Interval indices are = ");
		for (int index : result1) {
			System.out.print(index + ", " );
		}
		System.out.println();
		
 		
	}

	private static int[] dFindNextInterval(Interval[] intervals) {
		int n = intervals.length;
		int[] result = new int[n];
		PriorityQueue<Integer> maxStartHeap = new PriorityQueue<>(n, (i1, i2) -> (intervals[i2].start - intervals[i1].start));
		PriorityQueue<Integer> maxEndHeap = new PriorityQueue<>(n, (i1, i2) -> (intervals[i2].end - intervals[i1].end));
		
		for (int i = 0; i < intervals.length; i++) { // Enter all the indices in both the max heaps
			maxStartHeap.offer(i);
			maxEndHeap.offer(i);
		}
			
		for (int i = 0; i < intervals.length; i++) {
			int topEnd = maxEndHeap.poll(); // extract the top element from Maxend Heap
			result[topEnd] = -1; // Initialize with Default value
				if(intervals[maxStartHeap.peek()].start >= intervals[topEnd].end) {
					int	topStart = maxStartHeap.poll();
					
					while(!maxStartHeap.isEmpty() && intervals[maxStartHeap.peek()].start >= intervals[topEnd].end) {
						topStart = maxStartHeap.poll();
					}
					result[topEnd] = topStart;
					maxStartHeap.offer(topStart);
				}
		}
 				
		return result;
	}

}
