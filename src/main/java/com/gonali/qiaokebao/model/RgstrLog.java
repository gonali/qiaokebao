package com.gonali.qiaokebao.model;

import java.io.Serializable;
import java.sql.Date;

/**
 * Created by Administrator on 2016/8/27.
 */
public class RgstrLog implements Serializable {

    private long rgstrId;
    private String phone;
    private String authCode;
    private Date datetime;
    private String status;
    private boolean isValid;

    public long getRgstrId() {
        return rgstrId;
    }

    public void setRgstrId(long rgstrId) {
        this.rgstrId = rgstrId;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAuthCode() {
        return authCode;
    }

    public void setAuthCode(String authCode) {
        this.authCode = authCode;
    }

    public Date getDatetime() {
        return datetime;
    }

    public void setDatetime(Date datetime) {
        this.datetime = datetime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public boolean isValid() {
        return isValid;
    }

    public void setValid(boolean valid) {
        isValid = valid;
    }
}
