package com.o2o.manager.mapper.sys.resource;

import com.o2o.manager.base.BaseMapper;
import com.o2o.manager.model.sys.resource.ResourceModel;
import com.o2o.manager.model.sys.role.RoleModel;

import java.util.List;
import java.util.Map;

/**
 * User: 重庆-石恒
 * qq:  374696376
 * Date: 2016/11/11
 * Time:17:01
 * Descrption:
 */
public interface ResourceMapper extends BaseMapper<ResourceModel> {

  Integer insert(ResourceModel resource);

  Integer deleteDatas();
}
