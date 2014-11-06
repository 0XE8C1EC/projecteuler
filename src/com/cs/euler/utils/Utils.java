package com.cs.euler.utils;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Utils {
	public static Map<Integer, Integer> factorization(int number) {
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
	
	public static Set<Integer> evenDivisors(int number){
		Set<Integer> result= new HashSet<>();
		int sqrt=(int) (Math.sqrt(number)+1);
		for(int i=2;i<sqrt;i++){
			if(number%i==0){
				result.add(i);
				result.add(number/i);
			}
		}
		result.add(1);
		return result;
	}
}