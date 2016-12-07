package com.o2o.manager.impl.sys.user;

import com.o2o.manager.mapper.sys.user.UserMapper;
import com.o2o.manager.model.sys.user.UserModel;
import com.o2o.manager.service.sys.user.UserService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * User: 重庆-石恒
 * qq:  374696376
 * Date: 2016/11/14
 * Time:10:26
 * Descrption:
 */
@Service("sys-userService")
public class UserServiceImpl implements UserService {

  @Autowired
  private UserMapper userMapper;

  public List<UserModel> listData() {
    return userMapper.listData();
  }

  public long dataSize() {
    return userMapper.dataSize();
  }

  public UserModel findUserByLoginName(@Param("username") String username) {
    return userMapper.findUserByLoginName(username);
  }
}
