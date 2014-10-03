package com.cs.euler.p050;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import com.cs.euler.EulerBase;

public class P014LongestCollatzSequence extends EulerBase {

	/*
	 * n → n/2 (n is even) n → 3n + 1 (n is odd) Which starting number, under
	 * one million, produces the longest chain?
	 */

	Map<Long, Long> cache = new HashMap<>(1000000*10);
	Map<Long, Long> cache2 =new HashMap<>(10000);

	@Test
	public void resolve() {
		long result = 0;
		long num=0;
		long start =  System.currentTimeMillis();
		long N=1000000;
		for (long i = 2; i < N; i++) {
			long step = collatzSteps(i);
			if (step > result) {
				result = step;
				num=i;
			}
			cache.put(i, step);
			if(i%(N/100)==0){
				print(i/(N/100), "%  Time=", (System.currentTimeMillis()-start)/1000, i, step);
			}
		}
		print(num);
	}

	private long collatzSteps(long num) {
		long result=0;
		cache2.clear();
		while(num!=1){
			if(cache.get(num)!=null){
				result = result+cache.get(num);
				break;
			}
			if(num<0){
				print(num, "< 0");
			}
			if(num%2==0){
				num=num/2;
			}else{
				num=num*3+1;
			}
			result++;
			cache2.put(num, result);
		}
		for(Long i:cache2.keySet()){
			if(!cache.containsKey(i)){
				cache.put(i, result-cache2.get(i));
			}
		}
		return result;
	}
}
