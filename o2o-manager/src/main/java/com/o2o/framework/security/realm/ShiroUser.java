/**
 *
 */
package com.o2o.framework.security.realm;

import java.io.Serializable;
import java.util.List;

/**
 * @description：自定义Authentication对象，使得Subject除了携带用户的登录名外还可以携带更多信息
 * @author：zhixuan.wang
 * @date：2015/10/1 14:51
 */
public class ShiroUser implements Serializable {

    private static final long serialVersionUID = -1373760761780840081L;
    public String code;
    public String account;
    public String name;
    public List<String> roleList;

  public ShiroUser(String code, String account, String name, List<String> roleList) {
    this.code = code;
    this.account = account;
    this.name = name;
    this.roleList = roleList;
  }

  public String getName() {
        return name;
    }

    /**
     * 本函数输出将作为默认的<shiro:principal/>输出.
     */
    @Override
    public String toString() {
        return account;
    }
}
