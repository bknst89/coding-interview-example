package by.bknst.interview;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a string. Find the second non-repeating character in it and return its index.
 * If it doesn't exist return -1
 * <p>
 * Examples:
 * <p>
 * Input: "ababcde"
 * Output: 5
 */
public class NonRepeatingCharacters {
	public static void main(String[] args) {
		System.out.println(secondNonRepeatingCharIndex("ababcded"));

	}

	public static int secondNonRepeatingCharIndex(String givenString) {

		Map<Character, Integer> charCount = new HashMap<>();
		int stringLength = givenString.length();
		for (int i = 0; i < stringLength; ++i) {
			if (!charCount.containsKey(givenString.charAt(i))) {
				charCount.put(givenString.charAt(i), 0);
			}

			int count = charCount.get(givenString.charAt(i));
			charCount.put(givenString.charAt(i), ++count);
		}

		int count = 0;
		for (int i = 0; i < stringLength; ++i) {
			if (charCount.get(givenString.charAt(i)) == 1) {
				++count;
			}
			if (count == 2) {
				return i;
			}
		}

		return -1;
	}
}
