package com.zhan.websys.api.menu.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @author zhanxp
 * @version 1.0  2018/12/2
 * @Description todo
 */
@Getter
@Setter
public class MenuDeleteDTO implements Serializable {
    private String urid;
    private Integer version;
}
