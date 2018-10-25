package com.zhan.websys.common.enums;

/**
 * @author zhanxp
 * @version 1.0 2018/10/25
 */
public enum ENYesOrNo implements LabelAndValue<String> {
    /**
     * 是否
     */
    NO("0", "否"),
    YES("1", "是");
    private String value;
    private String label;

    ENYesOrNo(String value, String label) {
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
