package com.o2o.manager.controller.sys;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.o2o.iteam.annotation.Module;
import com.o2o.iteam.annotation.Operation;
import com.o2o.iteam.code.Result;
import com.o2o.manager.model.sys.OrganizationModel;
import com.o2o.manager.model.sys.resource.ResourceModel;
import com.o2o.manager.model.sys.role.RoleModel;
import com.o2o.manager.service.sys.OrganizationService;
import com.o2o.manager.service.sys.resource.ResourceService;
import com.o2o.manager.service.sys.role.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * User: 重庆-石恒
 * qq:  374696376
 * Date: 2016/11/10
 * Time:15:11
 * Descrption:
 */
@Controller("sys-resource")
@RequestMapping("/resource")
@Module(code = "A02",title = "资源管理",url = "www.baidu.com")
public class ResourceController {

  @Autowired
  private OrganizationService organizationService;

  @Autowired
  private RoleService roleService;

  @Autowired
  private ResourceService resourceService;

  @Operation(code = "A0201",name = "资源列表")
  @RequestMapping("/list")
  public ModelAndView list(){
    return new ModelAndView("/sys/resource/resource-list");
  }

  @RequestMapping("/data")
  @ResponseBody
  public JSONArray data(){

    JSONObject jsonObject;
    JSONArray jsonArray = new JSONArray();
    jsonObject = new JSONObject();
    jsonObject.put("name","荭琪枫商城");
    jsonObject.put("id","0");
    jsonObject.put("open",true);
    jsonArray.add(jsonObject);

   // List<RoleModel> roles = roleService.listData();
   // for(RoleModel role:roles){
    //  System.out.println(role.getName()+"----------"+role.getCode());
   // }

    List<OrganizationModel> organizations = organizationService.findOrganizations();

    List<ResourceModel> resources = resourceService.listData();
    for(ResourceModel resource:resources){
      jsonObject = new JSONObject();
      jsonObject.put("id", resource.getCode());
      jsonObject.put("name", resource.getTitle());
      jsonObject.put("icon", resource.getIcon());
      jsonObject.put("pId", resource.getParent_code());
      jsonObject.put("open",true);
      jsonArray.add(jsonObject);
    }


    for(OrganizationModel og:organizations){
      jsonObject = new JSONObject();
      jsonObject.put("id", og.getId());
      jsonObject.put("name", og.getName());
      jsonObject.put("icon", og.getIcon());
      jsonObject.put("pId", og.getPid());
      jsonObject.put("open",true);
      jsonArray.add(jsonObject);
    }
    return jsonArray;
  }

  @RequestMapping(value = "/putData", method = {RequestMethod.POST })
  @ResponseBody
  public Result putData(@RequestBody List<ResourceModel> resourceModel){
    Result result = new Result();
    result.setMsg("保存成功了唷");
    result.setSuccess(true);
    return result;
  }

}
