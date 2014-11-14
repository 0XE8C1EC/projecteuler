package com.cs.euler.p050;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.cs.euler.EulerBase;

public class P024LexicographicPermutations extends EulerBase {

	/*
	 * 
	 * 
	 * A permutation is an ordered arrangement of objects. For example, 3124 is
	 * one possible permutation of the digits 1, 2, 3 and 4. If all of the
	 * permutations are listed numerically or alphabetically, we call it
	 * lexicographic order. The lexicographic permutations of 0, 1 and 2 are:
	 * 
	 * 012 021 102 120 201 210
	 * 
	 * What is the millionth lexicographic permutation of the digits 0, 1, 2, 3,
	 * 4, 5, 6, 7, 8 and 9?
	 * 
	 * f(n+1)=(n+1)*f(n)
	 * 
	 */

	@Test
	public void resolve() {
		int[] data=new int[11];
		data[1]=1;
		for(int i=2;i<=10;i++){
			data[i]=i*data[i-1];
		}
		int count=999999;
		List<Integer> positions=new ArrayList<>();
		for(int level=10;level>1;level--){
			int pos = count/data[level-1];
			positions.add(pos);
			count=count-pos*data[level-1];
		}
		List<Integer> nums=new ArrayList<>();
		for(int i=0;i<10;i++){
			nums.add(i);
		}
		StringBuilder sb=new StringBuilder();
		for(int pos:positions){
			if(pos<=nums.size()&&pos>0){
				Integer num=nums.get(pos);
				nums.remove(num);
				sb.append(num);
			}
		}
		for(int i:nums){
			sb.append(i);
		}
		print(sb.toString());
	}
}
