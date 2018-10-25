package com.zhan.websys.dao.dbdatasource;

import com.zhan.websys.entity.dbdatasource.DbDatasource;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DbDatasourceMapper {
    int insert(DbDatasource record);

    DbDatasource selectByPrimaryKey(String databaseKey);

    int updateByPrimaryKeySelective(DbDatasource record);

    List<DbDatasource> findAll();
}