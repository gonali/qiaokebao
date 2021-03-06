package com.gonali.qiaokebao.mapper;

import com.gonali.qiaokebao.dao.BaseDao;
import com.gonali.qiaokebao.model.Pay;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Administrator on 2016/8/22.
 */
@Repository
public interface PayMapper extends BaseDao<Pay> {

    List<Pay> findAllByUserId(@Param("userId") Object userId);
}
