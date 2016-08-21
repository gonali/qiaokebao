package com.gonali.qiaokebao.model;

import java.io.Serializable;

/**
 * Created by TianyuanPan on 8/15/16.
 */
public class SchlInfo implements Serializable {

    private long schlId;
    private String schlName;
    private String schlLocation;


    public long getSchlId() {
        return schlId;
    }

    public void setSchlId(long schlId) {
        this.schlId = schlId;
    }

    public String getSchlName() {
        return schlName;
    }

    public void setSchlName(String schlName) {
        this.schlName = schlName;
    }

    public String getSchlLocation() {
        return schlLocation;
    }

    public void setSchlLocation(String schlLocation) {
        this.schlLocation = schlLocation;
    }
}
