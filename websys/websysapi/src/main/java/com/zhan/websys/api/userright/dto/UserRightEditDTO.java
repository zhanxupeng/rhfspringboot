package com.zhan.websys.api.userright.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @author zhanxp
 * @version 1.0  2018/11/25
 * @Description todo
 */
@Getter
@Setter
public class UserRightEditDTO {
    private List<String> operationIdList;
}
