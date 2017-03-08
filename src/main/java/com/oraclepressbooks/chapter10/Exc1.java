package com.oraclepressbooks.chapter10;

/**
 * @formatter:off
 * Exc1.java
 * 2017-03-08 19:59:00 
 * @author JiaMingsheng
 * @formatter:on
 * p222
 */
public class Exc1 {
  static void subroutine() {
    int d = 0;
    int a = 10 / d;
  }
  
  public static void main(String[] args) {
    Exc1.subroutine();
  }
}
