package com.cs.euler.p050;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.junit.Test;

import com.cs.euler.EulerBase;
import com.cs.euler.utils.Primes;

public class P005SmallestMultiple extends EulerBase {
	/*
	 * 2520 is the smallest number that can be divided by each of the numbers
	 * from 1 to 10 without any remainder. What is the smallest positive number
	 * that is evenly divisible by all of the numbers from 1 to 20?
	 */

	@Test
	public void resolve() {
		Primes.isPrime(20);
		Map<Integer, Integer> factors = new HashMap<Integer, Integer>();
		for (int i = 2; i <= 20; i++) {
			merge(factors, factorization(i));
		}
		print(factors, mul(factors));
	}

	private int mul(Map<Integer, Integer> factors) {
		int m = 1;
		for (Entry<Integer, Integer> e : factors.entrySet()) {
			m *= Math.pow(e.getKey(), e.getValue());
		}
		return m;
	}

	private void merge(Map<Integer, Integer> dest, Map<Integer, Integer> src) {
		for (Entry<Integer, Integer> e : src.entrySet()) {
			Integer count = dest.get(e.getKey());
			if (count == null || e.getValue() > count) {
				dest.put(e.getKey(), e.getValue());
			}
		}

	}

	public Map<Integer, Integer> factorization(int number) {
		final Map<Integer, Integer> result = new HashMap<Integer, Integer>();
		for (int i = 2; i <= number; i++) {
			if (!Primes.isPrime(i)) {
				continue;
			}
			int prime = i;
			if (prime <= number) {
				int tmp = number;
				int count = 0;
				while (tmp % prime == 0) {
					count++;
					tmp = (int) (tmp / prime);
				}
				if (count > 0) {
					result.put(prime, count);
				}
			}
		}
		return result;
	}

}
