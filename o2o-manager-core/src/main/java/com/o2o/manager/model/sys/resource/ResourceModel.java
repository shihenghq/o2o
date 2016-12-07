package com.o2o.manager.model.sys.resource;

import java.io.Serializable;

/**
 * User: 重庆-石恒
 * qq:  374696376
 * Date: 2016/11/24
 * Time:16:35
 * Descrption:
 */
public class ResourceModel implements Serializable {
  private String code;
  private String parent_code;
  private String icon;
  private String title;
  private String description;
  private String scope;
  private String level_code;
  private String level;
  private boolean leaf;
  private String url;
  private String type;
  private boolean enabled;
  private String create_time;
  private Integer seq;

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public String getParent_code() {
    return parent_code;
  }

  public void setParent_code(String parent_code) {
    this.parent_code = parent_code;
  }

  public String getIcon() {
    return icon;
  }

  public void setIcon(String icon) {
    this.icon = icon;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getScope() {
    return scope;
  }

  public void setScope(String scope) {
    this.scope = scope;
  }

  public String getLevel_code() {
    return level_code;
  }

  public void setLevel_code(String level_code) {
    this.level_code = level_code;
  }

  public String getLevel() {
    return level;
  }

  public void setLevel(String level) {
    this.level = level;
  }

  public boolean isLeaf() {
    return leaf;
  }

  public void setLeaf(boolean leaf) {
    this.leaf = leaf;
  }

  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public boolean isEnabled() {
    return enabled;
  }

  public void setEnabled(boolean enabled) {
    this.enabled = enabled;
  }

  public String getCreate_time() {
    return create_time;
  }

  public void setCreate_time(String create_time) {
    this.create_time = create_time;
  }

  public Integer getSeq() {
    return seq;
  }

  public void setSeq(Integer seq) {
    this.seq = seq;
  }
}
