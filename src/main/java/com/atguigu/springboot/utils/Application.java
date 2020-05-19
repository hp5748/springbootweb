package com.atguigu.springboot.utils;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

//获取服务工具类，解决不能注入service问题
@Component
public class Application implements ApplicationContextAware {

    private static ApplicationContext applicationContext;

    public static ApplicationContext getApplicationContext() {
        return applicationContext;
    }
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        Application.applicationContext = applicationContext;
    }


    public static Object getBean(String beanName) {
        return applicationContext.getBean(beanName);
    }
}
