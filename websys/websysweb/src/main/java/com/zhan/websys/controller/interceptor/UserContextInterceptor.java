package com.zhan.websys.controller.interceptor;

import cn.hutool.core.util.ObjectUtil;
import com.zhan.common.loginuser.UserContext;
import com.zhan.common.loginuser.UserInfo;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author zhanxp
 * @version 1.0 2018/10/24
 */
public class UserContextInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        UserInfo user = (UserInfo) request.getSession().getAttribute(UserContext.USER_SESSION);
//        if (ObjectUtil.isNull(user)) {
//            ResultContext resultContext = ResultContext.systemException("请求失败");
//            response.setContentType("application/json");
//            response.setCharacterEncoding("UTF-8");
//            response.getWriter().write(JSONUtil.toJsonStr(resultContext));
//            return false;
//        }
        if (ObjectUtil.isNotNull(user)) {
            UserContext.setUserInfo(user);
        }
        return true;
    }
}
