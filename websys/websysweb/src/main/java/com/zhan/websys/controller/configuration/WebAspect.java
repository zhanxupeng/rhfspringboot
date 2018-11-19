package com.zhan.websys.controller.configuration;

import com.zhan.websys.common.bean.ResultContext;
import com.zhan.websys.common.enums.ENMsgCode;
import com.zhan.websys.common.exception.BusinessException;
import com.zhan.websys.common.exception.SystemException;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * @author zhanxp
 * @version 1.0 2018/11/19
 */
@Aspect
@Component
public class WebAspect {

    @Around("execution(* com.zhan.websys.api..*.*(..))")
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        ResultContext resultContext;
        try {
            resultContext = (ResultContext) pjp.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            throw new SystemException("严重错误");
        }
        if (ENMsgCode.isBusinessError(resultContext.getCode())) {
            throw new BusinessException(resultContext.getInfo());
        }
        if (ENMsgCode.isSysException(resultContext.getCode())) {
            throw new SystemException("系统错误");
        }
        return resultContext;
    }

}
