package com.bc.controller;

import com.bc.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
//@RestController=@Controller+@ResponseBody
//添加该注解后,相当于把类中的每一个方法都加上了@ResponseBody
@RequestMapping("/test")
public class AjaxController {
@RequestMapping("/ajax")
    public void testAjax(Integer id, HttpServletResponse response,@RequestBody String requestBody) throws IOException {
    System.out.println("id:"+id);
    System.out.println("requestBody:"+requestBody);
    response.getWriter().write("hello,axios");
}
@RequestMapping("/RequestBody/json")
    public void testRequestBody(@RequestBody User user,HttpServletResponse response) throws IOException {
    System.out.println("user:"+user);
    response.getWriter().write("hello,RequestBody");
}
//浏览器发送的请求没写/ 请求映射也不用写/
@RequestMapping("ResponseBody")
@ResponseBody
    public String testResponseBody(){
    return "啊哈哈哈哈";
}
@RequestMapping("/ResponseBodyJson")
    @ResponseBody
    public User testResponseBodyJson(){
    User user=new User(1001,"admin","123456",20,"女");
    return user;
}
@RequestMapping("/ResponseBodyJsonUseMap")
    @ResponseBody
    public Map<String,Object> testResponseBodyUseMap(){
    User user1=new User(1, "user1", "123456", 20, "女");
    User user2=new User(2, "user2", "123456", 20, "女");
    User user3=new User(3, "user3", "123456", 20, "女");
    User user4=new User(4, "user4", "123456", 20, "女");
    User user5=new User(5, "user5", "123456", 20, "女");
    Map<String,Object> map=new HashMap<>();
    map.put("user1", user1);
    map.put("user2", user2);
    map.put("user3", user3);
    map.put("user4", user4);
    map.put("user5", user5);
    return map;
}
@RequestMapping("/ResponseBodyJsonUseList")
    @ResponseBody
    public List<User> testResponseBodyUseList(){
    User user1=new User(1, "user1", "123456", 20, "女");
    User user2=new User(2, "user2", "123456", 20, "女");
    User user3=new User(3, "user3", "123456", 20, "女");
    User user4=new User(4, "user4", "123456", 20, "女");
    User user5=new User(5, "user5", "123456", 20, "女");
//    List<User> userList=new ArrayList<>();
    List<User> asList = Arrays.asList(user1, user2, user3, user4, user5);
    return asList;
}
}
