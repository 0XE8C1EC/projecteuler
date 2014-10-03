package com.cs.euler.p050;

import org.junit.Test;

import com.cs.euler.EulerBase;

public class P001MultiplesOf3and5 extends EulerBase{
	
  private int calc(int begin, int end, int number) {
    int min = begin % number == 0 ? begin : (begin / number + 1) * number;
    int max = end % number == 0 ? end : end / number * number;
    int count = (max - min) / number + 1;
    return (min + max) * count / 2;
  }

  @Test
  public void resolve() {
    int begin = 1;
    int end = 999;
    
    int result = calc(begin, end, 3) + calc(begin, end, 5) - calc(begin, end, 15);
    
    print(result);
  }
}
