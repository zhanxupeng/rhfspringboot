package com.zhan.websys.api.menuoperation;

import com.zhan.websys.api.base.PageQueryDTO;
import com.zhan.websys.api.base.PageViewVO;
import com.zhan.websys.api.base.ResultContext;
import com.zhan.websys.api.menuoperation.dto.MenuOperationAddDTO;
import com.zhan.websys.api.menuoperation.dto.MenuOperationDTO;
import com.zhan.websys.api.menuoperation.dto.MenuOperationDeleteDTO;
import com.zhan.websys.api.menuoperation.dto.MenuOperationEditDTO;
import com.zhan.websys.api.menuoperation.vo.MenuOperationVO;

import java.util.List;

/**
 * @author zhanxp
 * @version 1.0 2018/11/27
 */
public interface MenuOperationApi {
    ResultContext<Void> add(MenuOperationAddDTO menuOperationAddDTO);

    ResultContext<Void> edit(MenuOperationEditDTO menuOperationEditDTO);


    ResultContext<PageViewVO<MenuOperationVO>> query(PageQueryDTO<MenuOperationDTO> pageQueryDTO);

    ResultContext<Void> deletes(List<MenuOperationDeleteDTO> list);

    ResultContext<MenuOperationVO> getById(String urid);
}
