package com.oraclepressbooks.chapter12;

/**
 * @formatter:off
 * EnumDemo.java
 * 2017-03-22 16:30:11 
 * @author JiaMingsheng
 * @formatter:on
 * p271
 * An enumeration of apple varieties.
 */

enum Apple {
  Jonathan, GoldenDel, RedDel, Winesap, Cortland
}

public class EnumDemo {
  public static void main(String[] args) {
    Apple ap;

    ap = Apple.RedDel;

    // Output an enum value.
    System.out.println("Value of ap: " + ap);
    System.out.println();

    ap = Apple.GoldenDel;

    // Compare two enum values.
    if (ap == Apple.GoldenDel) System.out.println("ap contains GoldenDel.\n");

    // Use an enum to control a switch statement.
    switch (ap) {
      case Jonathan:
        System.out.println("Jonathan is red.");
        break;
      case GoldenDel:
        System.out.println("Golden Delicious is yellow.");
        break;
      case RedDel:
        System.out.println("Red Delicious is red.");
        break;
      case Winesap:
        System.out.println("Winesap is red.");
        break;
      case Cortland:
        System.out.println("Cortland is red.");
        break;
    }
  }
}
