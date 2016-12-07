package com.o2o.manager.model.sys.role;

import java.io.Serializable;

/**
 * User: 重庆-石恒
 * qq:  374696376
 * Date: 2016/11/11
 * Time:16:57
 * Descrption:
 */
public class RoleModel implements Serializable {
  private String code;
  private String name;//名称
  private String seq;//排序
  private String description;//描述
  private String status;//状态

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getSeq() {
    return seq;
  }

  public void setSeq(String seq) {
    this.seq = seq;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }
}
