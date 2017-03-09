package com.oraclepressbooks.chapter10;

/**
 * @formatter:off
 * ExceptionDemo.java
 * 2017-03-09 14:44:19 
 * @author JiaMingsheng
 * @formatter:on
 * p235
 */
public class ExceptionDemo {
  static void compute(int a) throws MyException {
    System.out.println("Called compute(" + a + ")");
    if(a > 10)
      throw new MyException(a);
    System.out.println("Normal exit");
  }
  
  public static void main(String[] args) {
    try {
      compute(1);
      compute(20);
    } catch (MyException e) {
      System.out.println("Caught " + e);
    }
  }
}
