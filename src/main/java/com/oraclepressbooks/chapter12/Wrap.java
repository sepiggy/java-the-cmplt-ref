package com.oraclepressbooks.chapter12;

/**
 * @formatter:off
 * Wrap.java
 * 2017-03-23 14:13:09 
 * @author JiaMingsheng
 * @formatter:on
 * p280
 * Demonstrate a type wrapper.
 */

public class Wrap {
  public static void main(String[] args) {
    
    Integer iOb = new Integer(100);
    
    int i = iOb.intValue();
    
    System.out.println(i + " " + iOb); // displays 100 100
  }

}
