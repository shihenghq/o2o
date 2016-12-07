package com.o2o.manager.base;

import java.util.List;

/**
 * User: 重庆-石恒
 * qq:  374696376
 * Date: 2016/11/11
 * Time:17:02
 * Descrption:
 */
public interface BaseMapper<T> {

  List<T> listData();

  long dataSize();

}
