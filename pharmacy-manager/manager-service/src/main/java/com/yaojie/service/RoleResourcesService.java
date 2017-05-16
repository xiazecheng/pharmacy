package com.yaojie.service;

import com.yaojie.mapper.RoleResourceMapper;
import com.yaojie.pojo.RoleResources;
import com.yaojie.pojo.RoleResourceswr;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by madao on 2017/5/15.
 */
@Service
public class RoleResourcesService extends BaseService<RoleResources> {

    @Autowired
    private RoleResourceMapper roleResourceMapper;

    public List<RoleResourceswr> getResourcesByRole(int roleId){
        return roleResourceMapper.getResourcesByRole(roleId);
    }
}
