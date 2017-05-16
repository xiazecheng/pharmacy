package com.yaojie.pojo;

import java.util.Date;

/**
 * Created by madao on 2017/5/12.
 */
public abstract class BasePojo {

    private Date created;
    private Date updated;
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
}
