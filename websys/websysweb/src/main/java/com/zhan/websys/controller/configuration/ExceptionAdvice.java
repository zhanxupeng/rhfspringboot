package com.zhan.websys.controller.configuration;

import com.zhan.websys.common.bean.ResultContext;
import com.zhan.websys.common.exception.BusinessException;
import com.zhan.websys.common.exception.SystemException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author zhanxp
 * @version 1.0 2018/11/19
 */
@ControllerAdvice
public class ExceptionAdvice {
    @ResponseBody
    @ExceptionHandler(value = BusinessException.class)
    public ResultContext handleBusinessException(BusinessException e) {
        return ResultContext.businessFail(e.getMessage());
    }

    @ResponseBody
    @ExceptionHandler(value = SystemException.class)
    public ResultContext handleSystemException(SystemException e) {
        e.printStackTrace();
        return ResultContext.systemException("系统错误");
    }

    @ResponseBody
    @ExceptionHandler(value = Exception.class)
    public ResultContext handleException(Exception e) {
        e.printStackTrace();
        return ResultContext.systemException("严重错误");
    }
}
