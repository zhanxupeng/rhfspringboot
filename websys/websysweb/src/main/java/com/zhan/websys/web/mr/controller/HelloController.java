package com.zhan.websys.web.mr.controller;

import com.zhan.websys.common.bean.ResultContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhanxp
 * @version 1.0  2018/10/14
 * @Description todo
 */
@RestController
@RequestMapping("/hello")
public class HelloController {
    @GetMapping("/test.pub")
    public ResultContext hello() {
        return ResultContext.success();
    }
}
