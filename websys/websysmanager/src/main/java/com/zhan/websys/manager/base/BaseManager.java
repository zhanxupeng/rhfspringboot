package com.zhan.websys.manager.base;

import com.zhan.websys.entity.base.BaseEntity;
import com.zhan.websys.entity.base.PageQuery;

import java.util.List;

/**
 * @author zhanxp
 * @version 1.0 2018/11/8
 */
public interface BaseManager<M extends BaseEntity> {
    /**
     * 根据ID查询，查不到抛出异常
     *
     * @param urid
     * @return
     */
    M getById(String urid);

    /**
     * 新增，失败抛异常
     *
     * @param entity
     */
    void insert(M entity);

    /**
     * 更新，失败抛异常
     *
     * @param entity
     */
    void update(M entity);

    /**
     * 删除，失败回滚抛异常
     *
     * @param list
     */
    void deletes(List<M> list);

    /**
     * 查询
     *
     * @param entity
     * @return
     */
    List<M> find(M entity);

    /**
     * 分页查询
     *
     * @param pageQuery
     * @return
     */
    List<M> pageQuery(PageQuery<M> pageQuery);
}
