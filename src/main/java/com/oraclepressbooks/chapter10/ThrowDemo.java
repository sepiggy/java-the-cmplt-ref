package com.oraclepressbooks.chapter10;

/**
 * @formatter:off
 * ThrowDemo.java
 * 2017-03-09 10:38:34 
 * @author JiaMingsheng
 * @formatter:on
 * p228
 * Demonstrate throw.
 */
public class ThrowDemo {
  static void demoproc() {
    try {
      throw new NullPointerException("demo");
    } catch(NullPointerException e) {
      System.out.println("Caught inside demoproc.");
      throw e;
    }
  }

  
  public static void main(String[] args) {
    try {
      demoproc();
    } catch(NullPointerException e) {
      System.out.println("Recaught: " + e);
      System.out.println(e.getMessage());
    }
  }
}
