package com.gonali.qiaokebao.dao;

import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by TianyuanPan on 8/16/16.
 */
public interface BaseDao<T> {

    Integer insert(T model) throws Exception;

    Integer delete(@Param("id") Object id) throws Exception;

    Integer flagDelete(@Param("id") Object id) throws Exception;

    Integer update(T model) throws Exception;

    Integer countAll() throws Exception;


    T findById(@Param("id") Object id) throws Exception;

    List<T> findAll(@Param("order") String order) throws Exception;

    List<T> findByPage(@Param("order") String order, @Param("start") int start, @Param("pageSize") int pageSize) throws Exception;

    Integer deleteWhere(@Param("where") String where) throws Exception ;

    Integer deleteByPropertyName(@Param("propertyName") String propertyName, @Param("value") Object value) throws Exception;

    Integer countWhere(@Param("where") String where) throws Exception;

    Integer countByPropertyName(@Param("propertyName") String propertyName, @Param("value") Object value) throws Exception ;

    List<T> findWhere(@Param("order") String order, @Param("where") String where) throws Exception ;

    List<T> findWhereByPage(@Param("order") String order, @Param("where") String where, @Param("limit") int limit, @Param("start") int start) throws Exception;

    List<T> findByPropertyName(@Param("order") String order, @Param("propertyName") String propertyName, @Param("value") Object value) throws Exception;

}
