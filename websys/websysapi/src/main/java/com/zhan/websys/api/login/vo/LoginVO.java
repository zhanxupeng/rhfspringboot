package com.zhan.websys.api.login.vo;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @author zhanxp
 * @version 1.0 2018/11/8
 */
@Getter
@Setter
public class LoginVO implements Serializable {
    private String urid;
    private String loginId;
    private String name;
    private Boolean needChangPassWord;
}
