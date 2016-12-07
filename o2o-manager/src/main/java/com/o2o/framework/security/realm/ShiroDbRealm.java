package com.o2o.framework.security.realm;

import com.google.common.collect.Sets;
import com.o2o.manager.model.sys.user.UserModel;
import com.o2o.manager.service.sys.role.RoleService;
import com.o2o.manager.service.sys.user.UserService;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * User: 重庆-石恒
 * qq:  374696376
 * Date: 2016/11/14
 * Time:17:07
 * Descrption:shiro权限认证
 */
public class ShiroDbRealm extends AuthorizingRealm {

  private static Logger LOGGER = Logger.getLogger(ShiroDbRealm.class);

  @Autowired
  private UserService userService;

  @Autowired
  private RoleService roleService;

  @Override
  protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authcToken) throws AuthenticationException {
    LOGGER.info("Shiro开始登录认证");
    UsernamePasswordToken token = (UsernamePasswordToken) authcToken;
    UserModel user = userService.findUserByLoginName(token.getUsername());
    // 账号不存在
    if (user == null) {
      return null;
    }
    // 账号未启用
    if (user.getStatus() == 1) {
      return null;
    }
    List<String> roleList = roleService.findRolesByUserCode(user.getAccount());
    ShiroUser shiroUser = new ShiroUser(user.getCode(), user.getAccount(), user.getName(), roleList);
    // 认证缓存信息
    return new SimpleAuthenticationInfo(shiroUser, user.getPwd().toCharArray(), getName());
  }

  @Override
  protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {

    ShiroUser shiroUser = (ShiroUser) principals.getPrimaryPrincipal();
    List<String> roleList = shiroUser.roleList;

    Set<String> urlSet = Sets.newHashSet();
    for (String code : roleList) {
      List<Map<String, String>> roleResourceList = roleService.findRoleResourcesByRoleCode(code);
      if (roleResourceList != null) {
        for (Map<String, String> map : roleResourceList) {
          if (StringUtils.isNoneBlank(map.get("url"))) {
            urlSet.add(map.get("url"));
          }
        }
      }
    }
    SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
    info.addStringPermissions(urlSet);
    return info;
  }

}
