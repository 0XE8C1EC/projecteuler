package com.cs.euler.p050;

import org.junit.Test;

import com.cs.euler.EulerBase;

public class P004LargestPalindromeProduct extends EulerBase {

  /*
   * A palindromic number reads the same both ways. The largest palindrome made
   * from the product of two 2-digit numbers is 9009 = 91 � 99. Find the largest
   * palindrome made from the product of two 3-digit numbers.
   */

  @Test
  public void resolve() {
    int resi=0, resj=0, res=0;
    for(int i=999;i>=100;i--){
      for(int j=i;j>=100;j--){
        if(isPalindrome(i*j)){
          if(i*j>res){
            res=i*j;
            resi=i;
            resj=j;
          }
        }
      }
    }
    print(resi, resj, res);
  }

  private boolean isPalindrome(int number) {
    int count = (int) (Math.log10(number) + 1);
    int res = 0;
    int tmp = number;
    for (int i = 1; i <= count; i++) {
      int dec = tmp % 10;
      res = res * 10 + dec;
      tmp = tmp / 10;
    }
    return res == number;
  }
}
