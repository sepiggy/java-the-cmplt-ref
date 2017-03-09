package com.oraclepressbooks.chapter10;

/**
 * @formatter:off
 * NestTry.java
 * 2017-03-09 09:57:50 
 * @author JiaMingsheng
 * @formatter:on
 * p226
 * An example of nested try statements.
 */
public class NestTry {
  public static void main(String[] args) {
    try {
      int a = args.length;
      
      int b = 42 / a;
      
      System.out.println("a = " + a);
      
      try {
        if (a==1) a = a/(a-a);
        
        if (a==2) {
          int[] c = { 1 };
          c[42] = 99;
        }
      } catch(ArrayIndexOutOfBoundsException e) {
        System.out.println(e);
      }
    } catch(ArithmeticException e) {
      System.out.println(e);
    }
  }

}
