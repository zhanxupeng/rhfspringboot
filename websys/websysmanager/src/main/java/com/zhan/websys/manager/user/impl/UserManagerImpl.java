package com.zhan.websys.manager.user.impl;

import cn.hutool.core.collection.CollectionUtil;
import com.zhan.websys.common.enums.ENLockStatus;
import com.zhan.websys.common.exception.SystemException;
import com.zhan.websys.dao.user.UserMapper;
import com.zhan.websys.entity.user.User;
import com.zhan.websys.manager.base.impl.BaseManagerImpl;
import com.zhan.websys.manager.user.UserManager;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author zhanxp
 * @version 1.0  2018/11/17
 * @Description todo
 */
@Component
public class UserManagerImpl extends BaseManagerImpl<UserMapper, User> implements UserManager {
    @Override
    public User getByLoginId(String loginId) {
        User user = new User();
        user.setLoginId(loginId);
        List<User> list = mapper.find(user);
        return CollectionUtil.isEmpty(list) ? null : list.get(0);
    }

    @Override
    public void lock(String urid) {
        User user = new User();
        user.setUrid(urid);
        user.setLockStatus(ENLockStatus.LOCKED.getValue());
        user.edit();
        int update = mapper.update(user);
        if (update != 1) {
            throw new SystemException("更新记录失败");
        }
    }
}
