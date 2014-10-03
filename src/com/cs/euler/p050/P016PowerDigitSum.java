package com.cs.euler.p050;

import org.junit.Test;

import com.cs.euler.EulerBase;

public class P016PowerDigitSum extends EulerBase {

	/*

  */

	@Test
	public void resolve() {
		print(digitalSum(1000));
	}

	private int digitalSum(int x) {
		int[] number = new int[1000];
		number[0] = 2;
		int len = 1;
		int high = 0;
		for (int i = 2; i <= x; i++) {
			for (int j = 0; j < len; j++) {
				number[j] = number[j] * 2 + high;
				high = number[j] / 10;
				number[j] = number[j] % 10;
			}
			if (high > 0) {
				number[len] = high;
				len++;
				high=0;
			}
		}
		int res = 0;
		for (int i = 0; i < len; i++) {
			res += number[i];
		}
		return res;
	}

}
