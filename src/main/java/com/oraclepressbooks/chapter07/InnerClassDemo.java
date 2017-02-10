package com.oraclepressbooks.chapter07;

/**
 * @formatter:off
 * InnerClassDemo.java
 * 2017-02-09 18:05:19 
 * @author JiaMingsheng
 * p151
 * Demonstrate an inner class.
 * @formatter:on
 */
class Outer {
  int outer_x = 100;
  
  void test() {
    Inner inner = new Inner();
    inner.display();
  }
  
  // this is an inner class
  class Inner {
    void display() {
      System.out.println("display: outer_x = " + outer_x);
    }
  }
}

public class InnerClassDemo {
  public static void main(String[] args) {
    Outer outer = new Outer();
    outer.test();
  }

}
