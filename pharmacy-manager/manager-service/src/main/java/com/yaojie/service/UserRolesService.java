package com.yaojie.service;

import com.yaojie.mapper.UserRolesMapper;
import com.yaojie.pojo.UserRoles;
import com.yaojie.pojo.UserRoleswn;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by madao on 2017/5/15.
 */
@Service
public class UserRolesService extends BaseService<UserRoles>{

    @Autowired
    private UserRolesMapper userRolesMapper;

    public List<UserRoleswn> getRoleByUserId(int userId){
        return userRolesMapper.getRoleByUserId(userId);
    }
}
