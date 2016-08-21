package com.gonali.qiaokebao.model;

import java.io.Serializable;

/**
 * Created by TianyuanPan on 8/16/16.
 */
public class CrdtLog implements Serializable {

    private long logId;
    private String userId;
    private int credit;
    private String direction;
    private String describe;

    public long getLogId() {
        return logId;
    }

    public void setLogId(long logId) {
        this.logId = logId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public int getCredit() {
        return credit;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }
}
