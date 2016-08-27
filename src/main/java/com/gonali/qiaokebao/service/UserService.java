package com.gonali.qiaokebao.service;

import com.gonali.qiaokebao.model.User;

/**
 * Created by Administrator on 2016/8/23.
 */
public interface UserService {

    boolean userRegister(User user) throws Exception;

    User findUserById(String userId) throws Exception;

    Integer updatePassword(String userId, String password) throws Exception;
}
