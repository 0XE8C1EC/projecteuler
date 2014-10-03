package com.cs.euler.p050;

import org.junit.Test;

import com.cs.euler.EulerBase;

public class P015LatticePaths extends EulerBase {

	/*
	 * How many such routes are there through a 20×20 grid? 
	 * N(i,j)=N(i+1, j)+N(i, j+1)
	 * 
	 */

	@Test
	public void resolve() {
		int N=20;
		long [][] grid=new long[N+1][N+1];
		for(int i=N;i>=0;i--){
			for(int j=N;j>=0;j--){
				if(i==N||j==N){
					grid[i][j]=1;
				}else{
					grid[i][j]=grid[i][j+1]+grid[i+1][j];
				}
			}
		}
		print(grid[0][0]);
	}

}
