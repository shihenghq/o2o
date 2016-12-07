package com.o2o.manager.mapper.sys;

import com.o2o.manager.model.sys.OrganizationModel;

import java.util.List;

/**
 * User: 重庆-石恒
 * qq:  374696376
 * Date: 2016/11/10
 * Time:15:21
 * Descrption:
 */
public interface OrganizationMapper {
  /**
   * 获取组织列表
   * @return
   */
  List<OrganizationModel> findOrganizations();
}
