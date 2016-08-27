package com.gonali.qiaokebao.service.impl;

import com.gonali.qiaokebao.mapper.RgstrLogMapper;
import com.gonali.qiaokebao.model.RgstrLog;
import com.gonali.qiaokebao.model.User;
import com.gonali.qiaokebao.service.RegisterService;
import com.gonali.qiaokebao.utilsModel.TbRgstrLogStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2016/8/27.
 */

@Service
public class RegisterServiceImpl implements RegisterService {

    @Autowired
    private RgstrLogMapper mapper;


    @Override
    public boolean registerToLog(User user, String authCode) throws Exception {

        RgstrLog log = new RgstrLog();
        log.setPhone(user.getUserId());
        log.setAuthCode(authCode);
        log.setValid(true);
        log.setStatus(TbRgstrLogStatus.WAITING);


        if (mapper.insert(log) > 0)
            return true;

        return false;
    }


    @Override
    public boolean registerConfirm(User user, String authCode) throws Exception {

        List<RgstrLog> rgstrLogs = mapper.findByPhoneAndCode("datetime", user.getUserId(), authCode);
        if (rgstrLogs.size() == 0)
            return false;

        for (RgstrLog log : rgstrLogs) {

            log.setStatus(TbRgstrLogStatus.SUCCESS);
            log.setValid(false);
            mapper.registerConfirm(log);
        }

        return true;
    }
}
