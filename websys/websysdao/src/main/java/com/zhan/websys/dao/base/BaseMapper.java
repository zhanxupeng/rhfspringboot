package com.zhan.websys.dao.base;

import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author zhanxp
 * @version 1.0 2018/11/8
 */
public interface BaseMapper<T> {

    /**
     * 按ID获取
     */
    T selectById(@Param("urid") String urid);

    /**
     * 新增
     */
    int insert(T entity);

    /**
     * 更新
     */
    int update(T entity);

    /**
     * 删除
     */
    int delete(@Param("urid") String urid, @Param("version") Integer version);

    /**
     * 查询
     *
     * @param entity
     * @return
     */
    List<T> find(T entity);
}
