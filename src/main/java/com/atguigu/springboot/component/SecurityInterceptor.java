package com.atguigu.springboot.component;

import com.atguigu.springboot.config.annotation.RequiredPermission;
import com.atguigu.springboot.entity.RoleAuthority;
import com.atguigu.springboot.entity.User;
import com.atguigu.springboot.servise.RoleAuthorityService;
import com.atguigu.springboot.utils.Application;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/*权限拦截器*/
@Component
public class SecurityInterceptor implements HandlerInterceptor {

//    @Resource
//    private RoleAuthorityService roleAuthorityService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //
        if (this.hasPermission(handler)) {
            System.out.println("preHandle 进入 true");
            return true;
        }
        System.out.println("preHandle 进入 false");
        response.sendError(HttpStatus.FORBIDDEN.value(), "无权限");
        return false;
    }

    private boolean hasPermission(Object handler) {
        if (handler instanceof HandlerMethod) {
            System.out.println("HandlerMethod");
            HandlerMethod handlerMethod = (HandlerMethod) handler;
            //获取方法上的注解

            RequiredPermission requiredPermission = handlerMethod.getMethod().getAnnotation(RequiredPermission.class);
            //如果方法上的注解为空，则获取类的注解
            if (requiredPermission == null) {
                System.out.println("requiredPermission==null");
                requiredPermission = handlerMethod.getMethod().getDeclaringClass().getAnnotation(RequiredPermission.class);
            } else {
                System.out.println("注解在方法上");
            }
            //如果标记了注解，则判断权限
            if (requiredPermission != null && !StringUtils.isEmpty(requiredPermission.value())) {
                //redis或数据库
                //这里写一个获取权限，看下是否包含权限内容
                System.out.println("进入注解判断");

                HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
                Object role_id = request.getSession().getAttribute("role_id");
                System.out.println("roleId:" + role_id.toString());
                int id = Integer.parseInt(role_id.toString());
                System.out.println("id:" + id);
                RoleAuthorityService roleAuthorityService = (RoleAuthorityService) Application.getBean("RoleAuthorityService");

                List<RoleAuthority> permissionSet = roleAuthorityService.selectUserAuthority(id);
                System.out.println(permissionSet);
                //然后返回true或false
                if (permissionSet == null) {
                    System.out.println("false");
                    //没有被限制权限
                    return true;
                }
                boolean is_canNext = false;
                for (RoleAuthority str : permissionSet) {
                    System.out.println("getFunction_flag:" + str.getFunction_flag());
                    System.out.println("requiredPermission:" + requiredPermission.value());
                    if (str.getFunction_flag().equals(requiredPermission.value())) {
                        System.out.println("result:" + requiredPermission.value());
                        is_canNext = true;
                    }
                }
                return is_canNext;
            } else {
                System.out.println("没有注解判断");
            }
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
