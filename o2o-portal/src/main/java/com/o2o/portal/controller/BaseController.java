package com.o2o.portal.controller;

import com.o2o.portal.mapper.UserMapper;
import com.o2o.portal.po.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * User: 重庆-石恒
 * qq:  374696376
 * Date: 2016/11/9
 * Time:11:10
 * Descrption:
 */
@Controller
@RequestMapping("/base")
public class BaseController {

  @Autowired
  private UserMapper userMapper;

  @RequestMapping("/index")
  public ModelAndView index(){
    List<User> users = userMapper.findUser();
    for (User user:users) {
      System.out.println(user.getName()+"===="+user.getPhone()+"====="+user.getId());
    }
    return new ModelAndView("index");
  }
}
