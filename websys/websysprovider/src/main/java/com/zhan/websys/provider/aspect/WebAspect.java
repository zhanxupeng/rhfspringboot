package com.zhan.websys.provider.aspect;

import com.zhan.websys.common.bean.ResultContext;
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
        } catch (BusinessException e) {
            e.printStackTrace();
            resultContext = ResultContext.businessFail(e.getMessage());
        } catch (SystemException e) {
            e.printStackTrace();
            resultContext = ResultContext.systemException("系统异常");
        } catch (Throwable e) {
            e.printStackTrace();
            resultContext = ResultContext.systemException("严重错误");
        }
        return resultContext;
    }
}
