package com.oraclepressbooks.chapter10;

/**
 * @formatter:off
 * MyException.java
 * 2017-03-09 14:41:42 
 * @author JiaMingsheng
 * @formatter:on
 * p234
 * This program creates a custom exception type.
 */
public class MyException extends Exception {
  private int detail;
  
  public MyException(int a) {
   detail = a;
  }
  
  public String toString() {
    return "MyException[" + detail + "]";
  }
}
