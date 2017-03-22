package com.oraclepressbooks.chapter12;

/**
 * @formatter:off
 * EnumDemo2.java
 * 2017-03-22 16:43:35 
 * @author JiaMingsheng
 * @formatter:on
 * p272
 * Use the built-in enumeration methods.
 */

public class EnumDemo2 {
  public static void main(String[] args) {
    Apple ap;

    System.out.println("Here are all Apple constants:");

    // use values()
    Apple[] allapples = Apple.values();
    for (Apple a:allapples)
      System.out.println(a);
    
    System.out.println();
    
    // use valueOf()
    ap = Apple.valueOf("Winesap");
    System.out.println("ap contains " + ap);
  }
}
