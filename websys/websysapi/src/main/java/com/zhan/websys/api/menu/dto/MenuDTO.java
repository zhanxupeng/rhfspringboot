package com.zhan.websys.api.menu.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @author zhanxp
 * @version 1.0  2018/11/24
 * @Description todo
 */
@Getter
@Setter
public class MenuDTO implements Serializable {
    private String parentId;
    private String code;
    private String name;
}
