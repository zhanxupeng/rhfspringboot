package com.zhan.websys.dao.enumpath;

import com.zhan.websys.entity.enumpath.EnumPath;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface EnumPathMapper {

    int insert(EnumPath record);

    EnumPath selectByPrimaryKey(String urid);

    int updateByPrimaryKeySelective(EnumPath record);

    EnumPath getByCode(@Param("code") String code);
}