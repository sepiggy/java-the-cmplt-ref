package com.oraclepressbooks.chapter08;

/**
 * @formatter:off
 * UseSuper.java
 * 2017-02-15 13:56:24 
 * @author JiaMingsheng
 * p175
 * Using super to overcome name hiding.
 * @formatter:on
 */
class Parent {
  int i;
}

// Create a subclass by extending class A.
class Child extends Parent {
  int i; // this i hides the i in A
  
  Child(int a, int b) {
    super.i = a; // i in A
    i = b; // i in B
  }
  
  void show() {
    System.out.println("i in superclass: " + super.i);
    System.out.println("i in subclass: " + i);
  }
}

public class UseSuper {
  public static void main(String[] args) {
    Child subOb = new Child(1, 2);
    subOb.show();
  }

}
