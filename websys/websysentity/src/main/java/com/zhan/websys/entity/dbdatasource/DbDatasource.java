package com.zhan.websys.entity.dbdatasource;

import lombok.Getter;
import lombok.Setter;

/**
 * 多数据源的数据源配置表
 * DB_DATASOURCE
 */
@Getter
@Setter
public class DbDatasource {
    /**
     * 多数据源的数据源key
     * DATABASE_KEY
     */
    private String databaseKey;

    /**
     * oracle数据库url
     * JDBC_URL
     */
    private String jdbcUrl;

    /**
     * oracle数据库用户名
     * JDBC_USERNAME
     */
    private String jdbcUsername;

    /**
     * oracle数据库密码
     * JDBC_PASSWORD
     */
    private String jdbcPassword;

    /**
     * 数据源前端显示的名称
     * DATABASE_NAME
     */
    private String databaseName;
}