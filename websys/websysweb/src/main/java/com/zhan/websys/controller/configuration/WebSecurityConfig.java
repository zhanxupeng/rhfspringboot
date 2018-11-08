package com.zhan.websys.controller.configuration;

import com.zhan.websys.controller.interceptor.AuthorizationCheckInterceptor;
import com.zhan.websys.controller.interceptor.UserContextInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author zhanxp
 * @version 1.0 2018/10/24
 */
@Configuration
public class WebSecurityConfig implements WebMvcConfigurer {
    @Bean
    public UserContextInterceptor getUserContextInterceptor() {
        return new UserContextInterceptor();
    }

    @Bean
    AuthorizationCheckInterceptor getAuthorizationCheckInterceptor() {
        return new AuthorizationCheckInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(getUserContextInterceptor()).addPathPatterns("/**")
//                .excludePathPatterns("/customer/getDropDown.pub", "/customer/login.pub");
//
//        registry.addInterceptor(getAuthorizationCheckInterceptor()).addPathPatterns("/**/*.do");
    }
}
