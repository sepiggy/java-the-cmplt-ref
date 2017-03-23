package com.oraclepressbooks.chapter12;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

/**
 * @formatter:off
 * Meta2.java
 * 2017-03-23 16:17:15 
 * @author JiaMingsheng
 * @formatter:on
 * p291
 */
@What(description = "An annotation test class")
@MyAnno(str = "Meta2", val = 99)
public class Meta2 {

  @What(description = "An annotation test method")
  @MyAnno(str = "Testing", val = 100)
  public static void myMeth() {
    Meta2 ob = new Meta2();

    try {
      Annotation[] annos = ob.getClass().getAnnotations();

      // Display all annotations for Meta2.
      System.out.println("All annotations for Meta2:");
      for (Annotation a : annos)
        System.out.println(a);

      System.out.println();

      // Dispaly all annotations for myMeth.
      Method m = ob.getClass().getMethod("myMeth");
      annos = m.getAnnotations();

      System.out.println("All annotations for myMeth:");
      for (Annotation a : annos)
        System.out.println(a);
    } catch (NoSuchMethodException e) {
      e.printStackTrace();
      System.out.println("Method Not Found.");
    }
  }

  public static void main(String[] args) {
    myMeth();
  }

}
