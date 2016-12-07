package com.o2o.manager.mapper.sys.user;

import com.o2o.manager.base.BaseMapper;
import com.o2o.manager.model.sys.user.UserModel;
import org.apache.ibatis.annotations.Param;

/**
 * User: 重庆-石恒
 * qq:  374696376
 * Date: 2016/11/14
 * Time:10:26
 * Descrption:
 */
public interface UserMapper extends BaseMapper<UserModel> {
  /**
   * 根据用户名查询用户
   *
   * @param username
   * @return
   */
  UserModel findUserByLoginName(@Param("username") String username);
}
