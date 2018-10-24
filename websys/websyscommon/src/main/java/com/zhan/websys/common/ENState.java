package com.zhan.websys.common;

import com.zhan.websys.common.enums.LabelAndValue;

/**
 * @author zhanxp
 * @version 1.0 2018/10/24
 */
public enum ENState implements LabelAndValue<String> {
    /**
     * 状态
     */
    CLOSE("0", "关闭"),
    OPEN("1", "开启");
    private String value;
    private String label;

    ENState(String value, String label) {
        this.value = value;
        this.label = label;
    }

    @Override
    public String getValue() {
        return value;
    }

    @Override
    public String getLabel() {
        return label;
    }
}
