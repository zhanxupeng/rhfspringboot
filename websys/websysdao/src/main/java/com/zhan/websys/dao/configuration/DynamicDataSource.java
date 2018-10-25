package com.zhan.websys.dao.configuration;

import cn.hutool.core.util.ReflectUtil;
import com.alibaba.druid.pool.DruidDataSource;
import com.zhan.websys.entity.dbdatasource.DbDatasource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

import java.sql.SQLException;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author zhanxp
 * @version 1.0 2018/10/24
 */
public class DynamicDataSource extends AbstractRoutingDataSource implements IDynamicDataSource {

    @Autowired
    ApplicationContext applicationContext;

    /**
     * 当前子系统实例的数据库信息保存的地方
     */
    private static final Map<String, DbDatasource> KEY_BD_DATASOURCE = new HashMap<>();

    @Override
    protected Object determineCurrentLookupKey() {
        return DataSourceContextHolder.getSourceKey();
    }

    /**
     * 新增数据库配置
     *
     * @param dbDatasourceList
     */
    @Override
    public void addDatasourceList(List<DbDatasource> dbDatasourceList) {
        Map<Object, Object> targetDataSources = getTargetDataSources();
        dbDatasourceList.forEach(dbDatasource -> {
            if (KEY_BD_DATASOURCE.containsKey(dbDatasource.getDatabaseKey())) {
                return;
            }
            DruidDataSource dataSource = applicationContext.getBean("sourceTwo", DruidDataSource.class);
            dataSource.setUsername(dbDatasource.getJdbcUsername());
            dataSource.setPassword(dbDatasource.getJdbcPassword());
            dataSource.setUrl(dbDatasource.getJdbcUrl());
            try {
                dataSource.init();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            KEY_BD_DATASOURCE.put(dbDatasource.getDatabaseKey(), dbDatasource);
            targetDataSources.put(dbDatasource.getDatabaseKey(), dataSource);
        });
        afterPropertiesSet();
    }

    /**
     * 删除数据库配置
     *
     * @param dbDatasources
     */
    private void deleteDatasourceList(List<DbDatasource> dbDatasources) {
        dbDatasources.forEach(x -> {
            KEY_BD_DATASOURCE.remove(x.getDatabaseKey());
            Map<Object, Object> targetDataSources = getTargetDataSources();
            if (targetDataSources.containsKey(x.getDatabaseKey())) {
                Object remove = targetDataSources.remove(x.getDatabaseKey());
                if (remove instanceof DruidDataSource) {
                    DruidDataSource dataSource = (DruidDataSource) remove;
                    if (!dataSource.isClosed()) {
                        dataSource.close();
                    }
                }
            }
        });

        afterPropertiesSet();
    }

    /**
     * 更新数据库配置
     *
     * @param dbDatasources
     */
    @Override
    public void updateDatasourceList(List<DbDatasource> dbDatasources) {
        List<DbDatasource> needUpdateList = new LinkedList<>();
        List<DbDatasource> needDeleteList = new LinkedList<>();
        List<DbDatasource> needInsertList;
        List<String> keyList = dbDatasources.stream().map(DbDatasource::getDatabaseKey).collect(Collectors.toList());


        Collection<DbDatasource> currentList = KEY_BD_DATASOURCE.values();
        Set<String> currentKeyList = KEY_BD_DATASOURCE.keySet();
        currentList.forEach(x -> {
            if (!keyList.contains(x.getDatabaseKey())) {
                needDeleteList.add(x);
            } else {
                Optional<DbDatasource> dbDatasourceOptional = dbDatasources.stream().filter(y -> y.getDatabaseKey().equals(x.getDatabaseKey())).findAny();
                if (dbDatasourceOptional.isPresent()) {
                    DbDatasource d = dbDatasourceOptional.get();
                    if (!(d.getJdbcUrl().equals(x.getJdbcUrl()) && d.getJdbcUsername().equals(x.getJdbcUsername()) && d.getJdbcPassword().equals(x.getJdbcPassword()))) {
                        needUpdateList.add(x);
                    }
                }
            }

        });

        needInsertList = dbDatasources.stream().filter(x -> !currentKeyList.contains(x.getDatabaseKey())).collect(Collectors.toList());

        needDeleteList.addAll(needUpdateList);
        needInsertList.addAll(needUpdateList);

        deleteDatasourceList(needDeleteList);
        addDatasourceList(needInsertList);
    }

    private Map<Object, Object> getTargetDataSources() {
        Map<Object, Object> map = (Map<Object, Object>) ReflectUtil.getFieldValue(this, "targetDataSources");
        if (map == null) {
            map = new LinkedHashMap<>();
            setTargetDataSources(map);
        }
        return map;
    }

}
