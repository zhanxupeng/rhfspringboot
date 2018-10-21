package com.zhan.websys.dao.customer;

import com.zhan.websys.entity.customer.Customer;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface CustomerMapper {
    int insert(Customer record);

    Customer selectByPrimaryKey(@Param("urid") String urid);

    int updateByPrimaryKeySelective(Customer record);
}