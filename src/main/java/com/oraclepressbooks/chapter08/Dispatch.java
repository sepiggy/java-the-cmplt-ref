package com.oraclepressbooks.chapter08;

/**
 * @formatter:off
 * Dispatch.java
 * 2017-02-16 15:06:52 
 * @author JiaMingsheng
 * p183
 * Dynamic Method Dispatch
 * @formatter:on
 */
class A2 {
  void callme() {
    System.out.println("Inside A's callme method");
  }
}

class B2 extends A2 {
  // override callme()
  void callme() {
    System.out.println("Inside B's callme method");
  }
}

class C2 extends A2 {
  // override callme()
  void callme() {
    System.out.println("Inside C's callme method");
  }
}

public class Dispatch {
  public static void main(String args[]) {
    A2 a = new A2(); // object of type A2
    B2 b = new B2(); 
    C2 c = new C2();
    
    A2 r; // obtain a reference of type A2
    
    r = a; 
    r.callme();
    
    r = b;
    r.callme();
    
    r = c;
    r.callme();
  }
}
