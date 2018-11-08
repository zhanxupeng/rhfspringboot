package com.zhan.websys.common.exception;

import com.zhan.websys.common.enums.ENMsgCode;

/**
 * @author zhanxp
 * @version 1.0 2018/11/8
 */
public class SystemException extends BaseRuntimeException {
    SystemException(String message) {
        super(ENMsgCode.SYSTEM_EXCEPTION.getValue(), message);
    }

    SystemException(Throwable throwable) {
        super(ENMsgCode.SYSTEM_EXCEPTION.getValue(), throwable);
    }

    SystemException(String message, Throwable throwable) {
        super(ENMsgCode.SYSTEM_EXCEPTION.getValue(), message, throwable);
    }
}
