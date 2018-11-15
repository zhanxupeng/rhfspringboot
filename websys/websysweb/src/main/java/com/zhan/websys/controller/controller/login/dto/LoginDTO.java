package com.zhan.websys.controller.controller.login.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * @author zhanxp
 * @version 1.0 2018/11/8
 */
@Getter
@Setter
public class LoginDTO {
    /**
     * 登录名
     */
    private String loginId;
    /**
     * 登录密码
     */
    private String password;
    /**
     * 验证码
     */
    private String captchaText;
}
