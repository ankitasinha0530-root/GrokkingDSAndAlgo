package com.practice.k.binary.search;

public class ENumberRangeOfAKey {

	public static void main(String[] args) {
		int[] result = ENumberRangeOfAKey.numberRangeOfAKey(new int[] {4, 6, 6, 6 , 6, 10}, 6);
		System.out.println(result[0] + ", " + result[1]);
		
		result = ENumberRangeOfAKey.numberRangeOfAKey(new int[] {1, 2, 4 , 4, 5, 5, 5}, 5 );
		System.out.println(result[0] + ", " + result[1]);
		
		result = ENumberRangeOfAKey.numberRangeOfAKey(new int[] {1, 3, 8, 10, 15}, 10);
		System.out.println(result[0] + ", " + result[1]);
		
		result = ENumberRangeOfAKey.numberRangeOfAKey(new int[] {1, 3, 8, 10, 15}, 12);
		System.out.println(result[0] + ", " + result[1]);

	}

	private static int[] numberRangeOfAKey(int[] arr, int key) {
		
		int[] result = new int[] {-1, -1};
		result[0] = search(arr, key, false); //step 1 : Find result[0]
		
		if(result[0] != -1) { //step 2 : if result[0] is not equal -1 then only find result[1]
			result[1] = search(arr, key, true);// step 3 : if step 2 is true then only find result[1]
		}
		return result;
	}

	private static int search(int[] arr, int key, boolean isfindMaxIndex) {  // arr is sorted in ascending order
		
		int keyIndex = -1;
		int start = 0, end = arr.length - 1;
		
		while(start <= end) {
			int mid = start + (end - start)/2;
			
			if(key < arr[mid]) {
				end = mid - 1;
			}else if(key > arr[mid]) {
				start = mid + 1;
			}else {  // if key == arr[mid]
				keyIndex = mid;
				if(isfindMaxIndex) {
					start = mid + 1;
				}else {
					end = mid - 1;
				}
			}
		}
		return keyIndex;
	}

}
