package com.zhan.websys.controller.shoulddelete;

import cn.hutool.core.util.StrUtil;
import com.google.code.kaptcha.Constants;
import com.google.code.kaptcha.Producer;
import com.zhan.websys.common.bean.ResultContext;
import com.zhan.websys.common.loginuser.UserInfo;
import com.zhan.websys.dao.configuration.DataSourceContextHolder;
import com.zhan.websys.entity.customer.Customer;
import com.zhan.websys.service.customer.CustomerService;
import com.zhan.websys.service.enumpath.EnumPathService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Date;

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
    @Autowired
    private EnumPathService enumPathService;
    @Autowired
    private Producer captchaProducer;

    @GetMapping("/getById.do")
    public Customer getById(String urid) {
        return customerService.getById(urid);
    }

    @PostMapping("/login.pub")
    public ResultContext login(LoginDTO loginDTO, HttpServletRequest request) {
        if (StrUtil.hasBlank(loginDTO.getLoginId(), loginDTO.getPassword())) {
            throw new RuntimeException("账号密码不能为空");
        }
        UserInfo userInfo = new UserInfo();
        userInfo.setLoginId(loginDTO.getLoginId());
        userInfo.setUserName("admin");
        userInfo.setNeedChangPassWord(Boolean.FALSE);
        request.getSession().setAttribute("user", userInfo);
        return ResultContext.success(userInfo);
    }

    @GetMapping("/getInfo.do")
    public ResultContext getInfo(HttpServletRequest request) {
        Object object = request.getSession().getAttribute("user");
        return ResultContext.success(object);
    }

    @GetMapping("/getDropDown.pub")
    public ResultContext getDropDown(String code) {
        DataSourceContextHolder.setSourceKey("sourceTwo");
        return ResultContext.success(enumPathService.getDropDown(code));
    }

    @PostMapping("ifNeetCaptcha.pub")
    public ResultContext ifNeetCaptcha(String loginId){
        return ResultContext.success(Boolean.TRUE);
    }

    /**
     * 生成带验证码的图片
     */
    @GetMapping(value = "/getCaptchaImage.pub")
    public void getCaptchaImage(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setDateHeader("Expires", 0);
        response.setHeader("Cache-Control", "no-store, no-cache, must-revalidate");
        response.addHeader("Cache-Control", "post-check=0, pre-check=0");
        response.setHeader("Pragma", "no-cache");
        response.setContentType("image/jpeg");
        String capText = captchaProducer.createText();

        request.getSession().setAttribute(Constants.KAPTCHA_SESSION_KEY, capText);
        request.getSession().setAttribute(Constants.KAPTCHA_SESSION_DATE, new Date());
        BufferedImage bi = captchaProducer.createImage(capText);
        try (ServletOutputStream out = response.getOutputStream()) {
            ImageIO.write(bi, "jpeg", out);
            out.flush();
        }
    }
}
