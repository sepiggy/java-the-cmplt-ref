package com.oraclepressbooks.chapter11;

/**
 * @formatter:off
 * DemoJoin.java
 * 2017-03-10 13:22:10 
 * @author JiaMingsheng
 * @formatter:on
 * p250
 */
class NewThread4 implements Runnable {
  String name;
  Thread t;
  
  public NewThread4(String threadname) {
    name = threadname;
    t = new Thread(this, name);
    System.out.println("New thread: " + t);
    t.start();
  }
  
  public void run() {
    try {
      for (int i=5; i>0; i--) {
        System.out.println(name + ": " + i);
        Thread.sleep(1000);
      }
    } catch (InterruptedException e) {
      System.out.println(name + " interrupted.");
    }
    System.out.println(name + " exiting.");
  }
}

public class DemoJoin {
  public static void main(String[] args) {
    NewThread4 ob1 = new NewThread4("One");
    NewThread4 ob2 = new NewThread4("Two");
    NewThread4 ob3 = new NewThread4("Three");
    
    System.out.println("Thread One is alive: " + ob1.t.isAlive());
    System.out.println("Thread Two is alive: " + ob2.t.isAlive());
    System.out.println("Thread Three is alive: " + ob3.t.isAlive());
    
    System.out.println("Main thread exiting.");
  }
}
