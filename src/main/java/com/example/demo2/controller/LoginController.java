package com.example.demo2.controller;

import com.example.demo2.entity.User;
import com.example.demo2.service.UserService;
import common.Msg;
import common.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;

@Controller
@RequestMapping("user")
public class LoginController {

    @Autowired
    private UserService userService;

    @RequestMapping("/toIndex")
    public String show(){
        return "index";
    }

    //登录操作
    @ResponseBody
    @RequestMapping(value = "/loginUser",method = RequestMethod.POST)
    public Msg login(@RequestBody @Valid User user, HttpServletRequest request) throws Exception {
        String userName = user.getUserName();
        String passWord = user.getPassword();
        User u1 =userService.login(userName,passWord);
        if (u1==null){
            Msg msg = ResultUtil.error(202,"账户密码错误");
            return msg;
        }else{
            //登录成功后将用户放入session中，用于拦截
            request.getSession().setAttribute("session_user",user);
            Msg msg = ResultUtil.success();
            return msg;
        }
    }

    //跳转注册页
    @RequestMapping("/toRegister")
    public String toRegister(){
        return "register";
    }

    //注册操作
    @RequestMapping("/register")
    public String register(User user){
        //TODO 判断user数据格式
        int su = userService.register(user);
        if(su==0){
            System.out.println("----");
        }
        return "welcome";
    }

    //测试未登陆拦截页面
    @RequestMapping("/welcome")
    public String welcome(){
        return "welcome";
    }

    //退出登录
    @RequestMapping("/outUser")
    public void outUser(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.getSession().removeAttribute("session_user");
        response.sendRedirect("/user/toIndex");
    }

}
