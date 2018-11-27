package com.zhan.websys.provider.provider.menuoperation;

import cn.hutool.core.bean.BeanUtil;
import com.alibaba.dubbo.config.annotation.Service;
import com.zhan.websys.api.base.ResultContext;
import com.zhan.websys.api.menuoperation.MenuOperationApi;
import com.zhan.websys.api.menuoperation.dto.MenuOperationAddDTO;
import com.zhan.websys.api.menuoperation.dto.MenuOperationEditDTO;
import com.zhan.websys.entity.menuoperation.MenuOperation;
import com.zhan.websys.provider.provider.BaseProvider;
import com.zhan.websys.service.menuoperation.MenuOperationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author zhanxp
 * @version 1.0  2018/11/25
 * @Description todo
 */
@Service(interfaceClass = MenuOperationApi.class)
@Component
public class MenuOperationProvider extends BaseProvider implements MenuOperationApi {
    @Autowired
    private MenuOperationService menuOperationService;

    @Override
    public ResultContext<Void> add(MenuOperationAddDTO menuOperationAddDTO) {
        MenuOperation menuOperation = new MenuOperation();
        BeanUtil.copyProperties(menuOperationAddDTO, menuOperation);
        menuOperationService.add(menuOperation);
        return success();
    }

    @Override
    public ResultContext<Void> edit(MenuOperationEditDTO menuOperationEditDTO) {
        MenuOperation menuOperation = new MenuOperation();
        BeanUtil.copyProperties(menuOperationEditDTO, menuOperation);
        menuOperationService.edit(menuOperation);
        return success();
    }
}
