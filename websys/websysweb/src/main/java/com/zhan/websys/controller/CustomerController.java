package com.zhan.websys.controller;

import cn.hutool.core.util.StrUtil;
import com.zhan.websys.common.bean.ResultContext;
import com.zhan.websys.entity.customer.Customer;
import com.zhan.websys.service.customer.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @author zhanxp
 * @version 1.0  2018/10/21
 * @Description todo
 */
@RestController
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @GetMapping("/getById.do")
    public Customer getById(String urid) {
        return customerService.getById(urid);
    }

    @PostMapping("/login.do")
    public ResultContext login(LoginDTO loginDTO, HttpServletRequest request) {
        if (StrUtil.hasBlank(loginDTO.getUserName(), loginDTO.getPassword())) {
            throw new RuntimeException("账号密码不能为空");
        }
        Map<String, String> map = new HashMap<>(3);
        map.put("userName", loginDTO.getUserName());
        map.put("password", loginDTO.getPassword());
        request.getSession().setAttribute("user", map);
        return ResultContext.success();
    }

    @GetMapping("/getInfo.do")
    public ResultContext getInfo(HttpServletRequest request) {
        Object object = request.getSession().getAttribute("user");
        return ResultContext.success(object);
    }
}
