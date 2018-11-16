package com.zhan.websys.api.enumpath.vo;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @author zhanxp
 * @version 1.0 2018/11/15
 */
@Getter
@Setter
public class DropDownVO implements Serializable {
    private static final long serialVersionUID = -1770559331751045429L;
    private String value;
    private String label;
}
