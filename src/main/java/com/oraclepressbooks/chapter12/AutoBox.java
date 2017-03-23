package com.oraclepressbooks.chapter12;

/**
 * @formatter:off
 * AutoBox.java
 * 2017-03-23 14:19:00 
 * @author JiaMingsheng
 * @formatter:on
 * p281
 * Demonstrate autoboxing/unboxing.
 */
public class AutoBox {

  public static void main(String[] args) {
    
    Integer iOb = 100; // autobox an int
    
    int i = iOb; //auto-unbox
    
    System.out.println(i + " " + iOb); // displays 100 100
  }

}
