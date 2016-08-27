package com.gonali.qiaokebao.controller;

import com.gonali.qiaokebao.model.User;
import com.gonali.qiaokebao.service.UserService;
import com.gonali.qiaokebao.utils.SignatureUtils;
import com.gonali.qiaokebao.utilsModel.ErrMsg;
import com.gonali.qiaokebao.utilsModel.ResCodes;
import com.gonali.qiaokebao.utilsModel.ResStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by TianyuanPan on 8/27/16.
 */

@RestController
@RequestMapping("/api/userInfo")
public class UserInfoController {

    @Autowired
    private UserService userService;


    /**
     * -------------------------------------------------------------
     * =============================================================
     * <p>
     * 接口描述： 用户修改密码接口
     * API地址： http://hostname:port/api/userInfo/set/password/{userId}/{signature}/{password}
     * 请求方法：POST
     * 编码：utf-8
     * 参数说明：
     * 没有Bogdy参数，由路径传入
     * 名称            类型         必须            说明
     * userId           String       true      用户Id
     * signature        String       true     签名串，userId用原来的password签名得到
     * password        String       true      新密码串
     * <p>
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
     *
     * @param userId
     * @param signature
     * @param password
     * @return
     */
    @RequestMapping("set/password/{userId}/{signature}/{password}")
    public String setPassword(@PathVariable("userId") String userId,
                              @PathVariable("signature") String signature,
                              @PathVariable("password") String password) {

        User user = null;

        try {
            user = userService.findUserById(userId);
        } catch (Exception e) {
            e.printStackTrace();
            return ResStatus.failedReturn(ResCodes.ERROR_7, ErrMsg.getErrMsg(ResCodes.ERROR_7));
        }

        if (!signature.equals(SignatureUtils.base64HmacSha1Sign(user.getUserId(), user.getPassword())))
            return ResStatus.failedReturn(ResCodes.ERROR_8, ErrMsg.getErrMsg(ResCodes.ERROR_8));

        try {
            if (userService.updatePassword(userId, password) > 0)
                return ResStatus.successReturn();
        } catch (Exception e) {
            e.printStackTrace();
            return ResStatus.failedReturn(ResCodes.ERROR_7, ErrMsg.getErrMsg(ResCodes.ERROR_7));
        }

        return ResStatus.failedReturn(ResCodes.ERROR_7, ErrMsg.getErrMsg(ResCodes.ERROR_7));
    }



}
