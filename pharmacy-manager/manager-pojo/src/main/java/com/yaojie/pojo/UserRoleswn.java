package com.yaojie.pojo;

import javax.persistence.Column;
import javax.persistence.Id;
import java.util.Date;

/**
 * Created by madao on 2017/5/15.
 */
public class UserRoleswn {
    /*
     * 自增id
     */
    private Integer id;

    /**
     * 用户uid, 对应表users(u_id)
     */
    @Column(name = "user_id")
    private Integer userId;

    /**
     * 角色id, 对应表roles(ro_id)
     */
    @Column(name = "role_id")
    private Integer roleId;


    /**
     * 删除标识,0.可用，1.已删除不可用
     */

    @Column(name = "is_deleted")
    private Byte isDeleted;

    private String roleName;

    private Date created;

    private Date updated;

    private static final long serialVersionUID = 1L;

    public Date getCreated() {
        return created;
    }
    public void setCreated(Date created) {
        this.created = created;
    }
    public Date getUpdated() {
        return updated;
    }
    public void setUpdated(Date updated) {
        this.updated = updated;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public Byte getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Byte isDeleted) {
        this.isDeleted = isDeleted;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

}
