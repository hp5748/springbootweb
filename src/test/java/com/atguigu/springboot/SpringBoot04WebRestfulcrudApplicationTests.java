package com.atguigu.springboot;

import com.atguigu.springboot.servise.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;

@SpringBootTest
@ComponentScan("com.atguigu.springboot")
class SpringBoot04WebRestfulcrudApplicationTests {

    @Test
    void contextLoads() {
        System.out.println("sss");
    }

    @Autowired
    private UserService userService;
    @Test
    void selectTest(){

        System.out.println(userService.selectUser("admin").toString());
    }


}
