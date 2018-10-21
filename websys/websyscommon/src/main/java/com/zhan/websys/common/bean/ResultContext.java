package com.zhan.websys.common.bean;

import com.zhan.websys.common.enums.ENMsgCode;

import java.io.Serializable;
public class ResultContext implements Serializable {
    private final static String SUCCESS = "操作成功";
    private static final long serialVersionUID = 5856432252782588227L;

    /**
     * 状态码，对应枚举ENMsgCode
     * 0：请求操作成功
     * 1：业务错误
     * 2：系统异常
     * 3：未登录
     * 4：session超时
     * 5：没有权限
     */
    private String code;

    /**
     * 提示信息
     */
    private String info;

    /**
     * 需要返回的数据
     */
    private Object data;

    public static ResultContext success() {
        ResultContext resultContext = new ResultContext();
        resultContext.setCode(ENMsgCode.SUCCESS.getValue());
        resultContext.setInfo(SUCCESS);
        return resultContext;
    }

    public static ResultContext success(Object t) {
        ResultContext resultContext = new ResultContext();
        resultContext.setCode(ENMsgCode.SUCCESS.getValue());
        resultContext.setData(t);
        resultContext.setInfo(SUCCESS);
        return resultContext;
    }

    public static ResultContext businessFail(String info) {
        ResultContext resultContext = new ResultContext();
        resultContext.setCode(ENMsgCode.BUSINESS_ERROR.getValue());
        resultContext.setInfo(info);
        return resultContext;
    }

    public static ResultContext systemException(String info) {
        ResultContext resultContext = new ResultContext();
        resultContext.setCode(ENMsgCode.SYSTEM_EXCEPTION.getValue());
        resultContext.setInfo(info);
        return resultContext;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
