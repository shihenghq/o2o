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
public interface UserRoleMapper extends BaseMapper<RoleModel> {
  /**
   * 根据用户查询id查询权限集合
   *
   * @param code
   * @return
   */
  List<String> findRolesByUserCode(String code);
}
