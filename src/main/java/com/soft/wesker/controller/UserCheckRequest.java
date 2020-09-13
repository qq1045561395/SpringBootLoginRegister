package com.soft.wesker.controller;


import com.soft.wesker.service.UserCheckService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/user")
public class UserCheckRequest {

    @Resource
    private UserCheckService userCheckService;

    //处理登录
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@RequestParam("username") String userName, @RequestParam("password") String passWord) {

        //检查账号密码
        if (userCheckService.checkLogin(userName, passWord)) {
            return "登录成功";
        }
        return "登录失败";
    }

    //处理注册
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String register(@RequestParam("username") String userName, @RequestParam("password") String passWord
            , @RequestParam("againpassword") String againpassWord
            ,@RequestParam("option") String option
            ,@RequestParam("optionText") String optionText) {
        if (userCheckService.checkRegister(userName, passWord, againpassWord,option,optionText)) {
            return "注册成功";
        }
        return "注册失败";

    }

    //修改密码
    @RequestMapping("/change")
    public String change(@RequestParam("username") String userName
            , @RequestParam("oldpassword") String oldPassWord
            , @RequestParam("newpassword") String newPassWord
            , @RequestParam("againnewpassword") String againNewPassWord) {

        if (userCheckService.changeUser(userName, oldPassWord, newPassWord,againNewPassWord)) {
            return "修改成功";
        }
        return "用户不存在或者原密码错误";

    }

    //找回密码
    @RequestMapping(value = "/find", method = RequestMethod.POST)
    public String Find(@RequestParam("username") String userName, @RequestParam("password") String passWord
            , @RequestParam("againpassword") String againpassWord
            ,@RequestParam("option") String option
            ,@RequestParam("optionText") String optionText) {
        if (userCheckService.findUser(userName, passWord, againpassWord,option,optionText)) {
            return "密码找回成功";
        }
        return "账号不存在或者密保错误";

    }
}
