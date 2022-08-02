package by.bknst.interview;

import java.util.Arrays;

/**
 * Given an integer array nums sorted in non-decreasing order.
 * Return an array of the squares of each number sorted in non-decreasing order.
 * Follow up: Squaring each element and sorting the new array is very trivial, could you find an O(n) solution using a different approach?
 * */
public class SortedArraySquares {
	public static void main(String[] args) {
		System.out.println(Arrays.toString(sortedSquares(new int[] { -4, -1, 0, 3, 10 })));
	}

	public static int[] sortedSquares(int[] nums) {
		for(int i = 0; i < nums.length; ++i) {
			nums[i] = nums[i]*nums[i];
		}
		int i = 0, n = nums.length;
		boolean swapNeeded = true;
		while (i < n - 1 && swapNeeded) {
			swapNeeded = false;
			for (int j = 1; j < n - i; ++j) {
				if (nums[j - 1] > nums[j]) {
					int temp = nums[j - 1];
					nums[j - 1] = nums[j];
					nums[j] = temp;
					swapNeeded = true;
				}
			}
			if (!swapNeeded) {
				break;
			}
			++i;
		}
		return nums;
	}
}
