package com.o2o.manager.model.sys;

import java.io.Serializable;

/**
 * User: 重庆-石恒
 * qq:  374696376
 * Date: 2016/11/10
 * Time:15:14
 * Descrption:
 */
public class OrganizationModel implements Serializable {
  private String id;
  private String name;
  private String description;
  private String code;
  private String icon;
  private String pid;
  private String seq;
  private String create_time;

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

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public String getIcon() {
    return icon;
  }

  public void setIcon(String icon) {
    this.icon = icon;
  }

  public String getPid() {
    return pid;
  }

  public void setPid(String pid) {
    this.pid = pid;
  }

  public String getSeq() {
    return seq;
  }

  public void setSeq(String seq) {
    this.seq = seq;
  }

  public String getCreate_time() {
    return create_time;
  }

  public void setCreate_time(String create_time) {
    this.create_time = create_time;
  }
}
