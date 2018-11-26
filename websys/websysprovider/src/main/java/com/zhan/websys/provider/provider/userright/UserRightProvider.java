package com.zhan.websys.provider.provider.userright;

import com.zhan.websys.api.base.ResultContext;
import com.zhan.websys.api.userright.UserRightApi;
import com.zhan.websys.api.userright.dto.UserRightEditDTO;
import com.zhan.websys.provider.provider.BaseProvider;
import com.zhan.websys.service.userright.UserRightService;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author zhanxp
 * @version 1.0  2018/11/25
 * @Description todo
 */
@Getter
@Setter
public class UserRightProvider extends BaseProvider implements UserRightApi {

    @Autowired
    private UserRightService userRightService;

    @Override
    public ResultContext<Void> edit(UserRightEditDTO userRightEditDTO) {
        userRightService.edit(userRightEditDTO.getOperationIdList());
        return success();
    }
}
