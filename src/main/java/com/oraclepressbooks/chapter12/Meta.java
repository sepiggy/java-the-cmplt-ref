package com.oraclepressbooks.chapter12;

import java.lang.reflect.Method;

/**
 * @formatter:off
 * Meta.java
 * 2017-03-23 15:40:05 
 * @author JiaMingsheng
 * @formatter:on
 * p289
 */

public class Meta {

  // Annotate a method.
  @MyAnno(str = "Annotation Example", val = 100)
  public static void myMeth() {
    Meta ob = new Meta();

    // Obtain the annotation for this method and display the values of the members.
    try {
      Class<?> c = ob.getClass();

      Method m = c.getMethod("myMeth");

      MyAnno anno = m.getAnnotation(MyAnno.class);

      System.out.println(anno.str() + " " + anno.val());

    } catch (NoSuchMethodException exc) {
      exc.printStackTrace();
      System.out.println("Method not Found.");
    }
  }

  public static void main(String[] args) {
    myMeth();
  }
}
