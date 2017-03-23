package com.oraclepressbooks.chapter12;

/**
 * @formatter:off
 * AutoBox2.java
 * 2017-03-23 14:22:20 
 * @author JiaMingsheng
 * @formatter:on
 * p282
 * Autoboxing/unboxing takes place with method parameters and return values.
 */

public class AutoBox2 {
  // Take an Integer parameter and return an int value;
  static int m(Integer v) {
    return v; // auto-unbox to int
  }
  
  public static void main(String[] args) {
    // It takes autoboxing/unboxing three times.
    Integer iOb = m(100);
    
    System.out.println(iOb);
  }
}
