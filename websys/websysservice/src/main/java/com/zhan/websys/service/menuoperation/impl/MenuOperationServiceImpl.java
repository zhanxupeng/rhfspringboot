package com.zhan.websys.service.menuoperation.impl;

import com.zhan.websys.entity.menuoperation.MenuOperation;
import com.zhan.websys.manager.menuoperation.MenuOperationManager;
import com.zhan.websys.service.menuoperation.MenuOperationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author zhanxp
 * @version 1.0  2018/11/25
 * @Description todo
 */
@Service
public class MenuOperationServiceImpl implements MenuOperationService {
    @Autowired
    private MenuOperationManager menuOperationManager;

    @Override
    public void add(MenuOperation menuOperation) {
        menuOperationManager.insert(menuOperation);
    }
}
