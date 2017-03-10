package com.oraclepressbooks.chapter11;

/**
 * @formatter:off
 * ExtendThread.java
 * 2017-03-10 09:44:53 
 * @author JiaMingsheng
 * @formatter:on
 * p247
 */
// Create a second thread by extending Thread
class NewThread2 extends Thread {
  
  NewThread2() {
    // Create a new, second thread
    super("Demo Thread");
    System.out.println("Child thread: " + this);
    start(); // Start the thread
  }
  
  // This is the entry point for the second thread.
  public void run() {
    try {
      for(int i=5; i>0; i--) {
        System.out.println("Child Thread: " + i);
        Thread.sleep(500);
      }
    } catch (InterruptedException e) {
      System.out.println("Child interrupted.");
    }
    System.out.println("Exiting child thread.");
  }
}

public class ExtendThread {
  
  public static void main(String[] args) {
    new NewThread2(); // crate a new thread
    
    try {
      for(int i=5; i>0; i--) {
        System.out.println("Main Thread: " + i);
        Thread.sleep(1000);
      }
    } catch (InterruptedException e) {
      System.out.println("Main thread interrupted.");
    }
    System.out.println("Main thread exiting");
  }
}
