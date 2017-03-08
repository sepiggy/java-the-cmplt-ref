package com.oraclepressbooks.chapter09;

/**
 * @formatter:off
 * MyIF.java
 * 2017-03-08 15:15:06 
 * @author JiaMingsheng
 * @formatter:on
 * p217
 */
public interface MyIF {
  
  int getNumber();
  
  default String getString() {
    return "Default String";
  }
  
  static int getDefaultNumber() {
    return 0;
  }
}
