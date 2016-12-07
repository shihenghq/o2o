package com.o2o.manager.impl.sys.resource;

import com.o2o.manager.mapper.sys.resource.ResourceMapper;
import com.o2o.manager.model.sys.resource.ResourceModel;
import com.o2o.manager.service.sys.resource.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * User: 重庆-石恒
 * qq:  374696376
 * Date: 2016/11/11
 * Time:16:57
 * Descrption:
 */
@Service("sys-resourceServiceImpl")
public class ResourceServiceImpl implements ResourceService {

  @Autowired
  private ResourceMapper resourceMapper;

  public Integer insert(ResourceModel resource) {
    return resourceMapper.insert(resource);
  }

  public List<ResourceModel> listData() {
    return resourceMapper.listData();
  }

  public long dataSize() {
    return resourceMapper.dataSize();
  }
}
