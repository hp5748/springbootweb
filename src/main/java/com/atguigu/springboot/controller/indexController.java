package com.atguigu.springboot.controller;

import com.atguigu.springboot.config.annotation.RequiredPermission;
import com.atguigu.springboot.constant.PermissionConstants;
import com.atguigu.springboot.entity.User;
import com.atguigu.springboot.entity.UserInfo;
import com.atguigu.springboot.servise.RoleAuthorityService;
import com.atguigu.springboot.servise.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@Controller
public class indexController {

    @Autowired
    private UserService userService;

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

/*
* @ResponseBody 这个注解， 就表明该方法的返回值直接写入到 HTTP Response Body 中。
* 这就是说，如果返回的是JSON， 就得必须添加 @ResponseBody 这个注解，
* 一般在异步获取数据时使用，在使用@RequestMapping后，返回值通常解析为跳转路径，
* 加上@responsebody后返回结果不会被解析为跳转路径，而是直接写入HTTP response body中。
* 比如异步获取json数据，加上@responsebody后，会直接返回json数据。
* */
    @ResponseBody
    @RequestMapping(value = "/search",produces = {MediaType.APPLICATION_JSON_VALUE})
    @RequiredPermission(PermissionConstants.ME_AND_PDE_OPERATION)
    public User search(String personName)
    {
        System.out.println("personName:"+personName);
        User user=userService.selectUser("h06422");
        System.out.println(user);
        return user;
    }
//getUsers，获取用户账户，
@ResponseBody
@RequestMapping(value = "/getUsers",produces = {MediaType.APPLICATION_JSON_VALUE})
public List<UserInfo> getUsers()
{
    HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
    Object role_id = request.getSession().getAttribute("role_id");
    int id = Integer.parseInt(role_id.toString());
    List<UserInfo> users=null;
    if(id==0)
    {
        users=userService.getAllUsers();
        System.out.println(users);
    }else {
       users=userService.getAllUsersByRoleId(id);
       System.out.println(users);
    }

    return users;
}
}
