package com.practice.i.two.heaps;

import java.util.PriorityQueue;

public class CMaximizeProfit {

	public static void main(String[] args) {
		// ReferVide = https://www.youtube.com/watch?v=e7ZYZmGImSE
		
		int result1 = CMaximizeProfit.cMaximizeProfit(new int[] {0, 1, 2}, new int[] { 1, 2, 3}, 2, 1);
		System.out.println(" median result 1 = " + result1);
		
		int result2 = CMaximizeProfit.cMaximizeProfit(new int[] {0, 1, 2, 3}, new int[] { 1, 2, 3, 5}, 3, 0);
		System.out.println(" median result 2 = " + result2);
		
		int result3 = CMaximizeProfit.cMaximizeProfit(new int[] {0, 1, 1}, new int[] { 1, 2, 3}, 2, 0);
		System.out.println(" median result 3 = " + result3);

	}

	private static int cMaximizeProfit(int[] capital, int[] profit, int maxProject, int inpCap) {
		
		int n = profit.length;
		int availableCap = inpCap;
		PriorityQueue<Integer> maxProfHeap = new PriorityQueue<>(n, (i1, i2) -> profit[i2] - profit[i1]);
		PriorityQueue<Integer> minCapHeap = new PriorityQueue<>(n, (i1, i2) -> capital[i1] - capital[i2]);
		
		// enter all project capitals in min heap
		for (int i = 0; i < capital.length; i++) {
			minCapHeap.offer(capital[i]);
		}
		
		//find Total number of best projects
		for (int i = 0; i < maxProject; i++) {
			//Find all the projects that can be selected within the available capital and insert all of them in maxHeap
			while(!minCapHeap.isEmpty() && capital[minCapHeap.peek()] <= availableCap) {
				maxProfHeap.offer(minCapHeap.poll());
			}
			
		//	terminate the loop if we are not able to find the project with available profit
			if(maxProfHeap.isEmpty()) 
				break;
			
			// Of all the projects added in MaxProfit heap select the one with MaxProfit
			availableCap += profit[maxProfHeap.poll()];
		}
		return availableCap;
		}
	
}
