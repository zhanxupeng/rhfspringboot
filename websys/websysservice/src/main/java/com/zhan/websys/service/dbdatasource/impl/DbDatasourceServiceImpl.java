package com.zhan.websys.service.dbdatasource.impl;

import com.zhan.websys.dao.configuration.IDynamicDataSource;
import com.zhan.websys.dao.dbdatasource.DbDatasourceMapper;
import com.zhan.websys.entity.dbdatasource.DbDatasource;
import com.zhan.websys.service.dbdatasource.DbDatasourceService;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author zhanxp
 * @version 1.0 2018/10/25
 */
@Service
public class DbDatasourceServiceImpl implements DbDatasourceService, InitializingBean {
    @Autowired
    private DbDatasourceMapper dbDatasourceMapper;
    @Resource(name = "dataSource")
    private IDynamicDataSource dynamicDataSource;

    public List<DbDatasource> findAll() {
        return dbDatasourceMapper.findAll();
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        dynamicDataSource.addDatasourceList(findAll());
    }
}
