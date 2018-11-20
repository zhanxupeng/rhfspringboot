package com.zhan.websys.bo.userlogin;

import lombok.Getter;
import lombok.Setter;

/**
 * @author zhanxp
 * @version 1.0  2018/11/17
 * @Description todo
 */
@Getter
@Setter
public class LoginBO {
    private String urid;
    private String loginId;
    private String name;
    private Boolean needChangPassWord;
}
