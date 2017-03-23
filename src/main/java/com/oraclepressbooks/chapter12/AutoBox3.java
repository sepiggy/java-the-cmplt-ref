package com.oraclepressbooks.chapter12;

/**
 * @formatter:off
 * AutoBox3.java
 * 2017-03-23 14:31:08 
 * @author JiaMingsheng
 * @formatter:on
 * p282
 * Autoboxing/unboxing occurs inside expressions.
 */

public class AutoBox3 {
  public static void main(String[] args) {
    Integer iOb, iOb2;
    int i;
    
    iOb = 100;
    System.out.println("Original value of iOb: " + iOb);
    
    // The following automatically unboxes iOb,
    // performs the increment, and then reboxes
    // the result back into iOb.
    ++iOb;
    System.out.println("After ++iOb: " + iOb);
    
    // Here, iOb is unboxed, the expression is
    // evaluated, and the result is reboxed and
    // assigned to iOb2.
    iOb2 = iOb + (iOb / 3);
    System.out.println("iOb2 after expression: " + iOb2);
    
    // The same expression is evaluated, but the result is not reboxed.
    i = iOb + (iOb / 3);
    System.out.println("i after expression: " + i);
  }
}
