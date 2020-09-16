package com.soft.wesker.dao;


import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


@Repository
public class UserCheckDao {

    @Resource
    private TUserMapper tUserMapper;

    //获取用户信息
    @Transactional(propagation = Propagation.REQUIRES_NEW, isolation = Isolation.READ_COMMITTED, readOnly = true)
    public TUser checkUserName(String userName) {
        TUser tUsers = tUserMapper.checkUserName(userName);
        return tUsers;
    }

    //注册用户
    @Transactional
    public boolean registerUser(String userName, String passWord,String option,String optionText) {
        TUser tUser = new TUser();
        tUser.setUserName(userName)
                .setPassWord(passWord)
                .setProblem(option)
                .setProblemText(optionText);
        tUserMapper.registerUser(tUser);
        if (tUser.getId() != null) {
            return true;
        }
        return false;
    }

    @Transactional
    public boolean changeUserName(String userName, String NewPassWord) {
        TUser tUser = new TUser();
        tUser.setUserName(userName);
        tUser.setPassWord(NewPassWord);
        try {
            tUserMapper.changeUser(tUser);
        }catch (RuntimeException e){
            e.printStackTrace();
        }
        return true;
    }

    //找回密码
    @Transactional
    public TUser findUserName(String userName,String option,String optionText) {
        TUser tUsers = tUserMapper.finkUser(userName,option,optionText);
        return tUsers;
    }

    @Transactional
    public boolean findChangeUser(String userName, String passWord) {
        return changeUserName(userName,passWord);
    }
}
