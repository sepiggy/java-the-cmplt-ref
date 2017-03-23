package com.oraclepressbooks.chapter12;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * @formatter:off
 * What.java
 * 2017-03-23 16:13:58 
 * @author JiaMingsheng
 * @formatter:on
 * p291
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface What {
  String description();
}
