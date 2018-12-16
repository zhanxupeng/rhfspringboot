package com.zhan.websys.controller.controller.menuoperation;

import com.zhan.websys.api.base.PageQueryDTO;
import com.zhan.websys.api.base.PageViewVO;
import com.zhan.websys.api.base.ResultContext;
import com.zhan.websys.api.menuoperation.MenuOperationApi;
import com.zhan.websys.api.menuoperation.dto.MenuOperationAddDTO;
import com.zhan.websys.api.menuoperation.dto.MenuOperationDTO;
import com.zhan.websys.api.menuoperation.dto.MenuOperationDeleteDTO;
import com.zhan.websys.api.menuoperation.dto.MenuOperationEditDTO;
import com.zhan.websys.api.menuoperation.vo.MenuOperationVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author zhanxp
 * @version 1.0  2018/12/16
 * @Description todo
 */
@RestController
@RequestMapping("/websys/menuoperation")
public class MenuOperationController {
    @Autowired
    private MenuOperationApi menuOperationApi;

    @PostMapping("add.do")
    public ResultContext<Void> add(@RequestBody MenuOperationAddDTO menuOperationAddDTO) {
        return menuOperationApi.add(menuOperationAddDTO);
    }


    @PostMapping("edit.do")
    public ResultContext<Void> edit(@RequestBody MenuOperationEditDTO menuOperationEditDTO) {
        return menuOperationApi.edit(menuOperationEditDTO);
    }

    @PostMapping("query.do")
    public ResultContext<PageViewVO<MenuOperationVO>> query(@RequestBody PageQueryDTO<MenuOperationDTO> pageQueryDTO) {
        return menuOperationApi.query(pageQueryDTO);
    }

    @PostMapping("delete.do")
    public ResultContext<Void> delete(@RequestBody List<MenuOperationDeleteDTO> list) {
        return menuOperationApi.deletes(list);
    }

    @GetMapping("getById.do")
    public ResultContext<MenuOperationVO> getById(String urid) {
        return menuOperationApi.getById(urid);
    }
}
