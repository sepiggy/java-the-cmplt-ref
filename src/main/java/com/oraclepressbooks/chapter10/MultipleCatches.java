package com.oraclepressbooks.chapter10;

/**
 * @formatter:off
 * MultipleCatches.java
 * 2017-03-09 09:32:53 
 * @author JiaMingsheng
 * @formatter:on
 * p224
 * Demonstrate multiple catch statements.
 */
public class MultipleCatches {
  public static void main(String[] args) {
    try {
      int a = args.length;
      System.out.println("a = " + a);
      int b = 42 / a;
      int[] c = { 1 };
      c[42] = 99;
    } catch(ArithmeticException e) {
      System.out.println(e);
    } catch(ArrayIndexOutOfBoundsException e) {
      System.out.println(e);
    }
    System.out.println("After try/catch blocks.");
  }

}
