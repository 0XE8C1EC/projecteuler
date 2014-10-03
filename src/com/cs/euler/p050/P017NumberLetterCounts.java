package com.cs.euler.p050;

import org.junit.Test;

import com.cs.euler.EulerBase;

public class P017NumberLetterCounts extends EulerBase {

	/*
	 * If the numbers 1 to 5 are written out in words: one, two, three, four,
	 * five, then there are 3 + 3 + 5 + 4 + 4 = 19 letters used in total. If all
	 * the numbers from 1 to 1000 (one thousand) inclusive were written out in
	 * words, how many letters would be used? NOTE: Do not count spaces or
	 * hyphens. For example, 342 (three hundred and forty-two) contains 23
	 * letters and 115 (one hundred and fifteen) contains 20 letters. The use of
	 * "and" when writing out numbers is in compliance with British usage.
	 */

	private static final String[] l1 = { "", "one", "two", "three", "four",
			"five", "six", "seven", "eight", "nine", "ten", "eleven", "twelve",
			"thirteen", "fourteen", "fifteen", "sixteen", "seventeen",
			"eighteen", "nineteen", "twenty" };
	private static final String[] l2 = { "", "", "twenty", "thirty", "forty",
			"fifty", "sixty", "seventy", "eighty", "ninety" };
	private static final String hundred = "hundred";

	@Test
	public void resolve() {
		int sum = 0;
		for (int i = 1; i < 1000; i++) {
			sum += getLetterCount(i);
		}
		sum += "onethousand".length();
		print(sum);
	}

	private int getLetterCount(int i) {
		int count = 0;

		int h = i / 100;
		if (h > 0) {
			count += l1[h].length() + hundred.length();
		}

		i = i % 100;
		if (i > 0) {
			if (h > 0) {
				count += 3;//and
			}
			if (i <= (l1.length - 1)) {
				count += l1[i].length();
			} else {
				count += l2[i / 10].length() + l1[i % 10].length();
			}
		}

		return count;
	}

}
