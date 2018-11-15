package com.zhan.websys.controller.controller.login;

import cn.hutool.core.lang.Assert;
import com.alibaba.dubbo.config.annotation.Reference;
import com.google.code.kaptcha.Constants;
import com.google.code.kaptcha.Producer;
import com.zhan.websys.api.login.UserLoginApi;
import com.zhan.websys.api.login.vo.LoginVO;
import com.zhan.websys.common.bean.ResultContext;
import com.zhan.websys.common.loginuser.UserContext;
import com.zhan.websys.common.loginuser.UserInfo;
import com.zhan.websys.controller.controller.base.BaseController;
import com.zhan.websys.controller.controller.login.dto.LoginDTO;
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
import java.util.Enumeration;

/**
 * @author zhanxp
 * @version 1.0 2018/11/8
 */
@RestController
@RequestMapping("/websys/userlogin")
public class UserLoginController extends BaseController {
    @Reference
    private UserLoginApi userLoginApi;
    @Autowired
    private Producer captchaProducer;

    @GetMapping("/test.pub")
    public ResultContext test() {
        return userLoginApi.ifNeetCaptcha("test");
    }

    @PostMapping("/login.pub")
    public ResultContext login(LoginDTO loginDTO, HttpServletRequest request) {
        Assert.notBlank(loginDTO.getLoginId(), "用户名不能为空！");
        Assert.notBlank(loginDTO.getPassword(), "密码不能为空！");

        //是否需要验证码
        boolean neetCaptcha = userLoginApi.ifNeetCaptcha(loginDTO.getLoginId()).getData();

        if (neetCaptcha) {
            Assert.notBlank(loginDTO.getCaptchaText(), "验证码不能为空！");
            String sessionCaptchaText = (String) request.getSession().getAttribute(Constants.KAPTCHA_SESSION_KEY);
            if (!loginDTO.getCaptchaText().equalsIgnoreCase(sessionCaptchaText)) {
                throw new IllegalArgumentException("验证码输入有误！");
            }
        }
        //输入完成后移除验证码
        request.getSession().removeAttribute(Constants.KAPTCHA_SESSION_KEY);

        LoginVO loginVO = userLoginApi.login(loginDTO.getLoginId(), loginDTO.getPassword()).getData();
        UserInfo userInfo = new UserInfo();
        userInfo.setUserId(loginVO.getUrid());
        userInfo.setLoginId(loginVO.getLoginId());
        userInfo.setUserName(loginVO.getName());
        request.getSession().setAttribute(UserContext.USER_SESSION, userInfo);
        return success(loginVO);
    }


    @PostMapping("/logout.pub")
    public ResultContext<Void> logout(HttpServletRequest request) {
        request.getSession().setAttribute(UserContext.USER_SESSION, null);
        Enumeration enumeration = request.getSession().getAttributeNames();
        while (enumeration.hasMoreElements()) {
            request.getSession().removeAttribute(enumeration.nextElement().toString());
        }
        return success();
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
