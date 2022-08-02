package by.bknst.interview;

/**
 * Given an array of integers, find the one that appears an add number of times.
 * There will always be only one integer that appears an odd number of times
 * */
public class FindOdd {

	public static void main(String[] args) {
		System.out.println(findIt(new int[]{2,5,2,5}));
	}

	public static int findIt(int[] A) {
		int xor = 0;
		for (int i = 0; i < A.length; i++) {
			xor ^= A[i];
		}
		return xor;
	}

}
