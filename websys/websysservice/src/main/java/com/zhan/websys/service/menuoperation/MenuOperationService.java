package com.zhan.websys.service.menuoperation;

import com.zhan.websys.bo.treeparser.TreeNodeBO;

import java.util.List;

/**
 * @author zhanxp
 * @version 1.0 2018/11/26
 */
public interface MenuOperationService {
    List<TreeNodeBO> getOperationNode();
}
