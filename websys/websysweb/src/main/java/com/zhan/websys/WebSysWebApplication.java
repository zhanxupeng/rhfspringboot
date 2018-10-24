package com.zhan.websys;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * @author zhanxp
 * @version 1.0  2018/10/14
 * @Description todo
 */
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class WebSysWebApplication {
    public static void main(String[] args) {
        SpringApplication.run(WebSysWebApplication.class, args);
    }

}
