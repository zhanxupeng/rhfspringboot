package com.zhan.websys.service.customer.impl;

import com.zhan.websys.dao.customer.CustomerMapper;
import com.zhan.websys.entity.customer.Customer;
import com.zhan.websys.service.customer.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author zhanxp
 * @version 1.0  2018/10/21
 * @Description todo
 */
@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerMapper customerMapper;

    @Override
    public Customer getById(String urid) {
        return customerMapper.selectByPrimaryKey(urid);
    }
}
