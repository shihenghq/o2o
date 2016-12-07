package com.o2o.manager.service.sys.resource;

import com.o2o.manager.base.BaseService;
import com.o2o.manager.model.sys.resource.ResourceModel;

import java.util.List;
import java.util.Map;

/**
 * User: 重庆-石恒
 * qq:  374696376
 * Date: 2016/11/11
 * Time:16:54
 * Descrption:系统管理-角色管理服务类
 */
public interface ResourceService extends BaseService<ResourceModel> {
  Integer insert(ResourceModel resource);
}
