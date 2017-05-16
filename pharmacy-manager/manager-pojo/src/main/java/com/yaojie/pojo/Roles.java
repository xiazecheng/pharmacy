package com.yaojie.pojo;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 * @author 
 */
@Table(name = "tb_roles")
public class Roles extends BasePojo implements Serializable {
    /**
     * 角色id
     */
    @Id
    private Integer id;

    /**
     * 角色名称
     */
    private String name;

    /**
     * 角色附加描述
     */
    private String detail;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public Byte getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Byte isDeleted) {
        this.isDeleted = isDeleted;
    }
}