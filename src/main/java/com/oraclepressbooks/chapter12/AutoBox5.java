package com.oraclepressbooks.chapter12;

/**
 * @formatter:off
 * AutoBox5.java
 * 2017-03-23 15:12:12 
 * @author JiaMingsheng
 * @formatter:on
 * p284
 * Autoboxing/unboxing a Boolean and Character.
 */
public class AutoBox5 {
  public static void main(String[] args) {
    
    // Autobox/unbox a boolean.
    Boolean b = true;
    
    // auto-unboxed
    if (b)
      System.out.println("b is true");
    
    // Autobox/unbox a char.
    Character ch = 'x'; // box a char
    char ch2 = ch; // unbox a char
    
    System.out.println("ch2 is " + ch2);
  }
}
