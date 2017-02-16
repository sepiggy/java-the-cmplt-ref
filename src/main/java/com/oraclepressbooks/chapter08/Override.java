package com.oraclepressbooks.chapter08;

/**
 * @formatter:off
 * Override.java
 * 2017-02-15 15:15:38 
 * @author JiaMingsheng
 * p181
 * Method overriding.
 * @formatter:on
 */
class A1 {
  int i, j;
  
  A1(int a, int b) {
    i = a;
    j = b;
  }
  
  void show() {
    System.out.println("i and j: " + i + " " + j);
  }
}

class B1 extends A1 {
  int k;
  
  B1(int a, int b, int c) {
    super(a, b);
    k = c;
  }
  
  /*
  void show() {
    // super.show();
    System.out.println("k: " + k);
  }
  */
  
  void show(String msg) {
    System.out.println(msg + k);
  }
}

public class Override {
  public static void main(String[] args) {
    B1 subOb = new B1(1, 2, 3);
    
    subOb.show("This is k: ");
    subOb.show();

  }
}
