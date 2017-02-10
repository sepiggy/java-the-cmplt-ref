package com.oraclepressbooks.chapter07;

/**
 * @formatter:off
 * VarArgs.java
 * 2017-02-10 14:17:44 
 * @author JiaMingsheng
 * p157
 * Demonstrate variable-length arguments.
 * @formatter:on
 */
public class VarArgs {
  
  // vaTest() now uses a vararg.
  static void vaTest(int ... v) {
    System.out.print("Number of args: " + v.length + " Contents: ");
    
    for(int x: v)
      System.out.print(x + " ");
    
    System.out.println();
  }
  
  public static void main(String[] args) {
    // Notice how vaTest() can be called with a variable number of arguments.
    vaTest(10);
    vaTest(1, 2, 3);
    vaTest();
  }

}
