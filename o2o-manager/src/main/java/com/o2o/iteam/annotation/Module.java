package com.o2o.iteam.annotation;

import java.lang.annotation.*;

/**
 * User: 重庆-石恒
 * qq:  374696376
 * Date: 2016/11/23
 * Time:9:20
 * Descrption:资源管理注解器
 */
@Documented
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Module {
  String code();

  String title();

  String description() default "";

  String url() default "";

  String icon() default "";

  boolean leaf() default false;

  String type() default "";

  boolean show() default true;

  boolean auth() default true;

  boolean login() default true;

  String parent() default "";

  int seq() default 0;
}
