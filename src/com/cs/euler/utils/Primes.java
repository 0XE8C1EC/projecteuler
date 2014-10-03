package com.cs.euler.utils;

import java.util.ArrayList;
import java.util.List;

public class Primes {
	private static int max = 0;
	private static boolean[] bitmap = new boolean[] { false };
	public static List<Integer> primes=new ArrayList<Integer>(10000);

	public static interface Function<R>{
		R apply(int num);
	}
	public static Integer last(Function<Boolean> f){
		Integer last=null;
		for(int i=2;i<=max;i++){
			if(bitmap[i]){
				if(f.apply(i)){
					last = i;
				}
			}
		}
		return last;
	}
	
	public static boolean isPrime(int n) {
		if (n > max) {
			genPrime(n);
		}
		return bitmap[n];
	}

	private static void genPrime(int n) {
		if (n < 1000) {
			n = 1000;
		}
		boolean[] oldPrimes = bitmap;
		boolean[] newPrimes = new boolean[n + 1];
		for (int i = 0; i <= max; i++) {
			newPrimes[i] = oldPrimes[i];
		}
		for (int i = max; i <= n; i++) {
			newPrimes[i] = true;
		}
		int sqrt = (int) (Math.sqrt(n) + 1);
		newPrimes[0] = false;
		newPrimes[1] = false;
		newPrimes[2] = true;
		int start = Math.max(3, max);
		for (int i = 2; i <= sqrt; i++) {
			for (int j = start / i * i + i; j <= n; j += i) {
				newPrimes[j] = false;
			}
			start = Math.max(max, i * i + 1);
		}
		bitmap=newPrimes;
		for(int i=max+1;i<=n;i++){
			if(bitmap[i]){
				primes.add(i);
			}
		}
		max = n;
	}
}
