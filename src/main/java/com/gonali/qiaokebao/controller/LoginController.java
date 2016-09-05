package com.gonali.qiaokebao.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.gonali.qiaokebao.model.User;
import com.gonali.qiaokebao.service.UserService;
import com.gonali.qiaokebao.utils.GetServletRequestBody;
import com.gonali.qiaokebao.utilsModel.ErrMsg;
import com.gonali.qiaokebao.utilsModel.ResCodes;
import com.gonali.qiaokebao.utilsModel.ResStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletRequest;

/**
 * Created by TianyuanPan on 9/4/16.
 */

@RestController
@RequestMapping(value = "/api/app", method = RequestMethod.POST)
public class LoginController {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    UserService userService;


    /**
     * 传入数据格式：
     * {
     * "userId":"123456789",
     * "password":"fsdfaadsafsdfad"
     * }
     * <p>
     * <p>
     * 正常返回：
     * <p>
     * {
     * "statusCode":0
     * }
     * <p>
     * 异常返回：
     * <p>
     * {
     * "statusCode":error code,
     * "message":"error message"
     * }
     *
     * @param request
     * @return
     */
    @RequestMapping("login")
    public String appLogin(ServletRequest request) {

        String data = GetServletRequestBody.getBodyString(request);
        if (data == null || data.length() == 0) {
            LOGGER.warn("Get data from request is null.");
            return ResStatus.failedReturn(ResCodes.ERROR_1, ErrMsg.getErrMsg(ResCodes.ERROR_1));
        }

        JSONObject jsonObject;
        String userId = null;
        String password = null;

        try {
            jsonObject = JSON.parseObject(data);
            userId = (String)jsonObject.get("userId");
            password = (String)jsonObject.get("password");
        } catch (Exception e) {
            e.printStackTrace();
            return ResStatus.failedReturn(ResCodes.ERROR_2, ErrMsg.getErrMsg(ResCodes.ERROR_2));
        }

        User user = null;

        try {
            user = userService.findUserById(userId);
            if (user == null)
                return ResStatus.failedReturn(ResCodes.ERROR_9, ErrMsg.getErrMsg(ResCodes.ERROR_9));

            if (!user.getPassword().equals(password))
                return ResStatus.failedReturn(ResCodes.ERROR_10, ErrMsg.getErrMsg(ResCodes.ERROR_10));

        } catch (Exception e) {
            e.printStackTrace();
            return ResStatus.failedReturn(ResCodes.ERROR_7, ErrMsg.getErrMsg(ResCodes.ERROR_7));
        }

        return ResStatus.successReturn();

    }

}
