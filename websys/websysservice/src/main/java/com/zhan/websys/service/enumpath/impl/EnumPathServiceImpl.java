package com.zhan.websys.service.enumpath.impl;

import cn.hutool.core.util.ReflectUtil;
import com.zhan.websys.dao.dropdown.DropDown;
import com.zhan.websys.dao.enumpath.EnumPathMapper;
import com.zhan.websys.entity.enumpath.EnumPath;
import com.zhan.websys.service.enumpath.EnumPathService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
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
    public List<DropDown> getDropDown(String code) {
        EnumPath enumPath = enumPathMapper.getByCode(code);
        Class<?> clazz = getClass(enumPath.getPath());

        return Arrays.stream(clazz.getEnumConstants()).map(x -> {
            DropDown dropDown = new DropDown();
            dropDown.setValue(ReflectUtil.getFieldValue(x, VALUE).toString());
            dropDown.setLabel(ReflectUtil.getFieldValue(x, LABEL).toString());
            return dropDown;
        }).collect(Collectors.toList());
    }

    private Class<?> getClass(String classPath) {
        try {
            return Class.forName(classPath);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("枚举不存在");
        }
    }
}
