package com.oraclepressbooks.chapter07;

/**
 * @formatter:off
 * VarArgs2.java
 * 2017-02-10 14:24:04 
 * @author JiaMingsheng
 * p160
 * Use varargs with standard arguments.
 * @formatter:on
 */
public class VarArgs2 {
  // Here, msg is a normal parameter and v is a varargs parameter.
  static void vaTest(String msg, int... v) {
    System.out.print(msg + v.length + " Contents: ");
    
    for(int x: v)
      System.out.print(x + " ");
    
    System.out.println();
  }
  
  public static void main(String[] args) {
    vaTest("One vararg: ", 10);
    vaTest("Three varargs: ", 1, 2, 3);
    vaTest("No varargs: ");
  }

}
