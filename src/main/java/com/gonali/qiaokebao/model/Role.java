package com.gonali.qiaokebao.model;

import java.io.Serializable;

/**
 * Created by TianyuanPan on 8/15/16.
 */
public class Role implements Serializable{

    private long roleId;
    private String name;
    private String authority;



    public long getRoleId() {
        return roleId;
    }

    public void setRoleId(long roleId) {
        this.roleId = roleId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }
}
