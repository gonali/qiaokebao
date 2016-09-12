package com.gonali.qiaokebao.mapper;

import com.gonali.qiaokebao.dao.BaseDao;
import com.gonali.qiaokebao.model.RgstrLog;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Administrator on 2016/8/27.
 */

@Repository
public interface RgstrLogMapper extends BaseDao<RgstrLog> {

    Integer  registerConfirm(RgstrLog model) throws Exception;

    List<RgstrLog> findByPhoneAndCode( @Param("phone") Object phone, @Param("code") Object code, @Param("order") String order) throws Exception;
}
