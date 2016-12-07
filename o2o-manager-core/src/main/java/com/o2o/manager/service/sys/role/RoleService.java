package com.o2o.manager.service.sys.role;

import com.o2o.manager.base.BaseService;
import com.o2o.manager.model.sys.role.RoleModel;

import java.util.List;
import java.util.Map;

/**
 * User: 重庆-石恒
 * qq:  374696376
 * Date: 2016/11/11
 * Time:16:54
 * Descrption:系统管理-角色管理服务类
 */
public interface RoleService extends BaseService<RoleModel> {
  /**
   * 根据权限查询id查询资源路径集合
   *
   * @param code
   * @return
   */
  List<Map<String, String>> findRoleResourcesByRoleCode(String code);

  /**
   * 根据用户查询id查询权限集合
   *
   * @param code
   * @return
   */
  List<String> findRolesByUserCode(String code);
}
