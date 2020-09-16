package com.soft.wesker.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TUserMapper {
    //    @Select("select * from t_user where id = #{id}")
    //验证用户
    TUser checkUserName(@Param("userName") String userName);

    //验证用户
    TUser finkUser(@Param("userName") String userName
                    ,@Param("option") String option
                    ,@Param("optionText") String optionText);

    //注册用户
    void registerUser(TUser tUsers);

    //修改密码
    void changeUser(TUser tUsers);
}
