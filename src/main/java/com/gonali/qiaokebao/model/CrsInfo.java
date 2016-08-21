package com.gonali.qiaokebao.model;

import java.io.Serializable;

/**
 * Created by TianyuanPan on 8/15/16.
 */
public class CrsInfo implements Serializable{

    private long crsId;
    private String userId;
    private String crsName;
    private String crsLocation;
    private String crsTchrName;
    private int crsWeek;
    private String crsTime;



    public long getCrsId() {
        return crsId;
    }

    public void setCrsId(long crsId) {
        this.crsId = crsId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getCrsName() {
        return crsName;
    }

    public void setCrsName(String crsName) {
        this.crsName = crsName;
    }

    public String getCrsLocation() {
        return crsLocation;
    }

    public void setCrsLocation(String crsLocation) {
        this.crsLocation = crsLocation;
    }

    public String getCrsTchrName() {
        return crsTchrName;
    }

    public void setCrsTchrName(String crsTchrName) {
        this.crsTchrName = crsTchrName;
    }

    public int getCrsWeek() {
        return crsWeek;
    }

    public void setCrsWeek(int crsWeek) {
        this.crsWeek = crsWeek;
    }

    public String getCrsTime() {
        return crsTime;
    }

    public void setCrsTime(String crsTime) {
        this.crsTime = crsTime;
    }
}
