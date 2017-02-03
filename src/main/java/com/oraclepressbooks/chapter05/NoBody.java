package com.oraclepressbooks.chapter05;

/**
 * @formatter:off
 * NoBody.java
 * 2017-02-03 16:03:37 
 * @author JiaMingsheng
 * p90
 * The target of a loop can be empty.
 * result:
 * Midpoint is 150
 * i=150, j=150
 * @formatter:on
 */
public class NoBody {
  public static void main(String[] args) {
    int i, j;
    
    i = 100;
    j = 200;
    
    // find midpoint between i and j
    while(++i < --j) ; // no body in this loop
    
    System.out.println("Midpoint is " + i);
    System.out.println("i=" + i + ", j=" + j);
  }
}
