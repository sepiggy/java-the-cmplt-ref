package com.oraclepressbooks.chapter09;

/**
 * @formatter:off
 * A.java
 * 2017-03-08 09:27:40 
 * @author JiaMingsheng
 * @formatter:on
 * p206
 * A nested interface example.
 */

// This class contains a member interface.
class A {
  // this is a nested interface.
  public interface NestedIF {
    boolean isNotNegative(int x);
  }
}