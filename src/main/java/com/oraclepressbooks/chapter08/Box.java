package com.oraclepressbooks.chapter08;

/**
 * @formatter:off
 * Box.java
 * 2017-02-14 10:33:54 
 * @author JiaMingsheng
 * p168
 * @formatter:on
 */
public class Box {
  private double width;
  private double height;
  private double depth;
  
  Box(Box ob) {
    width = ob.width;
    height = ob.height;
    depth = ob.depth;
  }
  
  Box(double w, double h, double d) {
    width = w;
    height = h;
    depth = d;
  }
  
  Box() {
    width = -1;
    height = -1;
    depth = -1;
  }
  
  Box(double len) {
    width = height = depth = len;
  }
  
  double volume() {
    return width * height * depth;
  }
  
}
