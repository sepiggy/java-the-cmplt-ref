package com.oraclepressbooks.chapter09;

/**
 * @formatter:off
 * B.java
 * 2017-03-08 10:39:57 
 * @author JiaMingsheng
 * @formatter:on
 * B implements the nested interface.
 * p206
 */
class B implements A.NestedIF {
  public boolean isNotNegative(int x) {
    return x < 0 ? false : true;
  }
}