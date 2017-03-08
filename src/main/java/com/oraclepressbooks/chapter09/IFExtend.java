package com.oraclepressbooks.chapter09;

/**
 * @formatter:off
 * IFExtend.java
 * 2017-03-08 13:54:06 
 * @author JiaMingsheng
 * @formatter:on
 * p212
 */

interface Parent{
  void meth1();
  void meth2();
}

interface Child extends Parent {
  void meth3();
}

// This class must implement all of A and B
class MyClass implements Child {
  public void meth1() {
    System.out.println("1");
  }
  
  public void meth2() {
    System.out.println("2");
  }
  
  public void meth3() {
    System.out.println("3");
  }
}

public class IFExtend {
  public static void main(String[] args) {
    MyClass mc = new MyClass();
    
    mc.meth1();
    mc.meth2();
    mc.meth3();
  }
}
