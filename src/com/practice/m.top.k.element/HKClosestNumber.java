package com.practice.m.top.k.element;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

class Entry{
	int key;
	int value;
	
	public Entry(int key, int value) {
		this.key = key;
		this.value = value;
	}
}

public class HKClosestNumber {
	// Given a Sorted Array
	// First we need to find the index which is closest to this element..
	// create a window where start = index-k and end = index + k
	// Add all the elements in this range to minHEap. 
	// Extract k elements from minHeap and add to result
	// sort the element
	
	
	// Using MinHeap method
	public static List<Integer> findClosesElement(int[] arr, int k, int x){
		List<Integer> result = new ArrayList<>();
		
		int index = binarySearch(arr, x);  // extract the index of the element or the closest index if element is not present in the array
		System.out.println("index = " + index);
		
	//	Identify range of search
		int low = Math.max(0, index-k);
		int high = Math.min(arr.length-1, index+k);
		
		PriorityQueue<Entry> minHeap = new PriorityQueue<Entry>((i1, i2) -> i1.value - i2.value);
		
	//	Add all elements to minHEap sorted based on the diff of element with the target element
		for (int i = low; i <= high; i++) {
			minHeap.add(new Entry(i, Math.abs(arr[i] - x)));
		}
		
		// extract k elements
		for (int i = 0; i < k; i++) {
			result.add(arr[minHeap.poll().key]);
		}
	//	sort result array
		Collections.sort(result);
		return result;
	}

	private static int binarySearch(int[] arr, int x) {
		int start = 0, end = arr.length - 1;
		while(start <= end) {
			int mid = start + (end - start)/2;
			if(arr[mid] == x) {
				return mid;
			}else {
				if(arr[mid] < x) {
					start = mid + 1;
				}else {
					end = mid - 1;
				}
			}
			if(start > 0) {
				return start - 1;	
			}
		}
		return start;
	}
	
	// solution using two pointers
	private static List<Integer> findClosesElementV2(int[] arr, int k, int x) {
		// serach the index of the element
		int index = binarySearch(arr, x);
		List<Integer> result = new ArrayList<>();
		
		// define the range of the search
		int left = index;
		int right = index + 1;
		
		for (int i = 0; i < k; i++) {  // run loop for k elements 
	//		extract the values using two pointers algorithm
			if(left >= 0 && right < arr.length) {
				int diffleft = Math.abs(arr[left] - x);
				int diffright = Math.abs(arr[right] - x);
				if(diffleft <= diffright) {
					result.add(0, arr[left]);
					left --;
				}else {
					result.add(arr[right]);
					right++;
				}
			}else if(left >= 0) {
				result.add(0, arr[left]);
				left++;
			}else if(right < arr.length) {
				result.add(arr[right]);
				right++;
			}
		}
		Collections.sort(result);
		return result;
	}

	public static void main(String[] args) {
		
		System.out.println("'K' closest elements to 'X' are = " + HKClosestNumber.findClosesElement(new int[] {5, 6, 7 ,8 ,9 }, 3, 7));
		System.out.println("'K' closest elements to 'X' are = " + HKClosestNumber.findClosesElement(new int[] {2, 4, 5, 6, 9 }, 3, 6));
		System.out.println("'K' closest elements to 'X' are = " + HKClosestNumber.findClosesElement(new int[] {2, 4, 5, 6, 9}, 3, 10));

		System.out.println("'K' closest elements to 'X' are = " + HKClosestNumber.findClosesElementV2(new int[] {5, 6, 7 ,8 ,9 }, 3, 7));
		System.out.println("'K' closest elements to 'X' are = " + HKClosestNumber.findClosesElementV2(new int[] {2, 4, 5, 6, 9 }, 3, 6));
		System.out.println("'K' closest elements to 'X' are = " + HKClosestNumber.findClosesElementV2(new int[] {2, 4, 5, 6, 9}, 3, 10));

	}

}
