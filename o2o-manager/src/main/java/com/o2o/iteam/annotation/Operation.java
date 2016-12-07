package com.o2o.iteam.annotation;

import java.lang.annotation.*;

/**
 * User: 重庆-石恒
 * qq:  374696376
 * Date: 2016/11/23
 * Time:9:20
 * Descrption:资源管理方法注解器
 */
@Documented
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Operation {
  String code();

  String name();

  String url() default "";

  String type() default "";

  boolean show() default true;

  boolean auth() default true;

  boolean login() default true;

  boolean json() default false;

  int seq() default 0;
}
