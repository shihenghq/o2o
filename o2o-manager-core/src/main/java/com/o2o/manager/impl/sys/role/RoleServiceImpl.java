package com.o2o.manager.impl.sys.role;

import com.o2o.manager.mapper.sys.role.RoleMapper;
import com.o2o.manager.mapper.sys.role.UserRoleMapper;
import com.o2o.manager.model.sys.role.RoleModel;
import com.o2o.manager.service.sys.role.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * User: 重庆-石恒
 * qq:  374696376
 * Date: 2016/11/11
 * Time:16:57
 * Descrption:
 */
@Service("sys-roleServiceImpl")
public class RoleServiceImpl implements RoleService {

  @Autowired
  private UserRoleMapper userRoleMapper;

  @Autowired
  private RoleMapper roleMapper;

  public List<RoleModel> listData() {
    return roleMapper.listData();
  }

  public long dataSize() {
    return userRoleMapper.dataSize();
  }

  public List<Map<String, String>> findRoleResourcesByRoleCode(String code) {
    return roleMapper.findRoleResourcesByRoleCode(code);
  }

  public List<String> findRolesByUserCode(String code) {
    return userRoleMapper.findRolesByUserCode(code);
  }
}
