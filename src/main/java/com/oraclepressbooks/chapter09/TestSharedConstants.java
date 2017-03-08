package com.oraclepressbooks.chapter09;

public class TestSharedConstants implements SharedConstants {
  public static void main(String[] args) {
    System.out.println(NO);
    System.out.println(YES);
    System.out.println(MAYBE);
    // NO = 1234; error!
  }
}
