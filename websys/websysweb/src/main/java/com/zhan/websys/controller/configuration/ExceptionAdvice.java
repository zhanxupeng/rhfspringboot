package com.zhan.websys.controller.configuration;

import com.zhan.websys.common.bean.ResultContext;
import com.zhan.websys.common.exception.BusinessException;
import com.zhan.websys.common.exception.SystemException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author zhanxp
 * @version 1.0  2018/11/17
 * @Description todo
 */
@ControllerAdvice
public class ExceptionAdvice {
    @ExceptionHandler({BusinessException.class, IllegalArgumentException.class})
    @ResponseBody
    public ResultContext<Void> handBusException(Exception e) throws Exception {
        return ResultContext.businessFail(e.getMessage());
    }

    @ExceptionHandler({SystemException.class})
    @ResponseBody
    public ResultContext<Void> handSysException(SystemException e) throws Exception {
        return ResultContext.businessFail(e.getMessage());
    }

    @ExceptionHandler({Exception.class})
    @ResponseBody
    public ResultContext<Void> handSysException(Exception e) throws Exception {
        e.printStackTrace();
        return ResultContext.businessFail("严重错误");
    }
}
