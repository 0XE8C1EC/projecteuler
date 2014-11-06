package com.cs.euler.p050;

import java.util.Set;

import org.junit.Test;

import com.cs.euler.EulerBase;
import com.cs.euler.utils.Utils;

public class P021AmicableNumbers extends EulerBase {

	/*
	 * Let d(n) be defined as the sum of proper divisors of n (numbers less than
	 * n which divide evenly into n). If d(a) = b and d(b) = a, where a ≠ b,
	 * then a and b are an amicable pair and each of a and b are called amicable
	 * numbers. For example, the proper divisors of 220 are 1, 2, 4, 5, 10, 11,
	 * 20, 22, 44, 55 and 110; therefore d(220) = 284. The proper divisors of
	 * 284 are 1, 2, 4, 71 and 142; so d(284) = 220. Evaluate the sum of all the
	 * amicable numbers under 10000.
	 */

	@Test
	public void resolve() {
		int sum = 0;
		for (int a = 1; a <= 10000; a++) {
			int b = d(a);
			if (a != b && d(b) == a) {
				sum += a;
			}
		}
		print(sum);
	}

	private int d(int num) {
		Set<Integer> facts = Utils.evenDivisors(num);
		int b = 0;
		for (Integer fact : facts) {
			b += fact;
		}
		return b;
	}

}
