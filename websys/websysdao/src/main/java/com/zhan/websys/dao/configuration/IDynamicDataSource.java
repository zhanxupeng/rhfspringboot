package com.zhan.websys.dao.configuration;

import com.zhan.websys.entity.dbdatasource.DbDatasource;

import java.util.List;

/**
 * @author zhanxp
 * @version 1.0 2018/10/25
 */
public interface IDynamicDataSource {
    /**
     * 新增数据库配置
     *
     * @param dbDatasourceList
     */
    void addDatasourceList(List<DbDatasource> dbDatasourceList);

    /**
     * 更新数据库配置
     *
     * @param dbDatasources
     */
    void updateDatasourceList(List<DbDatasource> dbDatasources);
}
