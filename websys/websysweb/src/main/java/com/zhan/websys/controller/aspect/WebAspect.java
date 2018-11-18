package com.zhan.websys.controller.aspect;

import com.zhan.websys.common.bean.ResultContext;
import com.zhan.websys.common.enums.ENMsgCode;
import com.zhan.websys.common.exception.BusinessException;
import com.zhan.websys.common.exception.SystemException;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 *
 */
@Aspect
@Component
public class WebAspect {

    @Around("execution(* com.zhan.websys.api..*.*(..))")
    public Object exceptionHandle(ProceedingJoinPoint pjp) {
        ResultContext resultContext;

        try {
            resultContext = (ResultContext) pjp.proceed();
        } catch (Throwable e) {
            e.printStackTrace();
            throw new SystemException("严重错误");
        }

        if (ENMsgCode.isBusException(resultContext.getCode())) {
            throw new BusinessException(resultContext.getInfo());
        }

        if (ENMsgCode.isSysException(resultContext.getCode())) {
            throw new SystemException(resultContext.getInfo());
        }
        return resultContext;
    }
}
