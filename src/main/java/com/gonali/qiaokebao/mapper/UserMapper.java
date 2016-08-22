package com.gonali.qiaokebao.mapper;

import com.gonali.qiaokebao.dao.BaseDao;
import com.gonali.qiaokebao.model.User;
import org.apache.ibatis.annotations.Param;

/**
 * Created by Administrator on 2016/8/22.
 */
public interface UserMapper extends BaseDao<User> {

    Integer updateRealName(@Param("userId") Object userId, @Param("realName") Object realName) throws Exception;

    Integer updateNickName(@Param("userId") Object userId, @Param("nickName") Object nickName) throws Exception;

    Integer updateSex(@Param("userId") Object userId, @Param("sex") Object sex)throws Exception;

    Integer updateBirthday(@Param("userId") Object userId, @Param("birthday") Object birthday)throws Exception;

    Integer updateEmail(@Param("userId") Object userId, @Param("email") Object email)throws Exception;

    Integer updatePassword(@Param("userId") Object userId, @Param("password") Object password)throws Exception;
}
