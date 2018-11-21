package com.zhan.websys.provider.aspect;

import com.alibaba.dubbo.rpc.RpcContext;
import com.zhan.websys.common.bean.ResultContext;
import com.zhan.websys.common.exception.BusinessException;
import com.zhan.websys.common.exception.SystemException;
import com.zhan.websys.common.loginuser.UserContext;
import com.zhan.websys.common.loginuser.UserInfo;
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
            //用户相关信息设置
            UserContext.remove();
            Map<String, String> attachments = RpcContext.getContext().getAttachments();
            if (attachments.get(UserContext.LOGIN_ID) != null) {
                UserInfo userInfo = new UserInfo();
                userInfo.setUserId(attachments.get(UserContext.USER_ID));
                userInfo.setLoginId(attachments.get(UserContext.LOGIN_ID));
                userInfo.setUserName(attachments.get(UserContext.USER_NAME));
                userInfo.setTenantIds(attachments.get(UserContext.TENANT_ID));
                System.out.println(userInfo);
                UserContext.setUserInfo(userInfo);
            }

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
