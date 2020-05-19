package com.atguigu.springboot.controller;

import com.atguigu.springboot.config.annotation.RequiredPermission;
import com.atguigu.springboot.constant.PermissionConstants;
import com.atguigu.springboot.entity.User;
import com.atguigu.springboot.servise.RoleAuthorityService;
import com.atguigu.springboot.servise.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class indexController {

    @Autowired
    private UserService userService;

    @Autowired
    private RoleAuthorityService roleAuthorityService;

    @PostMapping(value = "/Login")
    public String login(@RequestParam("username") String username, @RequestParam("password")
            String password, Map<String, Object> map, HttpSession session) {

        if (!StringUtils.isEmpty(username) || !StringUtils.isEmpty(password)) {

            User user = null;
            user = userService.selectUser(username);
            System.out.println(user);
            if (user == null) {
                map.put("msg", "用户名错误");
                System.out.println("no!");
                return "Login";
            }
            String psw = user.getPassword();
            if (psw.equals(password)) {
                session.setAttribute("loginUser", user.getUser_name());//登录成功
                session.setAttribute("role_id",user.getRole_id());
                System.out.println("ok!");
                return "redirect:/home";//重定向
            } else {
                map.put("msg", "密码错误");
                System.out.println("no!");
                return "Login";
            }


        } else {
            map.put("msg", "用户名或密码不能为空！");
            System.out.println("no!");
            return "Login";
        }
    }

    @RequestMapping(value = "/logout")
    public String logout(Model model, HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.invalidate();
        return "Login";
    }

    //权限给PDE查询

    @RequestMapping(value = "/search",produces = {MediaType.APPLICATION_JSON_VALUE})
    @RequiredPermission(PermissionConstants.PDE_OPERATION)
    public User search(String personName)
    {
        System.out.println("personName:"+personName);
       User user= new User();
//       user.setPuid(1);
//       user.setUser_name(personName);
//       user.setAccount("hp");
//       user.setPassword("123456");
//        user.setEffective("1");
//        user.setGroup_id(1);
//        user.setGroup_id(1);
        return user;
    }

}
