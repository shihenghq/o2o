package com.o2o.manager.impl.sys;

import com.o2o.manager.mapper.sys.OrganizationMapper;
import com.o2o.manager.model.sys.OrganizationModel;
import com.o2o.manager.service.sys.OrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * User: 重庆-石恒
 * qq:  374696376
 * Date: 2016/11/10
 * Time:15:21
 * Descrption:
 */
@Service
public class OrganizationServiceImpl implements OrganizationService {

  @Autowired
  private OrganizationMapper organizationMapper;

  public List<OrganizationModel> findOrganizations() {
    return organizationMapper.findOrganizations();
  }
}
