package com.zhan.websys.service.customer;

import com.zhan.websys.entity.customer.Customer;

/**
 * @author zhanxp
 * @version 1.0  2018/10/21
 * @Description todo
 */
public interface CustomerService {

    Customer getById(String urid);
}
