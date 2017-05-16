package com.yaojie.pojo;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 * @author
 */
public class RoleResourceswr implements Serializable {

    private static final long serialVersionUID = 1L;
    /**
     * 自增id
     */
    private Integer id;

    /**
     * 请求相对路径id
     */
    private Integer resourceId;

    /**
     * 角色id
     */
    private Integer roleId;

    /**
     * 删除标识,0.可用，1.已删除不可用
     */
    private Byte isDeleted;

    private Date created;

    private Date updated;

    /**
     * 请求相对路径
     */
    private String uri;

    /**
     * 请求方法 GET/POST
     */
    private String method;

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public Date getCreated() { return created; }

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

    public Integer getResourceId() {
        return resourceId;
    }

    public void setResourceId(Integer resourceId) {
        this.resourceId = resourceId;
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