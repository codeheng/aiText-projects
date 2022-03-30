package com.heng.springboot.config;

import com.heng.springboot.config.interceptor.JwtInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class InterceptorConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor( jwtInterceptor() )
                .addPathPatterns("/**")  // 拦截所有请求，通过判断token是否合法来决定是否需要登录,并且排除别的

                //这些接口不需要验证
                .excludePathPatterns("/user/login", "/user/register", "/**/export", "/**/import","/**/pic", "/**/swagger-resources/**","/**/webjars/**","/**/v2/**","/**/swagger-ui.html/**");
    }
    @Bean //注入
    public JwtInterceptor jwtInterceptor() {
        return new JwtInterceptor();
    }
}
