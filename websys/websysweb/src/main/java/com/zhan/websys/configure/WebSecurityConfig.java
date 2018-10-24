package com.zhan.websys.configure;

import com.zhan.websys.interceptor.UserContextInterceptor;
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

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(getUserContextInterceptor()).addPathPatterns("/**")
                .excludePathPatterns("/customer/getDropDown.do", "/customer/login.do");
    }
}
