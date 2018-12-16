package com.zhan.websys.common.enums;

import com.zhan.common.enums.LabelAndValue;
import com.zhan.common.exception.BusinessException;

import java.util.Arrays;

/**
 * @author zhanxp
 * @version 1.0  2018/12/16
 * @Description todo
 */
public enum ENMenuOperationActiveFlag implements LabelAndValue<String> {
    NO("0", "否"),
    YES("1", "是");
    private String value;
    private String label;

    ENMenuOperationActiveFlag(String value, String label) {
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

    public static String getLabelByValue(String value) {
        return Arrays.stream(ENMenuOperationActiveFlag.values()).filter(x -> x.value.equals(value))
                .findAny().orElseThrow(() -> new BusinessException(ENConstants.NOT_FOUND)).label;
    }
}