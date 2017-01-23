package com.oraclepressbooks.chapter03;

/**
 * @formatter:off
 * TwoDAgain.java
 * 2017-01-23 12:43:12 
 * @author JiaMingsheng
 * p55
 * Manually allocate differing size second dimensions.
 * @formatter:on
 */
public class TwoDAgain {
  public static void main(String[] args) {
    int twoD[][] = new int[4][];
    twoD[0] = new int[1];
    twoD[1] = new int[2];
    twoD[2] = new int[3];
    twoD[3] = new int[4];

    int i, j, k = 0;

    for (i = 0; i < 4; i++)
      for (j = 0; j < i + 1; j++) {
        twoD[i][j] = k;
        k++;
      }

    for (i = 0; i < 4; i++) {
      for (j = 0; j < i + 1; j++)
        System.out.print(twoD[i][j] + " ");
      System.out.println();
    }
  }
}
