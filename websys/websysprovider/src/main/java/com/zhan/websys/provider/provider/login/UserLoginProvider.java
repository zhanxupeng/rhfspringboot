package com.zhan.websys.provider.provider.login;

import com.alibaba.dubbo.config.annotation.Service;
import com.alibaba.dubbo.rpc.RpcContext;
import com.zhan.websys.api.login.UserLoginApi;
import com.zhan.websys.api.login.vo.LoginVO;
import com.zhan.websys.bo.userlogin.LoginBO;
import com.zhan.websys.common.bean.ResultContext;
import com.zhan.websys.provider.provider.BaseProvider;
import com.zhan.websys.service.userlogin.UserLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author zhanxp
 * @version 1.0 2018/11/8
 */
@Service(interfaceClass = UserLoginApi.class)
@Component
public class UserLoginProvider extends BaseProvider implements UserLoginApi {
    @Autowired
    private UserLoginService userLoginService;

    @Override
    public ResultContext<Boolean> ifNeetCaptcha(String loginId) {
        return success(userLoginService.ifNeetCaptcha(loginId));
    }

    @Override
    public ResultContext<LoginVO> login(String loginId, String password) {
        LoginBO loginBO = userLoginService.login(loginId, password, RpcContext.getContext().getRemoteHost());

        LoginVO loginVO = new LoginVO();
        loginVO.setUrid(loginBO.getUrid());
        loginVO.setLoginId(loginBO.getLoginId());
        loginVO.setName(loginBO.getName());
        loginVO.setNeedChangPassWord(loginBO.getNeedChangPassWord());
        return success(loginVO);
    }
}
