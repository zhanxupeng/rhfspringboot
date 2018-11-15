package com.zhan.websys.provider;

import com.alibaba.dubbo.spring.boot.annotation.EnableDubboConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * @author zhanxp
 * @version 1.0 2018/11/15
 */
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@EnableDubboConfiguration
public class WebSysProviderApplication {
    public static void main(String[] args) {
        SpringApplication.run(WebSysProviderApplication.class, args);
    }

}
