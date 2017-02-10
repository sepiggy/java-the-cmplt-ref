package com.oraclepressbooks.chapter07;

/**
 * @formatter:off
 * Length.java
 * 2017-02-09 13:26:15 
 * @author JiaMingsheng
 * p150
 * This program demonstrates the length array member.
 * @formatter:on
 */
public class Length{
  public static void main(String args[]) {
    int a1[] = new int[10];
    int a2[] = { 3, 5, 7, 1, 8, 99, 44, -10 };
    int a3[] = { 4, 3, 2, 1 };
    int a4[] = new int[1234];

    System.out.println("length of a1 is " + a1.length);
    System.out.println("length of a2 is " + a2.length);
    System.out.println("length of a3 is " + a3.length);
    System.out.println("length of a4 is " + a4.length);
    
    for(int i=0; i<a4.length; i++) {
      System.out.print(a4[i] + " ");
    }
  }

}
