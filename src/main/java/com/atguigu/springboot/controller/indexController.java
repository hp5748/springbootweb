package com.atguigu.springboot.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.thymeleaf.util.StringUtils;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class indexController {
    @PostMapping(value = "/Login")
    public String login(@RequestParam("username") String username, @RequestParam("password")
            String password, Map<String,Object> map,HttpSession session){
        if(!StringUtils.isEmpty(username)&&"123456".equals(password))
        {
            session.setAttribute("loginUser",username);//登录成功
            System.out.println("ok!");
            return "redirect:/home";//重定向
        }else
        {
            map.put("msg","用户名密码错误");
            System.out.println("no!");
            return "Login";
        }
    }
    @RequestMapping(value = "/logout")
    public String logout(Model model, HttpServletRequest request)
    {
        HttpSession session=request.getSession();
        session.invalidate();
        return "Login";
    }
}
