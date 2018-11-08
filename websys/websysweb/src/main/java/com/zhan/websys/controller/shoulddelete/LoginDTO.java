package com.zhan.websys.controller.shoulddelete;

import lombok.Getter;
import lombok.Setter;

/**
 * @author zhanxp
 * @version 1.0  2018/10/21
 * @Description todo
 */
@Getter
@Setter
public class LoginDTO {
    private String loginId;
    private String password;
    private String captchaText;
}
