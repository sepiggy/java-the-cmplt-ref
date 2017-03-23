package com.oraclepressbooks.chapter12;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * @formatter:off
 * MyAnno.java
 * 2017-03-23 16:14:09 
 * @author JiaMingsheng
 * @formatter:on
 * p287
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnno {
  String str();

  int val();
}
