package com.cs.euler.p050;

import org.junit.Test;

import com.cs.euler.EulerBase;

public class P009SpecialPythagoreanTriplet extends EulerBase {

  /*
   * A Pythagorean triplet is a set of three natural numbers, a < b < c, for
   * which, a2 + b2 = c2
   * 
   * For example, 32 + 42 = 9 + 16 = 25 = 52.
   * 
   * There exists exactly one Pythagorean triplet for which a + b + c = 1000.
   * Find the product abc.
   */

  @Test
  public void resolve() {
    for (int c = 999; c > 0; c--) {
      for (int b = 1000 - c; b > 0; b--) {
        int a = 1000 - b - c;
        if (c > b && b > a && a > 0 && b > 0 && c > 0) {
          if ((a * a + b * b) == c * c) {
            print(a, b, c, a * b * c);
          }
        }
      }
    }
  }
}
