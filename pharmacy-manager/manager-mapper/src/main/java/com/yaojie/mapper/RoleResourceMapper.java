package com.yaojie.mapper;

import com.yaojie.pojo.RoleResources;
import com.yaojie.pojo.RoleResourceswr;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * Created by madao on 2017/5/15.
 */
public interface RoleResourceMapper extends Mapper<RoleResources>{

    @Select("select " +
            "rr.id as id," +
            "rr.resource_id as resourceId," +
            "rr.role_id as roleId," +
            "rr.is_deleted as isDeleted," +
            "r.uri as uri," +
            "r.method as method " +
            "from tb_role_resources rr inner join tb_resources r on rr.resource_id = r.id " +
            "where rr.role_id = #{roleId}")
    List<RoleResourceswr> getResourcesByRole(int roleId);

}
