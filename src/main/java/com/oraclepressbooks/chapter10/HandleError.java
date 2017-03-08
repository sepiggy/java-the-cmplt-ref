package com.oraclepressbooks.chapter10;

import java.util.Random;

/**
 * @formatter:off
 * HandleError.java
 * 2017-03-08 20:31:13 
 * @author JiaMingsheng
 * @formatter:on
 * p223
 * Handle an exception and move on.
 */

public class HandleError {
  public static void main(String[] args) {
    int a=0, b=0, c=0;
    Random r = new Random();
    
    for(int i=0; i<32000; i++) {
      try {
        b = r.nextInt();
        c = r.nextInt();
        a = 12345 / (b/c);
      } catch (ArithmeticException e) {
        System.out.println("Division by zero.");
        a = 0;
      }
      System.out.println("a: " + a);
    }
  }
}
