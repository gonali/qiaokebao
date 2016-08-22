package com.gonali.qiaokebao.utilsModel;

import com.alibaba.fastjson.JSONObject;

/**
 * Created by Administrator on 2016/8/22.
 */
public class SchlLocation {

    private String province;
    private String city;
    private String cityArea;
    private String schlArea;

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCityArea() {
        return cityArea;
    }

    public void setCityArea(String cityArea) {
        this.cityArea = cityArea;
    }

    public String getSchlArea() {
        return schlArea;
    }

    public void setSchlArea(String schlArea) {
        this.schlArea = schlArea;
    }

    @Override
    public String toString() {

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("province", this.province);
        jsonObject.put("city", this.city);
        jsonObject.put("cityArea", this.cityArea);
        jsonObject.put("schlArea", this.schlArea);

        return jsonObject.toJSONString();
    }
}
