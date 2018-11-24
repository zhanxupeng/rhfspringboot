package com.zhan.websys.controller.configuration;

import com.zhan.common.exception.BusinessException;
import com.zhan.common.exception.SystemException;
import com.zhan.websys.api.base.ResultContext;
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
    @ExceptionHandler(value = {BusinessException.class, IllegalArgumentException.class})
    public ResultContext handleBusinessException(Exception e) {
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
