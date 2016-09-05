package com.gonali.qiaokebao.service.impl;

import com.gonali.qiaokebao.mapper.SchlInfoMapper;
import com.gonali.qiaokebao.mapper.SysMapper;
import com.gonali.qiaokebao.model.SchlInfo;
import com.gonali.qiaokebao.model.Sys;
import com.gonali.qiaokebao.service.RootService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by TianyuanPan on 9/5/16.
 */

@Service
public class RootServiceImpl implements RootService {

    @Autowired
    private SchlInfoMapper schlInfoMapper;
    @Autowired
    private SysMapper sysMapper;

    @Override
    public Sys findAdmin(String name) throws Exception {
        return sysMapper.findByName(name);
    }

    @Override
    public Integer addSchool(SchlInfo model) throws Exception {
        return schlInfoMapper.insert(model);
    }

    @Override
    public Integer delSchool(Object schlId) throws Exception {
        return schlInfoMapper.delete(schlId);
    }

    @Override
    public Integer updateSchool(SchlInfo model) throws Exception {
        return schlInfoMapper.update(model);
    }


}
