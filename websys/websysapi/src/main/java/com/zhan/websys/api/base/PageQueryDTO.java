package com.zhan.websys.api.base;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @author zhanxp
 * @version 1.0 2018/11/8
 */
@Getter
@Setter
public class PageQueryDTO<T> implements Serializable {

    private T entity;
    /**
     * 页码
     */
    private Integer pageNum = 1;

    /**
     * 每页记录数量
     */
    private Integer pageSize = 20;

    /**
     * 表格排序字段名
     */
    private String sortName;

    /**
     * 表格排序类型 desc,asc
     */
    private String sortType;
}
