package com.gonali.qiaokebao.mapper;

import com.gonali.qiaokebao.dao.BaseDao;
import com.gonali.qiaokebao.model.MsgTask;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by TianyuanPan on 8/20/16.
 */
@Repository
public interface MsgTaskMapper extends BaseDao<MsgTask> {

    List<MsgTask> selectByCreatorId(@Param("creatorId") Object creatorId) throws Exception;

    List<MsgTask> selectByGeterId(@Param("geterId") Object geterId) throws Exception;
}
