package com.cs.euler.p050;

import org.junit.Test;

import com.cs.euler.EulerBase;
import com.cs.euler.utils.Primes;

public class P010SummationOfPrimes extends EulerBase {

  /*
   * The sum of the primes below 10 is 2 + 3 + 5 + 7 = 17. Find the sum of all
   * the primes below two million.
   */

  @Test
  public void resolve() {
    int n = 2000000;
    long sum = 0;
    Primes.isPrime(n);
    for (int p : Primes.primes) {
      if (p < n) {
        sum += p;
      }
    }
    print(sum);
  }

}
