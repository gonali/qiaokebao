package com.gonali.qiaokebao.mapper;

import com.gonali.qiaokebao.dao.BaseDao;
import com.gonali.qiaokebao.model.CllgInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by TianyuanPan on 8/16/16.
 */

@Repository
public interface CllgInfoMapper extends BaseDao<CllgInfo> {

    List<CllgInfo> findAllByUserId(@Param("order") String order, @Param("userId") Object userId) throws Exception;
    Integer updateByUser(CllgInfo model) throws Exception;
}
