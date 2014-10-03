package com.cs.euler.p050;

import org.junit.Test;

import com.cs.euler.EulerBase;
import com.cs.euler.utils.Primes;

public class P003LargestPrimeFactor extends EulerBase {
	private static final long N = 600851475143L;

	@Test
	public void resolve() {
		int sqrt = ((int) Math.sqrt(N)) + 1;
		Primes.isPrime(sqrt);
		print(largest(N));
	}

	private long largest(final long number) {
		long result = 1;
		for (int p : Primes.primes) {
			if (number % p == 0) {
				result = p;
			}
		}
		return result;
	}

}
