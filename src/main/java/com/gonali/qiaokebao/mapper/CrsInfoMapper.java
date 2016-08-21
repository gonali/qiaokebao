package com.gonali.qiaokebao.mapper;

import com.gonali.qiaokebao.dao.BaseDao;
import com.gonali.qiaokebao.model.CrsInfo;

/**
 * Created by TianyuanPan on 8/20/16.
 */
public interface CrsInfoMapper extends BaseDao<CrsInfoMapper> {

    Integer deleteByUser(CrsInfo model) throws Exception;
}
