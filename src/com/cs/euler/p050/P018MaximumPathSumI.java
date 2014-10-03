package com.cs.euler.p050;

import org.apache.commons.io.IOUtils;
import org.junit.Test;

import com.cs.euler.EulerBase;

public class P018MaximumPathSumI extends EulerBase{

  /*
Find the maximum total from top to bottom of the triangle below:
  */
  

  @Test
  public void resolve() {
	  long[][] data = loadArrays("data\\p018.txt");
	  int E=data.length-1;
	  for(int i=E-1;i>=0;i--){
		  for(int j=0;j<=i;j++){
			  data[i][j]+=data[i+1][j]>data[i+1][j+1]?data[i+1][j]:data[i+1][j+1];
		  }
	  }
		  
	  print(data[0][0]);
  }

}
