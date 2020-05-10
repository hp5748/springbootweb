package com.atguigu.springboot.controller;

import com.atguigu.springboot.entity.User;
import com.atguigu.springboot.servise.UserService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @PostMapping(value = "/Login")
    public String login(@RequestParam("username") String username, @RequestParam("password")
            String password, Map<String, Object> map, HttpSession session) {

        if (!StringUtils.isEmpty(username) || !StringUtils.isEmpty(password)) {

            User user = null;
            user = userService.selectUser(username);
            if (user == null) {
                map.put("msg", "用户名错误");
                System.out.println("no!");
                return "Login";
            }
            String psw = user.getPassword();
            if (psw.equals(password)) {
                session.setAttribute("loginUser", username);//登录成功
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
}
