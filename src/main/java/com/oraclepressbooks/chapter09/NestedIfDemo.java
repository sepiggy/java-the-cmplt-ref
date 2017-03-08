package com.oraclepressbooks.chapter09;

/**
 * @formatter:off
 * NestedIfDemo.java
 * 2017-03-08 10:41:09 
 * @author JiaMingsheng
 * @formatter:on
 * p206
 */
public class NestedIfDemo {
  public static void main(String[] args) {
    // use a nested interface reference
    A.NestedIF nif = new B();
    
    if(nif.isNotNegative(10))
      System.out.println("10 is not negative");
    
    if(nif.isNotNegative(-12))
      System.out.println("this won't be displayed");
  }
}
