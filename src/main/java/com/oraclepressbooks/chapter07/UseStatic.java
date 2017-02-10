package com.oraclepressbooks.chapter07;

/**
 * @formatter:off
 * UseStatic.java
 * 2017-02-09 10:29:56 
 * @author JiaMingsheng
 * p148
 * Demonstrate static variables, methods, and blocks.
 * @formatter:on
 */
public class UseStatic {
  static int a = 3;
  static int b;
  
  public static void main(String args[]) {
    meth(42);
  }

  static void meth(int x) {
    System.out.println("x = " + x);
    System.out.println("a = " + a);
    System.out.println("b = " + b);
  }
  
  static {
    System.out.println("Static block initialized.");
    b = a * 4;
  }

}
