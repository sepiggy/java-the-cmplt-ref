package com.oraclepressbooks.chapter11;

/**
 * @formatter:off
 * CurrentThreadDemo.java
 * 2017-03-09 22:16:57 
 * @author JiaMingsheng
 * @formatter:on
 * p243
 * Controllong the main Thread.
 */
public class CurrentThreadDemo {
  public static void main(String[] args) {
    Thread t = Thread.currentThread();
    
    System.out.println("Current thread: " + t);
    
    // change the name of the thread
    t.setName("My Thread");
    System.out.println("After name change: " + t);
    System.out.println(t.getName());
  
    try {
      for(int n=5; n>0; n--) {
        System.out.println(n);
        Thread.sleep(1000);
      }
    } catch (InterruptedException e) {
      System.out.println("Main thread interrupted");
    }
  }
}
