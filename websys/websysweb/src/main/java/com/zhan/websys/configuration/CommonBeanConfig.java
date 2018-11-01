package com.zhan.websys.configuration;

import com.google.code.kaptcha.Producer;
import com.google.code.kaptcha.impl.DefaultKaptcha;
import com.google.code.kaptcha.util.Config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.io.IOException;
import java.util.Properties;

/**
 * @author zhanxp
 * @version 1.0 2018/11/1
 */
@Configuration
public class CommonBeanConfig {

    @Bean
    public Config getKaptchaConfig() {
        Properties properties = new Properties();
        try {
            properties.load(new ClassPathResource("identify-code.properties").getInputStream());
        } catch (IOException e) {
            throw new RuntimeException("加载图片配置失败", e);
        }
        return new Config(properties);
    }

    @Bean
    public Producer getCaptchaProducer() {
        DefaultKaptcha defaultKaptcha = new DefaultKaptcha();
        defaultKaptcha.setConfig(getKaptchaConfig());
        return defaultKaptcha;
    }


    public static void main(String[] args) throws Exception {
        Resource resource = new ClassPathResource("test.properties");
        Properties properties = new Properties();
        properties.load(resource.getInputStream());
        System.out.println(properties);
    }
}
