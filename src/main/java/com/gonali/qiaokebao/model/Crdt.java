package com.gonali.qiaokebao.model;

import java.io.Serializable;

/**
 * Created by TianyuanPan on 8/16/16.
 */
public class Crdt  implements Serializable{

    private long crdtId;
    private String userId;
    private int credit;
    private int frozen;
    private int useable;
    private String describe;


    public long getCrdtId() {
        return crdtId;
    }

    public void setCrdtId(long crdtId) {
        this.crdtId = crdtId;
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

    public int getFrozen() {
        return frozen;
    }

    public void setFrozen(int frozen) {
        this.frozen = frozen;
    }

    public int getUseable() {
        return useable;
    }

    public void setUseable(int useable) {
        this.useable = useable;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }
}
