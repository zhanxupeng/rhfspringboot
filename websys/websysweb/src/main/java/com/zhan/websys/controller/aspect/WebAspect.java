package com.zhan.websys.controller.aspect;

import com.alibaba.dubbo.rpc.RpcContext;
import com.zhan.common.enums.ENMsgCode;
import com.zhan.common.exception.BusinessException;
import com.zhan.common.exception.SystemException;
import com.zhan.common.loginuser.UserContext;
import com.zhan.common.loginuser.UserInfo;
import com.zhan.websys.api.base.ResultContext;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.Map;

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
            if (UserContext.hasUserInfo()) {
                UserInfo userInfo = UserContext.getUserInfo();
                Map<String, String> attachments = RpcContext.getContext().getAttachments();
                attachments.put(UserContext.USER_ID, userInfo.getUserId());
                attachments.put(UserContext.LOGIN_ID, userInfo.getLoginId());
                attachments.put(UserContext.USER_NAME, userInfo.getUserName());
                attachments.put(UserContext.TENANT_ID, userInfo.getTenantIds());
            }

            resultContext = (ResultContext) pjp.proceed();

        } catch (Throwable e) {
            e.printStackTrace();
            throw new SystemException("严重错误");
        }

        if (ENMsgCode.isBusinessError(resultContext.getCode())) {
            throw new BusinessException(resultContext.getInfo());
        }

        if (ENMsgCode.isSysException(resultContext.getCode())) {
            throw new SystemException(resultContext.getInfo());
        }
        return resultContext;
    }
}
