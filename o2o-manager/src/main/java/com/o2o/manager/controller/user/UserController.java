package com.o2o.manager.controller.user;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.o2o.iteam.annotation.Module;
import com.o2o.iteam.annotation.Operation;
import com.o2o.iteam.common.BootPage;
import com.o2o.iteam.common.PageHelper;
import com.o2o.manager.base.BaseController;
import com.o2o.manager.model.sys.user.UserModel;
import com.o2o.manager.service.sys.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * User: 重庆-石恒
 * qq:  374696376
 * Date: 2016/11/14
 * Time:10:22
 * Descrption:系统用户控制器
 */
@Controller("sys-user")
@RequestMapping("sysUser")
@Module(code = "A01",title = "用户管理")
public class UserController extends BaseController {

  @Autowired
  private UserService userService;

  @Operation(code = "A0101",name = "用户列表")
  @RequestMapping("/list")
  public ModelAndView list(ModelMap map){
    return new ModelAndView("/sys/user/user-list");
  }

  @RequestMapping("/data")
  @ResponseBody
  public JSONObject  data(BootPage page){
    // 开始分页
    PageHelper.startPage(page.getPage(),page.getLimit());

    List<UserModel> users = userService.listData();
    JSONArray jsonArray = new JSONArray();
    JSONObject jsonObject = null;
    for(UserModel user:users){
      jsonObject = new JSONObject();
      jsonObject.put("account", user.getAccount());
      jsonObject.put("name", user.getName());
      jsonObject.put("phone", user.getPhone());
      jsonObject.put("code", user.getCode());
      jsonObject.put("sex", user.getSex());
      jsonObject.put("email", user.getEmail());
      jsonObject.put("status", user.getStatus());
      jsonObject.put("birthday", user.getBirthday());
      jsonArray.add(jsonObject);
    }
    jsonObject = new JSONObject();
    jsonObject.put("total",userService.dataSize());
    jsonObject.put("rows",jsonArray);
    return jsonObject;
  }
}
