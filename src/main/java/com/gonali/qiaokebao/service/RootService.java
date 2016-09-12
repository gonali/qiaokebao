package com.gonali.qiaokebao.service;

import com.gonali.qiaokebao.model.SchlInfo;
import com.gonali.qiaokebao.model.Sys;

/**
 * Created by TianyuanPan on 9/5/16.
 */
public interface RootService {


    /* sys service */
    Sys findAdmin(String name) throws Exception;

    /* school admin */
    Integer  addSchool(SchlInfo model) throws Exception;
    Integer  delSchool(Object schlId) throws Exception;
    Integer  updateSchool(SchlInfo model) throws Exception;




}
