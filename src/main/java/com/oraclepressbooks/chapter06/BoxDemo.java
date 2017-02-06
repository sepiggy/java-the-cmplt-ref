package com.oraclepressbooks.chapter06;

/**
 * @formatter:off
 * BoxDemo.java
 * 2017-02-06 16:36:35 
 * @author JiaMingsheng
 * p113
 * A program that uses the Box class.
 * Call this file BoxDemo.java
 * @formatter:on
 */
class Box {
  double width;
  double height;
  double depth;
}

// This class declares an object of type Box.
class BoxDemo {
  public static void main(String args[]) {
    Box myBox = new Box();
    double vol;
    
    // assign values to mybox's instance variables
    myBox.width = 10;
    myBox.height = 20;
    myBox.depth = 15;
    
    // compute volume of box
    vol = myBox.width * myBox.height * myBox.depth;
    
    System.out.println("Volume is " + vol);
  }
}
