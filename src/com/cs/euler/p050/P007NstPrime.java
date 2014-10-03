package com.cs.euler.p050;

import org.junit.Test;

import com.cs.euler.EulerBase;
import com.cs.euler.utils.Primes;

public class P007NstPrime extends EulerBase {
  /*
   * 
   * By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see
   * that the 6th prime is 13. What is the 10001st prime number?
   */
  @Test
  public void resolve() {
    int n = 1000;
    int add = 1000;
    while (n < 100000000) {
      Primes.isPrime(n);
      if (Primes.primes.size() >= 10001) {
        print(Primes.primes.get(10000));
        break;
      }
      n+=add;
    }
  }

}
