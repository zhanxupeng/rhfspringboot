package com.zhan.websys.service.enumpath.impl;

import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.ReflectUtil;
import com.zhan.websys.common.exception.BusinessException;
import com.zhan.websys.bo.dropdown.DropDownBO;
import com.zhan.websys.dao.enumpath.EnumPathMapper;
import com.zhan.websys.entity.enumpath.EnumPath;
import com.zhan.websys.service.enumpath.EnumPathService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author zhanxp
 * @version 1.0 2018/10/24
 */
@Service
public class EnumPathServiceImpl implements EnumPathService {
    private final static String VALUE = "value";
    private final static String LABEL = "label";
    @Autowired
    private EnumPathMapper enumPathMapper;

    @Override
    public List<DropDownBO> getDropDown(String code) {
        EnumPath enumPath = enumPathMapper.getByCode(code);
        if (ObjectUtil.isNull(enumPath)) {
            return new LinkedList<>();
        }

        Class<?> clazz = getClass(enumPath.getPath());

        return Arrays.stream(clazz.getEnumConstants()).map(x -> {
            DropDownBO dropDownBO = new DropDownBO();
            dropDownBO.setValue(ReflectUtil.getFieldValue(x, VALUE).toString());
            dropDownBO.setLabel(ReflectUtil.getFieldValue(x, LABEL).toString());
            return dropDownBO;
        }).collect(Collectors.toList());
    }

    private Class<?> getClass(String classPath) {
        try {
            return Class.forName(classPath);
        } catch (ClassNotFoundException e) {
            throw new BusinessException("枚举不存在");
        }
    }
}
