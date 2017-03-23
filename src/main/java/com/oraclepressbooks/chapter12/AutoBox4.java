package com.oraclepressbooks.chapter12;

/**
 * @formatter:off
 * AutoBox4.java
 * 2017-03-23 15:08:03 
 * @author JiaMingsheng
 * @formatter:on
 * p282
 */
public class AutoBox4 {
  public static void main(String[] args) {
    
    Integer iOb = 100;
    Double dOb = 98.6;
    
    dOb = dOb + iOb;
    System.out.println("dOb after expression: " + dOb);
  }

}
