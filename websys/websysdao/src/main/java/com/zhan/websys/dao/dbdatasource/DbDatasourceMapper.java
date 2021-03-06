package com.zhan.websys.dao.dbdatasource;

import com.zhan.websys.entity.dbdatasource.DbDatasource;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DbDatasourceMapper {
    int insert(DbDatasource record);

    DbDatasource getById(String databaseKey);

    int update(DbDatasource record);

    List<DbDatasource> findAll();
}