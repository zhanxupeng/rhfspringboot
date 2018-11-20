package com.zhan.websys.manager.user;

import com.zhan.websys.entity.user.User;
import com.zhan.websys.manager.base.BaseManager;

/**
 * @author zhanxp
 * @version 1.0  2018/11/17
 * @Description todo
 */
public interface UserManager extends BaseManager<User> {
    User getByLoginId(String loginId);

    void lock(String urid);
}
