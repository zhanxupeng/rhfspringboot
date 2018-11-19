package com.zhan.websys;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ImportResource;

/**
 * @author zhanxp
 * @version 1.0  2018/10/14
 * @Description todo
 */
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
//@EnableDubboConfiguration
@ImportResource({"classpath:applicationContext-dubbo.xml"})
public class WebSysWebApplication {
    public static void main(String[] args) {
        SpringApplication.run(WebSysWebApplication.class, args);
    }

}
