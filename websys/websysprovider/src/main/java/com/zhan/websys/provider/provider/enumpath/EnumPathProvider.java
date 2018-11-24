package com.zhan.websys.provider.provider.enumpath;

import com.alibaba.dubbo.config.annotation.Service;
import com.zhan.websys.api.enumpath.EnumPathApi;
import com.zhan.websys.api.enumpath.vo.DropDownVO;
import com.zhan.websys.bo.dropdown.DropDownBO;
import com.zhan.websys.api.base.ResultContext;
import com.zhan.websys.provider.provider.BaseProvider;
import com.zhan.websys.service.enumpath.EnumPathService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author zhanxp
 * @version 1.0 2018/11/15
 */
@Service(interfaceClass = EnumPathApi.class)
@Component
public class EnumPathProvider extends BaseProvider implements EnumPathApi {
    @Autowired
    private EnumPathService enumPathService;

    @Override
    public ResultContext<List<DropDownVO>> getDropDown(String code) {
        List<DropDownBO> list = enumPathService.getDropDown(code);

        List<DropDownVO> resultList = list.stream().map(x -> {
            DropDownVO dropDownVO = new DropDownVO();
            dropDownVO.setValue(x.getValue());
            dropDownVO.setLabel(x.getLabel());
            return dropDownVO;
        }).collect(Collectors.toList());
        return success(resultList);
    }
}
