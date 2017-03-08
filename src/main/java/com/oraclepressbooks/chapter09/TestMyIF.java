package com.oraclepressbooks.chapter09;

public class TestMyIF implements MyIF {
  
  public int getNumber() {
    return 1024;
  }
  
  public static void main(String[] args) {
    TestMyIF obj = new TestMyIF();
    System.out.println(obj.getNumber());
    System.out.println(obj.getString());
    System.out.println(MyIF.getDefaultNumber());
  }
}
