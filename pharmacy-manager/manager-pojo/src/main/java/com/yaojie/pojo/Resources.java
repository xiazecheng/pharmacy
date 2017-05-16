package com.yaojie.pojo;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 * @author 
 */
@Table(name = "tb_resources")
public class Resources extends BasePojo implements Serializable {
    /**
     * 自增id
     */
    @Id
    private Integer id;

    /**
     * 请求相对路径
     */
    private String uri;

    /**
     * 请求方法 GET/POST
     */
    private String method;

    /**
     * uri详细描述
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