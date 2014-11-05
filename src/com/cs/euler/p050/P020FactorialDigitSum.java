package com.cs.euler.p050;

import java.math.BigDecimal;

import org.junit.Test;

import com.cs.euler.EulerBase;

public class P020FactorialDigitSum extends EulerBase{

  /*
n! means n × (n − 1) × ... × 3 × 2 × 1
For example, 10! = 10 × 9 × ... × 3 × 2 × 1 = 3628800,
and the sum of the digits in the number 10! is 3 + 6 + 2 + 8 + 8 + 0 + 0 = 27.
Find the sum of the digits in the number 100!
  */
  

	@Test
	public void resolve() {
		int sum = 0;
		BigDecimal fac = new BigDecimal(1);
		for (int i = 1; i <= 100; i++) {
			fac = fac.multiply(new BigDecimal(i));
		}
		while (fac.doubleValue() >= 1) {
			sum += fac.remainder(new BigDecimal(10)).intValue();
			fac = fac.divide(new BigDecimal(10));
		}
		print(sum);
	}

}
