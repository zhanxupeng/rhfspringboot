package com.zhan.websys.provider.provider.login;

import com.alibaba.dubbo.config.annotation.Service;
import com.zhan.websys.api.login.UserLoginApi;
import com.zhan.websys.api.login.vo.LoginVO;
import com.zhan.websys.common.bean.ResultContext;
import com.zhan.websys.provider.provider.BaseProvider;
import org.springframework.stereotype.Component;

/**
 * @author zhanxp
 * @version 1.0 2018/11/8
 */
@Service(interfaceClass = UserLoginApi.class)
@Component
public class UserLoginProvider extends BaseProvider implements UserLoginApi {
    @Override
    public ResultContext<Boolean> ifNeetCaptcha(String loginId) {
        return success(Boolean.TRUE);
    }

    @Override
    public ResultContext<LoginVO> login(String loginId, String password) {
        return null;
    }
}
