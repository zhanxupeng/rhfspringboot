package com.zhan.websys.provider.provider.menu;

import cn.hutool.core.collection.CollectionUtil;
import com.alibaba.dubbo.config.annotation.Service;
import com.zhan.websys.api.menu.MenuApi;
import com.zhan.websys.api.menu.vo.TreeNodeVO;
import com.zhan.websys.bo.treeparser.TreeNodeBO;
import com.zhan.websys.common.bean.ResultContext;
import com.zhan.websys.provider.provider.BaseProvider;
import com.zhan.websys.service.menu.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author zhanxp
 * @version 1.0 2018/11/20
 */
@Service(interfaceClass = MenuApi.class)
@Component
public class MenuProvider extends BaseProvider implements MenuApi {
    @Autowired
    private MenuService menuService;

    @Override
    public ResultContext<List<TreeNodeVO>> queryForDisplay() {
        List<TreeNodeBO> list = menuService.queryForDisplay();

        return success(convertToTreeNodeVO(list));
    }

    private List<TreeNodeVO> convertToTreeNodeVO(List<TreeNodeBO> list) {
        return list.stream().map(x -> {
            TreeNodeVO treeNodeVO = new TreeNodeVO();
            treeNodeVO.setTitle(x.getTitle());
            treeNodeVO.setPid(x.getPid());
            treeNodeVO.setChecked(x.getChecked());
            if (CollectionUtil.isNotEmpty(x.getChildren())) {
                treeNodeVO.setChildren(convertToTreeNodeVO(x.getChildren()));
            }
            return treeNodeVO;
        }).collect(Collectors.toList());

    }
}
