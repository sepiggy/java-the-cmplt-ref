package com.oraclepressbooks.chapter07;

/**
 * @formatter:off
 * AccessTest.java
 * 2017-02-09 09:28:30 
 * @author JiaMingsheng
 * p145
 * This program demonstrates the difference between public and private.
 * @formatter:on
 */
class Test {
  int a;
  public int b;
  private int c;
  
  void setc(int i) {
    c = i;
  }
  
  int getc() {
    return c;
  }
}
public class AccessTest {
  public static void main(String args[]) {
    Test ob = new Test();
    
    ob.a = 10;
    ob.b = 20;
    
    // ob.c = 100; // Error!
    
    // You must access c through its methods
    ob.setc(100); // ok
    System.out.println("a, b, and c: " + ob.a + " " + ob.b + " " + ob.getc());
  }
}
