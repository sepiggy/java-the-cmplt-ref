package com.oraclepressbooks.chapter06;

/**
 * @formatter:off
 * Stack.java
 * 2017-02-08 10:34:06 
 * @author JiaMingsheng
 * p129
 * This class defines an integer stack that can hold 10 values
 * 因为访问堆栈是通过push()和pop()方法进行的，所以堆栈由数组保存这个事实对于如何使用堆栈没有关系。
 * 因此，类实现了数据的封装。
 * @formatter:on
 */
public class Stack {
  int stck[] = new int[10];
  int tos;
  
  // Initialize top-of-stack
  Stack() {
    tos = -1;
  }
  
  // Push an item onto the stack
  void push(int item) {
    if(tos==9)
      System.out.println("Stack is full.");
    else
      stck[++tos] = item;
  }
  
  // Pop an item from the stack
  int pop() {
    if(tos < 0) {
      System.out.println("Stack underflow.");
      return 0;
    }
    else
      return stck[tos--];
  }
  
}
