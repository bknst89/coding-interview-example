package by.bknst.interview;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Coupon code consists of only unique digits.
 * Write a function to calculate available coupon codes for a specified number N (N=1...10) of digits in a coupon code
 * <p>
 * Examples:
 * <p>
 * Input: 1 (Coupon code length is 1 digit)
 * Output: 10 (Ten unique coupon codes with length of 1 digit)
 * <p>
 * Input: 2 (Coupon code length is 2 digits)
 * Output: 91 (All digit combination from 00 to 99 excluding non-unique combinations 11, 22, 33 ... 99)
 */
public class CouponCode {

	public static void main(String[] args) {
		System.out.println(calculate(3));
	}

	public static int calculate(int couponDigitsNum) {

		List<Integer> couponCodes = new ArrayList<>();

		double couponCodesMaxNum = Math.pow(10, couponDigitsNum) - 1;
		for (int i = 0; i <= couponCodesMaxNum; ++i) {
			couponCodes.add(i);
		}

		List<Integer> uniqueDigits = couponCodes.stream().filter(integer -> {

			if(integer == 0) {
				return true;
			}

			List<Integer> digits = new ArrayList<>();
			int target = integer;
			while (target > 0) {
				digits.add(target % 10);
				target = target / 10;
			}

			Set<Integer> uniqueDigitsSet = new HashSet<>(digits);

			return uniqueDigitsSet.size() == digits.size();

		}).collect(Collectors.toList());

		return uniqueDigits.size();
	}
}
