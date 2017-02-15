package com.oraclepressbooks.chapter08;

/**
 * @formatter:off
 * BoxWeight.java
 * 2017-02-14 10:41:23 
 * @author JiaMingsheng
 * p169
 * Here, Box is extended to include weight.
 * @formatter:on
 */
public class BoxWeight extends Box {
  double weight; // weight of box
  
  BoxWeight(double w, double h, double d, double m) {
    width = w;
    height = h;
    depth = d;
    weight = m;
  }

}
