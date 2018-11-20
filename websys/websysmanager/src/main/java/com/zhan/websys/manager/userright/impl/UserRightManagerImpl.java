package com.zhan.websys.manager.userright.impl;

import com.zhan.websys.dao.userright.UserRightMapper;
import com.zhan.websys.entity.userright.UserRight;
import com.zhan.websys.manager.base.impl.BaseManagerImpl;
import com.zhan.websys.manager.userright.UserRightManager;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author zhanxp
 * @version 1.0 2018/11/19
 */
@Component
public class UserRightManagerImpl extends BaseManagerImpl<UserRightMapper, UserRight> implements UserRightManager {

    @Override
    public Set<String> getRightIdByRole(String userId) {
        UserRight userRight = new UserRight();
        userRight.setUserId(userId);
        return mapper.find(userRight).stream().map(UserRight::getOperationId).collect(Collectors.toSet());
    }
}
