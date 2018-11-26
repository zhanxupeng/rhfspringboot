package com.zhan.websys.service.userright.impl;

import com.zhan.common.loginuser.UserContext;
import com.zhan.websys.entity.userright.UserRight;
import com.zhan.websys.manager.userright.UserRightManager;
import com.zhan.websys.service.userright.UserRightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author zhanxp
 * @version 1.0  2018/11/25
 * @Description todo
 */
@Service
public class UserRightServiceImpl implements UserRightService {
    @Autowired
    private UserRightManager userRightManager;

    @Override
    public void edit(List<String> operationIdList) {
        String userId = UserContext.getUserId();
        Set<String> originOperationIds = userRightManager.getRightIdByUser(userId);

        //新增的
        List<String> addList = operationIdList.stream().filter(x -> !originOperationIds.contains(x)).collect(Collectors.toList());

        //删除的
        List<String> deleteList = originOperationIds.stream().filter(x -> !operationIdList.contains(x)).collect(Collectors.toList());

        userRightManager.editUserRight(addList, deleteList, userId);
    }


}
