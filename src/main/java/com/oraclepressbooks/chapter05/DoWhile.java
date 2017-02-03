package com.oraclepressbooks.chapter05;

/**
 * @formatter:off
 * DoWhle.java
 * 2017-02-03 16:48:43 
 * p91
 * Demonstrate the do-while loop.
 * @author JiaMingsheng
 * @formatter:on
 */
public class DoWhile {
  public static void main(String[] args) {
    int n = 10;
    
    do {
      System.out.println("tick " + n);
    } while(--n > 0);
  }

}
