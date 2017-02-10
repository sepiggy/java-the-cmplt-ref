package com.oraclepressbooks.chapter07;

/**
 * @formatter:off
 * TestStack2.java
 * 2017-02-09 17:37:30 
 * @author JiaMingsheng
 * p150
 * Improved Stack class that uses the length array member.
 * @formatter:on
 */
class Stack {
  private int[] stck;
  private int tos; // 栈顶指针，标识数组实际存储整数的多少
  
  public Stack(int size) {
    stck = new int[size];
    tos = -1;
  }
  
  public void push(int num) {
    if (tos == stck.length - 1) {
      System.out.println("栈中数据已满");
    } else {
      stck[++tos] = num;
    }
  }
  
  public int pop() {
    if (tos < 0) {
      System.out.println("已到达栈底");
      return 0;
    } else {
      return stck[tos--];
    }
  }
}
public class TestStack2 {
  public static void main(String[] args) {
    Stack mystack1 = new Stack(5);
    Stack mystack2 = new Stack(8);
    
    for(int i=0; i<5; i++) mystack1.push(i);
    for(int i=0; i<8; i++) mystack2.push(i);
    
    System.out.println("Stack in mystack1:");
    for(int i=0; i<5; i++)
      System.out.println(mystack1.pop());
    
    System.out.println("Stack in mystack2:");
    for(int i=0; i<8; i++)
      System.out.println(mystack2.pop());
  }

}
