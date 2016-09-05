package com.gonali.qiaokebao.mapper;

import com.gonali.qiaokebao.dao.BaseDao;
import com.gonali.qiaokebao.model.Sys;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * Created by TianyuanPan on 9/5/16.
 */

@Repository
public interface SysMapper extends BaseDao<Sys> {

    Sys findByName(@Param("name") Object name) throws Exception;
}
