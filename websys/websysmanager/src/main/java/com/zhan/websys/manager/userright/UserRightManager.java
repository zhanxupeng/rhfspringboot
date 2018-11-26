package com.zhan.websys.manager.userright;

import com.zhan.websys.entity.userright.UserRight;
import com.zhan.websys.manager.base.BaseManager;

import java.util.List;
import java.util.Set;

/**
 * @author zhanxp
 * @version 1.0 2018/11/19
 */
public interface UserRightManager extends BaseManager<UserRight> {
    Set<String> getRightIdByUser(String userId);

    void editUserRight(List<String> addList, List<String> deleteList, String userId);
}
