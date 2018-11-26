package com.zhan.websys.manager.userright.impl;

import cn.hutool.core.collection.CollectionUtil;
import com.zhan.common.exception.SystemException;
import com.zhan.websys.dao.userright.UserRightMapper;
import com.zhan.websys.entity.userright.UserRight;
import com.zhan.websys.manager.base.impl.BaseManagerImpl;
import com.zhan.websys.manager.userright.UserRightManager;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author zhanxp
 * @version 1.0 2018/11/19
 */
@Component
public class UserRightManagerImpl extends BaseManagerImpl<UserRightMapper, UserRight> implements UserRightManager {

    @Override
    public Set<String> getRightIdByUser(String userId) {
        UserRight userRight = new UserRight();
        userRight.setUserId(userId);
        return mapper.find(userRight).stream().map(UserRight::getOperationId).collect(Collectors.toSet());
    }

    @Override
    @Transactional
    public void editUserRight(List<String> addList, List<String> deleteList, String userId) {
        if (CollectionUtil.isNotEmpty(addList)) {
            addList.forEach(x -> {
                UserRight userRight = new UserRight();
                userRight.setUserId(userId);
                userRight.setOperationId(x);
                insert(userRight);
            });
        }

        if (CollectionUtil.isNotEmpty(deleteList)) {
            deleteList.forEach(x -> {
                int delete = mapper.deleteByUserAndRight(userId, x);
                if (delete != 1) {
                    throw new SystemException("删除数据异常");
                }
            });
        }
    }
}
