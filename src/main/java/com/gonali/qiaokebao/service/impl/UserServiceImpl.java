package com.gonali.qiaokebao.service.impl;

import com.gonali.qiaokebao.mapper.UserMapper;
import com.gonali.qiaokebao.model.User;
import com.gonali.qiaokebao.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Administrator on 2016/8/23.
 */
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper mapper;

    @Override
    public boolean userRegister(User user) throws Exception {
        Integer i = mapper.insert(user);
        if (i > 0)
            return true;
        return false;
    }
}
