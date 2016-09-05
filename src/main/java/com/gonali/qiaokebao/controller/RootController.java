package com.gonali.qiaokebao.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.gonali.qiaokebao.model.SchlInfo;
import com.gonali.qiaokebao.model.Sys;
import com.gonali.qiaokebao.service.RootService;
import com.gonali.qiaokebao.utils.GetServletRequestBody;
import com.gonali.qiaokebao.utilsModel.ErrMsg;
import com.gonali.qiaokebao.utilsModel.ResCodes;
import com.gonali.qiaokebao.utilsModel.ResStatus;
import com.gonali.qiaokebao.utilsModel.SchlLocation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletRequest;

/**
 * Created by TianyuanPan on 9/5/16.
 */

@RestController
@RequestMapping(value = "/admin/root", method = RequestMethod.POST)
public class RootController {

    private static final Logger LOGGER = LoggerFactory.getLogger(RootController.class);

    @Autowired
    private RootService rootService;


    /**
     * {
     * "schlName":"name",
     * "location":{
     * "province"："String",
     * "city":"String",
     * "cityArea":"String",
     * "schlArea":"String"
     * }
     * }
     *
     * @param request
     * @param admin
     * @param password
     * @return
     */
    @RequestMapping("addSchool/{admin}/{password}")
    public String addSchool(ServletRequest request, @PathVariable("admin") String admin, @PathVariable("password") String password) {


        String name = admin;
        String passwd = password;

        Sys sys;

        try {
            sys = rootService.findAdmin(name);
            if (sys == null || !sys.getPassword().equals(passwd)) {
                LOGGER.warn("add school not allowed, because of error admin name or password.");
                return ResStatus.failedReturn(ResCodes.ERROR_11, ErrMsg.getErrMsg(ResCodes.ERROR_11));
            }

        } catch (Exception e) {
            LOGGER.warn("findAdmin error.");
            e.printStackTrace();
        }

        String data = GetServletRequestBody.getBodyString(request);

        if (data == null || data.length() == 0) {

            LOGGER.warn("request body data is null.");
            return ResStatus.failedReturn(ResCodes.ERROR_1, ErrMsg.getErrMsg(ResCodes.ERROR_1));
        }

        JSONObject jsonObject;

        try {
            jsonObject = JSON.parseObject(data);
        } catch (Exception e) {
            LOGGER.warn("parser data to json error.");
            e.printStackTrace();
            return ResStatus.failedReturn(ResCodes.ERROR_2, ErrMsg.getErrMsg(ResCodes.ERROR_2));
        }

        String schlName = (String) jsonObject.get("schlName");
        SchlLocation schlLocation = new SchlLocation();
        schlLocation.setProvince((String) jsonObject.getJSONObject("location").get("province"));
        schlLocation.setCity((String) jsonObject.getJSONObject("location").get("city"));
        schlLocation.setCityArea((String) jsonObject.getJSONObject("location").get("ctiyArea"));
        schlLocation.setSchlArea((String) jsonObject.getJSONObject("location").get("schlArea"));

        SchlInfo schlInfo = new SchlInfo();
        schlInfo.setSchlName(schlName);
        schlInfo.setSchlLocation(schlLocation.toString());

        try {
            if (rootService.addSchool(schlInfo) > 0)
                return ResStatus.successReturn();

        } catch (Exception e) {
            e.printStackTrace();
        }

        LOGGER.warn("add school error.");
        return ResStatus.failedReturn(ResCodes.ERROR_7, ErrMsg.getErrMsg(ResCodes.ERROR_7));
    }

}
