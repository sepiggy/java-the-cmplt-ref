package com.oraclepressbooks.chapter07;

/**
 * @formatter:off
 * CommandLine.java
 * 2017-02-10 13:56:26 
 * @author JiaMingsheng
 * p157
 * Display all command-line arguments.
 * @formatter:on
 */
public class CommandLine {
  public static void main(String[] args) {
    for(int i=0; i<args.length; i++) {
      System.out.println("args[" + i + "]: " + args[i]);
    }
  }
}
