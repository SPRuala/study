package com.bc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class ScopeController {
    //使用ModelAndView共享数据
    @RequestMapping("test/modelandview")
public ModelAndView testModelAndView(){
        ModelAndView modelAndView=new ModelAndView();
        //使用Model功能往域对象共享数据
        modelAndView.addObject("testRequestScope","helloModelAndView");
        //使用View功能设置逻辑视图
        //设置视图名称
        modelAndView.setViewName("hello");
        return modelAndView;
    }
    //使用Model共享数据
    @RequestMapping("test/model")
    public String testModel(Model model){
        //Model接口:输出model对象类名 org.springframework.validation.support.BindingAwareModelMap
        System.out.println(model.getClass().getName());
        model.addAttribute("testRequestScope","helloModel");
        return "hello";
    }
    //使用ModelMap共享数据
    @RequestMapping("test/modelMap")
    public String testModelMap(ModelMap modelMap){
        //ModelMap具体的类:输出modelMap对象类名 org.springframework.validation.support.BindingAwareModelMap
        System.out.println(modelMap.getClass().getName());
        modelMap.addAttribute("testRequestScope","helloModelMap");
        return "hello";
    }
    //使用Map共享数据
    @RequestMapping("test/map")
    public String testMap(Map<String,Object> map){
        //Map接口:输出map对象类名 org.springframework.validation.support.BindingAwareModelMap
        System.out.println(map.getClass().getName());
        map.put("testRequestScope","helloMap");
        return "hello";
    }
    //servletAPI向session域共享数据
    @RequestMapping("/test/session")
    public String testSession(HttpSession session){
        session.setAttribute("testSessionScope","helloSession");
        return "hello";
    }
    //servletAPI向application域共享数据
    @RequestMapping("/test/application")
    public String testApplication(HttpSession session){
        ServletContext servletContext = session.getServletContext();
        servletContext.setAttribute("testApplicationScope", "helloApplication");
        return "hello";
    }
}
