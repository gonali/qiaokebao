package com.gonali.qiaokebao.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.gonali.qiaokebao.model.User;
import com.gonali.qiaokebao.service.RegisterService;
import com.gonali.qiaokebao.service.UserService;
import com.gonali.qiaokebao.utils.GetServletRequestBody;
import com.gonali.qiaokebao.utils.RandomUtils;
import com.gonali.qiaokebao.utils.authorityCode.SendSmsAuthCode;
import com.gonali.qiaokebao.utilsModel.ErrMsg;
import com.gonali.qiaokebao.utilsModel.ResCodes;
import com.gonali.qiaokebao.utilsModel.ResStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletRequest;

/**
 * Created by Administrator on 2016/8/27.
 */

@RestController
@RequestMapping(value = "/api", method = RequestMethod.POST)
public class UserRegisterController {

    @Autowired
    private RegisterService registerService;

    @Autowired
    private UserService userService;


    /**
     * ------------------------------------------------
     * <p>
     * 接口描述： 注册时获取验手机证码接口
     * API地址： http://hostname:port/api/user/register/getAuthCode
     * 请求方法：POST
     * 编码：utf-8
     * 参数说明：
     * 名称            类型         必须
     * phone           String       true
     * nickname        String       true
     * <p>
     * 请求参数 JSON 格式说明：
     * <p>
     * {
     * "phone":"15012341234",
     * "nickname":"alili"
     * }
     * <p>
     * 接口返回说明：
     * 返回类型：json
     * 成功返回：
     * {
     * "statusCode":0
     * }
     * <p>
     * <p>
     * 失败返回：
     * <p>
     * {
     * "statusCode":error code,
     * "message":"error message"
     * }
     * -------------------------------------------------------------
     * =============================================================
     *
     * @param request
     * @return
     */
    @RequestMapping("user/register/getAuthCode")
    public String registerToLog(ServletRequest request) {


        String data = GetServletRequestBody.getBodyString(request);

        if (data == null)
            return ResStatus.failedReturn(ResCodes.ERROR_1, ErrMsg.getErrMsg(ResCodes.ERROR_1));

        JSONObject jsonObject = null;

        try {
            jsonObject = JSON.parseObject(data);
        } catch (Exception e) {
            e.printStackTrace();
            return ResStatus.failedReturn(ResCodes.ERROR_2, ErrMsg.getErrMsg(ResCodes.ERROR_2));
        }

        User user = new User();
        user.setUserId(jsonObject.getString("phone"));

        String authCode = RandomUtils.getRandomNumberStr(6);

        if (!new SendSmsAuthCode().sendAuthCode(user.getUserId(), authCode))
            return ResStatus.failedReturn(ResCodes.ERROR_3, ErrMsg.getErrMsg(ResCodes.ERROR_3));

        try {
            registerService.registerToLog(user, authCode);
        } catch (Exception e) {
            e.printStackTrace();
            return ResStatus.failedReturn(ResCodes.ERROR_4, ErrMsg.getErrMsg(ResCodes.ERROR_4));
        }

        return ResStatus.successReturn();
    }

}
