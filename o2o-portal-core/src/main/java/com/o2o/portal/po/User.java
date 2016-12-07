package com.o2o.portal.po;

import java.io.Serializable;

/**
 * User: 重庆-石恒
 * qq:  374696376
 * Date: 2016/11/9
 * Time:15:09
 * Descrption:
 */
public class User implements Serializable {
  private String id;
  private String name;
  private String phone;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }
}
