package com.cs.euler.p050;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

import com.cs.euler.EulerBase;

public class P012HighlyDivisibleTriangularNumber extends EulerBase{

  /*
The sequence of triangle numbers is generated by adding the natural numbers. So the 7th triangle number would be 1 + 2 + 3 + 4 + 5 + 6 + 7 = 28. The first ten terms would be:
1, 3, 6, 10, 15, 21, 28, 36, 45, 55, ...
Let us list the factors of the first seven triangle numbers:
     1: 1
     3: 1,3
     6: 1,2,3,6
    10: 1,2,5,10
    15: 1,3,5,15
    21: 1,3,7,21
    28: 1,2,4,7,14,28
We can see that 28 is the first triangle number to have over five divisors.
What is the value of the first triangle number to have over five hundred divisors?
  */
  

	@Test
	public void resolve() {
		long MAX=Long.MAX_VALUE;
		int max=0;
		for(long i=1, s=1;s<MAX; s=sum(++i)){
			//print(i, s);
			Set<Integer> divisors=new HashSet<Integer>();
			for(int j=1;j<Math.sqrt(s)+1; j++){
				if(s%j==0){
					divisors.add(j);
					divisors.add((int) (s/j));
				}
			}
			max=Math.max(max, divisors.size());
			//print(max, i,s, divisors);
			if(divisors.size()>500){
				print(s);
				break;
			}
		}
	}

	private long sum(long n) {
		return (n + 1) * n / 2;
	}

}