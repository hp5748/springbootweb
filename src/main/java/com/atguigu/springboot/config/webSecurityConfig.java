package com.atguigu.springboot.config;

import com.atguigu.springboot.component.LoginHandlerInterceptor;
import com.atguigu.springboot.component.SecurityInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.ResourceUtils;
import org.springframework.web.servlet.config.annotation.*;


@Configuration
public class webSecurityConfig extends WebMvcConfigurationSupport {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
          registry.addResourceHandler("/static/**").addResourceLocations(ResourceUtils.CLASSPATH_URL_PREFIX + "/static/");
    }
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("Login");
        registry.addViewController("/main").setViewName("main");
        registry.addViewController("/home").setViewName("home");
        registry.addViewController("/404").setViewName("404");

    }
//注册拦截器
    @Override
    protected void addInterceptors(InterceptorRegistry registry) {
        //登录拦截
        registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/**")
                .excludePathPatterns("/","/Login","/logout","/static/**");
        //权限拦截
        registry.addInterceptor(new SecurityInterceptor()).addPathPatterns("/**")
                .excludePathPatterns("/","/Login","/logout","/static/**");
    }


}
