package com.zhan.websys.service.userlogin.impl;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.crypto.digest.DigestUtil;
import com.zhan.websys.bo.userlogin.LoginBO;
import com.zhan.websys.common.enums.ENLockStatus;
import com.zhan.websys.common.enums.ENUserStatus;
import com.zhan.websys.common.exception.BusinessException;
import com.zhan.websys.common.loginuser.UserContext;
import com.zhan.websys.common.loginuser.UserInfo;
import com.zhan.websys.entity.user.User;
import com.zhan.websys.entity.userlogin.UserLogin;
import com.zhan.websys.manager.login.UserLoginManager;
import com.zhan.websys.manager.user.UserManager;
import com.zhan.websys.service.userlogin.UserLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @author zhanxp
 * @version 1.0  2018/11/17
 * @Description todo
 */
@Service
public class UserLoginServiceImpl implements UserLoginService {
    @Autowired
    private UserManager userManager;
    @Autowired
    private UserLoginManager userLoginManager;

    @Override
    public boolean ifNeetCaptcha(String loginId) {
        boolean needCaptcha = Boolean.TRUE;
        User user = userManager.getByLoginId(loginId);
        if (ObjectUtil.isNotNull(user)) {
            UserLogin userLogin = userLoginManager.getByUserId(user.getUrid());
            //第一次登录或者上一次登录成功的不需要验证码
            if (userLogin == null || userLogin.getLoginFailTimes() < 1) {
                needCaptcha = Boolean.FALSE;
            }
        }
        return needCaptcha;
    }

    @Override
    public LoginBO login(String loginId, String password, String loginIp) {
        LoginBO loginBO = new LoginBO();

        User user = userManager.getByLoginId(loginId);
        if (ObjectUtil.isNull(user)) {
            throw new BusinessException("用户不存在或密码错误！");
        }

        UserInfo userInfo = new UserInfo();
        userInfo.setUserId(user.getUrid());
        UserContext.setUserInfo(userInfo);

        switch (ENUserStatus.getByValue(user.getUserStatus())) {
            case LOG_OFF:
                throw new BusinessException("用户已被注销，无法登录！");
            case DISABLE:
                throw new BusinessException("用户已被冻结，请联系管理员激活！");
            default:
                break;
        }

        if (ENLockStatus.isLocked(user.getLockStatus())) {
            throw new BusinessException("用户已被锁定，请联系管理员解锁！");
        }

        UserLogin userLogin = userLoginManager.getByUserId(user.getUrid());
        if (ObjectUtil.isNull(userLogin)) {
            userLogin = new UserLogin();
            userLogin.setUserId(user.getUrid());
            userLogin.setLastLoginIp(loginIp);
            userLoginManager.add(userLogin);
        } else {
            //获取最后登录时间
            Date lastLoginDate = ObjectUtil.isNull(userLogin.getLastFailDate()) ? userLogin.getLastLoginDate() :
                    (userLogin.getLastLoginDate().after(userLogin.getLastFailDate()) ?
                            userLogin.getLastLoginDate() : userLogin.getLastFailDate());

            //若超过三个月(90天)未登录则锁定用户，不允许登录
            long betweenDay = DateUtil.betweenDay(lastLoginDate, new Date(), Boolean.TRUE);
            if (betweenDay >= 90) {
                userManager.lock(user.getUrid());
                //更新登录失败时间，防止无限被锁定
                userLogin.setLastFailDate(new Date());
                userLoginManager.edit(userLogin);
                throw new BusinessException("用户长时间未登录，已被锁定，请联系管理员解锁！");
            }

        }


        //判断密码
        String loginPassword = DigestUtil.sha256Hex(password + loginId).toUpperCase();
        //密码错误
        if (!user.getPassword().equalsIgnoreCase(loginPassword)) {
            //更新登录失败信息
            userLogin.setLoginFailTimes(userLogin.getLoginFailTimes() + 1);
            userLogin.setLastFailDate(new Date());
            userLoginManager.edit(userLogin);
            //密码错误超过五次
            if (userLogin.getLoginFailTimes() >= 5) {
                userManager.lock(user.getUrid());
                throw new BusinessException("密码错误次数过多，用户已被锁定！");
            }
            throw new BusinessException("用户不存在或密码错误！");
        }

        //初始密码需要强制修改密码
        if (loginPassword.equalsIgnoreCase(DigestUtil.sha256Hex(UserContext.DEFAULT_PWD + loginId))) {
            loginBO.setNeedChangPassWord(true);
        }

        //登录成功
        userLogin.setLoginFailTimes(0);
        userLogin.setLastLoginDate(new Date());
        userLoginManager.edit(userLogin);

        loginBO.setUrid(user.getUrid());
        loginBO.setLoginId(loginId);
        loginBO.setName(user.getName());
        return loginBO;
    }

    public static void main(String[] args) {
        System.out.println(DigestUtil.sha256Hex(UserContext.DEFAULT_PWD + "admin"));
    }
}
