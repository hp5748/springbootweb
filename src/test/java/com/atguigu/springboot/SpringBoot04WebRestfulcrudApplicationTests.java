package com.atguigu.springboot;

import com.atguigu.springboot.entity.RoleAuthority;
import com.atguigu.springboot.servise.RoleAuthorityService;
import com.atguigu.springboot.servise.UserService;
import org.junit.jupiter.api.Test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;

import java.util.List;

@SpringBootTest
@ComponentScan("com.atguigu.springboot")
class SpringBoot04WebRestfulcrudApplicationTests {
    Logger logger = LoggerFactory.getLogger(getClass());
    @Test
    void contextLoads() {
        System.out.println("sss");
    }

    @Autowired
    private UserService userService;
    @Test
    void selectTest(){
       // System.out.println(userService.selectUser("admin").toString());
     for(int i=0;i<10000;i++)
     {
         logger.trace("这是入职",i);
         logger.debug("debug",i);
         logger.info("info",i);
         logger.error("ss",i);
     }
    }
    @Autowired
    private RoleAuthorityService roleAuthorityService;

    @Test
    void selectRoleAuthority()
    {
        List<RoleAuthority> permissionSet=roleAuthorityService.selectUserAuthority(3);
        System.out.println(permissionSet);

    }


}
