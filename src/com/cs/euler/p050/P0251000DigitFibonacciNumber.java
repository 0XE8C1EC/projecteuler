package com.cs.euler.p050;

import java.math.BigDecimal;

import org.junit.Test;

import com.cs.euler.EulerBase;

public class P0251000DigitFibonacciNumber extends EulerBase{

  /*

  */
  

  @Test
  public void resolve() {
	  BigDecimal n1=new BigDecimal(1);
	  BigDecimal n2=new BigDecimal(1);
	  BigDecimal num=new BigDecimal(3);
	  int count=2;
	  
	  while(num.toString().length()<1000){
		  count++;
		  num=n2.add(n1);
		  n1=n2;
		  n2=num;
	  }
	  print(count);
  }

}
