package com.oraclepressbooks.chapter07;

/**
 * @formatter:off
 * StringDemo3.java
 * 2017-02-10 13:32:44 
 * @author JiaMingsheng
 * p156
 * Demonstrate String arrays.
 * @formatter:on
 */
public class StringDemo3 {
  public static void main(String[] args) {
    String str[] = { "one", "two", "three" };
    
    for(int i=0; i<str.length; i++)
      System.out.println("str[" + i + "]: " + str[i]);
  }

}
