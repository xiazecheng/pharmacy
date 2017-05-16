package com.yaojie.mapper;

import com.yaojie.pojo.UserRoles;
import com.yaojie.pojo.UserRoleswn;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * Created by madao on 2017/5/14.
 */
public interface UserRolesMapper extends Mapper<UserRoles>{

    @Select("select " +
            "u.id as id," +
            "u.role_id as roleId," +
            "u.create_time as createTime," +
            "u.update_time as updateTime" +
            "u.is_deleted as isDeleted"+
            ",r.name as roleName " +
            "from tb_user_roles u inner join tb_roles r on u.user_id = r.user_id " +
            "where u.user_id = #{userId}")
    List<UserRoleswn> getRoleByUserId(int userId);
}
