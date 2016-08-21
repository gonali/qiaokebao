package com.gonali.qiaokebao.model;

import java.io.Serializable;

/**
 * Created by TianyuanPan on 8/15/16.
 */
public class CllgInfo implements Serializable{

    private long cllgId;
    private String userId;
    private String cllgName;
    private String clssName;
    private boolean delFlag;


    public long getCllgId() {
        return cllgId;
    }

    public void setCllgId(long cllgId) {
        this.cllgId = cllgId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getCllgName() {
        return cllgName;
    }

    public void setCllgName(String cllgName) {
        this.cllgName = cllgName;
    }

    public String getClssName() {
        return clssName;
    }

    public void setClssName(String clssName) {
        this.clssName = clssName;
    }

    public boolean isDelFlag() {
        return delFlag;
    }

    public void setDelFlag(boolean delFlag) {
        this.delFlag = delFlag;
    }
}
