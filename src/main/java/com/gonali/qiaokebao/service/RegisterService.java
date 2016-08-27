package com.gonali.qiaokebao.service;

import com.gonali.qiaokebao.model.User;

/**
 * Created by Administrator on 2016/8/27.
 */
public interface RegisterService {

    boolean registerToLog(User user, String authCode) throws Exception;

    boolean registerConfirm(User user, String authCode) throws Exception;
}
