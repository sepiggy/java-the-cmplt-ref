package com.oraclepressbooks.chapter03;

/**
 * @formatter:off
 * Promote.java
 * 2017-01-22 16:39:45 
 * @author JiaMingsheng
 * p51
 * @formatter:on
 */
public class Promote {
  public static void main(String[] args) {
    byte b = 42;
    char c = 'a';
    short s = 1024;
    int i = 50000;
    float f = 5.67f;
    double d = .1234;
    double result = (f * b) + (i / c) - (d * s);
    System.out.println((f * b) + " + " + (i / c) + " - " + (d * s));
    System.out.println("result = " + result);
  }
}
