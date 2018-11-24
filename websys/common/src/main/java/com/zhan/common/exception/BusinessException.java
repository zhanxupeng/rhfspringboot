package com.zhan.common.exception;


import com.zhan.common.enums.ENMsgCode;

/**
 * @author zhanxp
 * @version 1.0 2018/11/8
 */
public class BusinessException extends BaseRuntimeException {
    public BusinessException(String message) {
        super(ENMsgCode.BUSINESS_ERROR.getValue(), message);
    }

    public BusinessException(Throwable throwable) {
        super(ENMsgCode.BUSINESS_ERROR.getValue(), throwable);
    }

    public BusinessException(String message, Throwable throwable) {
        super(ENMsgCode.BUSINESS_ERROR.getValue(), message, throwable);
    }
}
