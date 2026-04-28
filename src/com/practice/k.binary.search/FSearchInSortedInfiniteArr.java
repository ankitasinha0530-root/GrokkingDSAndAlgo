package com.practice.k.binary.search;

	class ArrayReader {
		int[] arr;

		ArrayReader(int[] arr) {
			this.arr = arr;
		}
	
	public int get(int index) {
		if (index >= arr. length)
			return Integer .MAX_VALUE;
		return arr[index];
		}
	}

public class FSearchInSortedInfiniteArr {

	public static void main(String[] args) {
		
		ArrayReader reader = new ArrayReader(new int[] { 4, 6, 8, 10, 12, 14, 16, 18, 20, 22, 24, 26, 28, 30 });
		System.out.println(FSearchInSortedInfiniteArr.search(reader, 16));
		System.out.println(FSearchInSortedInfiniteArr.search(reader, 11));
		reader = new ArrayReader(new int[] { 1, 3, 8, 10, 15 });
		System.out.println(FSearchInSortedInfiniteArr.search(reader, 15));
		System.out.println(FSearchInSortedInfiniteArr.search(reader, 200));
	}

	// this method is to find the limit where the given key resides
	private static int search(ArrayReader reader, int key) {

		int start = 0, end = 1;  // step 1 : take bound of 2 initialize start = 0 and end = 1
		int newStart = 0;
		while(reader.get(end) < key) { // run loop until we find the bound where key is present
			newStart = end + 1; 		// after iteration new Start will be end + 1
			end = end + (end - start) * 2; // double the search of bound
			start = newStart;			// start = end +1
		}
		
		FSearchInSortedInfiniteArr.binarySearch(start, end, reader, key);
		return FSearchInSortedInfiniteArr.binarySearch(start, end, reader, key);
	}

	private static int binarySearch(int start, int end, ArrayReader reader, int key) {

		while (start <= end) {
			
			int mid = start + (end - start)/2;
			
			if(key < reader.get(mid)) {
				end = mid - 1;
			}else if(key > reader.get(mid)) {
				start = mid + 1;
			}else {
				return mid;
			}
		}
		return -1;
		
	}
	


		

	
}
