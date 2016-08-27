package com.gonali.qiaokebao.mapper;

import com.gonali.qiaokebao.dao.BaseDao;
import com.gonali.qiaokebao.model.CrdtLog;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by TianyuanPan on 8/20/16.
 */

@Repository
public interface CrdtLogMapper extends BaseDao<CrdtLog> {

    List<CrdtLog> findByUserId(@Param("userId") Object UserId) throws Exception;

    List<CrdtLog> findPageByUserId(@Param("order") String order,
                                   @Param("userId") Object userId,
                                   @Param("start") int start,
                                   @Param("pageSize") int pageSize) throws Exception;

}
