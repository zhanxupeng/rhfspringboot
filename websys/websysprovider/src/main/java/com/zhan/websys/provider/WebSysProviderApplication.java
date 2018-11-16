package com.zhan.websys.provider;

import com.alibaba.dubbo.spring.boot.annotation.EnableDubboConfiguration;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author zhanxp
 * @version 1.0 2018/11/15
 */
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@ComponentScan(basePackages = {"com.zhan.websys.manager", "com.zhan.websys.service",
        "com.zhan.websys.provider"})
@EnableDubboConfiguration
@MapperScan(basePackages = {"com.zhan.websys.dao"})
public class WebSysProviderApplication {
    public static void main(String[] args) {
        SpringApplication.run(WebSysProviderApplication.class, args);
    }

}
