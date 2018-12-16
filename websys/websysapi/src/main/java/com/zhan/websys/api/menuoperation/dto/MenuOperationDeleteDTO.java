package com.zhan.websys.api.menuoperation.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @author zhanxp
 * @version 1.0  2018/12/16
 * @Description todo
 */
@Getter
@Setter
public class MenuOperationDeleteDTO implements Serializable {
    private String urid;
    private Long version;
}
