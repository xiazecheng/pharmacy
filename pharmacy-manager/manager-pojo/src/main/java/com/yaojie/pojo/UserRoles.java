package com.yaojie.pojo;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 * @author 
 */
@Table(name = "tb_user_roles")
public class UserRoles extends BasePojo implements Serializable {
    /**
     * 自增id
     */
    @Id
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

    private static final long serialVersionUID = 1L;

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
}