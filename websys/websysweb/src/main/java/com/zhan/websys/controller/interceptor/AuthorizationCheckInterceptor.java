package com.zhan.websys.controller.interceptor;

import cn.hutool.json.JSONUtil;
import com.zhan.websys.api.base.ResultContext;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author zhanxp
 * @version 1.0 2018/10/24
 */
public class AuthorizationCheckInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String servletPath = request.getServletPath();
        //判断用户是否有该路径的权限
        boolean b = Math.random() > 0.5;

        if (b) {
            return true;
        } else {
            ResultContext resultContext = ResultContext.systemException("很抱歉，您没有操作该功能的权限!");
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write(JSONUtil.toJsonStr(resultContext));
            return false;
        }
    }
}
