package com.oraclepressbooks.chapter08;

/**
 * @formatter:off
 * RefDemo.java
 * 2017-02-14 10:45:44 
 * @author JiaMingsheng
 * p170
 * @formatter:on
 */
public class RefDemo {
  public static void main(String[] args) {
    BoxWeight weightbox = new BoxWeight(3, 5, 7, 8.37);
    Box plainbox = new Box();
    double vol;
    
    vol = weightbox.volume();
    System.out.println("Volume of weightbox is " + vol);
    System.out.println("Weight of weightbox is " + weightbox.weight);
    System.out.println();
    
    // assign BoxWeight reference to Box reference
    plainbox = weightbox;
    
    vol = plainbox.volume();
    System.out.println("Volume of plainbox is " + vol);
    
    // error!
    // System.out.println("Weight of plainbox is " + plainbox.weight);
  }

}
