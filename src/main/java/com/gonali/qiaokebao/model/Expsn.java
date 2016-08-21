package com.gonali.qiaokebao.model;

import java.io.Serializable;
import java.sql.Date;

/**
 * Created by TianyuanPan on 8/16/16.
 */
public class Expsn implements Serializable {

    private long expnsId;
    private String userId;
    private long msgId;
    private Date time;
    private String status;


    public long getExpnsId() {
        return expnsId;
    }

    public void setExpnsId(long expnsId) {
        this.expnsId = expnsId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public long getMsgId() {
        return msgId;
    }

    public void setMsgId(long msgId) {
        this.msgId = msgId;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
