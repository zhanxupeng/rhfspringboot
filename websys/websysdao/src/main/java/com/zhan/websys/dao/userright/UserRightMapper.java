package com.zhan.websys.dao.userright;

import com.zhan.websys.dao.base.BaseMapper;
import com.zhan.websys.entity.userright.UserRight;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserRightMapper extends BaseMapper<UserRight> {
    int deleteByUserAndRight(@Param("userId") String userId,
                             @Param("operationId") String operationId);
}