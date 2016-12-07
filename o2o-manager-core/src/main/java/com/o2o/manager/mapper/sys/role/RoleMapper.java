package com.o2o.manager.mapper.sys.role;

import com.o2o.manager.base.BaseMapper;
import com.o2o.manager.model.sys.role.RoleModel;

import java.util.List;
import java.util.Map;

/**
 * User: 重庆-石恒
 * qq:  374696376
 * Date: 2016/11/11
 * Time:17:01
 * Descrption:
 */
public interface RoleMapper extends BaseMapper<RoleModel> {
  /**
   * 根据权限查询id查询资源路径集合
   *
   * @param code
   * @return
   */
  List<Map<String, String>> findRoleResourcesByRoleCode(String code);
}
