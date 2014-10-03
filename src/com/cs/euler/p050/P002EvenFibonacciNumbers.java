package com.cs.euler.p050;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import com.cs.euler.EulerBase;

public class P002EvenFibonacciNumbers extends EulerBase {

  Map<Integer, Long> cache = new HashMap<Integer, Long>();

  @Test
  public void resolve() {
    int i = 1;
    long sum = 0;
    long limit = 4 * 1000 * 1000;
    while (true) {
      long value = f(i);
      if (value > limit) {
        print(sum);
        break;
      } else if (value % 2 == 0) {
        sum += value;
      }
      i++;

    }
  }

  long f(int n) {
    cache.put(1, 1L);
    cache.put(2, 2L);
    for (int i = 3; i <= n; i++) {
      if (cache.get(i) == null) {
        cache.put(i, cache.get(i - 1) + cache.get(i - 2));
      }
    }

    return cache.get(n);
  }

}
