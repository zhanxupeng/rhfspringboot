package com.zhan.websys.api.userright;

import com.zhan.websys.api.base.ResultContext;
import com.zhan.websys.api.userright.dto.UserRightEditDTO;

/**
 * @author zhanxp
 * @version 1.0  2018/11/25
 * @Description todo
 */
public interface UserRightApi {
    ResultContext<Void> edit(UserRightEditDTO userRightEditDTO);
}
