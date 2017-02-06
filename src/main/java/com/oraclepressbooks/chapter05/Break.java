package com.oraclepressbooks.chapter05;

/**
 * @formatter:off
 * Break.java
 * 2017-02-06 13:32:53 
 * @author JiaMingsheng
 * p105
 * Using break as a civilized form of goto.
 * @formatter:on
 */
public class Break {
  public static void main(String[] args) {
    boolean t = true;
    
    first: {
      second: {
        third: {
          System.out.println("Before the break.");
          if(t) break second; // break out of second block
          System.out.println("This won't execute");
        }
      System.out.println("This won't execute");
      }
    System.out.println("This is after second block.");
    }
  }
}
