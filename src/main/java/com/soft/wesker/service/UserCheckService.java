package com.soft.wesker.service;

import com.soft.wesker.dao.TUser;
import com.soft.wesker.dao.UserCheckDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserCheckService {

    @Resource
    private UserCheckDao userCheckDao;

    //验证账号密码
    public boolean checkLogin(String userName, String passWrod) {
        //获取用户信息
        TUser tUser = userCheckDao.checkUserName(userName);
        if (tUser != null && tUser.getUserName().equals(userName)) {
            if (tUser.getPassWord().equals(passWrod)) {
                return true;
            }
        }
        return false;
    }

    //注册功能
    public boolean checkRegister(String userName, String passWord, String againpassWord,String option,String optionText) {
        //获取用户信息
        TUser tUser = userCheckDao.checkUserName(userName);
        if (tUser == null && passWord.equals(againpassWord)) {
            boolean result = userCheckDao.registerUser(userName, passWord,option,optionText);
            return result;
        }
        return false;
    }

    //修改密码
    public boolean changeUser(String userName, String oldPassWord, String newPassWord,String againNewPassWord) {
        //获取用户信息
        TUser tUser = userCheckDao.checkUserName(userName);
        if (tUser == null) return false;

        if (userName.equals(tUser.getUserName()) && oldPassWord.equals(tUser.getPassWord())) {
            boolean result = userCheckDao.changeUserName(userName, newPassWord);
            return result;
        }
        return false;
    }

    //找回密码
    public boolean findUser(String userName, String passWord, String againpassWord,String option,String optionText) {
        //获取用户信息
        TUser tUser = userCheckDao.findUserName(userName,option,optionText);
        if (tUser != null && passWord.equals(againpassWord)) {
            boolean result = userCheckDao.findChangeUser(userName, passWord);
            return result;
        }
        return false;
    }
}
