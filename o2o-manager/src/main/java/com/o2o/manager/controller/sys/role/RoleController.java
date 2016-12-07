package com.o2o.manager.controller.sys.role;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.o2o.iteam.annotation.Module;
import com.o2o.iteam.common.BootPage;
import com.o2o.iteam.common.PageHelper;
import com.o2o.manager.base.BaseController;
import com.o2o.manager.model.sys.role.RoleModel;
import com.o2o.manager.service.sys.role.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * User: 重庆-石恒
 * qq:  374696376
 * Date: 2016/11/11
 * Time:16:31
 * Descrption:系统管理-角色控制器
 */
@Controller("sys-role")
@RequestMapping("/sysRole")
@Module(code = "A03",title = "角色管理")
public class RoleController extends BaseController {

  @Autowired
  private RoleService roleService;

  @Override
  public String view() {
    return null;
  }

  @RequestMapping("/list")
  public ModelAndView list(){
    return new ModelAndView("/sys/role/role-list");
  }


  @RequestMapping("/data")
  @ResponseBody
  public JSONObject data(BootPage page){
    // 开始分页
    PageHelper.startPage(page.getPage(),page.getLimit());

    List<RoleModel> roles = roleService.listData();
    JSONArray jsonArray = new JSONArray();
    JSONObject jsonObject = null;
    for(RoleModel role:roles){
      jsonObject = new JSONObject();
      jsonObject.put("code", role.getCode());
      jsonObject.put("name", role.getName());
      jsonObject.put("seq", role.getSeq());
      jsonObject.put("description", role.getDescription());
      jsonObject.put("status", role.getStatus());
      jsonArray.add(jsonObject);
    }
    jsonObject = new JSONObject();
    jsonObject.put("total",roles.size());
    jsonObject.put("rows",jsonArray);
    return jsonObject;
  }

  @Override
  @RequestMapping("/listData")
  @ResponseBody
  public String listData() {
    return null;
  }



}
