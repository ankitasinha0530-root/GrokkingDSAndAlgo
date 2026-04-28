package com.practice.a.sliding.window;

public class GLongstSubArrWithOnesAftrReplacmntKelmnts {

	public static void main(String[] args) {
		int result = GLongstSubArrWithOnesAftrReplacmntKelmnts.gLongstSubArrWithOnesAftrReplacmntKelmnts(2,
				new int[] { 0, 1, 0, 1, 1, 0, 1, 1, 0 });
		int result1 = GLongstSubArrWithOnesAftrReplacmntKelmnts.gLongstSubArrWithOnesAftrReplacmntKelmnts(2,
				new int[] { 1, 1, 0, 1, 0, 1, 1, 0, 0 });
		 
		 int resultV2 = GLongstSubArrWithOnesAftrReplacmntKelmnts.gLongstSubArrWithOnesAftrReplacmntKelmntsV2(2, new int[] {0, 1, 0, 1, 1, 0, 1, 1, 0 });
		 int result1V2 = GLongstSubArrWithOnesAftrReplacmntKelmnts.gLongstSubArrWithOnesAftrReplacmntKelmntsV2(2, new int[] {1, 1, 0, 1, 0, 1, 1, 0, 0});

		System.out.println("gLongstSubArrWithOnesAftrReplacmntKelmnts == " + (result));
		System.out.println("gLongstSubArrWithOnesAftrReplacmntKelmnts == " + (result1));

			System.out.println("ELongstSubStrWithNoRptChars == " + (resultV2));
			System.out.println("ELongstSubStrWithNoRptChars == " + (result1V2));

	}

	private static int gLongstSubArrWithOnesAftrReplacmntKelmnts(int k, int[] arr) {
		int maxLength = 0;
		int ws = 0;
		int maxOnesCount = 0;
		for (int we = 0; we < arr.length; we++) {
			if (arr[we] == 1) {
				maxOnesCount++;
			}
			if ((we - ws + 1) - maxOnesCount > k) {
				if (arr[ws] == 1) {
					maxOnesCount--;
				}
				ws++;
			}
			maxLength = Math.max(maxLength, (we - ws + 1));

		}
		return maxLength;
	}

	private static int gLongstSubArrWithOnesAftrReplacmntKelmntsV2(int k, int[] arr) {
		int maxLength = 0;
		int ws = 0;
		int maxZeroesCount = 0;
		for (int we = 0; we < arr.length; we++) {
			if (arr[we] == 0) {
				maxZeroesCount++;
			}
			if (maxZeroesCount > k) {
				if (arr[ws] == 0) {
					maxZeroesCount--;
				}
				ws++;
			}
			maxLength = Math.max(maxLength, (we - ws + 1));
		}
		return maxLength;
	}

}
