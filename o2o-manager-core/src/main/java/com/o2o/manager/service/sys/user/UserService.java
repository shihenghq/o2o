package com.o2o.manager.service.sys.user;

import com.o2o.manager.base.BaseService;
import com.o2o.manager.model.sys.user.UserModel;

/**
 * User: 重庆-石恒
 * qq:  374696376
 * Date: 2016/11/14
 * Time:10:25
 * Descrption:
 */
public interface UserService extends BaseService<UserModel> {

  /**
   * 根据用户名查询用户
   *
   * @param username
   * @return
   */
  UserModel findUserByLoginName(String username);

}
