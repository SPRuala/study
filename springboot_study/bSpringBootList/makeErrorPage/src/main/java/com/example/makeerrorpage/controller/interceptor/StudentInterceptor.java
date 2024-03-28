package com.example.makeerrorpage.controller.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
public class StudentInterceptor implements HandlerInterceptor {
    //访问controller之前拦截
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //获取第一个参数
        String sid = request.getHeader("sid");
        //获取第二个参数
        String studentToken = request.getHeader("studentToken");
        //两个参数都不为空时才继续执行,否则拦截
        if (StringUtils.isEmpty(sid) || StringUtils.isEmpty(studentToken)){
            log.error("用户校验不通过,信息不完整");
            //拦截
            return false;
        }
        //假设用户id为1001,用户token为abcxyz(可以从数据库中查询出,再做校验)
        //equalsIgnoreCase: 比较时忽略大小写
        //如果sid!=1001,studentToken!=abcxyz
        if (!sid.equalsIgnoreCase("1001") || !studentToken.equalsIgnoreCase("abcxyz")){
            log.error("用户权限不通过");
            //拦截
            return false;
        }


        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }
}
