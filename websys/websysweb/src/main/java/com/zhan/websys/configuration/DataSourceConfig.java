package com.zhan.websys.configuration;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * @author zhanxp
 * @version 1.0 2018/10/24
 */
@Configuration
public class DataSourceConfig {

    @Bean(name = "sourceOne")
    @ConfigurationProperties(prefix = "spring.datasource.source-one")
    public DruidDataSource getSourceOne() {
        return new DruidDataSource();
    }

    @Bean(name = "sourceOwo")
    @ConfigurationProperties(prefix = "spring.datasource.source-two")
    public DruidDataSource getSourceTwo() {
        return new DruidDataSource();
    }

    @Bean
    public DataSource dataSource() {
        DynamicDataSource dynamicDataSource = new DynamicDataSource();
        // 默认数据源
        dynamicDataSource.setDefaultTargetDataSource(getSourceOne());

        // 配置多数据源
        Map<Object, Object> dsMap = new HashMap<>(5);
        dsMap.put("sourceOne", getSourceOne());
        dsMap.put("sourceTwo", getSourceTwo());

        dynamicDataSource.setTargetDataSources(dsMap);

        return dynamicDataSource;
    }


}
