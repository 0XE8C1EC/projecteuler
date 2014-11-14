package com.cs.euler.p050;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.junit.Test;

import com.cs.euler.EulerBase;
import com.cs.euler.utils.Utils;

public class P023NonAbundantSums extends EulerBase {

	/*
	 * 
	 * 
	 * A perfect number is a number for which the sum of its proper divisors is
	 * exactly equal to the number. For example, the sum of the proper divisors
	 * of 28 would be 1 + 2 + 4 + 7 + 14 = 28, which means that 28 is a perfect
	 * number. A number n is called deficient if the sum of its proper divisors
	 * is less than n and it is called abundant if this sum exceeds n.
	 * 
	 * As 12 is the smallest abundant number, 1 + 2 + 3 + 4 + 6 = 16, the
	 * smallest number that can be written as the sum of two abundant numbers is
	 * 24. By mathematical analysis, it can be shown that all integers greater
	 * than 28123 can be written as the sum of two abundant numbers. However,
	 * this upper limit cannot be reduced any further by analysis even though it
	 * is known that the greatest number that cannot be expressed as the sum of
	 * two abundant numbers is less than this limit.
	 * 
	 * Find the sum of all the positive integers which cannot be written as the
	 * sum of two abundant numbers.
	 */

	@Test
	public void resolve() {
		int len=28123;
		List<Integer> abundants=new ArrayList<>();
		for(int i=12;i<=len;i++){
			if(isAbundant(i)){
				abundants.add(i);
			}
		}
		int[] bits=new int[len+1];
		Integer[] as = abundants.toArray(new Integer[0]);

		for(int i=0;i<as.length;i++){
			for(int j=i;j<as.length;j++){
				int k=as[i]+as[j];
				if(k<=28123){
					bits[k]=1;
				}
			}
		}
		long sum=0;
		for(int i=1;i<=len;i++){
			if(bits[i]!=1){
				sum+=i;
			}
		}
		print(sum);
	}

	private boolean isAbundant(int i) {
		Set<Integer> divs = Utils.evenDivisors(i);
		int sum=0;
		for(int num:divs){
			sum+=num;
		}
		return sum>i;
	}

}
