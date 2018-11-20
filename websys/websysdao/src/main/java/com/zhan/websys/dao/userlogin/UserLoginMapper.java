package com.zhan.websys.dao.userlogin;

import com.zhan.websys.entity.userlogin.UserLogin;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserLoginMapper {
    int insert(UserLogin record);

    UserLogin getById(String urid);

    int update(UserLogin record);

    List<UserLogin> find(UserLogin userLogin);
}