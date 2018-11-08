package com.zhan.websys.common.enums;

/**
 * 消息代码
 */
public enum ENMsgCode implements LabelAndValue<String> {
    /**
     * 请求操作成功【0】
     */
    SUCCESS("0", "成功"),
    /**
     * 业务错误【1】
     */
    BUSINESS_ERROR("1", "业务异常"),
    /**
     * 系统异常【2】
     */
    SYSTEM_EXCEPTION("2", "系统异常");

    private String value;
    private String label;

    ENMsgCode(String value, String label) {
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
