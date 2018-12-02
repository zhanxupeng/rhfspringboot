package com.zhan.websys.provider.provider.menu;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollectionUtil;
import com.alibaba.dubbo.config.annotation.Service;
import com.zhan.websys.api.base.PageQueryDTO;
import com.zhan.websys.api.base.PageViewVO;
import com.zhan.websys.api.base.ResultContext;
import com.zhan.websys.api.menu.MenuApi;
import com.zhan.websys.api.menu.dto.*;
import com.zhan.websys.api.menu.vo.MenuVO;
import com.zhan.websys.api.menu.vo.TreeNodeVO;
import com.zhan.websys.bo.base.PageView;
import com.zhan.websys.bo.treeparser.TreeNodeBO;
import com.zhan.websys.common.enums.ENMenuActiveFlag;
import com.zhan.websys.common.enums.ENMenuShowFlag;
import com.zhan.websys.entity.base.PageQuery;
import com.zhan.websys.entity.menu.Menu;
import com.zhan.websys.provider.provider.BaseProvider;
import com.zhan.websys.service.menu.MenuService;
import org.springframework.beans.BeanUtils;
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
    private final static String TOP_MENU = "0";
    @Autowired
    private MenuService menuService;

    @Override
    public ResultContext<List<TreeNodeVO>> queryForDisplay() {
        List<TreeNodeBO> list = menuService.queryForDisplay();

        return success(convertToTreeNodeVO(list));
    }

    @Override
    public ResultContext<List<TreeNodeVO>> queryTree() {
        List<TreeNodeBO> list = menuService.queryTree();

        return success(convertToTreeNodeVO(list));
    }

    @Override
    public ResultContext<PageViewVO<MenuVO>> query(PageQueryDTO<MenuDTO> pageQueryDTO) {
        PageView<Menu> pageViewVO = menuService.query(convertToPageQuery(pageQueryDTO));

        return success(convertToPageViewVO(pageViewVO));
    }

    @Override
    public ResultContext<Void> add(MenuAddDTO menuAddDTO) {
        Menu menu = new Menu();
        BeanUtil.copyProperties(menuAddDTO, menu);
        menuService.add(menu);
        return success();
    }

    @Override
    public ResultContext<List<TreeNodeVO>> userTree() {
        List<TreeNodeBO> list = menuService.userTree();

        return success(convertToTreeNodeVO(list));
    }

    @Override
    public ResultContext<Void> delete(List<MenuDeleteDTO> list) {
        menuService.delete(deleteConvertToMenu(list));

        return success();
    }

    @Override
    public ResultContext<Void> edit(MenuEditDTO menuEditDTO) {
        Menu menu = new Menu();
        BeanUtil.copyProperties(menuEditDTO, menu);

        menuService.edit(menu);

        return success();
    }

    @Override
    public ResultContext<MenuVO> getById(String urid) {
        MenuVO menuVO = new MenuVO();
        Menu menu = menuService.getById(urid);

        BeanUtil.copyProperties(menu, menuVO);
        return success(menuVO);
    }

    @Override
    public ResultContext<Void> enable(List<MenuEnableDTO> list) {
        List<Menu> menuList = list.stream().map(x -> {
            Menu menu = new Menu();
            BeanUtil.copyProperties(x, menu);
            return menu;
        }).collect(Collectors.toList());

        menuService.enable(menuList);
        return success();
    }

    @Override
    public ResultContext<Void> disable(List<MenuDisableDTO> list) {
        List<Menu> menuList = list.stream().map(x -> {
            Menu menu = new Menu();
            BeanUtil.copyProperties(x, menu);
            return menu;
        }).collect(Collectors.toList());

        menuService.disable(menuList);
        return success();
    }

    private List<Menu> deleteConvertToMenu(List<MenuDeleteDTO> list) {
        return list.stream().map(x -> {
            Menu menu = new Menu();
            BeanUtil.copyProperties(x, menu);
            return menu;
        }).collect(Collectors.toList());
    }

    private PageViewVO<MenuVO> convertToPageViewVO(PageView<Menu> pageView) {
        List<Menu> menuList = pageView.getData();
        List<MenuVO> menuVOList = menuList.stream().map(x -> {
            MenuVO menuVO = new MenuVO();
            BeanUtils.copyProperties(x, menuVO);
            if (!TOP_MENU.equals(x.getParentId())) {
                menuVO.setParentName(menuService.getById(x.getParentId()).getName());
            }
            menuVO.setActiveFlagShow(ENMenuActiveFlag.getLabelByValue(x.getActiveFlag()));
            menuVO.setShowFlagShow(ENMenuShowFlag.getLabelByValue(x.getShowFlag()));
            return menuVO;
        }).collect(Collectors.toList());

        PageViewVO<MenuVO> pageViewVO = new PageViewVO<>();
        pageViewVO.setData(menuVOList);
        pageViewVO.setTotal(pageView.getTotal());
        pageViewVO.setSize(pageView.getSize());
        return pageViewVO;
    }

    private PageQuery<Menu> convertToPageQuery(PageQueryDTO<MenuDTO> pageQueryDTO) {
        MenuDTO menuDTO = pageQueryDTO.getEntity();
        Menu menu = new Menu();
        menu.setParentId(menuDTO.getParentId());
        menu.setCode(menuDTO.getCode());
        menu.setName(menuDTO.getName());

        PageQuery<Menu> pageQuery = new PageQuery<>();
        pageQuery.setEntity(menu);
        pageQuery.setPageNum(pageQueryDTO.getPageNum());
        pageQuery.setPageSize(pageQueryDTO.getPageSize());
        pageQuery.setSortName(pageQueryDTO.getSortName());
        pageQuery.setSortType(pageQueryDTO.getSortType());
        return pageQuery;
    }

    private List<TreeNodeVO> convertToTreeNodeVO(List<TreeNodeBO> list) {
        return list.stream().map(x -> {
            TreeNodeVO treeNodeVO = new TreeNodeVO();
            treeNodeVO.setUrid(x.getId());
            treeNodeVO.setTitle(x.getTitle());
            treeNodeVO.setPid(x.getPid());
            treeNodeVO.setChecked(x.getChecked());
            treeNodeVO.setUrl(x.getUrl());
            if (CollectionUtil.isNotEmpty(x.getChildren())) {
                treeNodeVO.setChildren(convertToTreeNodeVO(x.getChildren()));
            }
            return treeNodeVO;
        }).collect(Collectors.toList());
    }
}
