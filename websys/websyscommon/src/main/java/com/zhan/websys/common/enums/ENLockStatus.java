package com.zhan.websys.common.enums;

import cn.hutool.core.util.StrUtil;
import com.zhan.common.enums.LabelAndValue;
import com.zhan.common.exception.BusinessException;

import java.util.Arrays;

public enum ENLockStatus implements LabelAndValue<String> {
    /**
     * 正常【0】
     */
    NORMAL("0", "正常"),

    /**
     * 锁定【1】
     */
    LOCKED("1", "锁定");

    private String value;
    private String label;

    ENLockStatus(String value, String label) {
        this.value = value;
        this.label = label;
    }

    @Override
    public String getValue() {
        return this.value;
    }

    @Override
    public String getLabel() {
        return this.label;
    }

    public static String getLabelByValue(String value) {
        return StrUtil.isBlank(value) ? null : Arrays.stream(ENLockStatus.values()).filter(x -> x.value.equals(value)).findAny()
                .orElseThrow(() -> new BusinessException("出现未知枚举值")).label;
    }

    public static boolean isLocked(String value) {
        return LOCKED.value.equals(value);
    }
}
