package com.oraclepressbooks.chapter09.p1;

/**
 * @formatter:off
 * Derived.java
 * 2017-02-17 22:03:45 
 * @author JiaMingsheng
 * p198
 * @formatter:on
 */
class Derived extends Protection {
  Derived() {
    System.out.println("derived constructor");
    System.out.println("n = " + n);
    
    // class only
    // System.out.println("n_pri = " + n_pri);
    
    System.out.println("n_pri = " + n_pro);
    System.out.println("n_pub = " + n_pub);
  }
}
