package com.zhan.websys.provider.provider.menuoperation;

import cn.hutool.core.bean.BeanUtil;
import com.alibaba.dubbo.config.annotation.Service;
import com.zhan.websys.api.base.PageQueryDTO;
import com.zhan.websys.api.base.PageViewVO;
import com.zhan.websys.api.base.ResultContext;
import com.zhan.websys.api.menu.dto.MenuDeleteDTO;
import com.zhan.websys.api.menuoperation.MenuOperationApi;
import com.zhan.websys.api.menuoperation.dto.MenuOperationAddDTO;
import com.zhan.websys.api.menuoperation.dto.MenuOperationDTO;
import com.zhan.websys.api.menuoperation.dto.MenuOperationDeleteDTO;
import com.zhan.websys.api.menuoperation.dto.MenuOperationEditDTO;
import com.zhan.websys.api.menuoperation.vo.MenuOperationVO;
import com.zhan.websys.bo.base.PageView;
import com.zhan.websys.common.enums.ENMenuOperationActiveFlag;
import com.zhan.websys.entity.base.PageQuery;
import com.zhan.websys.entity.menuoperation.MenuOperation;
import com.zhan.websys.provider.provider.BaseProvider;
import com.zhan.websys.service.menuoperation.MenuOperationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

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

    @Override
    public ResultContext<PageViewVO<MenuOperationVO>> query(PageQueryDTO<MenuOperationDTO> pageQueryDTO) {
        PageView<MenuOperation> pageView = menuOperationService.query(convertToPageQuery(pageQueryDTO));

        return success(convertToPageViewVO(pageView));
    }

    @Override
    public ResultContext<Void> deletes(List<MenuOperationDeleteDTO> list) {
        List<MenuOperation> menuOperationList = list.stream().map(x -> {
            MenuOperation menuOperation = new MenuOperation();
            BeanUtil.copyProperties(x, menuOperation);
            return menuOperation;
        }).collect(Collectors.toList());

        menuOperationService.deletes(menuOperationList);
        return success();
    }

    @Override
    public ResultContext<MenuOperationVO> getById(String urid) {
        MenuOperation menuOperation = menuOperationService.getById(urid);
        MenuOperationVO menuOperationVO = new MenuOperationVO();
        BeanUtil.copyProperties(menuOperation, menuOperationVO);
        return success(menuOperationVO);
    }

    private PageViewVO<MenuOperationVO> convertToPageViewVO(PageView<MenuOperation> pageView) {
        List<MenuOperation> list = pageView.getData();
        List<MenuOperationVO> voList = list.stream().map(x -> {
            MenuOperationVO menuOperationVO = new MenuOperationVO();
            BeanUtil.copyProperties(x, menuOperationVO);
            menuOperationVO.setActiveFlagShow(ENMenuOperationActiveFlag.getLabelByValue(x.getActiveFlag()));
            return menuOperationVO;
        }).collect(Collectors.toList());

        PageViewVO<MenuOperationVO> pageViewVO = new PageViewVO<>();
        pageViewVO.setData(voList);
        pageViewVO.setTotal(pageView.getTotal());
        pageViewVO.setSize(pageView.getSize());
        return pageViewVO;
    }

    private PageQuery<MenuOperation> convertToPageQuery(PageQueryDTO<MenuOperationDTO> pageQueryDTO) {
        MenuOperationDTO menuOperationDTO = pageQueryDTO.getEntity();
        MenuOperation menuOperation = new MenuOperation();
        BeanUtil.copyProperties(menuOperationDTO, menuOperation);

        PageQuery<MenuOperation> pageQuery = new PageQuery<>();
        pageQuery.setPageNum(pageQueryDTO.getPageNum());
        pageQuery.setPageSize(pageQueryDTO.getPageSize());
        pageQuery.setSortType(pageQueryDTO.getSortType());
        pageQuery.setSortName(pageQueryDTO.getSortName());
        return pageQuery;
    }
}
