package com.zhan.websys.dao.user;

import com.zhan.websys.dao.base.BaseMapper;
import com.zhan.websys.entity.user.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<User> {
}