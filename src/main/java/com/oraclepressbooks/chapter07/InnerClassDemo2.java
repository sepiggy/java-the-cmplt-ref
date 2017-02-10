package com.oraclepressbooks.chapter07;

/**
 * @formatter:off
 * InnerClassDemo2.java
 * 2017-02-10 10:38:06 
 * @author JiaMingsheng
 * p153
 * Define an inner class within a for loop.
 * @formatter:on
 */
class Outer2 {
  int outer_x = 100;
  
  void test() {
    for(int i=0; i<10; i++) {
      class Inner {
        void display() {
          System.out.println("display: outer_x = " + outer_x);
        }
      }
      Inner inner = new Inner();
      inner.display();
    }
  }
}

public class InnerClassDemo2 {
  public static void main(String args[]) {
     Outer2 outer2 = new Outer2();
     outer2.test();
  }
}
