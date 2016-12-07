package com.o2o.iteam.common;

import java.util.List;

/**
 * User: 重庆-石恒
 * qq:  374696376
 * Date: 2016/11/22
 * Time:9:38
 * Descrption:
 */
public class BootPage<T> {
  protected Long total;

  protected List<T> rows;

  protected int limit=0;

  protected int offset = 0;

  protected int page = 1;

  protected String order ="asc" ;

  public Long getTotal() {
    return total;
  }

  public void setTotal(Long total) {
    this.total = total;
  }

  public List<T> getRows() {
    return rows;
  }

  public void setRows(List<T> rows) {
    this.rows = rows;
  }

  public int getLimit() {
    return limit;
  }

  public void setLimit(int limit) {
    this.limit = limit;
  }

  public int getOffset() {
    return offset;
  }

  public void setOffset(int offset) {
    this.offset = offset;
  }

  public String getOrder() {
    return order;
  }

  public void setOrder(String order) {
    this.order = order;
  }

  public int getPage() {
    return (int) Math.ceil(offset / limit)+1;
  }

  public void setPage(int page) {
    this.page = page;
  }
}
