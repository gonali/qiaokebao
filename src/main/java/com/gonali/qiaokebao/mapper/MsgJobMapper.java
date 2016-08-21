package com.gonali.qiaokebao.mapper;

import com.gonali.qiaokebao.dao.BaseDao;
import com.gonali.qiaokebao.model.MsgJob;
import org.apache.ibatis.annotations.Param;

import java.sql.Date;

/**
 * Created by TianyuanPan on 8/20/16.
 */
public interface MsgJobMapper extends BaseDao<MsgJob> {

    Integer updateEndDate(@Param("msgId") Object msgId, @Param("date")Date endDate) throws Exception;

    Integer updateGeter(@Param("msgid") Object msgId, @Param("date") Date getDate) throws Exception;
}
